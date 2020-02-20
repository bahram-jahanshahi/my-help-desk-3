package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in;

import ir.mctab.myhelpdesk3.core.annotations.UseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.SubmitIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.exceptions.SubmitIncidentByEmployeeException;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.SubmitIncidentByEmployeeOutcome;

@UseCase
public interface SubmitIncidentByEmployeeUseCase {

    SubmitIncidentByEmployeeOutcome submit(SubmitIncidentByEmployeeCommand command) throws SubmitIncidentByEmployeeException;
}
