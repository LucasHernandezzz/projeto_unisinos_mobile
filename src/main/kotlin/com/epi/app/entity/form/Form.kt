package com.epi.app.entity.form

import com.epi.app.service.form.Enum.EpiState
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tb_forms")
data class Form(

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "use_mandatory")
    val useMandatory: Boolean,
    @Column(name = "use_Adequate")
    val useAdequate: Boolean,
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    val state: EpiState,
    @Column(name = "place_adequate")
    val adequatePlace: Boolean,
    @Column(name = "user_id")
    val user: String,
    @Column(name = "date_register")
    val dateRegister: LocalDateTime,

    )
