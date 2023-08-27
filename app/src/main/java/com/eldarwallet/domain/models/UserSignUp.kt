package com.eldarwallet.domain.models

import com.eldarwallet.domain.usecases.EncryptionUseCase

data class UserSignUp(
    val name: String,
    val surname: String,
    val email: String,
    val emailConfirm: String,
    val password: String,
    val passwordConfirm: String
){
    fun mapToUser(): User {
        return User(
            name,
            surname,
            email,
            EncryptionUseCase.encrypt(password))
    }
}
