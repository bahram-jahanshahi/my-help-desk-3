package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes;

import ir.mctab.myhelpdesk3.core.annotations.UseCaseOutcome;
import ir.mctab.myhelpdesk3.features.incident_management.domain.IncidentOfEmployee;

import java.util.List;

@UseCaseOutcome
public class ListIncidentByEmployeeOutcome {
    List<IncidentOfEmployee> incidentsOfEmployee;
}
