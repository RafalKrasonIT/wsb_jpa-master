package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;


public class VisitMapper {

    public static VisitTO mapToTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());

        // Założenie: Klasa DoctorMapper i PatientMapper mają metodę mapToTO.
        DoctorTO doctorTO = DoctorMapper.mapToTO(visitEntity.getDoctor());
        visitTO.setDoctor(doctorTO);

        PatientTO patientTO = PatientMapper.mapToTO(visitEntity.getPatient());
        visitTO.setPatient(patientTO);

        // Mapowanie dla pola medicalTreatments jest opcjonalne i może być bardziej skomplikowane,
        // więc pominę je w tym przykładzie.

        return visitTO;
    }

    public static VisitEntity mapToEntity(VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());

        // Założenie: Klasa DoctorMapper i PatientMapper mają metodę mapToEntity.
        visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()));
        visitEntity.setPatient(PatientMapper.mapToEntity(visitTO.getPatient()));

        // Podobnie jak wyżej, mapowanie dla pola medicalTreatments pominięto.

        return visitEntity;
    }
}
