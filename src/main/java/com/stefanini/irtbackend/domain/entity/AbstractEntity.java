package com.stefanini.irtbackend.domain.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDate createdDate;

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity otherEntity = (AbstractEntity) other;
        return Objects.equals(getId(), otherEntity.getId());
    }

    public int hashCode() {
        return getClass().hashCode();
    }

}
