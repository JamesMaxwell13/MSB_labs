package com.lab.cryptostore.crypto.presentation.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginTextField(
    text: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    TextField(value = text, onValueChange = {
        onValueChange(it)
    },
        shape = RoundedCornerShape(100f),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Green,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black, RoundedCornerShape(100f)),
        singleLine = true,
        label = { Text(text = label) }
    )
}