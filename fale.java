package gra.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class fale extends Canvas implements Runnable
{	
	private static final long serialVersionUID = 8603649520512405428L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private przetwarzanie przetwarzanie;
	private HUD hud;
	private spawn spawner;
	private Menu menu;
	
	public enum Stan
	{
		Menu,
		Help,
		Game,
		End
	};
	
	public static Stan stangry = Stan.Menu; 
	
	public fale()
	{
		przetwarzanie = new przetwarzanie();
		hud = new HUD();
		menu = new Menu(this, przetwarzanie, hud);
		this.addKeyListener(new KeyInput(przetwarzanie));
		this.addMouseListener(menu);
		
		new okienko(WIDTH, HEIGHT, "Waves", this);
		
		spawner = new spawn(przetwarzanie, hud);
		r  = new Random();
		
		if(stangry == Stan.Game)
		{
			przetwarzanie.addObject(new gracz(WIDTH/2-32, HEIGHT/2-32, ID.Player, przetwarzanie));
			przetwarzanie.addObject(new wrog(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy, przetwarzanie));
		}
		else
		{
			for(int i = 0; i < 3; i++)
			{
				przetwarzanie.addObject(new tlomenu(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.TloMenu, przetwarzanie));
			}
		}
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus(); // dzia³a bez klikania
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick()
	{
		przetwarzanie.tick();
		
		if(stangry == Stan.Game)
		{
			hud.tick();
			spawner.tick();
			
			if(HUD.HEALTH <= 0)
			{
				HUD.HEALTH = 100;
				stangry = Stan.End;
				przetwarzanie.clearEnemies();
				for(int i = 0; i < 3; i++)
				{
					przetwarzanie.addObject(new tlomenu(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.TloMenu, przetwarzanie));
				}
			}
		}
		else if(stangry == Stan.Menu || stangry == Stan.End)
		{
			menu.tick();
		}
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		przetwarzanie.render(g);
		
		if(stangry == Stan.Game)
		{
			hud.render(g);
		}
		else if(stangry == Stan.Menu || stangry == Stan.Help || stangry == Stan.End)
		{
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static float blok(float var, float min, float max)
	{
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String args[])
	{
		new fale();
	}
}
