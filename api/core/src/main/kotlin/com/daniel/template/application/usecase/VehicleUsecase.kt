package com.daniel.template.application.usecase

import com.daniel.template.domain.entity.Vehicle
import com.daniel.template.domain.vo.VIN

interface VehicleUsecase {
    suspend fun retrieveVehicle(vin: VIN): Vehicle

    suspend fun create(vehicle: Vehicle): Vehicle
}