package _06_gridworld;

import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class GridWorld {
	public static void main(String[] args) {
		World gridWorld = new World();
		gridWorld.show();
		Bug bugI = new Bug();
		Location locationI = new Location(5, 5);
		gridWorld.add(locationI, bugI);
		Random randy = new Random();
		int bugX = randy.nextInt(9);
		int bugY = randy.nextInt(9);
		Location locationII = new Location(bugX, bugY);
		Bug bugII = new Bug();
		gridWorld.add(locationII, bugII);
		bugII.setColor(Color.BLUE);
		bugII.setDirection(90);
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				bugX = j;
				bugY = i;
				Location locationIII = new Location(bugX, bugY - 1);
				Location locationIV = new Location(bugX, bugY + 1);
				Flower flowerI = new Flower();
				Flower flowerII = new Flower();
				gridWorld.add(locationIII, flowerI);
				gridWorld.add(locationIV, flowerII);
			}
		}
		
	}
}
