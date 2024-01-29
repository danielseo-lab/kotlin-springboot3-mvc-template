package com.daniel.template.domain.entity

import com.daniel.template.domain.vo.VIN
import java.time.ZonedDateTime

data class Vehicle(
    val vin: VIN,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
)