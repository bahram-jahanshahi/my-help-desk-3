package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in;

import ir.mctab.myhelpdesk3.entities.Incident;
import ir.mctab.myhelpdesk3.entities.IncidentLog;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.SubmitIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.exceptions.SubmitIncidentByEmployeeException;
import ir.mctab.myhelpdesk3.repositories.IncidentLogRepository;
import ir.mctab.myhelpdesk3.repositories.IncidentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SubmitIncidentByEmployeeUseCaseTest {

    @Autowired
    SubmitIncidentByEmployeeUseCase submitIncidentByEmployeeUseCase;

    @Autowired
    IncidentRepository incidentRepository;

    @Autowired
    IncidentLogRepository incidentLogRepository;

    @Test
    void submit() {
        try {
            String issue = "عدم اتصال به اینترنت";
            String description = "نمی توانم به سایت ورزش سه وصل شوم";
            Long incidentId =
                    submitIncidentByEmployeeUseCase.submit(
                            new SubmitIncidentByEmployeeCommand(
                                    issue,
                                    description,
                                    1L
                            )
                    ).getIncidentId();

            assertNotNull(incidentId);
            Incident incident = incidentRepository.findById(incidentId).get();

            List<IncidentLog> logs = incidentLogRepository.findAllByIncident_Id(incidentId);

            assertEquals(issue, incident.getIssue());
            assertEquals(description, incident.getDescription());
            assertEquals("Submitted", incident.getStatus());
            assertNotNull(incident.getSubmitBy());
            assertEquals(1L, incident.getSubmitBy().getId());
            assertEquals(1, logs.size());
            assertNotNull(logs.get(0).getTitle());
            assertEquals("Submit Incident", logs.get(0).getTitle());
            assertNotNull(logs.get(0).getCreateDate());
            assertNotNull(logs.get(0).getLogger());
            assertEquals(1L, logs.get(0).getLogger().getId());

        } catch (SubmitIncidentByEmployeeException e) {
            e.printStackTrace();
        }
    }
}
