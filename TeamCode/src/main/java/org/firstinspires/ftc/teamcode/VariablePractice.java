package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
class VariablePractice extends OpMode {

    @Override
    public void init() {
        int teamNumber = 23014;
        double motorSpeed= 0.75;
        boolean clawClosed = true;
        String teamName = "Astro Bruins";
        int motorAngle = 90;

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("claw Closed", clawClosed);
        telemetry.addData("Name", teamName);
        telemetry.addData("Motor Angle", motorAngle);
    }

    @Override
    public void loop() {

    }
}
