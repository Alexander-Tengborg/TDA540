public class Cleaner6 {
        private Robot robot;
        private Location startLocation;

        public static void main(String[] args) {
                Cleaner6 cleaner = new Cleaner6();
                cleaner.createEnviroment();
                cleaner.cleanCorridors();
        } //main

        private void createEnviroment() {
                RobotWorld world = RobotWorld.load("src/loop.txt");
                robot = new Robot(1, world.getNumCols() - 5, Robot.WEST, world);
                robot.setDelay(250);
        }//createEnviroment 

	    //before: The room has four corridors, forming a square
	    //after:  All cells in the corridors are light.
	    //        The robot has the same location and facing the same direction
        private void cleanCorridors() {
            startLocation = robot.getLocation();
            if(!robot.frontIsClear()) robot.turnLeft();

            do {
                cleanCorridorUpToPosition();
                if(robot.getLocation().equals(startLocation)) return;
                robot.turnLeft();
                if(!robot.frontIsClear()) {
                    robot.turnLeft();
                    robot.turnLeft();
                }
            } while(!robot.getLocation().equals(startLocation));
        }//cleanCorridors

        //after:  All cells in the corridor both on(/below) and behind the robot are cleaned.
        private void clearCorridorInFront() {
            while(robot.frontIsClear() && !robot.atEndOfWorld()) {
                if(robot.onDark()) robot.makeLight();
                robot.move();
            }
        }

        //after: All cells in the corridor up to a certain position are cleaned.
        private void cleanCorridorUpToPosition() {
            do {
                if(robot.onDark()) robot.makeLight();
                robot.move();
            } while(robot.frontIsClear() && !robot.atEndOfWorld() && !robot.getLocation().equals(startLocation));
        }
}//Cleaner

