package com.daniel.template.service

import com.daniel.template.entity.Vehicle
import com.daniel.template.mapper.VehicleMapper
import com.daniel.template.repository.VehicleRepository
import com.daniel.template.vo.VehicleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service

@Service
class VehicleService(
    private val vehicleRepository: VehicleRepository,
) {
    suspend fun retrieveVehicle(vin: String): VehicleResponse {
        val vehicle = withContext(Dispatchers.IO) {
            vehicleRepository.findByVin(vin)
        }
        return VehicleMapper.INSTNACE.to(vehicle)
    }

    suspend fun create(vin: String): VehicleResponse {
        val vehicle = withContext(Dispatchers.IO) {
            vehicleRepository.save(Vehicle(vin = vin))
        }
        return VehicleMapper.INSTNACE.to(vehicle)
    }
}