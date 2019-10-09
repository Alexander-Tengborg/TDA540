//This program reads the radius of a circle and prints its are

import javax.swing.*;

public class Circle2 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter the radius of the circle: ");
        double radius = Double.parseDouble(input);
        double area = Math.PI * Math.pow(radius, 2);
        double circumference = 2*radius*Math.PI;
        JOptionPane.showMessageDialog(null, "The area of the circle is " + area + "\nThe circumference of the circle is " + circumference);
    }
}
