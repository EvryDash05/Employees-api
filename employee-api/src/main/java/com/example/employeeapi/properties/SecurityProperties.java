package com.example.employeeapi.properties;

import lombok.Builder;

@Builder
public class SecurityProperties {
    /** JWT key */
    private final String jwtKey;
    /** Time valid token */
    private final int jwtLifeTime;
    /** Path authentication user */
    private final String userAuthenticationPath;
    /** Path to confirm user */
    private String userConfirmTokenPath;
    /** Path to forgot password */
    private String forgotPasswordPath;
}
