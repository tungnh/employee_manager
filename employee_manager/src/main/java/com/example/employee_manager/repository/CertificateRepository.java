package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.domain.Position;
import com.example.employee_manager.domain.Skill;
import com.example.employee_manager.service.dto.CertificateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Integer> {
    Page<Certificate> findByNameContaining(String search, Pageable pageable);
    List<Certificate> findByEmployeeId(int id);
}
