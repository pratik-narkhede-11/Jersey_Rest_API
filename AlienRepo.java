package com.pratik.restdemo;

import java.util.ArrayList;
import java.util.List;

public class AlienRepo {
	
	private static List<Alien> aliens = new ArrayList<>();
	
	public List<Alien> getAliens()
	{
		//System.out.println("Alien Resource was Called ");
		return aliens;
	}

	public Alien getAlien(int id) {
		for(Alien a : aliens)
		{
			if(a.getId() == id)
				return a;
		}
		return null;
	}
	
	public void create(Alien a)
	{
		aliens.add(a);
		/*for(Alien a1 : aliens)
		{
			System.out.println(a1);
		}*/
	}

	public void update(Alien a) {
		for(Alien i : aliens)
		{
			if(i.getId() == a.getId())
			{
				i.setName(a.getName());
				i.setPoints(a.getPoints());
			}
		}
	}

	public void delete(int id) {
		for(Alien i : aliens)
		{
			if(i.getId() == id)
			{
				aliens.remove(i);
			}
		}
		
	}
	
}
