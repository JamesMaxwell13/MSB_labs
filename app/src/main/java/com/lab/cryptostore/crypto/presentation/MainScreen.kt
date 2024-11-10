package com.lab.cryptostore.crypto.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.lab.cryptostore.crypto.login.data.AccountDataObject
import com.lab.cryptostore.crypto.presentation.account.AccountScreen
import com.lab.cryptostore.crypto.presentation.coins.CoinsScreen
import com.lab.cryptostore.crypto.presentation.navigation.BottomNavigation
import com.lab.cryptostore.crypto.presentation.navigation.BottomNavigationItem
import com.lab.cryptostore.crypto.presentation.wallet.WalletScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen (data: AccountDataObject) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(navController)
        }
    ) {
        NavHost(navController = navController, startDestination = BottomNavigationItem.Coins.route) {
            composable(BottomNavigationItem.Coins.route) {
                CoinsScreen()
            }
            composable(BottomNavigationItem.Wallet.route) {
                WalletScreen()
            }
            composable(BottomNavigationItem.Account.route) {
                AccountScreen(data)
            }
        }
    }
}