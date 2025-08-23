package dev.dvhstn.workfromhere.spaces.service;

import dev.dvhstn.workfromhere.spaces.model.SpaceResource;
import dev.dvhstn.workfromhere.spaces.repository.SpaceResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SpaceResourceService {

    private final SpaceResourceRepository spaceResourceRepository;

    public SpaceResourceService(SpaceResourceRepository spaceResourceRepository) {
        this.spaceResourceRepository = spaceResourceRepository;
    }

    public List<SpaceResource> getAllSpaces() {
        return spaceResourceRepository.findAll();
    }

    public SpaceResource getSpaceById(Long id) {
        return spaceResourceRepository.findById(id).orElse(null);
    }

    public SpaceResource createSpace(SpaceResource spaceResource) {
        return spaceResourceRepository.save(spaceResource);
    }

    public void updateSpace(Long id, SpaceResource updatedResource) {
        SpaceResource resourceToUpdate = spaceResourceRepository.findById(id).orElse(null);

        updateSpaceResource(resourceToUpdate, updatedResource);

        spaceResourceRepository.save(resourceToUpdate);
    }

    public void deleteSpaceById(Long id) {
        SpaceResource resourceToDelete = spaceResourceRepository.findById(id).orElse(null);

        if (Objects.nonNull(resourceToDelete)) {
            spaceResourceRepository.delete(resourceToDelete);
        }
    }

    private void updateSpaceResource(SpaceResource resourceToUpdate, SpaceResource updatedResource) {
        //Better validation needed to sanitize each field
        if (Objects.nonNull(resourceToUpdate) && Objects.nonNull(updatedResource)) {
            resourceToUpdate.setName(updatedResource.getName());
            resourceToUpdate.setDescription(updatedResource.getDescription());
            resourceToUpdate.setType(updatedResource.getType());
            resourceToUpdate.setWifiAvailable(updatedResource.isWifiAvailable());
            resourceToUpdate.setWifiPassword(updatedResource.getWifiPassword());
            resourceToUpdate.setWifiSpeed(updatedResource.getWifiSpeed());
        }
    }
}
