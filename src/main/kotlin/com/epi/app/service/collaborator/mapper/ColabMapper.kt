package com.epi.app.service.collaborator.mapper

import com.epi.app.entity.collaborator.Collaborator
import com.epi.app.entity.user.User
import com.epi.app.service.collaborator.dto.CollaboratorResponseDto
import com.epi.app.service.user.dto.UserResponseDto
import org.springframework.stereotype.Component

@Component
class ColabMapper {

    fun toColabResponse(colab: Collaborator): CollaboratorResponseDto {
        return CollaboratorResponseDto(
            name = colab.name,
            cpf = colab.cpf
        )
    }
}