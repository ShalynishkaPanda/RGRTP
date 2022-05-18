package com.Utis;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dateorder", nullable = false)
    private LocalDate dateOrder;

    @Column(name = "cost", nullable = false, precision = 131089)
    private BigDecimal cost;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcar", nullable = false)
    private Car idCar;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcustomer", nullable = false)
    private Customer idCustomer;

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Car getIdCar() {
        return idCar;
    }

    public void setIdCar(Car idCar) {
        this.idCar = idCar;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}