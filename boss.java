package gra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class boss extends obiektygry
{
	private przetwarzanie przetwarzanie;
	Random r = new Random();
	
	private int timer = 80;
	private int timer2 = 50;

	public boss(int x, int y, ID id, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		
		this.przetwarzanie = przetwarzanie;
		
		velX = 0;
		velY = 2;		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 96, 96);
	}

	public void tick()
	{
		x += velX;
		y += velY;
		
		if(timer <= 0) velY = 0;
		else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0)
		{
			if(velX == 0) velX = 2;
			
			if(velX == 0) velX += 0.005f;
			else if(velX <0) velX -= 0.005f;
			
			velX = fale.blok(velX, -10, 10);
			
			int spawn = r.nextInt(10);
			if(spawn == 0) przetwarzanie.addObject(new pociskibossa((int)x+48, (int)y+48, ID.BasicEnemy, przetwarzanie));
		}
		
		//if(y <= 0 || y >= fale.HEIGHT - 50) velY *= -1;
		if(x <= 0 || x >= fale.WIDTH - 96) velX *= -1;
		
		//przetwarzanie.addObject(new slad(x, y, ID.Trail, Color.red, 96, 96, 0.06f, przetwarzanie));
	}

	public void render(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
	}
	
}
