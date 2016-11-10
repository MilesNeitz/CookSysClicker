package cooksys.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cooksys.entity.Clicker;
import cooksys.projection.clicker.ClickerScoreProj;
import cooksys.repository.clicker.ClickerEntityRepository;
import cooksys.repository.clicker.ClickerProjectionRepository;
import cooksys.service.ClickerService;

@Service
public class ClickerServiceImpl implements ClickerService {

	private Logger logger = LoggerFactory.getLogger(ClickerServiceImpl.class);
	
	private ClickerProjectionRepository clickerProjectionRepo;
	private ClickerEntityRepository clickerEntityRepo;
	
	public ClickerServiceImpl(ClickerProjectionRepository clickerProjectionRepo, ClickerEntityRepository clickerEntityRepo) {
		this.clickerProjectionRepo = clickerProjectionRepo;
		this.clickerEntityRepo = clickerEntityRepo;
	}

	@Override
	public ClickerScoreProj getClickerStateByUser(String userName) {
		logger.info("Finding Clicker Projection by user name: " + userName);
		ClickerScoreProj result = clickerProjectionRepo.findByUserName(userName);
		logger.info("Searched for Clicker Projection by user name [" + userName + "], found: " + result);
		return result;
		
	}

	@Override
	public void store(Clicker clicker) {
		
		clickerEntityRepo.findByUserName(clicker.getUserName()).ifPresent(found -> { 
				clicker.setId(found.getId());
				logger.info("Found existing user name, retrieved: " + found);
			});
		
		logger.info("Storing clicker: " + clicker);
		clickerProjectionRepo.saveAndFlush(clicker);
	}
	
}
