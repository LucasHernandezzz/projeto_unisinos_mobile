package com.epi.app.entity.form

import com.epi.app.entity.collaborator.Collaborator
import com.epi.app.entity.user.User
import com.epi.app.service.form.Enum.EpiState
import com.epi.app.service.form.Enum.EpiUse
import io.micrometer.observation.Observation
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
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
    @Column(name = "description_activity")
    val descriptionActivity: String,
    @Column(name = "use_mandatory")
    val useMandatory: EpiUse,
    @Column(name = "use_Adequate")
    val useAdequate: EpiUse,
    @Column(name = "sector")
    val sector: String,
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    val state: EpiState,
    @Column(name = "place_adequate")
    val adequatePlace: EpiUse,
    @Column(name = "inspectionDate")
    var inspectionDate: String,
    @Column(name = "startTime")
    var startTime: String,
    @Column(name = "endTime")
    var endTime: String,
    @Column(name = "useEpi")
    var useEpi: Number,
    @Column(name = "notUseEpi")
    var notUseEpi: Number,
    @ElementCollection
    @CollectionTable(name = "form_collaborators", joinColumns = [JoinColumn(name = "form_id")])
    @Column(name = "collaborator_id")
    val collaborators: MutableList<Long> = mutableListOf(),
    @Column(name = "date_register")
    val dateRegister: LocalDateTime,
    @Column(name = "observation")
    val observation: String,
    @Column(name = "created_by")
    val userId: Long,
    @Column(name = "count_signed")
    var countSigned: Int = 0,
    )

