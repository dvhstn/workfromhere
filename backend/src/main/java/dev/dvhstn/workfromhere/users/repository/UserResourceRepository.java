package dev.dvhstn.workfromhere.users.repository;

import dev.dvhstn.workfromhere.users.model.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserResourceRepository extends JpaRepository<UserResource, Long> {
    public UserResource findByUserUUID(UUID id);
}
