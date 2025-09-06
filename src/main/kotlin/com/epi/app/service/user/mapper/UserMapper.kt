package com.epi.app.service.user.mapper

import com.epi.app.entity.user.User
import com.epi.app.service.user.dto.UserResponseDto
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toUserResponse(user: User): UserResponseDto {
        return UserResponseDto(
            id = user.id ?: 0,
            name = user.name,
            email = user.email,
            cpf = user.cpf
        )
    }
}