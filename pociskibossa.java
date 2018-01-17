package gra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class pociskibossa extends obiektygry
{
	private przetwarzanie przetwarzanie;
	Random r = new Random();

	public pociskibossa(int x, int y, ID id, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		
		this.przetwarzanie = przetwarzanie;
		
		velX = (r.nextInt(5 - -5) + -5);
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
		
		//if(y <= 0 || y >= fale.HEIGHT - 50) velY *= -1;
		//if(x <= 0 || x >= fale.WIDTH - 20) velX *= -1;
		
		if(y >= fale.HEIGHT) przetwarzanie.removeObject(this);
		
		przetwarzanie.addObject(new slad(x, y, ID.Trail, Color.red, 16, 16, 0.03f, przetwarzanie));
	}

	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
