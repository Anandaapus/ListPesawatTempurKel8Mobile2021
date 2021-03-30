package com.dicoding.tugasmobilelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class PesawatAdapter constructor(private val context: Context) : BaseAdapter() {
    internal var pesawat = arrayListOf<Pesawat>()
    override fun getCount(): Int = pesawat.size

    override fun getItem(i: Int): Any = pesawat[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, v: View?, viewGroup: ViewGroup): View {
        var itemView = v
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_pesawat, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val hero = getItem(position) as Pesawat
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val tvNama: TextView = view.findViewById(R.id.tv_nama)
        private val tvJulukan: TextView = view.findViewById(R.id.tv_julukan)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_item_photo)
        internal fun bind(pesawat: Pesawat) {
            tvNama.text = "${pesawat.nama} (${pesawat.tahun})"
            tvJulukan.text = pesawat.julukan
            imgPhoto.setImageResource(pesawat.photo)
        }
    }
}