package com.epi.app.controller.user

import com.epi.app.service.user.UserService
import com.epi.app.service.user.dto.UserCreateRequest
import com.epi.app.service.user.dto.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun create(@RequestBody dto: UserCreateRequest): ResponseEntity<Any> {
        userService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<UserResponse> {
        val user = userService.getUserById(id)
        return ResponseEntity.status(HttpStatus.OK).body(user)
    }
}