class ComputerShot {


	/**The values for the cells in the map are the following:
	 * 9 - useless cell, was thrown out initially after generating a 'checkers' map, will never choose it with random chooser, but will shoot it 
	 * 10 - regular cell, have never shoot it
	 * 1 - regular cell, have shot it and missed
	 * 2 - regular cell, have shot it and hit the target
	 * 3 - regular cell, have shot it, hit the target and hit the whole ship

	/**Define counter variables for the 'for' loops: */
	int i,j;
	Shot move;



	Map shotCheckerSteps(Map enemyMap) {
		/**Take each uneven row of a 2-d array: */
		for (i=0; i < enemyMap.GetMap().length; i++) {
			/**Take each uneven element of this row (a checkers map): */
			for (j=0; j < enemyMap.GetMap()[i].length; j = j + 2) {

				enemyMap.setCell(i,j+1,9);
				enemyMap.setCell(i,j,10);


			}

		}
		/**[EVEN] Take each even row of a 2-d array: */
		for (i=0; i < enemyMap.GetMap().length; i = i + 2) {
			/**Take each uneven element of this row (a checkers map): */
			for (j=0; j < enemyMap.GetMap()[i].length; j = j + 2) {

				enemyMap.setCell(i,j+1,10);
				enemyMap.setCell(i,j,9);


			}

		}
		for (i=0; i < enemyMap.GetMap().length; i++) {
			for (j=0; j < enemyMap.GetMap()[i].length; j++) {
				System.out.print(" " + enemyMap.getCell(i,j));
			}
			System.out.println("");
		}
		return enemyMap;
	}

	Shot checkForPreviousHits (Map enemyMap, Shot lastShot) {

				/**Check for the last shot, If there was a hit, then try to shoot around this previous cell */
				if (enemyMap.getCell(lastShot.getX(), lastShot.getY()) == 2) {
					if (lastShot.getX() >= 1) {
						if (enemyMap.getCell(lastShot.getX() - 1, lastShot.getY()) >= 9) 
						{
							move.setX(lastShot.getX() - 1);
							move.setY(lastShot.getY());
					System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
							return move;
						}
					}
					else if (lastShot.getY() >= 1) {
						if (enemyMap.getCell(lastShot.getX(), lastShot.getY() - 1) >= 9) 
						{
							move.setX(lastShot.getX());
							move.setY(lastShot.getY() - 1);
					System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
							return move;
						}
					}
					else if (lastShot.getX() <= 8) {
						if (enemyMap.getCell(lastShot.getX() + 1, lastShot.getY()) >= 9) 
						{
							move.setX(lastShot.getX() + 1);
							move.setY(lastShot.getY());
					System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
							return move;
						}
					}
					else if (lastShot.getY() >= 1) {
						if (enemyMap.getCell(lastShot.getX(), lastShot.getY() + 1) >= 9) 
						{
							move.setX(lastShot.getX());
							move.setY(lastShot.getY() + 1);
					System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
							return move;
						}
					}


				}


				/**A completely random shot on a checkered map: */

		for (i=0; i < enemyMap.GetMap().length; i++) {
			for (j=0; j < enemyMap.GetMap()[i].length; j++) {

				if (enemyMap.getCell(i,j) == 10) {

					Shot move = new Shot(i, j);
					System.out.println("The computer made a shot: " + move.getX() + ", " + move.getY());
					return move;

				}
			}

		}

		return move;
	}
}
