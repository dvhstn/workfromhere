package dev.dvhstn.workfromhere.users.util;

import dev.dvhstn.workfromhere.users.dto.UserResponseResource;
import dev.dvhstn.workfromhere.users.model.UserResource;

public class UserResourceMapper {

    public static UserResponseResource toUserResponseDTO(UserResource userResource) {
        UserResponseResource userResponseResource = new UserResponseResource();

        userResponseResource.setId(userResource.getId().toString());
        userResponseResource.setEmail(userResource.getEmail());
        userResponseResource.setFirstName(userResource.getFirstName());
        userResponseResource.setLastName(userResource.getLastName());

        return userResponseResource;
    }
}
