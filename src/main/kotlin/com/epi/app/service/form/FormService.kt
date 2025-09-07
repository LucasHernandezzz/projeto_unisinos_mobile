package com.epi.app.service.form

import com.epi.app.entity.collaborator.Collaborator
import com.epi.app.entity.form.Form
import com.epi.app.entity.user.User
import com.epi.app.exceptions.ValidationException
import com.epi.app.repository.form.FormRepository
import com.epi.app.service.collaborator.CollaboratorService
import com.epi.app.service.form.dto.FormCreateDto
import com.epi.app.service.form.dto.FormNoAdequateDto
import com.epi.app.service.form.dto.FormResponseDto
import com.epi.app.service.form.dto.FormUpdateDto
import com.epi.app.service.form.dto.mapper.FormMapper
import com.epi.app.service.user.UserService
import com.epi.app.service.user.enum.RoleUserEnum
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FormService(val formRepository: FormRepository, val userService: UserService, val collaboratorService: CollaboratorService, val mapper: FormMapper) {

    fun create(dto: FormCreateDto) {

        val user: User = userService.getEntityById(dto.userId)

        val form: Form = Form(
            useMandatory = dto.useMandatory,
            useAdequate = dto.useAdequate,
            state = dto.state,
            adequatePlace = dto.adequatePlace,
            dateRegister = LocalDateTime.now(),
            userId = dto.userId,
            observation = dto.observation,
            sector = dto.sector,
            collaboratorCpfs = dto.collaboratorCpf.toMutableList(),
            descriptionActivity = dto.descriptionActivity,
            inspectionDate = dto.inspectionDate,
            startTime = dto.startTime,
            endTime = dto.endTime,
            useEpi = dto.useEpi,
            notUseEpi = dto.notUseEpi,
        )
        formRepository.save(form)
    }

    @Transactional
    fun updateUserToForm(idFormulario: Long, dto: FormUpdateDto): Form {
        val form = findById(idFormulario)


        val collaborator: Collaborator = collaboratorService.getEntityById(dto.collaboratorId)

        if(!form.collaboratorCpfs.contains(collaborator.cpf)){
            form.collaboratorCpfs.add(collaborator.cpf)
            this.addCount(form)
        }
        return formRepository.save(form)
    }

    fun findAll(): List<FormResponseDto> {
        val forms: List<Form> = formRepository.findAll()
        return mapper.toDto(forms)
    }

    fun findById(id: Long): Form {
        val form = formRepository.findById(id).orElseThrow{ ValidationException("Usuário não encontrado") }
        return form;
    }

    private fun addCount(form: Form) {
        form.countSigned += 1
        formRepository.save(form)
    }

    public fun countForm(): FormNoAdequateDto {
        val count = formRepository.countForms()
        val countWithNoUseAdequate = formRepository.countFormsWithNoUseAdequate()

        return FormNoAdequateDto(
            count = count,
            countNoAdequate = countWithNoUseAdequate
        )
    }
}