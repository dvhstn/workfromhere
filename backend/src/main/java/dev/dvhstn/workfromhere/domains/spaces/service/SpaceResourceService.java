package dev.dvhstn.workfromhere.domains.spaces.service;

import dev.dvhstn.workfromhere.domains.spaces.model.SpaceResource;
import dev.dvhstn.workfromhere.domains.spaces.repository.SpaceResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceResourceService {

    private final SpaceResourceRepository spaceResourceRepository;

    public SpaceResourceService(SpaceResourceRepository spaceResourceRepository) {
        this.spaceResourceRepository = spaceResourceRepository;
    }

    public List<SpaceResource> getAllSpaces() {
        return spaceResourceRepository.findAll();
    }

    public SpaceResource getSpaceResourceById(Long id) {
        // TODO ADD PROPER EXCEPTION HANDLING
        return spaceResourceRepository.findById(id).orElse(null);
    }

    public SpaceResource createSpaceResource(SpaceResource spaceResource) {
        return spaceResourceRepository.save(spaceResource);
    }

    public SpaceResource updateSpaceResource(Long id, SpaceResource spaceResource) {
        if (!spaceResourceRepository.existsById(id)) {
            // TODO ADD PROPER EXCEPTION/NULL HANDLING
            return null;
        }

        return spaceResourceRepository.save(spaceResource);
    }

    public void deleteSpaceResource(Long id) {
        if (!spaceResourceRepository.existsById(id)) {
            // TODO ADD PROPER EXCEPTION/NULL HANDLING
            return;
        }

        spaceResourceRepository.deleteById(id);
    }
}
