package com.lab.cryptostore

import android.app.Application
import com.lab.cryptostore.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoStoreApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptoStoreApp)
            androidLogger()
            modules(appModule)
        }
    }
}