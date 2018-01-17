package gra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class wrog extends obiektygry
{
	private przetwarzanie przetwarzanie;

	public wrog(int x, int y, ID id, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		
		this.przetwarzanie = przetwarzanie;
		
		velX = 5;
		velY = 5;
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= fale.HEIGHT - 50) velY *= -1;
		if(x <= 0 || x >= fale.WIDTH - 20) velX *= -1;
		
		przetwarzanie.addObject(new slad(x, y, ID.Trail, Color.red, 16, 16, 0.04f, przetwarzanie));
	}

	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
