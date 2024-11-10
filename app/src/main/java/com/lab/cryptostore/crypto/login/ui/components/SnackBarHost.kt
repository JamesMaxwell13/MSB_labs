package com.lab.cryptostore.crypto.login.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SnackBarHost(
    snackbarHostState: SnackbarHostState
) {
    SnackbarHost(
    hostState = snackbarHostState,
    snackbar = { data: SnackbarData ->
        Snackbar(
            snackbarData = data,
            shape = RoundedCornerShape(50f),
            modifier = Modifier.padding(20.dp)
        )
    })
}