package org.springframework.samples.petclinic.grooming;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "coupons")
public class Coupon extends BaseEntity {
    
    @NotNull
    @Column(name = "start")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate startDate;

    @NotNull
    @Column(name = "finish")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate expiryDate;
    
    @ManyToOne(optional = false)
    @NotNull
    GroomingPackage groomingPackage;    

    @ManyToMany
    @NotNull
    List<Visit> consumed;
}

