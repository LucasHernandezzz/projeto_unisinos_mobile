package com.epi.app.service.form.dto

import com.epi.app.service.form.Enum.EpiState

data class FormResponseDto(
    var id: Long,
    var useMandatory: Boolean,
    var useAdequate: Boolean,
    var state: EpiState,
    var adequatePlace: Boolean,
    var count: Int
)

