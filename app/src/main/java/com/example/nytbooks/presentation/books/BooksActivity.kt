package com.example.nytbooks.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.nytbooks.R


class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.title = "Books"
        setSupportActionBar(toolbar)
    }
}