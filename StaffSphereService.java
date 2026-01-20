package com.devmart.staffsphereservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StaffSphereService {

    @Autowired
    private StaffRepository vault;

    // Retrieve all staff
    public List<StaffEntity> listAll() {
        return vault.findAll();
    }

    // Save staff
    public void save(StaffEntity staff) {
        vault.save(staff);
    }

    // Get staff by ID
    public StaffEntity get(Integer id) {
        return vault.findById(id).get();
    }

    // Delete staff
    public void delete(Integer id) {
        vault.deleteById(id);
    }
}
