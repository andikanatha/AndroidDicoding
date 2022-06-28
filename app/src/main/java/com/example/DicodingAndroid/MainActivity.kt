package com.example.DicodingAndroid

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    companion object{
        val Intent_parcelable = "OBJECT_INTENT"
    }

    private lateinit var listMakanan: RecyclerView
    private var list: ArrayList<Makanan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Action Bar
        val actionBar: ActionBar?
        actionBar = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#073042"))
        actionBar?.setBackgroundDrawable(colorDrawable);
        getActionBar()


        listMakanan = findViewById(R.id.list_Materi)
        listMakanan.setHasFixedSize(true)

        list.addAll(MakananData.listdata)
        showRecyclerCardView()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    private fun showRecyclerCardView() {
        listMakanan.layoutManager = LinearLayoutManager(this)
        val cardViewMateriAdapter = CardViewMakananAdapter.CardViewMakanan(list)
        listMakanan.adapter = cardViewMateriAdapter
    }

    fun moveprofil(item: MenuItem) {
        val intent = Intent(this, profil::class.java)
        startActivity(intent)
    }


}