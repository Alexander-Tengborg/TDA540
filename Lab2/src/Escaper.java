public class Escaper { 
	private Robot robot;
	private Location finishLocation;
	public static void main(String[] args) { 
		Escaper escaper = new Escaper(); 
		escaper.createEnviroment(); 
		escaper.moveToEntrance ();
		System.out.println("Found the entrance!");
	}//main 

	public void createEnviroment() { 
		RobotWorld  world = RobotWorld.load("src/room.txt");
		robot = new Robot(2, 2, Robot.WEST, world);
		robot.setDelay(100);
		finishLocation = new Location(4, 6);
	}//createEnviroment 

	//before: robot is inside the room
	//after:  robot is in the cell representing the the dorrjamb
	public void moveToEntrance() {
        while(robot.frontIsClear()) {
            robot.move();
            if(robot.getLocation().equals(finishLocation)) return;
        }
		do {
            boolean walls[] = new boolean[4];

            for(int i = 0; i < 4; i++) {
                walls[i] = !robot.frontIsClear();
                robot.turnLeft();
            }

            if(!walls[0] && walls[3]) {
                robot.move();
            } else if(walls[0]) {
                robot.turnLeft();
            } else {
                robot.turnLeft();
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
            }
		} while(!robot.getLocation().equals(finishLocation));
	}// moveToEntrance
}//Escaper
