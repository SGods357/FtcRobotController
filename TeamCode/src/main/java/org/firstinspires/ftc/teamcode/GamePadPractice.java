package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
class GamePadPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        // runs 50 times a second
        // Variables
        double speedForward = -gamepad1.left_stick_y / 2.0;
        double diffXJoysticks = gamepad1.left_stick_x - gamepad1.right_stick_x;
        double rearTriggerSum = gamepad1.left_trigger + gamepad1.right_trigger;

        // Left Joystick
        telemetry.addData("Left Stick x", gamepad1.left_stick_x);
        telemetry.addData("Left Stick y", speedForward);

        // Right Joystick
        telemetry.addData("Right Stick x", gamepad1.right_stick_x);
        telemetry.addData("Right Stick y", (-gamepad1.right_stick_y / 2.0));

        // Buttons
        telemetry.addData("A button", gamepad1.a);
        telemetry.addData("B button", gamepad1.b);

        // Exercise
        telemetry.addData("Difference Joy Sticks", diffXJoysticks);
        telemetry.addData("Sum of Rear Triggers", rearTriggerSum);
    }

}
