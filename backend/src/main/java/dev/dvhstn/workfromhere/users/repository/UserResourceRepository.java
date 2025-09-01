package dev.dvhstn.workfromhere.users.repository;

import dev.dvhstn.workfromhere.users.model.UserResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResourceRepository extends JpaRepository<UserResource, Long> {
}
