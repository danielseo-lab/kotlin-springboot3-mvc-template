package com.daniel.template.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.time.ZonedDateTime


@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
open class BaseEntity {

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    var createdAt: ZonedDateTime = ZonedDateTime.now();

    @UpdateTimestamp
    @Column(name = "UPDATED_AT", nullable = false)
    var updatedAt: ZonedDateTime = ZonedDateTime.now();
}