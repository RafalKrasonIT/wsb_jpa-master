package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientDao extends JpaRepository<PatientEntity, Long> {


    Optional<PatientEntity> findById(Long id);

    List<PatientEntity> findAll();

    PatientEntity save(PatientEntity patient);

    @Override
    void delete(PatientEntity patient);

}
