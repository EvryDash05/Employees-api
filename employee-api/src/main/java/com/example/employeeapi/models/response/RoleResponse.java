package com.example.employeeapi.models.response;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleResponse {

    private String roleId;
    private String name;

}
