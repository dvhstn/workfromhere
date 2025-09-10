package dev.dvhstn.workfromhere.users.service;

import dev.dvhstn.workfromhere.users.model.RoleResource;
import dev.dvhstn.workfromhere.users.repository.RoleResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.management.relation.Role;
import java.util.List;
import java.util.Objects;

@Service
public class RoleResourceService {

    private final RoleResourceRepository roleResourceRepository;

    public RoleResourceService(RoleResourceRepository roleResourceRepository) {
        this.roleResourceRepository = roleResourceRepository;
    }

    public List<RoleResource> getAllRoles() {
        return roleResourceRepository.findAll();
    }

    public RoleResource getRoleResourceById(@PathVariable long id) {
        return roleResourceRepository.findById(id).orElse(null);
    }

    public RoleResource getRoleResourceByName(String roleName) {
        return roleResourceRepository.findRoleResourceByName(roleName);
    }

    public RoleResource createRoleResource(RoleResource roleResource) {
        return roleResourceRepository.save(roleResource);
    }

    public void updateRoleResource(RoleResource roleResource, long id) throws Exception {
        RoleResource roleToUpdate = roleResourceRepository.findById(id).orElse(null);

        // Add better error handling
        if (Objects.isNull(roleToUpdate)) {
            throw new Exception();
        }

        roleToUpdate.setName(roleResource.getName());
        roleResourceRepository.save(roleToUpdate);
    }

    public void deleteRoleResource(long id) {
        RoleResource roleToDelete = roleResourceRepository.findById(id).orElse(null);
        if (roleToDelete != null) {
            roleResourceRepository.delete(roleToDelete);
        }
    }
}
