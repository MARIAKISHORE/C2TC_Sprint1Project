package com.devmart.staffsphereservice;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
}

