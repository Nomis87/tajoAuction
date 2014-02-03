package com.tajoAuction.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 14:58
 */
@javax.persistence.Table(name = "auction", schema = "public", catalog = "tajoauction")
@Entity
public class AuctionEntity {
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

    private Timestamp startTime;

    @javax.persistence.Column(name = "start_time")
    @Basic
    Timestamp getStartTime() {
        return startTime;
    }

    void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    private Timestamp endTime;

    @javax.persistence.Column(name = "end_time")
    @Basic
    Timestamp getEndTime() {
        return endTime;
    }

    void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    private short status;

    @javax.persistence.Column(name = "status")
    @Basic
    short getStatus() {
        return status;
    }

    void setStatus(short status) {
        this.status = status;
    }

    private double startPrice;

    @javax.persistence.Column(name = "start_price")
    @Basic
    double getStartPrice() {
        return startPrice;
    }

    void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    private int length;

    @javax.persistence.Column(name = "length")
    @Basic
    int getLength() {
        return length;
    }

    void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuctionEntity that = (AuctionEntity) o;

        if (id != that.id) return false;
        if (length != that.length) return false;
        if (Double.compare(that.startPrice, startPrice) != 0) return false;
        if (status != that.status) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (int) status;
        temp = Double.doubleToLongBits(startPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + length;
        return result;
    }

    private AppointmentEntity appointmentByAppointment;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "appointment", referencedColumnName = "id", nullable = false)
    AppointmentEntity getAppointmentByAppointment() {
        return appointmentByAppointment;
    }

    void setAppointmentByAppointment(AppointmentEntity appointmentByAppointment) {
        this.appointmentByAppointment = appointmentByAppointment;
    }

    private Collection<BidEntity> bidsById;

    @OneToMany(mappedBy = "auctionByAuction")
    Collection<BidEntity> getBidsById() {
        return bidsById;
    }

    void setBidsById(Collection<BidEntity> bidsById) {
        this.bidsById = bidsById;
    }
}
