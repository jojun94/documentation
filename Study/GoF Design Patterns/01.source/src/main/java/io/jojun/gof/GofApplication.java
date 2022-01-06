package io.jojun.gof;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GofApplication {
    private static final String TAG = "GofApplication";

    public static void main(String[] args) {
        SpringApplication.run(GofApplication.class, args);
        log.info(TAG + " - Server is listening.");
    }

}
