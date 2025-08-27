package com.epi.app.entity.imagesform

import com.epi.app.entity.form.Form
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table(name = "tb_form_img")
data class ImagesForm(

    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "image_name")
    val imageName: String,
    @Lob
    @Column(name = "image")
    val imageBase64: String,
    @ManyToOne
    @JoinColumn(name = "form_id")
    val form: Form,

    )
