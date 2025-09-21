package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous

public class AutoColorDetector extends LinearOpMode {

    private Drivetrain robot;
    ColorSensor colorSensor;
    
    public void runOpMode() throws InterruptedException {
        robot = new Drivetrain(hardwareMap);
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor"); // Replace with your actual sensor name
        
        robot.resetMotors();
        waitForStart();
        if (opModeIsActive()) {
            
            while(colorSensor.red()<55) {
                robot.move(-.5,-.5,-.5,-.5);
            }
            robot.move(0,0,0,0);
        
        }
    
    }
    
    // todo: write your code here
}