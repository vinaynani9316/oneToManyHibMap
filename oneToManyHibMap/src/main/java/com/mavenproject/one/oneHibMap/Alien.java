package com.mavenproject.one.oneHibMap;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@javax.persistence.Entity
public class Alien 
{
	@Id
	private int aid;
	private String aname;
	
	@OneToMany(mappedBy="alien", fetch=FetchType.EAGER) // by default it is lazy & fire two queries where as in eager, 
	private Collection<Laptop> laps= new ArrayList<Laptop>(); // it will print in one query uses left outer join 
	
	public Collection<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(Collection<Laptop> laps) {
		this.laps = laps;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	
	

}
