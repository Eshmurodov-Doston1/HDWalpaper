package com.example.hdwalpaper.models

data class Unsplash(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)