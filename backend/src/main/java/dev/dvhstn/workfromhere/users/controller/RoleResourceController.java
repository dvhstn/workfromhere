package dev.dvhstn.workfromhere.users.controller;

import dev.dvhstn.workfromhere.users.model.RoleResource;
import dev.dvhstn.workfromhere.users.service.RoleResourceService;
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

@RestController
@RequestMapping("/roles")
public class RoleResourceController {

    private final RoleResourceService roleResourceService;

    public RoleResourceController(RoleResourceService roleResourceService) {
        this.roleResourceService = roleResourceService;
    }

    @GetMapping
    private ResponseEntity<List<RoleResource>> getAllRoles() {
        return ResponseEntity.ok(roleResourceService.getAllRoles());
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<RoleResource> getRoleById(@PathVariable long id) {
        return ResponseEntity.ok(roleResourceService.getRoleResourceById(id));
    }

    @PostMapping
    private ResponseEntity<RoleResource> createRoleResource(@RequestBody RoleResource roleResource) {
        URI  roleResourceLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
                .toUri();

        return ResponseEntity.created(roleResourceLocation).body(roleResourceService.createRoleResource(roleResource));
    }

    @PutMapping(value = "/{id}")
    private ResponseEntity<Void> updateRoleResource(@PathVariable long id, @RequestBody RoleResource roleResource)
            throws Exception {
        roleResourceService.updateRoleResource(roleResource, id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Void> deleteRoleResource(@PathVariable long id) {
        roleResourceService.deleteRoleResource(id);

        return ResponseEntity.noContent().build();
    }
}
