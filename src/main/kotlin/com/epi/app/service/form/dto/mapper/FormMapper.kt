package com.epi.app.service.form.dto.mapper

import com.epi.app.entity.form.Form
import com.epi.app.service.form.dto.FormResponseDto
import org.springframework.stereotype.Component

@Component
class FormMapper {

    fun toDto(form: Form): FormResponseDto {
        return FormResponseDto(
            id = form.id!!,
            useMandatory = form.useMandatory,
            useAdequate = form.useAdequate,
            state = form.state,
            adequatePlace = form.adequatePlace,
            userId =  form.userId,
            count = form.countSigned
        )
    }
    fun toDto(forms: List<Form>): List<FormResponseDto> {
        return forms.map { toDto(it) }
    }
}