package com.dicoding.tugasmobilelist

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    private var title: String = "Ace Fighters"

    private lateinit var dataNama: Array<String>
    private lateinit var dataTahun: Array<String>
    private lateinit var dataJulukan: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var adapter: PesawatAdapter
    private var pesawat_ = arrayListOf<Pesawat>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        val listView: ListView = findViewById(R.id.lv_pesawat)
        adapter = PesawatAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, "Pesawat : ${pesawat_[position].nama} di Perkenalkan Tahun : ${pesawat_[position].tahun}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(aboutIntent)
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title : String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun prepare() {
        dataNama = resources.getStringArray(R.array.data_nama)
        dataTahun = resources.getStringArray(R.array.data_tahun)
        dataJulukan = resources.getStringArray(R.array.data_julukan)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataNama.indices) {
            val pesawat = Pesawat(
                dataNama[position],
                dataTahun[position],
                dataJulukan[position],
                dataPhoto.getResourceId(position, -1)
            )
            pesawat_.add(pesawat)
        }
        adapter.pesawat = pesawat_
    }
}