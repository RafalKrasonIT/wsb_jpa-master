import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

public class PatientServiceTest {

    @Mock
    private PatientEntity patientRepository;

    @Mock
    private VisitEntity visitRepository;

    @Mock
    private DoctorEntity doctorRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeletingPatientAlsoDeletesVisitsButNotDoctors() {
        // Przygotowanie danych
        DoctorEntity doctor = new DoctorEntity();
        PatientEntity patient = new PatientEntity();
        VisitEntity visit1 = new VisitEntity();
        VisitEntity visit2 = new VisitEntity();
        List<VisitEntity> visits = Arrays.asList(visit1, visit2);

        // Konfiguracja zachowania mocków
        when(visitRepository.findAllByPatientId(patient.getId())).thenReturn(visits);
        doNothing().when(visitRepository).deleteAll(visits);

        // Akcja: usunięcie pacjenta
        patientService.deletePatient(patient.getId());

        // Weryfikacja: czy wszystkie wizyty zostały usunięte
        verify(visitRepository).deleteAll(visits);

        // Weryfikacja: czy nie usunięto doktorów (sprawdzenie braku interakcji z repozytorium doktorów)
        verifyNoInteractions(doctorRepository);

    }
}
