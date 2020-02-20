package ir.mctab.myhelpdesk3.features.incident_management.application;

import ir.mctab.myhelpdesk3.entities.Incident;
import ir.mctab.myhelpdesk3.entities.IncidentLog;
import ir.mctab.myhelpdesk3.entities.security.User;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.SubmitIncidentByEmployeeUseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.SubmitIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.exceptions.SubmitIncidentByEmployeeException;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.SubmitIncidentByEmployeeOutcome;
import ir.mctab.myhelpdesk3.repositories.IncidentLogRepository;
import ir.mctab.myhelpdesk3.repositories.IncidentRepository;
import ir.mctab.myhelpdesk3.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SubmitIncidentService implements SubmitIncidentByEmployeeUseCase {

    final UserRepository userRepository;
    final IncidentRepository incidentRepository;
    final IncidentLogRepository incidentLogRepository;

    public SubmitIncidentService(UserRepository userRepository, IncidentRepository incidentRepository, IncidentLogRepository incidentLogRepository) {
        this.userRepository = userRepository;
        this.incidentRepository = incidentRepository;
        this.incidentLogRepository = incidentLogRepository;
    }

    @Override
    public SubmitIncidentByEmployeeOutcome submit(SubmitIncidentByEmployeeCommand command) throws SubmitIncidentByEmployeeException {
        User submitBy = userRepository.getOne(command.getUserId());
        Incident incident = new Incident(
                null,
                command.getIssue(),
                command.getDescription(),
                new Date(),
                submitBy,
                "Submitted"
        );
        incidentRepository.saveAndFlush(incident);
        IncidentLog log = new IncidentLog(
                null,
                "Submit Incident",
                new Date(),
                submitBy,
                incident
        );
        incidentLogRepository.save(log);
        return new SubmitIncidentByEmployeeOutcome(incident.getId());
    }
}
