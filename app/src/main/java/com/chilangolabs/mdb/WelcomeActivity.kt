package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import org.jetbrains.anko.startActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btnWelcomeGo.setOnClickListener {
            startActivity<TellUsAboutYourBussines>()
        }
    }
}
