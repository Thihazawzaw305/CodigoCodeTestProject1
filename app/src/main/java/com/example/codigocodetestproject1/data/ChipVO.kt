package com.example.codigocodetestproject1.data

data class ChipVO (
    val id: Int,
    val name: String
)

data class ChipList(
    val data: List<ChipVO>
)