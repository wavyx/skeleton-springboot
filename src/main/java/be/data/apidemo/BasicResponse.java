package be.data.apidemo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BasicResponse {

    LocalDateTime timestamp;
    String apiMessage;

}
