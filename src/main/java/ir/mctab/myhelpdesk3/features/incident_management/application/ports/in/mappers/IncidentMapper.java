package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.mappers;

import ir.mctab.myhelpdesk3.core.annotations.Mapper;
import ir.mctab.myhelpdesk3.entities.Incident;
import ir.mctab.myhelpdesk3.features.incident_management.domain.IncidentOfEmployee;

@Mapper
public class IncidentMapper {

    public static IncidentOfEmployee map(Incident incident) {
        return new IncidentOfEmployee(
                incident.getId(),
                incident.getIssue(),
                incident.getDescription(),
                incident.getCreateDate(),
                incident.getStatus()
        );
    }
}
