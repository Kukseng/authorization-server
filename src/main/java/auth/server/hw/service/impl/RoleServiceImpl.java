package auth.server.hw.service.impl;

import auth.server.hw.domain.Role;
import auth.server.hw.dto.role.CreateRole;
import auth.server.hw.repository.RoleRepository;
import auth.server.hw.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void createRole(CreateRole createRole) {
        if(roleRepository.existsByName(createRole.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role already exists");
        }

        Role role = new Role();
        role.setName(createRole.name());
        // Let JPA generate the ID
        roleRepository.save(role);
    }
}