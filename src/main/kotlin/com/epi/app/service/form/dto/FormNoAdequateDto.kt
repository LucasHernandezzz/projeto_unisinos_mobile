package com.epi.app.service.form.dto

import com.epi.app.service.form.Enum.EpiState
import com.epi.app.service.form.Enum.EpiUse

data class FormNoAdequateDto(
    var count: Int,
    var countNoAdequate: Int
)

