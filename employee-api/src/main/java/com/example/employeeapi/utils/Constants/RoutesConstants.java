package com.example.employeeapi.utils.Constants;

public abstract class RoutesConstants {

    /** → BASE PATHS ←  */
    /* Base path for employees */
    public static final String EMPLOYEE_BASE_PATH = "${api.uri.domain.employee}";
    /* Base path for job department */
    public static final String DEPARTMENT_BASE_PATH = "${api.uri.domain.jobDepartment}";
    /* Base path for roles */
    public static final String ROLE_BASE_PATH = "${api.uri.domain.role}";

    private RoutesConstants() {}
}
