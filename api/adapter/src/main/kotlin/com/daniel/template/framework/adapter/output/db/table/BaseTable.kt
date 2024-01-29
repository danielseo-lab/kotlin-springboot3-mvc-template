package com.daniel.template.framework.adapter.output.db.table

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime


@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
open class BaseTable {

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    var createdAt: ZonedDateTime = ZonedDateTime.now();

    @UpdateTimestamp
    @Column(name = "UPDATED_AT", nullable = false)
    var updatedAt: ZonedDateTime = ZonedDateTime.now();

}