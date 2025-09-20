package dev.dvhstn.workfromhere.users.security;

import dev.dvhstn.workfromhere.users.model.RoleResource;
import dev.dvhstn.workfromhere.users.model.UserResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private final UserResource userResource;

    public UserPrincipal(UserResource userResource) {
        this.userResource = userResource;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userResource.getRoleResources().stream()
                .map(RoleResource::getName)
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return userResource.getPassword();
    }

    @Override
    public String getUsername() {
        return userResource.getEmail();
    }

    public UUID getUserId() {
        return userResource.getId();
    }

}
