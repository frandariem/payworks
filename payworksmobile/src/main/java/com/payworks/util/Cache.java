package com.payworks.util;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.payworks.model.SuperHero;

/**
 * Singleton Bean
 * Stores SuperHeroes in current session
 * @author franciscotineo
 *
 */
@Component
public class Cache {
	
	//Key = SuperHero name
	private ConcurrentHashMap<String,SuperHero> superHeroes;
	
	public Cache() {
		superHeroes = new ConcurrentHashMap<String,SuperHero>();
	}

	/**
	 * @return the superHeroes
	 */
	public ConcurrentHashMap<String, SuperHero> getSuperHeroes() {
		return superHeroes;
	}

	/**
	 * @param superHeroes the superHeroes to set
	 */
	public void setSuperHeroes(ConcurrentHashMap<String, SuperHero> superHeroes) {
		this.superHeroes = superHeroes;
	}
	
	

}
