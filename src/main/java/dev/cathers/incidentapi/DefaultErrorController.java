package dev.cathers.incidentapi;

import dev.cathers.incidentapi.incident.ErrorDetails;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class DefaultErrorController implements ErrorController {

  @RequestMapping("/error")
  @ResponseBody
  public ResponseEntity<ErrorDetails> handleError(WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), "invalid",
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);


  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}
