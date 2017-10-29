package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_account_bancomer.*
import org.jetbrains.anko.startActivity

class NewAccountBancomerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account_bancomer)

        btnNewAccountNex.setOnClickListener {
            startActivity<RegisterAccountCPCURPActivity>()
        }

    }
}
