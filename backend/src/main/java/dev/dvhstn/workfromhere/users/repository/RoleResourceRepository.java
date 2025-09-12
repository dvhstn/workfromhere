package dev.dvhstn.workfromhere.users.repository;

import dev.dvhstn.workfromhere.users.model.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleResourceRepository extends JpaRepository<RoleResource, Long> {
    RoleResource findRoleResourceById(long id);
    RoleResource findRoleResourceByName(String name);
}
