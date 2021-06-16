package com.example.nytbooks.data.repository

import com.example.nytbooks.data.BooksResult

interface BooksRepository {
    fun getbooks(booksResultCallback: (result: BooksResult) -> Unit)
}