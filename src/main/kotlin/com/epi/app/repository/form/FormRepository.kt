package com.epi.app.repository.form

import com.epi.app.entity.form.Form
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FormRepository : JpaRepository<Form, Long> {
}