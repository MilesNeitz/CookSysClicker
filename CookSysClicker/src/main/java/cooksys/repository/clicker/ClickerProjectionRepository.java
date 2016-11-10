package cooksys.repository.clicker;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.entity.Clicker;
import cooksys.projection.clicker.ClickerScoreProj;

public interface ClickerProjectionRepository extends JpaRepository<Clicker, Long>{

	ClickerScoreProj findByUserName(String userName);

}
