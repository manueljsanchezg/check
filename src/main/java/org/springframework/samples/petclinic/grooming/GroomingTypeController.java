package org.springframework.samples.petclinic.grooming;

import java.net.ResponseCache;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/groomingtypes")
public class GroomingTypeController {

    private GroomingTypeService gts;

    @Autowired
    public GroomingTypeController(GroomingTypeService gts) {
        this.gts = gts;
    }

    @GetMapping
    public ResponseEntity<List<GroomingType>> getAll() {
        List<GroomingType> l = gts.getAllGroomingTypes();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroomingType> getGroomingTypeById(@PathVariable Integer id) {
        GroomingType gt = gts.getGroomingTypeById(id);
        if(gt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gt, HttpStatus.OK);
    }

    
    
}
