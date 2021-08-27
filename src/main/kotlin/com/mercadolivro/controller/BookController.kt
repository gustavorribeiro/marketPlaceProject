package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.service.BookService
import com.mercadolivro.service.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController (
    val bookService: BookService,
    val customerService: CustomerService
){

    @PostMapping
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }
}