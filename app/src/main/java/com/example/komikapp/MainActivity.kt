package com.example.komikapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecycleview.CardViewMangaAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvManga: RecyclerView
    private var list: ArrayList<Manga> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvManga = findViewById(R.id.rv_manga)
        rvManga.setHasFixedSize(true)
        list.addAll(MangaData.listData)
        showRecyclerCardView()
        val btnAboutScreen =findViewById(R.id.about_page)as ImageView
        btnAboutScreen.setOnClickListener{
            val moveIntent = Intent(this@MainActivity, AboutScreen::class.java)
            startActivity(moveIntent)
        }



    }
    private fun showRecyclerCardView() {
        rvManga.layoutManager = LinearLayoutManager(this)
        val cardViewMangaAdapter = CardViewMangaAdapter(list)
        rvManga.adapter = cardViewMangaAdapter
        cardViewMangaAdapter.setOnItemClickCallback(object : CardViewMangaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Manga) {
                val intent = Intent(this@MainActivity,DetailScreen::class.java)
                intent.putExtra("manga", data)
                startActivity(intent)
            }
        })

    }

}


