package com.epi.app.controller.user

import com.epi.app.service.user.UserService
import com.epi.app.service.user.dto.UserCreateDto
import com.epi.app.service.user.dto.UserResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/user"])
class UserController(private val userService: UserService) {

    @PostMapping("/create")
    fun create(@RequestBody dto: UserCreateDto): ResponseEntity<Any> {
        userService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserResponseDto> {
        val user = userService.getUserById(id)
        return ResponseEntity.status(HttpStatus.OK).body(user)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserResponseDto>> {
        val users = userService.getAllUsers()
        return ResponseEntity.ok(users)
    }

    @GetMapping("/me")
    fun getCurrentUser(authentication: Authentication): ResponseEntity<UserResponseDto> {
        val userEmail = authentication.name

        val currentUser = userService.getUserByEmail(userEmail)

        return ResponseEntity.ok(currentUser)
    }
}