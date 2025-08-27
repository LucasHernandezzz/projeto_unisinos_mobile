package com.epi.app.controller.imagesform

import com.epi.app.service.imagesform.ImagesFormService
import com.epi.app.service.imagesform.dto.ImageFormCreateDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/images-form")
class ImagesFormController(private val imagesFormService: ImagesFormService) {

    @PostMapping()
    fun saveImage(@RequestBody dto: ImageFormCreateDto): ResponseEntity<Any> {
        imagesFormService.saveImage(dto)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}