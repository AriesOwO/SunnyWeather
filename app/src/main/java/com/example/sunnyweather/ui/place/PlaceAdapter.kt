package com.example.sunnyweather.ui.place

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.sunnyweather.R
import com.example.sunnyweather.logic.model.PlaceResponse

class PlaceAdapter(data: MutableList<PlaceResponse.Place>) :
    BaseQuickAdapter<PlaceResponse.Place, BaseViewHolder>(R.layout.place_item, data) {

    override fun convert(holder: BaseViewHolder, item: PlaceResponse.Place) {
        holder.setText(R.id.place_name, item.name)
        holder.setText(R.id.place_address, item.formattedAddress)
    }
}