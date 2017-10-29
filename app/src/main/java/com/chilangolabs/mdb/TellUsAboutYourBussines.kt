package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tell_us_about_your_bussines.*

class TellUsAboutYourBussines : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tell_us_about_your_bussines)

        val numEmployes = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        spinnerAboutBussines.attachDataSource(numEmployes)


    }
}
