package com.youtility.energyswitchcui.scene.address

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.youtility.energyswitchcui.R
import com.youtility.energyswitchcui.model.Address
import com.youtility.listnear.OnItemClickListnear


class AddressListAdapter(val arrayList: ArrayList<Address>, val context: Context, val itemClickListnear: OnItemClickListnear) : RecyclerView.Adapter<AddressListAdapter.ViewHolder>() {

    internal var selectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_address_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bean: Address = arrayList[position]
        holder.name.text = bean.displayValue

        if (selectedPosition == position) {
            holder.imgCheck.visibility = View.VISIBLE
            arrayList[position].isSelected = true
        } else {
            holder.imgCheck.visibility = View.INVISIBLE
            arrayList[position].isSelected = false
        }

        holder.rlContainer.setOnClickListener {
            selectedPosition = holder.adapterPosition;
            notifyDataSetChanged()
            itemClickListnear.onItemClick(0)
        }

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    fun getSelectedAddress(): Address {
        return arrayList[selectedPosition]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView = itemView.findViewById(com.youtility.energyswitchcui.R.id.tvAddress)
        var imgCheck: ImageView = itemView.findViewById(R.id.imgCheck)
        var rlContainer: RelativeLayout = itemView.findViewById(R.id.rlContainer)
    }

}