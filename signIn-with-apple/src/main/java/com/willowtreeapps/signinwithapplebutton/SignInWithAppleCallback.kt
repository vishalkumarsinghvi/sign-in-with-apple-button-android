package com.willowtreeapps.signinwithapplebutton

interface SignInWithAppleCallback {

    fun onSignInWithAppleSuccess(authorizationCode: String, idToken: String, user: SignInWithAppleResult.User)

    fun onSignInWithAppleFailure(error: Throwable)

    fun onSignInWithAppleCancel()
}

internal fun SignInWithAppleCallback.toFunction(): (SignInWithAppleResult) -> Unit =
    { result ->
        when (result) {
            is SignInWithAppleResult.Success -> onSignInWithAppleSuccess(result.authorizationCode, result.idToken, result.user)
            is SignInWithAppleResult.Failure -> onSignInWithAppleFailure(result.error)
            is SignInWithAppleResult.Cancel -> onSignInWithAppleCancel()
        }
    }
