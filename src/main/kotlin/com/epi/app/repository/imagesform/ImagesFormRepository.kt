package com.epi.app.repository.imagesform

import com.epi.app.entity.imagesform.ImagesForm
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImagesFormRepository : JpaRepository<ImagesForm, Long> {
}