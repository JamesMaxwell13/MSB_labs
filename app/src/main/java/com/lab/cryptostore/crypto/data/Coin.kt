package com.lab.cryptostore.crypto.data

data class Coin(
    val id: String = "",
    val rank: Int = 0,
    val name: String = "",
    val symbol: String = "",
    val marketCapUsd: Double = 0.0,
    val priceUsd: Double = 0.0,
    val changePercent24Hr: Double = 0.0,
)

