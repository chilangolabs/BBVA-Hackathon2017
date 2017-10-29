package com.chilangolabs.mdb.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chilangolabs.mdb.R
import com.chilangolabs.mdb.entitys.ItemCardMainSelect
import kotlinx.android.synthetic.main.item_main_card_select.view.*

/**
 * @author Gorro.
 */
class AdapterMainCardSelect(val data: List<ItemCardMainSelect>) : RecyclerView.Adapter<AdapterMainCardSelect.ViewHolder>() {

    var lastCheckedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_main_card_select, parent, false))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val item = data[position]
        holder?.getItemView()?.let {
            with(it) {
                imgItemCardMain.setImageResource(item.img)
                txtItemCardMainName.text = item.cardName
                txtItemCardMainPlaceNum.text = item.numPh
//                    rdBtnItemCardMain.isChecked = item.selected
                rdBtnItemCardMain.isChecked = position == lastCheckedPosition

                rdBtnItemCardMain.setOnClickListener {
                    lastCheckedPosition = holder.adapterPosition

                    notifyDataSetChanged()
                }

                it.setOnClickListener {
                    lastCheckedPosition = holder.adapterPosition

                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount(): Int = data.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun getItemView() = itemView

    }
}