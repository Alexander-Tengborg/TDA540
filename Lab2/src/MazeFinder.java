public class MazeFinder { 
	private Robot robot; 
	public static void main(String[] args) { 
		MazeFinder finder = new MazeFinder(); 
		finder.createEnviroment(); 
		finder.findExit(); 
	}//main 

	public void createEnviroment() { 
		RobotWorld world = RobotWorld.load("src/maze.txt"); 
		robot = new Robot(1, 2, Robot.EAST, world); 
		robot.setDelay(20);
	}//createEnviroment 

	// The robot finds the way through a simply connected maze
	//before: The maze is simply connected.
	//        The robot is at the entrance of the maze.
	//after:  The robot is at the exit of the maze
	public void findExit() { 
		do {
		    boolean walls[] = new boolean[4];
		    boolean noWalls = true;

            for(int i = 0; i < 4; i++) {
                walls[i] = !robot.frontIsClear();
                if(walls[i]) noWalls = false;
                robot.turnLeft();
            }

            //Turn right, move forward
            if(walls[0] && walls[1] && !walls[3]) {
                robot.turnLeft();
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                continue;
            }

            //Turn around, move forward
            if(walls[0] && walls[1] && walls[3]) {
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                continue;
            }

            //Turn left, move forward
            if(noWalls || (walls[0] && !walls[1] && walls[3]) || walls[0]) {
                robot.turnLeft();
                robot.move();
                continue;
            }

            //Dont turn, move forward
            if(walls[1] || walls[3]) {
                robot.move();
                continue;
            }
		} while(!robot.atEndOfWorld());
        System.out.println("FINISHED!");
	}// findExit 
}//MazeFinder
