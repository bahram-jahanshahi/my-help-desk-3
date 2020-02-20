package ir.mctab.myhelpdesk3.features.incident_management.adapter.web;

import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.ListIncidentByEmployeeUseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.SubmitIncidentByEmployeeUseCase;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.ListIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.commands.SubmitIncidentByEmployeeCommand;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.exceptions.SubmitIncidentByEmployeeException;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.ListIncidentByEmployeeOutcome;
import ir.mctab.myhelpdesk3.features.incident_management.application.ports.in.outcomes.SubmitIncidentByEmployeeOutcome;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/incident")
public class IncidentController {

    final ListIncidentByEmployeeUseCase listIncidentByEmployeeUseCase;
    final SubmitIncidentByEmployeeUseCase submitIncidentByEmployeeUseCase;

    public IncidentController(ListIncidentByEmployeeUseCase listIncidentByEmployeeUseCase, SubmitIncidentByEmployeeUseCase submitIncidentByEmployeeUseCase) {
        this.listIncidentByEmployeeUseCase = listIncidentByEmployeeUseCase;
        this.submitIncidentByEmployeeUseCase = submitIncidentByEmployeeUseCase;
    }

    @PostMapping("/list-incident-by-employee")
    private ListIncidentByEmployeeOutcome listIncidentByEmployee(@RequestBody ListIncidentByEmployeeCommand command) throws Exception {
        return listIncidentByEmployeeUseCase.list(command);
    }

    @PostMapping("/submit-incident-by-employee")
    private SubmitIncidentByEmployeeOutcome submitIncidentByEmployee(@RequestBody SubmitIncidentByEmployeeCommand command) throws SubmitIncidentByEmployeeException {
        return submitIncidentByEmployeeUseCase.submit(command);
    }

}
