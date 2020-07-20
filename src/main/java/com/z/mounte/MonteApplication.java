package com.z.mounte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootApplication
@EnableFeignClients
public class MonteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonteApplication.class, args);
    }

}

@RestController
@RequiredArgsConstructor
class MessageResource {
    private final MessageService messageService;

    @GetMapping
    ResponseEntity<MessageResponse> getMessage() {
        return ResponseEntity.ok(messageService.getMessage());
    }
}

@RequiredArgsConstructor
@Service
class MessageService {
    private final MyExternalService myExternalService;

    MessageResponse getMessage() {
        return myExternalService.getMessage();
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class MessageResponse {
    private String message;
}

@FeignClient(name = "myExternalService", url = "${myExternalService.url}")
interface MyExternalService {
    @GetMapping(value = "/test", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    MessageResponse getMessage();
}