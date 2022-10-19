package com.poc;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;

import com.poc.configs.HttpClientTestConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Import(HttpClientTestConfig.class)
public class BaseIT {

	protected static final String BASE_URI_WITHOUT_PORT = "http://localhost:";

    protected static final String SEED_MAPPINGS_DIR = "seed/";

    protected static final String EXPECTED_MAPPINGS_DIR = "expected/";

    @Value("${server.port}")
	protected int serverPort;
	
    @Autowired
    protected TestRestTemplate testRestTemplate;

    protected String readJsonFrom(String responseLocation) 
    		throws Exception {
        return Files.readAllLines(Paths.get(ClassLoader.getSystemResource("__files/" + responseLocation).toURI()),
                                    Charset.forName(StandardCharsets.UTF_8.name()))
                        .stream()
                        .collect(Collectors.joining());
    }

}
