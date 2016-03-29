package com.payworks.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payworks.model.SuperHero;
import com.payworks.util.Cache;

/**
 * SuperHero Controller.
 * @author franciscotineo
 *
 */
@RestController
public class SuperHeroController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SuperHeroController.class);
	@Autowired
	private Cache cache;
	
	/**
	 * Route for Creating SuperHero
	 * @param superHero
	 * @return
	 */
	@RequestMapping(value="/heroes", method=RequestMethod.POST)
	public String addSuperHero(@RequestBody SuperHero superHero) {
		try {
			if(superHero != null && superHero.getName() != null || superHero.getPseudonym() != null
					|| !superHero.getAllies().isEmpty() || !superHero.getPowers().isEmpty() || superHero.getPublisher() != null) {
				LOG.info("SuperHeroController::addSuperHero() -> SuperHero: " + superHero.toString());
				cache.getSuperHeroes().put(superHero.getName(), superHero);
				
				if(!superHero.getAllies().isEmpty()) {
					superHero.getAllies().forEach(allie -> {
						cache.getSuperHeroes().put(allie.getName(), allie);
					});
			
				return "SuperHero added!";
				
				}
			} else {
				return "SuperHero couldn't be added";
			}
		} catch(Exception exc) {
			LOG.error("EXCEPTION! SuperHeroController::addSuperHero() -> " + exc);
		}
		
		return "SuperHero couldn't be added!";
	}
	
	/**
	 * Route for retrieving ALL SuperHero
	 * @return List<SuperHero>
	 */
	@RequestMapping("/heroes")
	public Collection<SuperHero> getSuperHeroes() {
		LOG.info("SuperHeroController::getSuperHeroes()");
		try {
			return cache.getSuperHeroes().values();
		} catch(Exception exc) {
			LOG.error("EXCEPTION! SuperHeroController::getSuperHeroes() -> " + exc);
			return new ArrayList<SuperHero>();
		}
	}
	
	/**
	 * Route for Searching for a SuperHero by name
	 * @param name
	 * @return
	 */
	@RequestMapping("/hero")
    public SuperHero getSuperHero(@RequestParam(value="name") String name) {
		if(name != null && !name.equals("")) {
			SuperHero hero = cache.getSuperHeroes().get(name);
			LOG.info("SuperHeroController::getSuperHero() -> SuperHero: " + hero);
			return hero;
		} else {
			return null;
		}
    }

}
