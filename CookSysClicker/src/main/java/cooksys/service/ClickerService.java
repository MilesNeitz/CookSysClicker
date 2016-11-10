package cooksys.service;

import cooksys.entity.Clicker;
import cooksys.projection.clicker.ClickerScoreProj;

public interface ClickerService {
	
	public ClickerScoreProj getClickerStateByUser(String userName);

	public void store(Clicker clicker);

}
