package ir.mctab.myhelpdesk3.features.incident_management.application;

import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.ListIncidentByEmployeeUseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.ListIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.ListIncidentByEmployeeOutcome;
import org.springframework.stereotype.Service;

@Service
public class ListIncidentService implements ListIncidentByEmployeeUseCase {
    @Override
    public ListIncidentByEmployeeOutcome list(ListIncidentByEmployeeCommand command) throws Exception {
        return null;
    }
}
