package com.epi.app.service.form.dto

import com.epi.app.service.form.Enum.EpiState
import com.epi.app.service.form.Enum.EpiUse

data class FormResponseDto(
    var id: Long,
    var useMandatory: EpiUse,
    var useAdequate: EpiUse,
    var state: EpiState,
    var adequatePlace: EpiUse,
    var count: Int,
    var userId: Long
)

