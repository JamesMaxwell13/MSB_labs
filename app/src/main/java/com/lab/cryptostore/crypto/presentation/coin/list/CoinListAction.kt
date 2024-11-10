package com.lab.cryptostore.crypto.presentation.coin.list

import com.lab.cryptostore.crypto.presentation.coin.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}