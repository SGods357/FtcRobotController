package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {

    private DigitalChannel touchSensor; //touchSensorIntake <- Give detailed name
    private DcMotor motor; //linearSlideMotor <- Give detailed name
    private double ticksPerRev; // revolution
    double gearRatio = 1;


    public void init(HardwareMap hwMap) {
        // Touch Sensor
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor"); // deviceName has to be the same one on the config file on the driver hub
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        // Dc Motor
        motor = hwMap.get(DcMotor.class, "motor"); // deviceName has to be the same one on the config file on the driver hub
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // - RUN_USING_ENCODER = control velocity, and uses encoder to make sure that velocity is reached and stable
        // - RUN_TO_POSITION = uses encoder to run to exact position
        // - RUN_WITHOUT_ENCODER = control velocity, but no way to double-check
        // - STOP_AND_RESET_ENCODER = stop motor, reset encoder value

        // BEST FOR DRIVETRAIN IS RUN_USING_ENCODER os it moves straight
        // use RUN_TO_POSTION for only one motor setups
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //BRAKE = HARD STOP
        //FLOAT = slow down to stop
        //motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    // ---------- touch sensor ----------
    public boolean isTouchSensorPressed() {
        return !touchSensor.getState(); // They use a pull resistor for electronically benefits, so we need to reverse it
    }

    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }

    // ---------- dc motor ----------
    public void setMotorSpeed( double speed ) {
        // accepts values from -1.0 to 1.0
        motor.setPower(speed);
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev * gearRatio; // normalizing ticks to revolutions
    }

    public void floatBrake() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void brakeBrake() {
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
