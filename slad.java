package gra.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class slad extends obiektygry
{
	private float alpha = 1;
	private float life;
	
	private przetwarzanie przetwarzanie;
	private Color color;
	
	private int width, height;
	
	//life = 0.01 - 0.1
	
	public slad(float x, float y, ID id, Color color, int width, int height, float life, przetwarzanie przetwarzanie)
	{
		super(x, y, id);
		this.przetwarzanie = przetwarzanie;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;

	}

	public void tick()
	{
		if(alpha > life)
		{
			alpha -= (life - 0.0001f);
		}
		else przetwarzanie.removeObject(this);
	}

	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha)
	{
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public Rectangle getBounds()
	{
		return null;
	}
	
}
