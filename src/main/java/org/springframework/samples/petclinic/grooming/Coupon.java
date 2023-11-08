package org.springframework.samples.petclinic.grooming;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Coupon extends BaseEntity {
    
    @Column(name = "start")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    LocalDate startDate;
    
    @Column(name = "finish")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    LocalDate expiryDate;
    
    @Transient
    GroomingPackage groomingPackage;    

    @Transient
    List<Visit> consumed;
}

