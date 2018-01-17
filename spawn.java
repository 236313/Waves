package gra.main;

import java.util.Random;

public class spawn
{
	private przetwarzanie przetwarzanie;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public spawn(przetwarzanie przetwarzanie, HUD hud)
	{
		this.przetwarzanie = przetwarzanie;
		this.hud = hud;
	}
	
	public void tick()
	{
		scoreKeep++;
		
		if(scoreKeep >= 250)
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(hud.getLevel() == 2)
			{
				przetwarzanie.addObject(new wrog(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy, przetwarzanie));
			}
			else if(hud.getLevel() == 3)
			{
				przetwarzanie.addObject(new wrog(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy, przetwarzanie));
			}
			else if(hud.getLevel() == 4)
			{
				przetwarzanie.addObject(new wrog(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy, przetwarzanie));
			}
			else if(hud.getLevel() == 5)
			{
				przetwarzanie.addObject(new wrog2(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy2, przetwarzanie));
			}
			else if(hud.getLevel() == 6)
			{
				przetwarzanie.addObject(new wrog2(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy2, przetwarzanie));
			}
			else if(hud.getLevel() == 7)
			{
				przetwarzanie.addObject(new wrog3(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.SmartEnemy, przetwarzanie));
			}
			else if(hud.getLevel() == 8)
			{
				przetwarzanie.addObject(new wrog2(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy2, przetwarzanie));
			}
			else if(hud.getLevel() == 9)
			{
				przetwarzanie.addObject(new wrog(r.nextInt(fale.WIDTH - 50), r.nextInt(fale.HEIGHT - 50), ID.BasicEnemy, przetwarzanie));
			}
			else if(hud.getLevel() == 10)
			{
				przetwarzanie.clearEnemies();
				przetwarzanie.addObject(new boss((fale.WIDTH / 2) -48, -135, ID.Boss, przetwarzanie));
			}
		}
	}

}
