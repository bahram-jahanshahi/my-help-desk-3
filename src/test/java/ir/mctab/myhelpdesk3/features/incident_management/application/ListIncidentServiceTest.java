package ir.mctab.myhelpdesk3.features.incident_management.application;

import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.ListIncidentByEmployeeUseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.ListIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.ListIncidentByEmployeeOutcome;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ListIncidentServiceTest {

    @Autowired
    ListIncidentByEmployeeUseCase listIncidentByEmployeeUseCase;

    @Test
    void listIncidentByEmployee() {
        ListIncidentByEmployeeCommand command = new ListIncidentByEmployeeCommand(
                "خراب",
                2L
        );

        try {
            ListIncidentByEmployeeOutcome outcome = listIncidentByEmployeeUseCase
                    .list(command);

            assertNotNull(outcome);
            assertNotNull(outcome.getIncidentsOfEmployee());
            assertEquals(0, outcome.getIncidentsOfEmployee().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
