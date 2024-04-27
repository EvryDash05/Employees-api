package com.example.employeeapi.apis;

import com.example.employeeapi.bussines.RoleBussines;
import com.example.employeeapi.models.request.RoleRequest;
import com.example.employeeapi.models.response.RoleResponse;
import com.example.employeeapi.utils.Constants.RoutesConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = RoutesConstants.ROLE_BASE_PATH)
public class RoleController {

    private final RoleBussines roleBussines;

    @GetMapping("/roleList")
    public ResponseEntity<List<RoleResponse>> retrive(@PageableDefault Pageable page){
        return ResponseEntity.ok(this.roleBussines.getRoles(page));
    }

    @PostMapping("/createRole")
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest request){
        return new ResponseEntity<>(this.roleBussines.save(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteRole/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable String id){
        this.roleBussines.deleteRoleById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable String id){
        return new ResponseEntity<>(this.roleBussines.searchById(id), HttpStatus.OK);
    }

    @PutMapping("updateRole/{id}")
    public ResponseEntity<RoleResponse> updateRole(@RequestBody String name, @PathVariable String id){
        return new ResponseEntity<>(this.roleBussines.updateRole(name, id), HttpStatus.OK);
    }

}
