package com.mercadolivro.enums

enum class Errors (val code: String, val message: String) {
    ML1001("ML-1001", "Book id= %s not exists"),
    ML1002("ML-1002", "Cannot update book with status %s"),
    ML2001("ML-2001", "Customer id= %s not exists")
}