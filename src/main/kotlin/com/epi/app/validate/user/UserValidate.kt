package com.epi.app.validate.user

import com.epi.app.exceptions.ValidationException
import com.epi.app.repository.user.UserRepository
import com.epi.app.service.user.dto.UserCreateDto
import org.springframework.stereotype.Component

@Component
class UserValidate(private val userRepository: UserRepository) {

    fun validateUserCreation(dto: UserCreateDto): Boolean {
        if (userRepository.existsByEmail(dto.email)) {
            throw ValidationException("O email ${dto.email} já está em uso.")
        }
        if (userRepository.existsByCpf(dto.cpf)) {
            throw ValidationException("O cpf ${dto.cpf} já está em uso.")
        }
        return true
    }
}