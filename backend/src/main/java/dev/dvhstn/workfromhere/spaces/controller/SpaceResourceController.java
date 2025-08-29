package dev.dvhstn.workfromhere.spaces.controller;

import dev.dvhstn.workfromhere.spaces.model.SpaceResource;
import dev.dvhstn.workfromhere.spaces.service.SpaceResourceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SpaceResourceController {

    private final SpaceResourceService spaceResourceService;

    public SpaceResourceController(SpaceResourceService spaceResourceService) {
        this.spaceResourceService = spaceResourceService;
    }

    @GetMapping
    public ResponseEntity<Page<SpaceResource>> getAllSpaces(Pageable pageable) {
        Page<SpaceResource> spaceResourcePage = spaceResourceService.getAllSpaces(pageable);

        return ResponseEntity.ok(spaceResourcePage);
    }

    @GetMapping
    public ResponseEntity<SpaceResource> getSpaceById(@PathVariable Long id) {
        return ResponseEntity.ok(spaceResourceService.getSpaceById(id));
    }

    @PostMapping
    public ResponseEntity<SpaceResource> createSpace(@RequestBody SpaceResource spaceResource) {
        URI createdSpaceURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
                .toUri();

        return ResponseEntity.created(createdSpaceURI).body(spaceResourceService.createSpace(spaceResource));
    }

    @PutMapping
    public ResponseEntity<Void> updateSpaceById(@PathVariable Long id, @RequestBody SpaceResource updatedResource) {
        spaceResourceService.updateSpace(id, updatedResource);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSpace(@PathVariable Long id) {
        spaceResourceService.deleteSpaceById(id);

        return ResponseEntity.noContent().build();
    }
}
