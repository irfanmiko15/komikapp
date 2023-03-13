package com.example.komikapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import android.widget.ImageView

class DetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        var tvDtTitle: TextView = findViewById(R.id.title)
        var tvDtPhoto:ImageView=findViewById(R.id.image)
        var tvDtAuthor:TextView=findViewById(R.id.author)
        var tvDtChapter:TextView=findViewById(R.id.chapter)
        var tvDtViews:TextView=findViewById(R.id.views)
        var tvDtRelease:TextView=findViewById(R.id.release)
        var tvDtGenre:TextView=findViewById(R.id.genre)
        var tvDtScore:TextView=findViewById(R.id.score)
        var tvDtSinopsis:TextView=findViewById(R.id.sinopsis)
        val manga = intent.getParcelableExtra<Manga>("manga")
        val title = manga?.title
        val photo=manga?.photo
        val author=manga?.author
        val chapter=manga?.chapter
        val views=manga?.countView
        val genre=manga?.genre
        val release=manga?.release
        val score=manga?.score
        val sinopsis=manga?.sinopsis
        tvDtTitle.text=title
        tvDtAuthor.text=author
        tvDtChapter.text=chapter
        tvDtViews.text=views
        tvDtGenre.text=genre
        tvDtRelease.text=release
        tvDtScore.text=score
        tvDtSinopsis.text=sinopsis

        if (photo != null) {
            tvDtPhoto.setImageResource(photo)
        }
        val btnShare:Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, title)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
        }

//
    }

}