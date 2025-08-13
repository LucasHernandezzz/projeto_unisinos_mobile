package com.epi.app.service.user.dto

data class UserCreateRequest(
    var name: String,
    var password: String,
    var email: String,
    var cpf: String
)