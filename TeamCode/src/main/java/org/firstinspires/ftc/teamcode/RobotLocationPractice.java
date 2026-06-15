package org.firstinspires.ftc.teamcode;

public class RobotLocationPractice {
    double angle;

    // constructor method
    public RobotLocationPractice(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        // normalize the angle from - 180 to 180, and returns it
        double angle = this.angle;

        while (angle >= 180) {
            angle -= 360;
        }
        while (angle <= -180) {
            angle += 360;
        }

        return angle; //return normalized value
    }

    public void turnRobot( double angleChange ) {
        angle += angleChange;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return this.angle;
    }

    // Practical Exercise
    double x;
    double y;
    public double getX() {
        return this.x;
    }

    public void changeX( double changeAmount ) {
        x += changeAmount;
    }

    public void setX( double x ) {
        this.x = x;
    }

    public void changeY( double changeAmount ) {
        y += changeAmount;
    }

    public void setY( double y ) {
        this.y = y;
    }

    public double getY() {
        return this.y;
    }
}
