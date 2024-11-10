package com.lab.cryptostore.crypto.presentation.account

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.lab.cryptostore.crypto.login.data.AccountDataObject

@Composable
fun AccountScreen(data: AccountDataObject) {
    Text(text = "email: ${data.email}\nuid: ${data.uid}")
}