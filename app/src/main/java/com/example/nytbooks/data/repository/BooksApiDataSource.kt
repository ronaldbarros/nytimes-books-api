package com.example.nytbooks.data.repository

import com.example.nytbooks.data.ApiService
import com.example.nytbooks.data.BooksResult
import com.example.nytbooks.data.model.Book
import com.example.nytbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksApiDataSource : BooksRepository {
    override fun getbooks(booksResultCallback: (result: BooksResult) -> Unit) {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                when {
                    response.isSuccessful -> {
                        val books: MutableList<Book> = mutableListOf()

                        response.body()?.let { bookBodyResponse ->
                            for (result in bookBodyResponse.bookResults) {
                                val book = result.bookDetails[0].getBookModel()

                                books.add(book)
                            }
                        }
                        booksResultCallback(BooksResult.Success(books))
                    } else -> booksResultCallback(BooksResult.ApiError(response.code()))
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                booksResultCallback(BooksResult.ServerError)
            }

        })
    }
}