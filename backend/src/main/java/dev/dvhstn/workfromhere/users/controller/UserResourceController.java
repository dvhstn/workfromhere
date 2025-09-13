package dev.dvhstn.workfromhere.users.controller;

import dev.dvhstn.workfromhere.users.dto.UserRequestResource;
import dev.dvhstn.workfromhere.users.dto.UserResponseResource;
import dev.dvhstn.workfromhere.users.service.UserResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserResourceController {

    private final UserResourceService userResourceService;

    public UserResourceController(UserResourceService userResourceService) {
        this.userResourceService = userResourceService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseResource>> getAllUsers() {
        return ResponseEntity.ok(userResourceService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseResource> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userResourceService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseResource> createUser(@RequestBody UserRequestResource userRequestResource) {

        URI createdUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
                .toUri();

        return ResponseEntity.created(createdUserURI).body(userResourceService.createUser(userRequestResource));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseResource> updateUser(
            @PathVariable String id, @RequestBody UserRequestResource userRequestResource) {
        userResourceService.updateUserById(UUID.fromString(id), userRequestResource);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userResourceService.deleteUserById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
