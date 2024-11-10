package com.lab.cryptostore.di

import com.lab.cryptostore.core.networking.HttpClientFactory
import com.lab.cryptostore.crypto.data.RemoteCoinDataSource
import com.lab.cryptostore.crypto.presentation.coin.list.CoinListViewModel
import com.lab.cryptostore.crypto.data.CoinDataSource
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()
    viewModelOf(::CoinListViewModel)
}