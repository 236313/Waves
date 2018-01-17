package gra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class gracz extends obiektygry
{
	Random r = new Random();
	przetwarzanie przetwarzanie;
	
	public gracz(int x, int y, ID id, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		this.przetwarzanie = przetwarzanie;

	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		x = fale.blok(x, 0, fale.WIDTH -38);
		y = fale.blok(y, 0, fale.HEIGHT -67);
		
		przetwarzanie.addObject(new slad(x, y, ID.Trail, Color.white, 32, 32, 0.08f, przetwarzanie));
		
		kolizja();
	}
	
	private void kolizja()
	{
		for(int i = 0; i < przetwarzanie.object.size(); i++)
		{
			obiektygry tempObject = przetwarzanie.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.BasicEnemy2 || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.Boss)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//kod kolizji
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	public void render(Graphics g)
	{		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}

}
