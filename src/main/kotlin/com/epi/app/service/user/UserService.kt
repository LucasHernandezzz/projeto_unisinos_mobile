package com.epi.app.service.user

import com.epi.app.entity.user.User
import com.epi.app.exceptions.ValidationException
import com.epi.app.repository.user.UserRepository
import com.epi.app.service.user.dto.UserCreateDto
import com.epi.app.service.user.dto.UserResponseDto
import com.epi.app.service.user.mapper.UserMapper
import com.epi.app.validate.user.UserValidate
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper,
    private val userValidate: UserValidate,
    private val passwordEncoder: PasswordEncoder
) {
    fun create(dto: UserCreateDto) {

        userValidate.validateUserCreation(dto)

        val user: User = User(
            name = dto.name,
            cpf = dto.cpf,
            email = dto.email,
            password = passwordEncoder.encode(dto.password),
        )
        userRepository.save(user)
    }

    fun getUserById(id: Long): UserResponseDto? {
        val user = userRepository.findById(id).orElseThrow { ValidationException("Usuário não encontrado") }
        return userMapper.toUserResponse(user)
    }

    fun getEntityById(id: Long): User {
        return userRepository.findById(id)
            .orElseThrow { Exception("Usuário com ID $id não encontrado") }
    }
}