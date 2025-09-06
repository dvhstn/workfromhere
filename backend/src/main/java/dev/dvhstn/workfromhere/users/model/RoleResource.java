package dev.dvhstn.workfromhere.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResource {
    private long id;
    private RoleName name;
}
