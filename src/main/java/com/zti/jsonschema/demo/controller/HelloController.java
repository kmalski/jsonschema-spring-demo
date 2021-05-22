package com.zti.jsonschema.demo.controller;

import com.zti.jsonschema.demo.validation.JsonSchema;
import com.zti.jsonschema.types.HelloWorldRequest;
import com.zti.jsonschema.types.HelloWorldResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/hello-world", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Hello Controller")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Say some cool stuff about your World")
    public HelloWorldResponse sayHello(@RequestBody @JsonSchema("schema/HelloWorldRequest.json") HelloWorldRequest request) {
        logger.info("Called POST /hello-world");

        HelloWorldResponse response = new HelloWorldResponse();
        String greetingText = request.getGreetingText() != null ? request.getGreetingText() : "Hello";
        response.setGreetings(greetingText + " " + request.getPlanet().getName() + "!");

        return response;
    }

    @GetMapping
    @Operation(summary = "Says hello to every stranger")
    public HelloWorldResponse sayHelloToEveryone() {
        logger.info("Called GET /hello-world");

        HelloWorldResponse response = new HelloWorldResponse();
        response.setGreetings("Hello stranger!");

        return response;
    }

}
