package com.lab.cryptostore.crypto.data

import com.lab.cryptostore.core.domain.NetworkError
import com.lab.cryptostore.core.domain.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}