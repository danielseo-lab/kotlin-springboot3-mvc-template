package com.daniel.template.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime


@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
open class BaseEntity {
    @CreatedDate
    @Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    var createdAt: ZonedDateTime = ZonedDateTime.now();

    @LastModifiedDate
    @Column(name = "UPDATED_AT", columnDefinition = "TIMESTAMP", nullable = false)
    var updatedAt: ZonedDateTime = ZonedDateTime.now();
}