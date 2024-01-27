package com.example.demo.repositories;

import com.example.demo.DeviceId;
import com.example.demo.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceId, Long> {
}
