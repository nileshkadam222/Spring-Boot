package io.hashtips.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Customer {
    @Id
    private Long customerId;
    private String customerName;
    @ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    @JoinTable(name = "customer_vehicle",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id")
    )
    @JsonIgnore
    private Collection<Vehicle> vehicles = new ArrayList<>();


    public Long getCustomerId() {
        return customerId;

    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
