package com.daniel.template.mapper

import com.daniel.template.entity.Vehicle
import com.daniel.template.vo.VehicleResponse
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
    fun to(entity: Vehicle): VehicleResponse

    companion object {
        val INSTNACE = Mappers.getMapper(VehicleMapper::class.java)
    }
}