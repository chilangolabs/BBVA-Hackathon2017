package com.chilangolabs.mdb.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chilangolabs.mdb.R
import com.chilangolabs.mdb.entitys.ItemCards
import kotlinx.android.synthetic.main.item_carousel_cards.view.*

/**
 * @author Gorro.
 */
class AdapterCards(val data: List<ItemCards>) : RecyclerView.Adapter<AdapterCards.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_carousel_cards, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindView(data[position])
    }

    override fun getItemCount(): Int = data.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: ItemCards) {
            itemView?.let {
                with(it) {
                    imgItemCards.setImageResource(item.img)
                }
            }
        }

    }

}