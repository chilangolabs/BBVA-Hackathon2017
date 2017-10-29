package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_destiny_account.*

class AddDestinyAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_destiny_account)


        btnAddNewAccount.setOnClickListener {
            //            startActivity<>()
        }

    }
}
