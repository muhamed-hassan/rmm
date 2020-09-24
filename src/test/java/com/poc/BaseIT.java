package com.poc;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseIT {

    protected static final String SEED_MAPPINGS_DIR = "seed/";

    protected static final String EXPECTED_MAPPINGS_DIR = "expected/";

    @Autowired
    protected MockMvc mockMvc;

    protected String readJsonFrom(String responseLocation) throws Exception {
        return Files.readAllLines(Paths.get(ClassLoader.getSystemResource("__files/" + responseLocation).toURI()),
                                    Charset.forName(StandardCharsets.UTF_8.name()))
                        .stream()
                        .collect(Collectors.joining());
    }

}
