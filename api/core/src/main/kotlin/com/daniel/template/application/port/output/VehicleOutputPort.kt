package com.daniel.template.application.port.output

import com.daniel.template.domain.entity.Vehicle
import com.daniel.template.domain.vo.VIN


interface VehicleOutputPort {
    suspend fun retrieveVehicle(vin: VIN): Vehicle

    suspend fun create(vehicle: Vehicle): Vehicle
}