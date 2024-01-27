package com.example.demo.repositories;
import com.example.demo.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Value, Long> {
}
