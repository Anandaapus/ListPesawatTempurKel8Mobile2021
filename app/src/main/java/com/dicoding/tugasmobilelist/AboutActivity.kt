package com.dicoding.tugasmobilelist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var igFebi: ImageButton
    private lateinit var igKifli: ImageButton
    private lateinit var igApus: ImageButton
    private lateinit var igAim: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setActionBarTitle("About Us")

        igFebi = findViewById(R.id.ig_anggota)
        igKifli = findViewById(R.id.ig_anggota2)
        igApus = findViewById(R.id.ig_anggota3)
        igAim = findViewById(R.id.ig_anggota4)

        igFebi.setOnClickListener(this)
        igKifli.setOnClickListener(this)
        igApus.setOnClickListener(this)
        igAim.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val aboutIntent = Intent(this@AboutActivity, MainActivity::class.java)
        startActivity(aboutIntent)
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title : String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.ig_anggota -> {
                val uri = Uri.parse("http://instagram.com/_u/dwiefajarr")
                val likeIng = Intent(Intent.ACTION_VIEW, uri)
                startActivity(likeIng)
            }
            R.id.ig_anggota2 -> {
                val uri = Uri.parse("http://instagram.com/_u/zulkifli_aljabarullah")
                val likeIng = Intent(Intent.ACTION_VIEW, uri)
                startActivity(likeIng)
            }
            R.id.ig_anggota3 -> {
                val uri = Uri.parse("http://instagram.com/_u/anandaapus")
                val likeIng = Intent(Intent.ACTION_VIEW, uri)
                startActivity(likeIng)
            }
            R.id.ig_anggota4 -> {
                val uri = Uri.parse("http://instagram.com/_u/abdulrahimbutolooo")
                val likeIng = Intent(Intent.ACTION_VIEW, uri)
                startActivity(likeIng)
            }
        }
    }
}