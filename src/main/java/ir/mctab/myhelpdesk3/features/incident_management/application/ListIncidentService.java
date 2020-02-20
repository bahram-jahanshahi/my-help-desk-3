package ir.mctab.myhelpdesk3.features.incident_management.application;

import ir.mctab.myhelpdesk3.entities.Incident;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.ListIncidentByEmployeeUseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.ListIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.mappers.IncidentMapper;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.ListIncidentByEmployeeOutcome;
import ir.mctab.myhelpdesk3.repositories.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListIncidentService implements ListIncidentByEmployeeUseCase {

    final IncidentRepository incidentRepository;

    public ListIncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public ListIncidentByEmployeeOutcome list(ListIncidentByEmployeeCommand command) throws Exception {
        List<Incident> incidents = incidentRepository
                .findAllByIssueContainingAndSubmitBy_Id(
                        command.getSearchTitle(),
                        command.getUserId()
                );

        return new ListIncidentByEmployeeOutcome(
                incidents
                        .stream()
                        .map(IncidentMapper::map)
                        .collect(Collectors.toList())
        );
    }
}
