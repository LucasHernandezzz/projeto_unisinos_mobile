package com.epi.app.service.user.mapper

import com.epi.app.entity.user.User
import com.epi.app.service.user.dto.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toUserResponse(user: User): UserResponse {
        return UserResponse(
            name = user.name,
            cpf = user.cpf
        )
    }
}