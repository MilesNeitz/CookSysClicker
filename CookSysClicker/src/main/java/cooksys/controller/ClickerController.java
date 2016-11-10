package cooksys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.entity.Clicker;
import cooksys.projection.clicker.ClickerScoreProj;
import cooksys.service.ClickerService;

@RestController
@RequestMapping("clicker")
public class ClickerController {
	
	private ClickerService clickerService;

	public ClickerController(ClickerService clickerService) {
		this.clickerService = clickerService;
	}
	
	@GetMapping("/{userName}")
	public ClickerScoreProj getClickerState(@PathVariable String userName) {
		return clickerService.getClickerStateByUser(userName);
	}
	
	@PostMapping
	public void storeClickerState(@RequestBody Clicker clicker) {
		clickerService.store(clicker);
	}
	
}
