package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register_account_cpcurp.*
import org.jetbrains.anko.startActivity

class RegisterAccountCPCURPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_account_cpcurp)

        btnRegisterCP.setOnClickListener {
            startActivity<RegisterPersonalInfoActivity>()
        }
    }
}
