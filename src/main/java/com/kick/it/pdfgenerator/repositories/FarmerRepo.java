package com.kick.it.pdfgenerator.repositories;

import com.kick.it.pdfgenerator.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepo extends JpaRepository<Farmer,Long> {
}
