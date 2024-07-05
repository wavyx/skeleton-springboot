package be.data.apidemo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping(
            value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public ResponseEntity<BasicResponse> index() {
        BasicResponse response = new BasicResponse();
        response.timestamp = java.time.LocalDateTime.now();
        response.apiMessage = "Hello, API World!";
        return ResponseEntity.ok(response);
    }
}
