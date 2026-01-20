package com.devmart.mallaxisservice;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mallaxis")
@CrossOrigin(origins = "http://localhost:4200")
public class MallAxisController {

    @Autowired
    private MallAxisService logic;

    // GET all mall units
    @GetMapping
    public List<MallUnitEntity> listAll() {
        return logic.getAllUnits();
    }

    // GET mall unit by ID
    @GetMapping("/{id}")
    public ResponseEntity<MallUnitEntity> get(@PathVariable Integer id) {
        try {
            MallUnitEntity unit = logic.getUnitById(id);
            return new ResponseEntity<>(unit, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // CREATE mall unit
    @PostMapping
    public ResponseEntity<?> add(@RequestBody MallUnitEntity unit) {
        logic.saveUnit(unit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // UPDATE mall unit
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,
                                    @RequestBody MallUnitEntity unit) {
        try {
            MallUnitEntity existing = logic.getUnitById(id);
            existing.setUnitName(unit.getUnitName());
            existing.setUnitType(unit.getUnitType());
            existing.setFloorNumber(unit.getFloorNumber());
            existing.setStatus(unit.getStatus());
            existing.setRentAmount(unit.getRentAmount());

            logic.saveUnit(existing);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE mall unit
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            logic.deleteUnit(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
