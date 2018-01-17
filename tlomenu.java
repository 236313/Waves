package gra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class tlomenu extends obiektygry
{
	private przetwarzanie przetwarzanie;
	
	Random r = new Random();

	private Color col;

	public tlomenu(int x, int y, ID id, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		
		this.przetwarzanie = przetwarzanie;
		
		velX = (r.nextInt(6 - -6) + -6);
		velY = (r.nextInt(6 - -6) + -6);
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
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
		
		przetwarzanie.addObject(new slad(x, y, ID.Trail, col, 16, 16, 0.03f, przetwarzanie));
	}

	public void render(Graphics g)
	{
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
