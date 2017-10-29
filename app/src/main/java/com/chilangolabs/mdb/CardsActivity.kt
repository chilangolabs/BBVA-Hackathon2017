package com.chilangolabs.mdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chilangolabs.mdb.adapters.AdapterAccounts
import com.chilangolabs.mdb.adapters.AdapterCards
import com.chilangolabs.mdb.customviews.ScaleRCTransformer
import com.chilangolabs.mdb.entitys.ItemAcounts
import com.chilangolabs.mdb.entitys.ItemCards
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager
import kotlinx.android.synthetic.main.activity_cards.*
import org.jetbrains.anko.startActivity

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


        rcCardsMainViewAccounts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val dataAccounts = mutableListOf<ItemAcounts>()

        dataAccounts.add(ItemAcounts(R.drawable.ic_bancomer, "Sofia Ceciliano", "•••• •••• •••• 4567"))
        dataAccounts.add(ItemAcounts(R.drawable.ic_visa, "Zelt Rodriguez", "•••• •••• •••• 6948"))
        dataAccounts.add(ItemAcounts(R.drawable.ic_mastercard, "Rodrigo Moreno", "•••• •••• •••• 9583"))
        dataAccounts.add(ItemAcounts(R.drawable.ic_bancomer, "Sebastian Tellez", "•••• •••• •••• 0956"))
        dataAccounts.add(ItemAcounts(R.drawable.ic_visa, "Angel Lira", "•••• •••• •••• 7264"))

        rcCardsMainViewAccounts.adapter = AdapterAccounts(dataAccounts) {
            val account = dataAccounts[it]
            startActivity<TransferActivity>("name" to account.nameAccount, "card" to account.cardNum)
        }

        fabAddAccount.setOnClickListener {
            startActivity<AddDestinyAccountActivity>("type" to 1, "boton" to "Cancelar")
        }

        rcCardsMainViewAccountsEmptyView.visibility = View.GONE

    }
}
