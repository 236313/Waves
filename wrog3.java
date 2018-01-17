package gra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class wrog3 extends obiektygry
{
	private przetwarzanie przetwarzanie;
	private obiektygry gracz;

	public wrog3(int x, int y, ID id, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		this.przetwarzanie = przetwarzanie;
		
		for(int i = 0; i < przetwarzanie.object.size(); i++)
		{
			if(przetwarzanie.object.get(i).getId() == ID.Player) gracz = przetwarzanie.object.get(i);
		}
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		float diffX = x - gracz.getX() - 16;
		float diffY = y - gracz.getY() - 16;
		float distance = (float) Math.sqrt((x - gracz.getX()) * (x - gracz.getX()) + (y - gracz.getY()) * (y - gracz.getY()));
		
		velX = ((-1/distance) * diffX);
		velY = ((-1/distance) * diffY);
		
		//if(y <= 0 || y >= fale.HEIGHT - 50) velY *= -1;
		//if(x <= 0 || x >= fale.WIDTH - 20) velX *= -1;
		
		przetwarzanie.addObject(new slad(x, y, ID.Trail, Color.green, 16, 16, 0.04f, przetwarzanie));
	}

	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
