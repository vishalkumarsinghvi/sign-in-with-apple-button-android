package com.willowtreeapps.signinwithapplebutton

import java.io.Serializable

sealed class SignInWithAppleResult {
    data class Success(val authorizationCode: String, val idToken: String, val user: User) :
        SignInWithAppleResult()

    data class Failure(val error: Throwable) : SignInWithAppleResult()

    object Cancel : SignInWithAppleResult()

    data class User(val name: Name, val email: String) : Serializable

    data class Name(val firstName: String, val middleName: String?, val lastName: String) :
        Serializable

}
