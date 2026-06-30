package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous
class LimeLightTest extends OpMode {

    private Limelight3A limelight3A;

    @Override
    public void init() {
        limelight3A = hardwareMap.get(Limelight3A.class, "limelight");
        limelight3A.pipelineSwitch(0);
    }

    @Override
    public void start() {
        limelight3A.start();
    }

    @Override
    public void loop() {
        LLResult llresult = limelight3A.getLatestResult();
        if (llresult != null && llresult.isValid()) {
            telemetry.addData("Target X offset", llresult.getTx());
            telemetry.addData("Target Y offset", llresult.getTy());
            telemetry.addData("Target Area Offset", llresult.getTa());
        }
    }
}
