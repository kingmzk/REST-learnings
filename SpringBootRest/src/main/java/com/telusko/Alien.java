package com.telusko;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Alien
{
  
	@javax.persistence.Id
	private String Name;
	private int points;
	private int Id;
	
	@Override
	public String toString() {
		return "Alien [Name=" + Name + ", points=" + points + ", Id=" + Id + "]";
	}
 
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getName()
	{
		return Name;
	}
	
	public void setName(String Name)
	{
		this.Name = Name;
	}
}
