package com.example.demo.Repository;

import com.example.demo.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mediaRepository extends JpaRepository<Media, Integer> {
    List<Media> findByOrderById();
}
