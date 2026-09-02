package com.example.myapplication.model

data class Produto(
    val nome: String,
    val volume: String,
    val preco: String,
    val imagem: Int,
    val desconto: String? = null
)
