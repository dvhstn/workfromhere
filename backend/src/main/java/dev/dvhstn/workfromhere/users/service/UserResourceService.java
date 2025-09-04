package dev.dvhstn.workfromhere.users.service;

import dev.dvhstn.workfromhere.users.dto.UserRequestResource;
import dev.dvhstn.workfromhere.users.dto.UserResponseResource;
import dev.dvhstn.workfromhere.users.exception.UserResourceException;
import dev.dvhstn.workfromhere.users.model.UserResource;
import dev.dvhstn.workfromhere.users.repository.UserResourceRepository;
import dev.dvhstn.workfromhere.users.util.UserResourceMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserResourceService {

    private final UserResourceRepository userResourceRepository;

    public UserResourceService(UserResourceRepository userResourceRepository) {
        this.userResourceRepository = userResourceRepository;
    }

    public List<UserResponseResource> getAllUsers() {
        List<UserResource> userResources = userResourceRepository.findAll();

         return userResources.stream()
                .map(UserResourceMapper::toUserResponseDTO)
                .toList();
    }

    public UserResponseResource getUserById(String id) {
        UserResource user = userResourceRepository.findByUserUUID(UUID.fromString(id));

        if (user == null) {
            throw new UserResourceException("User not found");
        }

        return UserResourceMapper.toUserResponseDTO(user);
    }

    public UserResponseResource createUser(UserRequestResource userRequestResource) {
        UserResource newUser = userResourceRepository.save(
                UserResourceMapper.toModel(userRequestResource)
        );

        return UserResourceMapper.toUserResponseDTO(newUser);
    }

    public UserResponseResource updateUserById(UUID id, UserRequestResource userRequestResource) {
        UserResource user = userResourceRepository.findByUserUUID(id);

        if (user == null) {
            throw new UserResourceException("User not found");
        }

        updateUserDetails(userRequestResource, user);

        UserResource updatedUser = userResourceRepository.save(user);

        return UserResourceMapper.toUserResponseDTO(updatedUser);
    }

    public UserResponseResource deleteUserById(UUID id) {
        UserResource user = userResourceRepository.findByUserUUID(id);

        if (user == null) {
            throw new UserResourceException("User not found");
        }

        return UserResourceMapper.toUserResponseDTO(user);
    }

    private void updateUserDetails(UserRequestResource userRequestResource, UserResource user) {
        user.setFirstName(userRequestResource.getFirstName());
        user.setLastName(userRequestResource.getLastName());
        user.setEmail(userRequestResource.getEmail());
        user.setPassword(userRequestResource.getPassword());
        user.setCreatedAt(LocalDateTime.parse(userRequestResource.getCreated_at()));
    }
}
