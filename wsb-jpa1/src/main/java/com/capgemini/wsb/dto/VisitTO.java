package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {

    private Long id;
    private String description;
    private LocalDateTime time;
    private DoctorTO doctor;
    private PatientTO patient;
    // Załóżmy, że każda wizyta może mieć kilka zabiegów medycznych
    private List<MedicalTreatmentEntity> medicalTreatments;

    // Konstruktory, gettery i settery

    public VisitTO() {
        // Domyślny konstruktor
    }

    // Konstruktor z wszystkimi polami, jeśli to konieczne

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    public List<MedicalTreatmentEntity> getMedicalTreatments() {
        return medicalTreatments;
    }

    public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }

    // Możesz też dodać metody toString, equals, hashCode, jeśli będą potrzebne.
}
