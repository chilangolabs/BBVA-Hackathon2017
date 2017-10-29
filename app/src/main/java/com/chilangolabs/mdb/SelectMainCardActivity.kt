package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.chilangolabs.mdb.adapters.AdapterMainCardSelect
import com.chilangolabs.mdb.entitys.ItemCardMainSelect
import kotlinx.android.synthetic.main.activity_select_main_card.*

class SelectMainCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_main_card)

        rcMainCardSelect.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val listCards = mutableListOf<ItemCardMainSelect>()
        listCards.add(ItemCardMainSelect(R.drawable.card_fake, "Bancomer Platino", "•••• •••• •••• 5324", false))
        listCards.add(ItemCardMainSelect(R.drawable.card_fake, "Bancomer Nómina", "•••• •••• •••• 9974", false))
        listCards.add(ItemCardMainSelect(R.drawable.card_fake, "Bancomer Nómina", "•••• •••• •••• 0937", false))

        rcMainCardSelect.adapter = AdapterMainCardSelect(listCards)

    }
}
