package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_transfer.*
import org.jetbrains.anko.startActivity

class TransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        toolbarTransfer.title = ""
        setSupportActionBar(toolbarTransfer)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imgTransferPay.setOnClickListener {
            startActivity<ConfirmTransferActivity>()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
