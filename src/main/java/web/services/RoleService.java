package web.services;

import web.models.Role;

import java.util.Set;


public interface RoleService {
    Set<Role> getRoles(Set<String> roles);

    Role getDefaultRole();

}
