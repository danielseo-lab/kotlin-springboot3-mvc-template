package com.daniel.template.application.port.input

import com.daniel.template.application.port.output.VehicleOutputPort
import com.daniel.template.application.usecase.VehicleUsecase
import com.daniel.template.domain.entity.Vehicle
import com.daniel.template.domain.vo.VIN


class VehicleInputPort(private val vehicleOutputPort: VehicleOutputPort) : VehicleUsecase {
    override suspend fun retrieveVehicle(vin: VIN): Vehicle {
        return vehicleOutputPort.retrieveVehicle(vin)
    }

    override suspend fun create(vehicle: Vehicle): Vehicle {
        return vehicleOutputPort.create(vehicle)
    }
}