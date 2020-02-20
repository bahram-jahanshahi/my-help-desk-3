package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes;

import ir.mctab.myhelpdesk3.core.annotations.UseCaseOutcome;
import ir.mctab.myhelpdesk3.features.incident_management.domain.IncidentOfEmployee;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter

@UseCaseOutcome
public class ListIncidentByEmployeeOutcome {
    List<IncidentOfEmployee> incidentsOfEmployee;
}
