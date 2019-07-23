package com.gmail.mrkondakovda.reactwallpaperabyssapi.sample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.gmail.mrkondakovda.reactwallpaperabyssapi.api.WallpaperInfo


class WallpapersAdapter(
    context: Context,
    private val dataSource: List<WallpaperInfo>
) :
    BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val titleTextView = rowView.findViewById<TextView>(android.R.id.text1)

        titleTextView.text = getItem(position).urlImage

        return rowView

    }

    override fun getItem(position: Int) = dataSource[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = dataSource.size


}

