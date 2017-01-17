package net.elyland.cloud.services;

import net.elyland.cloud.repositories.RoleRepository;
import net.elyland.cloud.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 07-Jul-16.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> listAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleRepository.getOne(id);
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.delete(id);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return null;
    }
}
