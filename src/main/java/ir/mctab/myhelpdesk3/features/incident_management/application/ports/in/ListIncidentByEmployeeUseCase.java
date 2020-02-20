package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in;

import ir.mctab.myhelpdesk3.core.annotations.UseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.ListIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.ListIncidentByEmployeeOutcome;

@UseCase
public interface ListIncidentByEmployeeUseCase {

    ListIncidentByEmployeeOutcome list(ListIncidentByEmployeeCommand command) throws Exception;
}
