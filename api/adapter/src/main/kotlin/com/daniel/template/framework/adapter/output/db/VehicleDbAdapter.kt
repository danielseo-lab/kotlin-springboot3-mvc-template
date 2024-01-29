package com.daniel.template.framework.adapter.output.db

import com.daniel.template.application.port.output.VehicleOutputPort
import com.daniel.template.domain.entity.Vehicle
import com.daniel.template.domain.vo.VIN
import com.daniel.template.framework.adapter.output.db.repository.VehicleRepository
import com.daniel.template.framework.mapper.VehicleMapper.Companion.toDomain
import com.daniel.template.framework.mapper.VehicleMapper.Companion.toTable
import org.springframework.stereotype.Service


@Service
class VehicleDbAdapter(private val vehicleRepository: VehicleRepository) : VehicleOutputPort {
    override suspend fun retrieveVehicle(vin: VIN): Vehicle =
        vehicleRepository.findByVin(vin.value).toDomain()

    override suspend fun create(vehicle: Vehicle): Vehicle =
        vehicleRepository.save(vehicle.toTable()).toDomain()
}