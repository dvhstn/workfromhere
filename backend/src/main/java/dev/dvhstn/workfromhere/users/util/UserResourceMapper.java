package dev.dvhstn.workfromhere.users.util;

import dev.dvhstn.workfromhere.users.dto.UserRequestResource;
import dev.dvhstn.workfromhere.users.dto.UserResponseResource;
import dev.dvhstn.workfromhere.users.model.UserResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserResourceMapper {

    private final PasswordEncoder passwordEncoder;

    public UserResourceMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseResource toUserResponseDTO(UserResource userResource) {
        UserResponseResource userResponseResource = new UserResponseResource();

        userResponseResource.setId(userResource.getId().toString());
        userResponseResource.setEmail(userResource.getEmail());
        userResponseResource.setFirstName(userResource.getFirstName());
        userResponseResource.setLastName(userResource.getLastName());

        return userResponseResource;
    }

    public UserResource toModel(UserRequestResource userRequestResource) {
        UserResource userResource = new UserResource();

        userResource.setEmail(userRequestResource.getEmail());
        userResource.setFirstName(userRequestResource.getFirstName());
        userResource.setLastName(userRequestResource.getLastName());
        userResource.setPassword(passwordEncoder.encode(userRequestResource.getPassword()));
        userResource.setCreatedAt(LocalDateTime.parse(userRequestResource.getCreated_at()));

        return userResource;
    }

    public void updateUserDetails(UserRequestResource userRequestResource, UserResource user) {
        user.setFirstName(userRequestResource.getFirstName());
        user.setLastName(userRequestResource.getLastName());
        user.setEmail(userRequestResource.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestResource.getPassword()));
        user.setCreatedAt(LocalDateTime.parse(userRequestResource.getCreated_at()));
    }
}
