package dev.dvhstn.workfromhere.spaces.controller;

import dev.dvhstn.workfromhere.spaces.model.SpaceResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpaceResourceController {

    @GetMapping
    public ResponseEntity<List<SpaceResource>> getAllSpaces() {
        return null;
    }

    @GetMapping
    public ResponseEntity<SpaceResource> getSpaceById(@PathVariable long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<SpaceResource> createSpace(@RequestBody SpaceResource spaceResource) {
        return null;
    }

    @PutMapping
    public ResponseEntity<Void> updateSpaceById(@PathVariable Long id, @RequestBody SpaceResource spaceResource) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSpace(@PathVariable long id) {
        return null;
    }
}
