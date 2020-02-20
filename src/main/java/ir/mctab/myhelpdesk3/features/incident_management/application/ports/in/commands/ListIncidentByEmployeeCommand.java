package ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands;

import ir.mctab.myhelpdesk3.core.annotations.UseCaseCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@AllArgsConstructor
@ToString

@UseCaseCommand
public class ListIncidentByEmployeeCommand {

    private String searchTitle;

    private Long userId;
}
