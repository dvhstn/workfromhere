package dev.dvhstn.workfromhere.spaces.service;

import dev.dvhstn.workfromhere.spaces.exception.SpaceResourceException;
import dev.dvhstn.workfromhere.spaces.model.SpaceResource;
import dev.dvhstn.workfromhere.spaces.repository.SpaceResourceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SpaceResourceService {

    private final SpaceResourceRepository spaceResourceRepository;

    public SpaceResourceService(SpaceResourceRepository spaceResourceRepository) {
        this.spaceResourceRepository = spaceResourceRepository;
    }

    public Page<SpaceResource> getAllSpaces(Pageable pageable) {
        return spaceResourceRepository.findAll(pageable);
    }

    public SpaceResource getSpaceById(Long id) {
        return spaceResourceRepository
                .findById(id)
                .orElseThrow(() -> new SpaceResourceException("Space with id: " + id + " does not exist"));
    }

    public SpaceResource createSpace(SpaceResource spaceResource) {
        return spaceResourceRepository.save(spaceResource);
    }

    public void updateSpace(Long id, SpaceResource updatedResource) {
        SpaceResource resourceToUpdate = getSpaceById(id);

        if (Objects.nonNull(resourceToUpdate)) {
            updateSpaceResource(resourceToUpdate, updatedResource);
            spaceResourceRepository.save(resourceToUpdate);
        }
    }

    public void deleteSpaceById(Long id) {
        SpaceResource resourceToDelete = getSpaceById(id);

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
