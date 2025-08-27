package com.epi.app.service.collaborator.dto

data class CollaboratorCreateDto(
    var name: String,
    var email: String,
    var cpf: String,
    var signature: String
)