package com.epi.app.entity.collaborator

import jakarta.persistence.*

@Entity
@Table(name = "tb_collaborator_user")
data class Collaborator(

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "cpf")
    val cpf: String,

    @Column(name = "signature")
    val signature: String,

    @Column(name = "idInspection")
    var idInspection: Long,
)
