package com.example.apidisneyalkemy.repositories;

import com.example.apidisneyalkemy.entities.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {
}
