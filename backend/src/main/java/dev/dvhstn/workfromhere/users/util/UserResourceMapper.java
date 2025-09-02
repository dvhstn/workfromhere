package dev.dvhstn.workfromhere.users.util;

import dev.dvhstn.workfromhere.users.dto.UserRequestResource;
import dev.dvhstn.workfromhere.users.dto.UserResponseResource;
import dev.dvhstn.workfromhere.users.model.UserResource;

import java.time.LocalDateTime;

public class UserResourceMapper {

    public static UserResponseResource toUserResponseDTO(UserResource userResource) {
        UserResponseResource userResponseResource = new UserResponseResource();

        userResponseResource.setId(userResource.getId().toString());
        userResponseResource.setEmail(userResource.getEmail());
        userResponseResource.setFirstName(userResource.getFirstName());
        userResponseResource.setLastName(userResource.getLastName());

        return userResponseResource;
    }

    public static UserResource toModel(UserRequestResource userRequestResource) {
        UserResource userResource = new UserResource();

        userResource.setEmail(userRequestResource.getEmail());
        userResource.setFirstName(userRequestResource.getFirstName());
        userResource.setLastName(userRequestResource.getLastName());
        userResource.setPassword(userRequestResource.getPassword()); // Needs to be hashed
        userResource.setCreatedAt(LocalDateTime.parse(userRequestResource.getCreated_at()));

        return userResource;
    }
}
