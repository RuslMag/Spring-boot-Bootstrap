package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;
import web.models.User;
import web.repository.RoleRepository;

import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getRoles(Set<String> roles) {
        return roleRepository.getRoleByNameIn(roles);
    }

    @Override
    public Role getDefaultRole() {
        String defaultRoleName = "ROLE_USER";
        return roleRepository.getRoleByName(defaultRoleName);
    }
}
