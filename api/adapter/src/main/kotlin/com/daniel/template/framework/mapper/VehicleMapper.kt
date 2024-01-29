package com.daniel.template.framework.mapper

import com.daniel.template.domain.entity.Vehicle
import com.daniel.template.framework.adapter.input.rest.vo.VehicleResponse
import com.daniel.template.framework.adapter.output.db.table.VehicleTable
import org.mapstruct.*
import org.mapstruct.factory.Mappers

/**
 * 매퍼 클래스의 함수는 @Mapping을 설정하지 않더라도 기본적으로 세팅하게 되어 있다.
 */
@Mapper(
    unmappedTargetPolicy = ReportingPolicy.WARN,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
)
interface VehicleMapper {
    fun to(entity: VehicleTable): VehicleResponse

    @Mapping(target = "vin", source = "vin.value")
    fun toResponse(vehicle: Vehicle): VehicleResponse

    @Mapping(target = "vin.value", source = "vin")
    fun toDomain(entity: VehicleTable): Vehicle

    @Mapping(target = "vin", source = "vin.value")
    fun toTable(vehicle: Vehicle): VehicleTable

    @Mapping(target = "vin.value", source = "vin")
    fun from(vin: String): Vehicle

    companion object {
        val INSTNACE = Mappers.getMapper(VehicleMapper::class.java)
        inline fun Vehicle.toResponse() = INSTNACE.toResponse(this)
        inline fun String.toDomain() = INSTNACE.from(this)

        inline fun VehicleTable.toDomain() = INSTNACE.toDomain(this)
        inline fun Vehicle.toTable() = INSTNACE.toTable(this)
    }
}