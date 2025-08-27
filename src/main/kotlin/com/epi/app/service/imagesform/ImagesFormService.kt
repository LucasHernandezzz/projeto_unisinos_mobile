package com.epi.app.service.imagesform

import com.epi.app.entity.imagesform.ImagesForm
import com.epi.app.exceptions.ValidationException
import com.epi.app.repository.imagesform.ImagesFormRepository
import com.epi.app.service.form.FormService
import com.epi.app.service.imagesform.dto.ImageFormCreateDto
import org.springframework.stereotype.Service

@Service
class ImagesFormService(var imagesFormRepository: ImagesFormRepository, var formService: FormService) {

    fun saveImage(dto: ImageFormCreateDto) {

        val form = formService.findById(dto.formId)

        if (form == null) {
            ValidationException("Formulário não encontrado")
        }

        val imageForm: ImagesForm = ImagesForm(
                imageName = dto.nameImage,
                imageBase64 = dto.image,
                form = form,
        )
        imagesFormRepository.save(imageForm)
    }
}