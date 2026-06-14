package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@Disabled
@Autonomous // Very Critical, code will not show (do @TeleOp or @Autonomous)
@TeleOp
public class HelloWorld extends OpMode { // Child Class of OpMode

    //Overrides current init()
    @Override
    public void init() {
        telemetry.addData("Hello", "World"); //prints Hello: World in the driver hub
    }

    @Override
    public void loop() {

    }
}
