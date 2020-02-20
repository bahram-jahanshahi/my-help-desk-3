package ir.mctab.myhelpdesk3.repositories;

import ir.mctab.myhelpdesk3.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findAllByIssueContainingAndSubmitBy_Id(String issue, Long userId);
}
