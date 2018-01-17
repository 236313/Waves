package gra.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import gra.main.fale.Stan;

public class Menu extends MouseAdapter
{
	private fale game;
	private przetwarzanie przetwarzanie;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(fale game, przetwarzanie przetwarzanie, HUD hud)
	{
		this.game = game;
		this.hud = hud;
		this.przetwarzanie = przetwarzanie;
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(game.stangry == Stan.Menu)
		{
			//przycisk play
			if(mouseOver(mx, my, 210, 125, 200, 64))
			{
				game.stangry = Stan.Game;
				przetwarzanie.addObject(new gracz(fale.WIDTH/2-32, fale.HEIGHT/2-32, ID.Player, przetwarzanie));
				przetwarzanie.clearEnemies();
				przetwarzanie.addObject(new wrog(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy, przetwarzanie));
			}
			
			//przycisk help
			if(mouseOver(mx, my, 210, 225, 200, 64))
			{
				game.stangry = Stan.Help;
			}
					
			//przycisk quit
			if(mouseOver(mx, my, 210, 325, 200, 64))
			{
				System.exit(1);
			}
		}
		
		//przycisk back
		if(game.stangry == Stan.Help)
		{
			if(mouseOver(mx, my, 210, 325, 200, 64))
			{
				game.stangry = Stan.Menu;
				return;
			}
		}
		
		//przycisk try again
			if(game.stangry == Stan.End)
			{
				if(mouseOver(mx, my, 210, 325, 200, 64))
				{
					game.stangry = Stan.Game;
					hud.setLevel(1);
					hud.setscore(0);
					przetwarzanie.addObject(new gracz(fale.WIDTH/2-32, fale.HEIGHT/2-32, ID.Player, przetwarzanie));
					przetwarzanie.clearEnemies();
					przetwarzanie.addObject(new wrog(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy, przetwarzanie));
				}
			}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		if(game.stangry == Stan.Menu)
		{
			Font fnt = new Font("forte", 1, 60);
			Font fnt2 = new Font("forte", 1, 30);
		
			g.setFont(fnt);
			g.setColor(Color.blue);
			g.drawString("Waves", 225, 70);
		
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(210, 125, 200, 64);
			g.drawString("Play", 274, 166);
		
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(210, 225, 200, 64);
			g.drawString("Help", 274, 266);
		
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(210, 325, 200, 64);
			g.drawString("Quit", 274, 366);
		}
		else if(game.stangry == Stan.Help)
		{
			Font fnt = new Font("forte", 1, 60);
			Font fnt2 = new Font("forte", 1, 30);
			Font fnt3 = new Font("forte", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.blue);
			g.drawString("Help", 225, 70);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("Use WASD keys to move and avoid enemies", 110, 150);
			
			g.setFont(fnt2);
			g.setColor(Color.blue);
			g.drawRect(210, 325, 200, 64);
			g.drawString("Back", 274, 366);
		}
		else if(game.stangry == Stan.End)
		{
			Font fnt = new Font("forte", 1, 60);
			Font fnt2 = new Font("forte", 1, 30);
			Font fnt3 = new Font("forte", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.blue);
			g.drawString("Game Over", 155, 70);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("You lost with a score of: " + hud.getScore(), 165, 150);
			
			g.setFont(fnt2);
			g.setColor(Color.blue);
			g.drawRect(210, 325, 200, 64);
			g.drawString("Try Again", 240, 366);
		}
	}

}
