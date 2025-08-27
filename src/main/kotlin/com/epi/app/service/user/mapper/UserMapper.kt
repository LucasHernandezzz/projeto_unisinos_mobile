package com.epi.app.service.user.mapper

import com.epi.app.entity.user.User
import com.epi.app.service.user.dto.UserResponseDto
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toUserResponse(user: User): UserResponseDto {
        return UserResponseDto(
            name = user.name,
            cpf = user.cpf
        )
    }
}