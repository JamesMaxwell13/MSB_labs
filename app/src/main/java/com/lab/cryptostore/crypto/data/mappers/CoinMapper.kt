package com.lab.cryptostore.crypto.data.mappers

import com.lab.cryptostore.crypto.data.Coin
import com.lab.cryptostore.crypto.data.CoinPrice
import com.lab.cryptostore.crypto.data.dto.CoinDto
import com.lab.cryptostore.crypto.data.dto.CoinPriceDto
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}