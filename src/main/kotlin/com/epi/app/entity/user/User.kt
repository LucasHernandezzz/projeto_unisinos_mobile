package com.epi.app.entity.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_users")
data class User(

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "name")
    val name: String,
    @Column(name = "cpf")
    val cpf: String,
    @Column(name = "email")
    val email: String,
    @Column(name = "password")
    val password: String,

)
