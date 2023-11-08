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

    @NotNull
    @ManyToOne(optional = false)
    GroomingPackage groomingPackage;    

    @ManyToMany
    @NotNull
    List<Visit> consumed;
}

