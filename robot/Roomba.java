package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	
	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";
	



		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
	}
	
	// declared here so it is visible in all the methods!
	private Robot roomba;

	// You will need to add many variables!!

	/**
	 * @param worldName
	 * @param startX
	 * @param startY
	 * @return
	 */
	public int cleanRoom(String worldName, int startX, int startY) {
		int worldSpeed = 0;
		Robot roomba = new Robot(startX, startY, East, 6); 
		roomba.nextToABeeper();

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
		// Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?

		int pile = 0;
		int totalBeepers = 0;
		int totalSquaredMoved = 1;
		int SizeOfPile = 0;
		int biggestPile = 0;
		int biggestPileX = roomba.street();
		int biggestPileY = roomba.avenue();
		int ave = 0;
		int street = 0;
		int width = ave + 1;
		int height = street + 1;
		int area = width * height;
		
		boolean needtocleanmore = true;

				

		while (needtocleanmore)
		{
			while(roomba.frontIsClear())
			{
				SizeOfPile = 0;

				while(roomba.nextToABeeper())
				{
					
					roomba.pickBeeper();
					SizeOfPile++;
					totalBeepers++;							
				}

				if(SizeOfPile != 0)
					pile++;
				
				if (SizeOfPile > biggestPile)
				{
					biggestPile = SizeOfPile;
					biggestPileX = roomba.avenue();
					biggestPileY = roomba.street();
				}
				
				totalSquaredMoved++;
				width++;
				roomba.move();				
			}
			
			SizeOfPile = 0;
			while(roomba.nextToABeeper())
			{				
				roomba.pickBeeper();
				SizeOfPile++;
				totalBeepers++;							
			}

			if(SizeOfPile != 0)
				pile++;
			
			if (SizeOfPile > biggestPile)
			{
				biggestPile = SizeOfPile;
				biggestPileX = roomba.avenue();
				biggestPileY = roomba.street();
			}
			
			if(roomba.facingEast())
			{
				roomba.turnLeft();
				if(roomba.frontIsClear())
				{
					roomba.move();
					totalSquaredMoved++;
					height++;
				}
				else
				{
					needtocleanmore = false;
				}
				
				roomba.turnLeft();
			}
			else 
			{
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.move();
				totalSquaredMoved++;
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
			}
			
		}

		area = width*height;

		System.out.print("Room area: " + area);
		System.out.print("Number of piles: " + pile);
		System.out.print("Total moves: " + totalSquaredMoved);
		System.out.print("biggest pile size: " + biggestPile);
		System.out.print("Biggest pile's location:("+biggestPileY+","+biggestPileX+")");
		System.out.print("Average pile:"+(double)totalBeepers/pile);
		
		// This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}








