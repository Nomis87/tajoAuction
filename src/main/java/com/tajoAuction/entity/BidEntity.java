package com.tajoAuction.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * User: Tobias
 * Date: 02.02.14
 * Time: 14:58
 */
@javax.persistence.Table(name = "bid", schema = "public", catalog = "tajoauction")
@Entity
public class BidEntity {
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

    private double value;

    @javax.persistence.Column(name = "value")
    @Basic
    double getValue() {
        return value;
    }

    void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BidEntity bidEntity = (BidEntity) o;

        if (id != bidEntity.id) return false;
        if (Double.compare(bidEntity.value, value) != 0) return false;
        if (createdAt != null ? !createdAt.equals(bidEntity.createdAt) : bidEntity.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(bidEntity.updatedAt) : bidEntity.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    private AuctionEntity auctionByAuction;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "auction", referencedColumnName = "id", nullable = false)
    AuctionEntity getAuctionByAuction() {
        return auctionByAuction;
    }

    void setAuctionByAuction(AuctionEntity auctionByAuction) {
        this.auctionByAuction = auctionByAuction;
    }

    private UserEntity userByUser;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    UserEntity getUserByUser() {
        return userByUser;
    }

    void setUserByUser(UserEntity userByUser) {
        this.userByUser = userByUser;
    }
}
