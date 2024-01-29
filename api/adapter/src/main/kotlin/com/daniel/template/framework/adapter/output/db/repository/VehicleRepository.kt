package com.daniel.template.framework.adapter.output.db.repository

import com.daniel.template.framework.adapter.output.db.table.VehicleTable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository : JpaRepository<VehicleTable, Long> {
    /**
     * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
     */
    fun findByVin(vin: String): VehicleTable
}