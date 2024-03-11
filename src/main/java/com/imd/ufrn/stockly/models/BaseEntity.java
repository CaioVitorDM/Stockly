package com.imd.ufrn.stockly.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

/**
 * A mapped superclass representing the base entity in the application.
 * Provides common attributes like ID, creation/update timestamps, and deletion
 * flag for entities.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    private long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Getter
    @Setter
    protected ZonedDateTime createdAt;

    @Column(name = "updated_at")
    @Getter
    @Setter
    protected ZonedDateTime updatedAt;

    @Column(name = "active")
    @Setter
    protected boolean active = true;

    public boolean isActive() {
        return active;
    }

    /**
     * Defines the creation time before persisting the object on the database.
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    /**
     * Defines the update time before updating the object on the database.
     */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BaseEntity that = (BaseEntity) o;
        return active == that.active && Objects.equals(id, that.id) && Objects.equals(createdAt, that.createdAt)
                && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt, active);
    }
}
