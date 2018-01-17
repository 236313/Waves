package gra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class wrog2 extends obiektygry
{
	private przetwarzanie przetwarzanie;

	public wrog2(int x, int y, ID id, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		
		this.przetwarzanie = przetwarzanie;
		
		velX = 2;
		velY = 9;
		
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
		
		przetwarzanie.addObject(new slad(x, y, ID.Trail, Color.orange, 16, 16, 0.03f, przetwarzanie));
	}

	public void render(Graphics g)
	{
		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
