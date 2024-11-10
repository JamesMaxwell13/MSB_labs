package com.lab.cryptostore.crypto.login.logic.impl

import android.util.Log
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.lab.cryptostore.crypto.login.data.AccountDataObject
import com.lab.cryptostore.crypto.login.logic.AuthLogicInterface

class AuthLogic(firebaseAuth: FirebaseAuth) : AuthLogicInterface {
    private val auth = firebaseAuth

    override fun signUp(
        email: String,
        password: String,
        onSignUpSuccess: (AccountDataObject) -> Unit,
        onSignUpFailure: (String) -> Unit
    ) {
        signUp(auth, email, password, onSignUpSuccess, onSignUpFailure)
    }

    override fun signIn(
        email: String,
        password: String,
        onSignInSuccess: (AccountDataObject) -> Unit,
        onSignInFailure: (String) -> Unit
    ) {
        signIn(auth, email, password, onSignInSuccess, onSignInFailure)
    }

    override fun deleteAccount(email: String, password: String) {
        deleteAccount(auth, email, password)
    }

    override fun signOut() {
        signOut(auth)
    }
}

private fun signUp(
    auth: FirebaseAuth,
    email: String,
    password: String,
    onSignUpSuccess: (AccountDataObject) -> Unit,
    onSignUpFailure: (String) -> Unit
) {
    if (email.isBlank() || password.isBlank()) {
        onSignUpFailure("Email or password cannot be empty")
        return
    }

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            if (it.isSuccessful) {
                onSignUpSuccess(
                    AccountDataObject(
                        it.result.user?.uid!!,
                        it.result.user?.email!!,
                    )
                )
            }
        }
        .addOnFailureListener {
            onSignUpFailure(it.message ?: "Sign Up Error")
        }
}

private fun signIn(
    auth: FirebaseAuth,
    email: String,
    password: String,
    onSignInSuccess: (AccountDataObject) -> Unit,
    onSignInFailure: (String) -> Unit
) {
    if (email.isBlank() || password.isBlank()) {
        onSignInFailure("Email or password cannot be empty")
        return
    }

    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            if (it.isSuccessful) {
                onSignInSuccess(
                    AccountDataObject(
                        it.result.user?.uid!!,
                        it.result.user?.email!!,
                    )
                )
            }
        }
        .addOnFailureListener {
            onSignInFailure(it.message ?: "Sign In Error")
        }
}

private fun deleteAccount(auth: FirebaseAuth, email: String, password: String) {
    val credential = EmailAuthProvider.getCredential(email, password)
    auth.currentUser?.reauthenticate(credential)?.addOnCompleteListener { it ->
        if (it.isSuccessful) {
            auth.currentUser?.delete()?.addOnCompleteListener { item ->
                if (item.isSuccessful) {
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