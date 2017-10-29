package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register_personal_info.*
import org.jetbrains.anko.intentFor

class RegisterPersonalInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_personal_info)

        btnRegisterPersonalInfo.setOnClickListener {
            startActivity(intentFor<RegisterAddressActivity>())
            finish()
        }
    }
}
