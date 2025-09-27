package dev.dvhstn.workfromhere.users.security;

import dev.dvhstn.workfromhere.users.model.UserResource;
import dev.dvhstn.workfromhere.users.repository.UserResourceRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.UUID;

public class UserResourceDetailsService  implements UserDetailsService {

    private final UserResourceRepository userResourceRepository;

    public UserResourceDetailsService(UserResourceRepository userResourceRepository) {
        this.userResourceRepository = userResourceRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResource userResource = userResourceRepository.findByUserUUID(UUID.fromString(username));

        if (userResource == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(userResource);
    }
}
