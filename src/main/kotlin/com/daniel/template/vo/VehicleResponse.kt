package com.daniel.template.vo

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.ZonedDateTime

data class VehicleResponse(
    val vin: String,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ssZ"
    )
    val createdAt: ZonedDateTime,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ssZ"
    )
    val updatedAt: ZonedDateTime,
)