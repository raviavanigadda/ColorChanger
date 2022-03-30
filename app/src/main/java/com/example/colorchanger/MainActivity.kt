package com.example.colorchanger

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var seekBarRed : SeekBar
    private lateinit var seekBarGreen : SeekBar
    private lateinit var seekBarBlue : SeekBar
    private lateinit var colorDisplay : View

    private lateinit var viewModel: MainActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        initViews()
        initListeners()
        initObserver()
    }

    private fun initViews(){
        seekBarRed = findViewById(R.id.seekBarRed)
        seekBarBlue = findViewById(R.id.seekBarBlue)
        seekBarGreen = findViewById(R.id.seekBarGreen)
        colorDisplay = findViewById(R.id.view)
    }

    private fun initListeners(){

        seekBarRed.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewModel.updateRedColor(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })


        seekBarGreen.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewModel.updateGreenColor(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })


        seekBarBlue.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewModel.updateBlueColor(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }

    private fun initObserver(){
        viewModel.viewColor.observe(this, {
            colorDisplay.setBackgroundColor(it)
        })
    }
}