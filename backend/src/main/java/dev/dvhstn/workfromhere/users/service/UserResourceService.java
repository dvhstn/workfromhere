package dev.dvhstn.workfromhere.users.service;

import dev.dvhstn.workfromhere.users.dto.UserRequestResource;
import dev.dvhstn.workfromhere.users.dto.UserResponseResource;
import dev.dvhstn.workfromhere.users.exception.UserResourceException;
import dev.dvhstn.workfromhere.users.model.UserResource;
import dev.dvhstn.workfromhere.users.repository.UserResourceRepository;
import dev.dvhstn.workfromhere.users.util.UserResourceMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserResourceService {

    private final UserResourceRepository userResourceRepository;
    private final UserResourceMapper userResourceMapper;

    public UserResourceService(UserResourceRepository userResourceRepository, UserResourceMapper userResourceMapper) {
        this.userResourceRepository = userResourceRepository;
        this.userResourceMapper = userResourceMapper;
    }

    public List<UserResponseResource> getAllUsers() {
        List<UserResource> userResources = userResourceRepository.findAll();

         return userResources.stream()
                .map(userResourceMapper::toUserResponseDTO)
                .toList();
    }

    public UserResponseResource getUserById(String id) {
        UserResource user = userResourceRepository.findByUserUUID(UUID.fromString(id));

        if (user == null) {
            throw new UserResourceException("User not found");
        }

        return userResourceMapper.toUserResponseDTO(user);
    }

    public UserResponseResource createUser(UserRequestResource userRequestResource) {
        UserResource newUser = userResourceRepository.save(
                userResourceMapper.toModel(userRequestResource)
        );

        return userResourceMapper.toUserResponseDTO(newUser);
    }

    @Transactional
    public UserResponseResource updateUserById(UUID id, UserRequestResource userRequestResource) {
        UserResource user = userResourceRepository.findByUserUUID(id);

        if (user == null) {
            throw new UserResourceException("User not found");
        }

        userResourceMapper.updateUserDetails(userRequestResource, user);

        UserResource updatedUser = userResourceRepository.save(user);

        return userResourceMapper.toUserResponseDTO(updatedUser);
    }

    public void deleteUserById(UUID id) {
        UserResource user = userResourceRepository.findByUserUUID(id);

        if (user == null) {
            throw new UserResourceException("User not found");
        }

        userResourceRepository.delete(user);
    }
}
