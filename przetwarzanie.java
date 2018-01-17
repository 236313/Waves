package gra.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class przetwarzanie
{
	LinkedList<obiektygry> object = new LinkedList<obiektygry>();

	public void tick()
	{
		for(int i = 0; i < object.size(); i++)
		{
			obiektygry tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < object.size(); i++)
		{
			obiektygry tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemies()
	{
		for(int i = 0; i < object.size(); i++)
		{
			obiektygry tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Player)
			{
				object.clear();
				if(fale.stangry != fale.Stan.End)
				addObject(new gracz((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		}
	}
	
	public void addObject(obiektygry object)
	{
		this.object.add(object);
	}
	
	public void removeObject(obiektygry object)
	{
		this.object.remove(object);
	}
	
}
