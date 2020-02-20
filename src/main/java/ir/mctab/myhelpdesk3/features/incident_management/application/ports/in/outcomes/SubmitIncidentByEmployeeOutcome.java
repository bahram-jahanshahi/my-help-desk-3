package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes;

import ir.mctab.myhelpdesk3.core.annotations.UseCaseOutcome;
import lombok.Value;

@Value

@UseCaseOutcome
public class SubmitIncidentByEmployeeOutcome {
    Long incidentId;
}
