package com.daniel.template.repository

import com.daniel.template.entity.Vehicle
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import jakarta.transaction.Transactional
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
@Transactional
class VehicleRepositoryTest (
    vehicleRepository: VehicleRepository
) : DescribeSpec({
    // Spring
    extension(SpringExtension)

    val testId = "15412"

    describe("차량 저장"){
        context("차대번호가 15412인 데이터가 있는 경우"){
            vehicleRepository.save(Vehicle(vin = testId))
            it("저장된 데이터를 반환한다."){
                val record = vehicleRepository.findByVin(testId)

                record.vin shouldBe testId
                record.createdAt.shouldNotBeNull()
                record.updatedAt.shouldNotBeNull()
            }
        }
    }
})