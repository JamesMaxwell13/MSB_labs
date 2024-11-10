package com.lab.cryptostore.crypto.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val route: String,
    val icon: ImageVector
) {
    data object Coins : BottomNavigationItem(
        route = "Coins",
        icon = Icons.Filled.Search
    )
    data object Wallet : BottomNavigationItem(
        route = "Wallet",
        icon = Icons.Filled.ShoppingCart
    )
    data object Account : BottomNavigationItem(
        route = "Account",
        icon = Icons.Filled.Person
    )

}