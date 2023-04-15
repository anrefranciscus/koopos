package com.gerryron.koopos.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {

    public static final List<String> endpoints = List.of(
            "/api/auth/signUp",
            "/api/auth/signIn",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> endpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}