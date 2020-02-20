package ir.mctab.myhelpdesk3.features.incident_management.application;

import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.SubmitIncidentByEmployeeUseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.SubmitIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.exceptions.SubmitIncidentByEmployeeException;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.SubmitIncidentByEmployeeOutcome;
import org.springframework.stereotype.Service;

@Service
public class SubmitIncidentService implements SubmitIncidentByEmployeeUseCase {
    @Override
    public SubmitIncidentByEmployeeOutcome submit(SubmitIncidentByEmployeeCommand command) throws SubmitIncidentByEmployeeException {

        return null;
    }
}
