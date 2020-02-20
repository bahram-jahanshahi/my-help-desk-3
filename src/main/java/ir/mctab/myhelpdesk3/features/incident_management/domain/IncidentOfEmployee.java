package ir.mctab.myhelpdesk3.features.incident_management.domain;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString

public class IncidentOfEmployee {

    private Long incidentId;

    private String incidentIssue;

    private String incidentDescription;

    private Date incidentCreateDate;

    private String status;
}
