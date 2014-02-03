package com.tajoAuction.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 14:58
 */
@javax.persistence.Table(name = "appointment", schema = "public", catalog = "tajoauction")
@Entity
public class AppointmentEntity {
    private int id;

    @javax.persistence.Column(name = "id")
    @Id
    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    private Timestamp createdAt;

    @javax.persistence.Column(name = "created_at")
    @Basic
    Timestamp getCreatedAt() {
        return createdAt;
    }

    void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    private Timestamp updatedAt;

    @javax.persistence.Column(name = "updated_at")
    @Basic
    Timestamp getUpdatedAt() {
        return updatedAt;
    }

    void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    private short category;

    @javax.persistence.Column(name = "category")
    @Basic
    short getCategory() {
        return category;
    }

    void setCategory(short category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointmentEntity that = (AppointmentEntity) o;

        if (category != that.category) return false;
        if (id != that.id) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (int) category;
        return result;
    }

}
