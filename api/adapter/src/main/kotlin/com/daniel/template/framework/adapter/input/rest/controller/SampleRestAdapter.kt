package com.daniel.template.framework.adapter.input.rest.controller

import com.daniel.template.application.port.output.VehicleOutputPort
import com.daniel.template.domain.vo.VIN
import com.daniel.template.framework.mapper.VehicleMapper.Companion.toDomain
import com.daniel.template.framework.mapper.VehicleMapper.Companion.toResponse
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController


@Tag(name = "테스트", description = "설명")
@RestController
class SampleRestAdapter(
    private val vehicleOutputPort: VehicleOutputPort
) {
    private val logger = KotlinLogging.logger {}

    @Operation(summary = "차량 정보", description = "차량정보 조회")
    @GetMapping("/vehicles/{vin}")
    suspend fun vehicle(
        @PathVariable vin: String
    ) =
        runCatching {
            vehicleOutputPort.retrieveVehicle(VIN(vin)).toResponse()
        }.onFailure {
            logger.error(it) { "failed to call from Database" }
        }.map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.badRequest() }

    @Operation(summary = "차량 정보 생성", description = "차량정보 생성")
    @PutMapping("/vehicles/{vin}")
    suspend fun put(
        @PathVariable vin: String
    ) =
        runCatching {
            vehicleOutputPort.create(vin.toDomain())
        }.onFailure {
            logger.error(it) { "failed to call from Database" }
        }.map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.badRequest() }
}

//
//@Configuration
//object SampleRestAdapterBeans {
//
//    @Bean
//    fun vehicleOutputPort(vehicleRepository: VehicleRepository): VehicleOutputPort {
//        return VehicleDbAdapter(vehicleRepository)
//    }
//}