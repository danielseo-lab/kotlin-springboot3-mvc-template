package com.daniel.template.repository

import com.daniel.template.entity.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository : JpaRepository<Vehicle, Long> {
    /**
     * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
     */
    fun findByVin(vin: String): Vehicle
}