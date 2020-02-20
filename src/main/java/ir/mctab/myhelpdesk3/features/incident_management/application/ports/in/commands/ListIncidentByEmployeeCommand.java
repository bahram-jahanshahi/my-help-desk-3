package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands;

import ir.mctab.myhelpdesk3.core.annotations.UseCaseCommand;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@ToString

@UseCaseCommand
public class ListIncidentByEmployeeCommand {

    private String searchTitle;
}
