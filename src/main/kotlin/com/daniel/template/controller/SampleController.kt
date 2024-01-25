package com.daniel.template.controller

import com.daniel.template.service.VehicleService
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@Tag(name = "테스트", description = "설명 ")
@RequestMapping("/api")
@RestController
class SampleController(val vehicleService: VehicleService) {
    private val logger = KotlinLogging.logger {}

    @Operation(summary = "차량 정보", description = "차량정보 조회")
    @GetMapping("/vehicles/{vin}")
    suspend fun vehicle(
        @PathVariable vin: String) =
        runCatching { vehicleService.retrieveVehicle(vin) }
            .onFailure {
                logger.error(it) { "failed to call from Database"}
            }
            .map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.badRequest() }

    @Operation(summary = "차량 정보 생성", description = "차량정보 생성")
    @PutMapping("/vehicles/{vin}")
    suspend fun put(
        @PathVariable vin: String) =
        runCatching { vehicleService.create(vin) }
            .onFailure {
                logger.error(it) { "failed to call from Database"}
            }
            .map { ResponseEntity.ok(it) }
            .getOrElse { ResponseEntity.badRequest() }
}