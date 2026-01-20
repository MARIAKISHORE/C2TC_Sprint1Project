package com.devmart.mallaxisservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MallAxisService {

    @Autowired
    private MallAxisRepository vault;

    public List<MallUnitEntity> getAllUnits() {
        return vault.findAll();
    }

    public MallUnitEntity getUnitById(Integer id) {
        return vault.findById(id).orElseThrow();
    }

    public void saveUnit(MallUnitEntity unit) {
        vault.save(unit);
    }

    public void deleteUnit(Integer id) {
        vault.deleteById(id);
    }
}
