package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_destiny_account.*
import org.jetbrains.anko.startActivity

class AddDestinyAccountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_destiny_account)

        var type = 0

        intent?.extras?.let {
            val btnString = it.getString("button")
            btnAddNewAccount.text = btnString
            type = it.getInt("type")
        }

        btnAddNewAccount.setOnClickListener {
            if (type == 0)
                startActivity<CardsActivity>()
            else
                finish()
        }

    }
}
