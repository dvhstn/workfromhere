package dev.dvhstn.workfromhere.domains.spaces.repository;

import dev.dvhstn.workfromhere.domains.spaces.model.SpaceResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceResourceRepository extends JpaRepository<SpaceResource, Long> {
}
