package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

@TeleOp(name="testColor", group="test")
public class Test_ColorDetector extends LinearOpMode {

    ColorSensor colorSensor;
    NormalizedColorSensor colorSensor2;

    @Override
    public void runOpMode() {

        // Initialize the ColorSensor
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor"); // Replace with your actual sensor name
        colorSensor2 = hardwareMap.get(NormalizedColorSensor.class, "colorSensor");
        // Wait for the start button to be pressed
        
        NormalizedRGBA colors = colorSensor2.getNormalizedColors(); 
        waitForStart();

        // Run the robot until the stop button is pressed
        while (opModeIsActive()) {

            // Check if the detected color is red
                telemetry.addData("red:", colorSensor.red());
                telemetry.addData("green:", colorSensor.green());
                telemetry.addData("blue:", colorSensor.blue());
                telemetry.addData("normalized colors", "%.3f", colors.red);
                telemetry.update();



            idle();
        }
    }

    // Method to check if the detected color is red
    private boolean isRedColorDetected() {
        int redThreshold = 100; 
        int greenThreshold = 50;
        int blueThreshold = 50;

        int redValue = colorSensor.red();
        int greenValue = colorSensor.green();
        int blueValue = colorSensor.blue();

        // Check if the red component is significantly higher than green and blue
        return (redValue > redThreshold) && (greenValue < greenThreshold) && (blueValue < blueThreshold);
    }
}