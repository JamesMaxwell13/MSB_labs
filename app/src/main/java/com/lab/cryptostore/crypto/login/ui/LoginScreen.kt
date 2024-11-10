package com.lab.cryptostore.crypto.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lab.cryptostore.crypto.login.data.AccountDataObject
import com.lab.cryptostore.crypto.login.logic.impl.AuthLogic
import com.lab.cryptostore.crypto.login.logic.AuthLogicInterface
import com.lab.cryptostore.crypto.login.ui.components.LoginButton
import com.lab.cryptostore.crypto.login.ui.components.LoginTextField
import com.lab.cryptostore.crypto.login.ui.components.PasswordTextField
import com.lab.cryptostore.crypto.login.ui.components.SnackBarHost


@Composable
fun LoginScreen(
    onNavigateToMainScreen: (AccountDataObject) -> Unit
) {
    val auth = remember {
        Firebase.auth
    }
    val authLogic: AuthLogicInterface = remember { AuthLogic(auth) }

    val emailState = remember {
        mutableStateOf("admin@gmail.com")
    }
    val passwordState = remember {
        mutableStateOf("admin_password")
    }

    val errorState = remember {
        mutableStateOf("")
    }
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 20.dp, end = 20.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SnackBarHost(snackbarHostState)

        LoginTextField(
            text = emailState.value,
            label = "Email"
        ) {
            emailState.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))

        PasswordTextField(
            text = passwordState.value,
            label = "Password"
        ) {
            passwordState.value = it
        }
        Spacer(modifier = Modifier.height(50.dp))

        LoginButton(text = "Sign In") {
            authLogic.signIn(emailState.value,
                passwordState.value,
                onSignInSuccess = { navData ->
                    onNavigateToMainScreen(navData)
                },
                onSignInFailure = { errorMessage ->
                    errorState.value = errorMessage
                })
        }
        Spacer(modifier = Modifier.height(10.dp))

//        LoginButton(text = "Sign Out") {
//            authLogic.signOut()
//        }
//        Spacer(modifier = Modifier.height(10.dp))

        LoginButton(text = "Sign Up") {
            authLogic.signUp(
                emailState.value,
                passwordState.value,
                onSignUpSuccess = { navData ->
                    onNavigateToMainScreen(navData)
                },
                onSignUpFailure = { errorMessage ->
                    errorState.value = errorMessage
                }
            )
        }


//        LoginButton(text = "Delete account") {
//            authLogic.deleteAccount(emailState.value, passwordState.value)
//        }
    }

    if (errorState.value.isNotEmpty()) {
        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar(
                message = errorState.value,
                actionLabel = "Dismiss"
            )
            errorState.value = ""
        }
    }
}

//    Image(painter = painterResource(id = R.drawable.img), contentDescription = "BG", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
//    Image("logo") Spacer() ...

