package ir.mctab.myhelpdesk3.repositories;

import ir.mctab.myhelpdesk3.entities.IncidentLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentLogRepository extends JpaRepository<IncidentLog, Long> {

    List<IncidentLog> findAllByIncident_Id(Long incidentId);
}
