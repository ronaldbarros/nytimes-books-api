package com.example.nytbooks.data

import com.example.nytbooks.data.model.Book

sealed class BooksResult {
    class Success(val books: List<Book>) : BooksResult()
    class ApiError(val statusCode: Int) : BooksResult()
    object ServerError : BooksResult()
}