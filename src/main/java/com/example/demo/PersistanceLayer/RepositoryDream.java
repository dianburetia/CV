package com.example.demo.PersistanceLayer;

import com.example.demo.models.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryDream extends JpaRepository<Dream, Long>{
        //Painting findByName(String name);
}
