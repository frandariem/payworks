package com.payworks.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.payworks.util.Power;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuperHero implements Comparable<SuperHero>{
	
	private String name, pseudonym, publisher;
	private List<Power> powers;
	private List<SuperHero> allies;
	private String firstAppearance;
	
	public SuperHero() {
		powers = new ArrayList<Power>();
		allies = new ArrayList<SuperHero>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		firstAppearance = format.format(new Date());
	}
	
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		if (object == null || object.getClass() != getClass()) {
			result = false;
		} else {
			SuperHero hero = (SuperHero) object;
			if (this.name == hero.getName()) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.name.hashCode();
		return hash;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pseudonym
	 */
	public String getPseudonym() {
		return pseudonym;
	}
	/**
	 * @param pseudonym the pseudonym to set
	 */
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the powers
	 */
	public List<Power> getPowers() {
		return powers;
	}
	/**
	 * @param powers the powers to set
	 */
	public void setPowers(List<Power> powers) {
		this.powers = powers;
	}
	/**
	 * @return the allies
	 */
	public List<SuperHero> getAllies() {
		return allies;
	}
	/**
	 * @param allies the allies to set
	 */
	public void setAllies(List<SuperHero> allies) {
		this.allies = allies;
	}
	/**
	 * @return the firstAppearance
	 */
	public String getFirstAppearance() {
		return firstAppearance;
	}
	/**
	 * @param firstAppearance the firstAppearance to set
	 */
	public void setFirstAppearance(String firstAppearance) {
		this.firstAppearance = firstAppearance;
	}
	
	@Override
	public int compareTo(SuperHero other) {
		return this.getName().compareTo(other.getName());
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Pseudonim: " + pseudonym + ", Publisher: " + publisher + ", FirstAppareance: " +
				firstAppearance + ", Powers: " + powers + ", Allies: " + allies;
	}
	

}
