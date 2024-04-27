package com.example.employeeapi.bussines;

import com.example.employeeapi.Exceptions.customs.BussinesException;
import com.example.employeeapi.entity.RoleEntity;
import com.example.employeeapi.models.request.RoleRequest;
import com.example.employeeapi.models.response.RoleResponse;
import com.example.employeeapi.repository.RoleRepository;
import com.example.employeeapi.service.RoleService;
import com.example.employeeapi.utils.Constants.ErrorConstants;
import com.example.employeeapi.utils.enums.Identifier;
import com.example.employeeapi.utils.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleBussines implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public RoleResponse save(RoleRequest request) {
        RoleEntity newRole = RoleEntity.builder()
                .roleId(Utilities.generatorRandomId(Identifier.ROLE.getCode()))
                .name(request.getName())
                .build();
        this.roleRepository.save(newRole);
        log.info("Role saved successfully");
        return this.toRoleResponse(newRole);
    }

    @Override
    public List<RoleResponse> getRoles(Pageable pageable) {
        int page = Utilities.getCurrentPage(pageable);
        return this.roleRepository.findAll(PageRequest.of(page, pageable.getPageSize())).stream()
                .map(this::toRoleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RoleResponse searchById(String id) {
        Optional<RoleEntity> findRole = this.roleRepository.findByRoleId(id);
        if (findRole.isPresent()) {
            return this.toRoleResponse(findRole.get());
        } else {
            throw new BussinesException(HttpStatus.NOT_FOUND.value(), ErrorConstants.ROLE_NOT_FOUND);
        }
    }

    @Override
    public RoleResponse updateRole(String name, String id) {
        Optional<RoleEntity> findRole = this.roleRepository.findByRoleId(id);
        if (findRole.isPresent()) {
            RoleEntity newRole = RoleEntity.builder()
                    .name(name)
                    .build();
            this.roleRepository.save(newRole);
            return this.toRoleResponse(newRole);
        } else {
            throw new BussinesException(HttpStatus.NOT_FOUND.value(), ErrorConstants.ROLE_NOT_FOUND);
        }
    }

    @Override
    public void deleteRoleById(String id) {
        Optional<RoleEntity> findRole = this.roleRepository.findByRoleId(id);
        if (findRole.isPresent()) {
            this.roleRepository.delete(findRole.get());
        } else {
            throw new BussinesException(HttpStatus.NOT_FOUND.value(), ErrorConstants.ROLE_NOT_FOUND);
        }
    }

    /* → MAPPERS ← */

    /**
     * Convert an object RoleEntity to RoleResponse
     *
     * @param entity
     * @return RoleResponse
     */
    private RoleResponse toRoleResponse(RoleEntity entity) {
        return new ModelMapper().map(entity, RoleResponse.class);
    }

    /**
     * Convert an object RoleResponse to RoleEntity
     *
     * @param response
     * @return RoleEntity
     */
    private RoleEntity toRoleEntity(RoleResponse response) {
        return new ModelMapper().map(response, RoleEntity.class);
    }

}
