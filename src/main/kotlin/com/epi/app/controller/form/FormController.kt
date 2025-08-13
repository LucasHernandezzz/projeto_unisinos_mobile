package com.epi.app.controller.form

import com.epi.app.service.form.FormService
import com.epi.app.service.form.dto.FormRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/form")
class FormController(private val formService: FormService) {

    @PostMapping("/register")
    fun registerForm(@RequestBody dto: FormRequest): ResponseEntity<Any> {
        formService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}