package org.springframework.samples.petclinic.grooming;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

public interface GroomingPackageRepository  {
    public GroomingPackage save(GroomingPackage o);
    public List<GroomingPackage> findAll();
    public Optional<GroomingPackage> findById(Integer id);

    @Query("SELECT gp FROM GroomingPackage gp") // TODO: Modify in exercise 7
    public List<GroomingPackage> findPackagesByDatesAndCost(LocalDate start,  LocalDate end, double cost);
}
