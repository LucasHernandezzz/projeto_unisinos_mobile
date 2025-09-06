package com.epi.app.service.form.dto

import com.epi.app.service.form.Enum.EpiState
import com.epi.app.service.form.Enum.EpiUse

data class FormUpdateDto(
    var useMandatory: EpiUse,
    var useAdequate: EpiUse,
    var state: EpiState,
    var adequatePlace: EpiUse,
    var userId: Long,
)