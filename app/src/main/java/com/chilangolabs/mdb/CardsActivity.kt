package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chilangolabs.mdb.adapters.AdapterCards
import com.chilangolabs.mdb.customviews.ScaleRCTransformer
import com.chilangolabs.mdb.entitys.ItemCards
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager
import kotlinx.android.synthetic.main.activity_cards.*

class CardsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        val lmanager = GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL)
        lmanager.setItemTransformer(ScaleRCTransformer())

        lmanager.attach(rcCardsMainView, 1)

        val mainCards = mutableListOf<ItemCards>()

        mainCards.add(ItemCards(R.drawable.ic_card_nomina))
        mainCards.add(ItemCards(R.drawable.card_gray))
        mainCards.add(ItemCards(R.drawable.ic_card_nomina))

        val adapter = AdapterCards(mainCards)
        rcCardsMainView.adapter = adapter


    }
}
