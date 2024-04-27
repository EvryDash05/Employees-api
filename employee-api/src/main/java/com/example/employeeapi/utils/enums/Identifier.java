package com.example.employeeapi.utils.enums;

import lombok.Getter;

@Getter
public enum Identifier {
    EMPLOYEE("EMP"),
    ROLE("RLE"),
    LEAVE("LVE"),
    SALARY("SLR"),
    TODO("TDO"),
    PAYROLL("PAY"),
    JOB_DEPARTMENT("DEP");

    private final String code;

    Identifier(String code) { this.code = code; }

}
