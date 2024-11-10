package com.lab.cryptostore.crypto.presentation.coin.list

import com.lab.cryptostore.core.domain.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}