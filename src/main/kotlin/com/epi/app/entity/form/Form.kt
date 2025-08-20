package com.epi.app.entity.form

import com.epi.app.entity.user.User
import com.epi.app.service.form.Enum.EpiState
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tb_forms_users",
        joinColumns = [JoinColumn(name = "form_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    val user: MutableList<User> = mutableListOf(),
    @Column(name = "date_register")
    val dateRegister: LocalDateTime,
    @Column(name = "count_signed")
    var countSigned: Int = 0,
    )
