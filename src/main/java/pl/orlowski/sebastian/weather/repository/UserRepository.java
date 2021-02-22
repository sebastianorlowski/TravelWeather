package pl.orlowski.sebastian.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.orlowski.sebastian.weather.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
