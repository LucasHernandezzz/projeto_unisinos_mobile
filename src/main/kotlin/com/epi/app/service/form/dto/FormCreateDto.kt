package com.epi.app.service.form.dto

import com.epi.app.service.form.Enum.EpiState
import com.epi.app.service.form.Enum.EpiUse

data class FormCreateDto(
    var useMandatory: EpiUse,
    var useAdequate: EpiUse,
    var state: EpiState,
    var adequatePlace: EpiUse,
    var userId: Long,
    var observation: String,
    var descriptionActivity: String,
    var sector: String,
    var collaboratorIds: List<Long>,
    var inspectionDate: String,
    var startTime: String,
    var endTime: String,
    var useEpi: Number,
    var notUseEpi: Number
)