package org.springframework.samples.petclinic.grooming;

import java.util.List;

import org.springframework.samples.petclinic.model.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroomingPackage extends BaseEntity {
    @DecimalMin("0.01")
    @NotNull
    double cost;

    @NotNull
    @NotEmpty
    String description;

    @NotEmpty
    @NotNull
    @ManyToMany
    List<GroomingType> contents;
}
