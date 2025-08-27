package com.epi.app.service.user.dto

data class UserCreateDto(
    var name: String,
    var password: String,
    var email: String,
    var cpf: String
)