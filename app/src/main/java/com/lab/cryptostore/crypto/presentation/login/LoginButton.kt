package com.lab.cryptostore.crypto.presentation.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoginButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(100f),
        modifier = Modifier.fillMaxWidth(0.75f),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray
        )
    ) {
        Text(text = text)
    }
}