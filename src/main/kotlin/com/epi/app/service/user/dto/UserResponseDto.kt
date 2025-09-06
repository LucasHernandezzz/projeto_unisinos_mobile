package com.epi.app.service.user.dto

data class UserResponseDto(
    var id: Long,
    var name: String,
    var email: String,
    var cpf: String
)