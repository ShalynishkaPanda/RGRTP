package com.Utis;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brands", nullable = false, length = 50)
    private String brands;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "free", nullable = false)
    private Boolean free = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idrentplace", nullable = false)
    private RentPlace idRentPlace;

    @OneToMany(mappedBy = "idCar")
    private Set<Order> orders = new LinkedHashSet<>();

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public RentPlace getIdRentPlace() {
        return idRentPlace;
    }

    public void setIdRentPlace(RentPlace idRentPlace) {
        this.idRentPlace = idRentPlace;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}