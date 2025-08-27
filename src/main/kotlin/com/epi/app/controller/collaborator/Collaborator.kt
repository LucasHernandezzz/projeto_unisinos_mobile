package com.epi.app.controller.collaborator

import com.epi.app.service.collaborator.CollaboratorService
import com.epi.app.service.collaborator.dto.CollaboratorCreateDto
import com.epi.app.service.collaborator.dto.CollaboratorResponseDto
import com.epi.app.service.user.UserService
import com.epi.app.service.user.dto.UserCreateDto
import com.epi.app.service.user.dto.UserResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/collaborator"])
class Collaborator(private val collaboratorService: CollaboratorService) {

    @PostMapping("/create")
    fun create(@RequestBody dto: CollaboratorCreateDto): ResponseEntity<Any> {
        collaboratorService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<CollaboratorResponseDto> {
        val colab = collaboratorService.getCollabById(id)
        return ResponseEntity.status(HttpStatus.OK).body(colab)
    }
}