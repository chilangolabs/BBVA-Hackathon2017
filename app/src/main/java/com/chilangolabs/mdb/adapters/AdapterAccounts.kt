package com.chilangolabs.mdb.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chilangolabs.mdb.R
import com.chilangolabs.mdb.entitys.ItemAcounts
import kotlinx.android.synthetic.main.item_accounts.view.*

/**
 * @author Gorro.
 */
class AdapterAccounts(val data: List<ItemAcounts>, val f: (pos: Int) -> Unit) : RecyclerView.Adapter<AdapterAccounts.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_accounts, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindView(data[position])
        holder?.itemView?.setOnClickListener {
            f(position)
        }
    }

    override fun getItemCount(): Int = data.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(item: ItemAcounts) {
            itemView?.let {
                with(it) {
                    imgItemAccountCard.setImageResource(item.icon)
                    txtItemAccountName.text = item.nameAccount
                    txtItemAccountCard.text = "Tarjeta: ${item.cardNum}"
                }

            }
        }
    }

}