package cooksys.repository.clicker;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.entity.Clicker;

public interface ClickerEntityRepository extends JpaRepository<Clicker, Long> {

	Optional<Clicker> findByUserName(String userName);
	
}
