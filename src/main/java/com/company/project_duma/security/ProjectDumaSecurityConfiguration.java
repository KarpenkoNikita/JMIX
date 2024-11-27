package com.company.project_duma.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import com.company.project_duma.entity.User;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.security.role.assignment.RoleAssignmentRoleType;
import io.jmix.securitydata.entity.RoleAssignmentEntity;
import org.springframework.stereotype.Component;


@Component
public class ProjectDumaSecurityConfiguration {
    private final UnconstrainedDataManager unconstrainedDataManager;

    public ProjectDumaSecurityConfiguration(UnconstrainedDataManager unconstrainedDataManager) {
        this.unconstrainedDataManager = unconstrainedDataManager;
    }

    public void register(User user) {
        RoleAssignmentEntity roleAssignment = unconstrainedDataManager.create(RoleAssignmentEntity.class);
        roleAssignment.setUsername(user.getUsername());
        roleAssignment.setRoleCode(FullAccessRole.CODE);
        roleAssignment.setRoleType(RoleAssignmentRoleType.RESOURCE);
        unconstrainedDataManager.save(user, roleAssignment);
    }

}