package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register_address.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop

class RegisterAddressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_address)

        btnRegisterAddress.setOnClickListener {
            startActivity(intentFor<CardsActivity>().singleTop())
        }

    }
}
