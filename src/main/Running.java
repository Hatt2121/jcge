package main;

import player.*;

public class Running {
	Player player;
	Ask a = new Ask();
	int clock = 1;
	
	public Running(Player player) {
		this.player = player;
	}
	
	public void mainrunner() {
		player.name = a.returnString("What do you want to be called?: ");
		System.out.println();
		player.world.name = a.returnString("What do you want the world to be called?: ");
		player.printCurrentBoard();
		player.printPosition();
		for(;;clock++) {
			String b = a.whatToDo(clock);
			String o = b.toLowerCase();
			if(o.equals("quit")) {
				break;
			} else {
				String[] n = o.split(" ");
				switch(n.length) {
				case 1:
					String h = n[0];
					one(h);
					postmove();
					break;
				case 2:
					String e = n[0];
					String q = n[1];
					two(e,q);
					postmove();
					break;
				case 3:
					String r = n[0];
					String y = n[1];
					String w = n[2];
					three(r,y,w);
					postmove();
					break;
				}
			}
		}
	}
	
	public void one(String h) {
		helpOne(h);
		interactOne(h);
	}
	
	public void two(String e, String q) {
		helpTwo(e,q);
		moveTwo(e,q);
		printTwo(e,q);
		faceTwo(e,q);
	}
	
	public void three(String r, String y, String w) {
		moveThree(r,y,w);
	}
	
	public void moveThree(String r, String y, String w) {
		if(r.equals("move")) {
			Direction m = Direction.fromString(y);
			int j = Integer.valueOf(w);
			
			System.out.println();
			player.move(m, j);
			player.fetchPosition(player.world);
			if(!player.movedtoomuch) {
				player.printCurrentBoard();
				player.printPosition();
			}
			clock = clock + j;
		}
	}
	
	public void moveTwo(String e, String q) {
		if(e.equals("move")) {
			Direction m = player.dir;
			int j = Integer.valueOf(q);
			
			System.out.println();
			player.move(m, j);
			player.fetchPosition(player.world);
			if(!player.movedtoomuch) {
				player.printCurrentBoard();
				player.printPosition();
			}
		}
	}
	
	public void helpTwo(String e, String q) {
		if(e.equals("help")) {
			switch(q) {
			default:
				System.out.println("Not a function.");
			}
			clock = clock -1;
		}
	}
	
	public void helpOne(String h) {
		if(h.equals("help")) {
			System.out.println("To get help, you need to write the funtion name after a space, after the help function.");
			System.out.println();
			System.out.println("Here is the list of functions:");
			System.out.println("------------------------------");
			System.out.println("help");
			System.out.println("print");
			System.out.println("face");
			System.out.println("");
			clock = clock -1;
		}
	}
	
	public void printTwo(String e, String q) {
		if(e.equals("print")) {
			switch(q) {
			case"world":
				//This method is currently being worked on
			case"current_position":
				player.printCurrentBoard();
				player.printPosition();
				break;
			case"inventory":
				player.inventory.printInventory();
				System.out.println();
				player.inventory.printStats();
				break;
			case"player_stats":
				System.out.println("Health: " + player.health);
				System.out.println("Health Percentage: " +((int) (player.health/player.maxhealth)*100) + "%");
				System.out.println();
				System.out.println("Hunger: " + player.hunger);
				System.out.println("Hunger Percentage: " + ((int) (player.hunger/player.maxhunger)*100) + "%");
				break;
				//More will come as more features are added (Specifically Temperature)
			}
			clock=clock-1;
		}
	}
	
	public void faceTwo(String e, String q) {
		if(e.equals("face")) {
			Direction a = Direction.fromString(q);
			player.changeFacingDirection(a);
		}
	}
	
	public void interactOne(String h) {
		if(h.equals("interact") ) {
			player.interact();
		}
	}
	
	public void saveOne() {
		
	}
	
	public void postmove() {
		//Npc needs to move
		//Things need to be cleaned up
		//Option to save at any time
	}
	
	public void consoleOne(String h) {
		if(h.equals("`")) {
			System.out.println("Console Activated: \nType \"`\" and then a command");
		}
	}
}
