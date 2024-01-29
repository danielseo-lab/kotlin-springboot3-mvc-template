package com.daniel.template.bootstrap.config

import com.daniel.template.application.port.input.VehicleInputPort
import com.daniel.template.application.port.output.VehicleOutputPort
import com.daniel.template.application.usecase.VehicleUsecase
import com.daniel.template.framework.adapter.output.db.VehicleDbAdapter
import com.daniel.template.framework.adapter.output.db.repository.VehicleRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SampleRestConfig(private val vehicleRepository: VehicleRepository) {

    @Bean
    fun vehicleUsecase(vehicleOutputPort: VehicleOutputPort): VehicleUsecase =
        VehicleInputPort(vehicleOutputPort)

    @Bean
    fun vehicleOutputPort(): VehicleOutputPort {
        return VehicleDbAdapter(vehicleRepository)
    }
}