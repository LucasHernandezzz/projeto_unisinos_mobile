package com.epi.app.controller.form

import com.epi.app.service.form.FormService
import com.epi.app.service.form.dto.FormCreateDto
import com.epi.app.service.form.dto.FormNoAdequateDto
import com.epi.app.service.form.dto.FormResponseDto
import com.epi.app.service.form.dto.FormUpdateDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/form")
class FormController(private val formService: FormService) {

    @PostMapping("/register")
    fun registerForm(@RequestBody dto: FormCreateDto): ResponseEntity<Any> {
        formService.create(dto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/{idFormulario}/assinar")
    fun registerForm(@RequestBody dto: FormUpdateDto, @PathVariable idFormulario: Long): ResponseEntity<Any> {
        formService.updateUserToForm(idFormulario, dto)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @GetMapping()
    fun getAllForms(): List<FormResponseDto> {
        return formService.findAll()
    }

    @GetMapping("/count")
    fun getFormsCount(): FormNoAdequateDto {
        return formService.countForm()
    }
}