package org.springframework.samples.petclinic.grooming;

import java.util.List;

import org.springframework.samples.petclinic.model.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroomingPackage extends BaseEntity {
    
    @NotNull
    @Positive
    double cost;

    @NotEmpty
    String description;

    @NotEmpty
    @ManyToMany()
    List<GroomingType> contents;
}
