package com.lab.cryptostore.crypto.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun LoginScreen() {
    val auth = Firebase.auth

    val emailState = remember {
        mutableStateOf("")
    }
    val passwordState = remember {
        mutableStateOf("")
    }

//    Image(painter = painterResource(id = R.drawable.img), contentDescription = "BG", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
//    Image("logo") Spacer() ...

    Column(
        modifier = Modifier.fillMaxSize().padding(
            start = 20.dp, end = 20.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LoginTextField(
            text = emailState.value,
            label = "Email"
        ) {
            emailState.value = it
        }
        Spacer(modifier = Modifier.height(10.dp))

        LoginTextField(
            text = passwordState.value,
            label = "Password"
        ) {
            passwordState.value = it
        }
        Spacer(modifier = Modifier.height(75.dp))

        LoginButton(text = "Sign In") {
            signIn(auth, emailState.value, passwordState.value)
        }
        Spacer(modifier = Modifier.height(10.dp))

        LoginButton(text = "Sign Out") {
            signOut(auth)
        }
        Spacer(modifier = Modifier.height(10.dp))

        LoginButton(text = "Sign Up") {
            signUp(auth, emailState.value, passwordState.value)
        }
        Spacer(modifier = Modifier.height(10.dp))

        LoginButton(text = "Delete account") {
            deleteAccount(auth, emailState.value, passwordState.value)
        }
    }
}

private fun signUp(auth: FirebaseAuth, email: String, password: String) {
    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
        if (it.isSuccessful) {
            Log.d("MyLog", "Sign Up successful!")
        } else {
            Log.d("MyLog", "Sign Up failure!")
        }
    }
}

private fun signIn(auth: FirebaseAuth, email: String, password: String) {
    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
        if (it.isSuccessful) {
            Log.d("MyLog", "Sign In successful!")
        } else {
            Log.d("MyLog", "Sign In failure!")
        }
    }
}

private fun deleteAccount(auth: FirebaseAuth, email: String, password: String) {
    val credential = EmailAuthProvider.getCredential(email, password)
    auth.currentUser?.reauthenticate(credential)?.addOnCompleteListener {
        if (it.isSuccessful) {
            auth.currentUser?.delete()?.addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("MyLog", "Account deleted!")
                } else {
                    Log.d("MyLog", "Failure delete account!")
                }
            }
        } else {
            Log.d("MyLog", "Failure reauthentificate!")
        }
    }
}

private fun signOut(auth: FirebaseAuth) {
    auth.signOut()
}