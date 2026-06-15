package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
class IfPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double leftY = gamepad1.left_stick_y;

        if (leftY >= -0.1 && leftY <= 0.1) {
            telemetry.addData("Left Stick", "in Dead Zone");
        }

        // Practice Examples
        // Turbo Btn
        double motorSpeed = -gamepad1.left_stick_y;

        if (!gamepad1.a) {
            motorSpeed *= 0.5;
        }

    }
}
