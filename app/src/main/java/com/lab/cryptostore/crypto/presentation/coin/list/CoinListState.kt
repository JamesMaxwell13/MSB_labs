package com.lab.cryptostore.crypto.presentation.coin.list

import androidx.compose.runtime.Immutable
import com.lab.cryptostore.crypto.presentation.coin.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)