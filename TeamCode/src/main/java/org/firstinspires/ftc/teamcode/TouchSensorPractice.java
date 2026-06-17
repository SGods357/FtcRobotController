package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class TouchSensorPractice extends OpMode {

    TestBench bench = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    String touchSensorState;

    @Override
    public void loop() {

        if (!bench.isTouchSensorReleased()) {
            touchSensorState = "pressed";
        }
        else {
            touchSensorState = "not pressed";
        }
        telemetry.addData("Touch Sensor State", touchSensorState);
        telemetry.addData("Touch Sensor State", bench.isTouchSensorPressed());
    }
}
