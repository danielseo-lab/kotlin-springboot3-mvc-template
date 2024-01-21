package com.daniel.template.entity

import jakarta.persistence.*

/**
 * 주의 entity 클래스는 절대로 data class를 사용하지 말자.
 * hibernate에서 lazy loading을 위해서 proxying을 하는데 이를 위해서 final 클래스(data class)를 사용하면 안된다.
 * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html#entity
 * 비정의 동작
 */
@Entity
@Table(name = "VEHICLE")
class Vehicle (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq: Long = 0L,
    @Column(name ="VIN", nullable = false, length = 50)
    var vin: String = "",
) : BaseEntity()