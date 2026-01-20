package com.devmart.staffsphereservice;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/staffsphere")
public class StaffSphereController {

    @Autowired
    private StaffSphereService logic;

    // GET all staff
    @GetMapping
    public List<StaffEntity> listAll() {
        return logic.listAll();
    }

    // GET staff by ID
    @GetMapping("/{id}")
    public ResponseEntity<StaffEntity> get(@PathVariable Integer id) {
        try {
            StaffEntity staff = logic.get(id);
            return new ResponseEntity<>(staff, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // CREATE staff
    @PostMapping
    public ResponseEntity<?> add(@RequestBody StaffEntity staff) {
        logic.save(staff);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // UPDATE staff
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody StaffEntity staff, @PathVariable Integer id) {
        try {
            StaffEntity existing = logic.get(id);
            existing.setStaffName(staff.getStaffName());
            existing.setRole(staff.getRole());
            existing.setSalary(staff.getSalary());
            existing.setDepartment(staff.getDepartment());
            existing.setShiftTiming(staff.getShiftTiming());

            logic.save(existing);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE staff
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            logic.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
