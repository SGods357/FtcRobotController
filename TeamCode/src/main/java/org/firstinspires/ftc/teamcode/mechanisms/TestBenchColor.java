package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TestBenchColor {
    NormalizedColorSensor colorSensor;

    public enum DetectedColor {
        RED,
        BLUE,
        YELLOW,
        UNKNOWN
    }

    public  void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensor_color_distance");
        // Increase gains for right values for colors
        colorSensor.setGain(8); // default 1
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = colorSensor.getNormalizedColors(); // return 4 values (RGBA)

        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normGreen = colors.green / colors.alpha;
        normBlue = colors.blue / colors.alpha;

        // Calibration
        telemetry.addData("red", normRed);
        telemetry.addData("green", normGreen);
        telemetry.addData("blue", normBlue);

        /*
        TEST VALUES, WILL CHANGE FOR OTHER COLORS AND SENSORS
        If color is right in front of sensor, reading should be 1 for a pure red,green, or blue
        red, green, blue
        RED CHIP = >.35, <.3, <.3
        YELLOW CHIP = >.5, >.9, <.6
        BLUE CHIP = <.2, <.5, >.5
         */

        if (normRed > 0.35 && normGreen < 0.3 && normBlue < 0.3){
            return DetectedColor.RED;
        }
        else if (normRed > 0.5 && normGreen > 0.9 && normBlue < 0.6){
            return DetectedColor.YELLOW;
        }
        else if (normRed < 0.2 && normGreen < 0.5 && normBlue > 0.5){
            return DetectedColor.BLUE;
        }
        else {
            return DetectedColor.UNKNOWN;
        }
    }
}
