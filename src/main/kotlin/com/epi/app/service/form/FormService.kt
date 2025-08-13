package com.epi.app.service.form

import com.epi.app.entity.form.Form
import com.epi.app.repository.form.FormRepository
import com.epi.app.service.form.Enum.EpiState
import com.epi.app.service.form.dto.FormRequest
import com.epi.app.service.user.dto.UserCreateRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FormService(val formRepository: FormRepository) {

    fun create(dto: FormRequest) {

        val form: Form = Form(
            useMandatory = dto.useMandatory,
            useAdequate = dto.useAdequate,
            state = dto.state,
            adequatePlace = dto.adequatePlace,
            dateRegister = LocalDateTime.now(),
            user = dto.user
        )
        formRepository.save(form)
    }
}