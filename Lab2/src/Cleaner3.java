public class Cleaner3 {
        private Robot robot;

        public static void main(String[] args) {
                Cleaner3 cleaner = new Cleaner3();
                cleaner.createEnviroment();
                cleaner.cleanCorridors();
        } //main

        private void createEnviroment() {
                RobotWorld world = RobotWorld.load("src/square3.txt");
                robot = new Robot(1, world.getNumCols() - 2, Robot.WEST, world);
                robot.setDelay(250);
        }//createEnviroment 

	    //before: The room has four corridors, forming a square
	    //        The robot is located in beginning of one of the corridors, facing the corridor
	    //        in counter-clockwise direction.
	    //after:  All cells in the corridors are light.
	    //        The robot has the same location and facing the same direction
        private void cleanCorridors() {
                for(int i = 0; i < 4; i++) {
                    clearCorridorInFront();
                    robot.turnLeft();
                }

        }//cleanCorridors

        //after:  All cells in the corridor both on(/below) and behind the robot are cleaned.
        private void clearCorridorInFront() {
            while(robot.frontIsClear() && !robot.atEndOfWorld()) {
                if(robot.onDark()) robot.makeLight();
                robot.move();
            }
        }
}//Cleaner 

