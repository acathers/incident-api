package dev.cathers.incidentapi.incident;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncidentNotFound extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public IncidentNotFound(long incidentId) {
    super("incident " + incidentId + " does not exist");
  }

}
