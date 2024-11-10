package com.lab.cryptostore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.lab.cryptostore.crypto.presentation.MainScreen
import com.lab.cryptostore.crypto.login.ui.LoginScreen
import com.lab.cryptostore.crypto.login.data.AccountDataObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") {
                    LoginScreen { navData ->
                        navController.navigate(navData)
                    }
                }
                composable<AccountDataObject> { navEntry ->
                    val navData = navEntry.toRoute<AccountDataObject>()
                    MainScreen(navData)
                }
            }
        }
    }
}

// admin@gmail.com admin_password
