package pl.orlowski.sebastian.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.orlowski.sebastian.weather.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
