package org.springframework.samples.petclinic.grooming;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/groomingtypes")
public class GroomingTypeController {

    private final GroomingTypeService grs;

    @Autowired
    public GroomingTypeController(GroomingTypeService grs) {
        this.grs = grs;
    }

    @GetMapping
    public ResponseEntity<List<GroomingType>> findAll() {
        List<GroomingType> list = grs.getAllGroomingTypes();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroomingType> findById(@PathVariable Integer id) {
        GroomingType gt = grs.getGroomingTypeById(id);
        if(gt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gt, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroomingType> create(@Valid @RequestBody GroomingType gt) {
        return new ResponseEntity<>(grs.save(gt), HttpStatus.CREATED);
    }


    
}
