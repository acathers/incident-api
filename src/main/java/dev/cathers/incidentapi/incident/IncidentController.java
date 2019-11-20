package dev.cathers.incidentapi.incident;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/v1")
public class IncidentController {
  @Autowired
  private IncidentRepository incidentRepository;
  /**
   * Get all incidents list.
   *
   * @return the list
   */
  @GetMapping("/incidents")
  public List<Incident> getAllIncidents() {
    return incidentRepository.findAll();
  }
  /**
   * Gets incidents by id.
   *
   * @param incidentId the incident id
   * @return the incidents by id
   * @throws IncidentNotFound resource not found exception
   */
  @GetMapping("/incidents/{id}")
  public Incident getIncidentsById(@PathVariable(value = "id") Long incidentId)
      throws IncidentNotFound {
    Incident incident =
        incidentRepository
            .findById(incidentId)
            .orElseThrow(() -> new IncidentNotFound(incidentId));
    return incident;
  }

  @GetMapping("/incidents/address/{address}")
  public List<Incident> getIncidentsByAddress(@PathVariable(value = "address") String addressString) throws IncidentNotFound{
    return incidentRepository.findByAddressContaining(addressString).orElseThrow(() -> new IncidentNotFound(addressString));
  }


  /**
   * Create Incident incident.
   *
   * @param incident the incident
   * @return the incident
   */
  @PostMapping("/incidents")
  public Incident createIncident(@Valid @RequestBody Incident incident) {
    return incidentRepository.save(incident);
  }

  @DeleteMapping("/incidents/{id}")
  public Map<String, Boolean> deleteIncident(@PathVariable(value = "id") Long incidentId) throws IncidentNotFound {
    Incident incident =
        incidentRepository
            .findById(incidentId)
            .orElseThrow(() -> new IncidentNotFound(incidentId));
    incidentRepository.delete(incident);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
