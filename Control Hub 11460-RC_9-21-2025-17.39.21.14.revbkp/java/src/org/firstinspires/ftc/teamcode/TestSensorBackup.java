package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@Autonomous

public class TestSensorBackup extends LinearOpMode {

    private Drivetrain robot; 
    private Claw claw; 
    private Wrist wrist;
    private Arm arm;
    // todo: write your code here
    
    public void runOpMode() throws InterruptedException { 
        robot = new Drivetrain(hardwareMap);
        claw = new Claw(hardwareMap);
        wrist = new Wrist(hardwareMap);
        arm = new Arm(hardwareMap);
        //coneLift = new Lift(hardwareMap);
        robot.setAuto();
        
        waitForStart();
        
        double flPower, blPower, frPower, brPower;
       
        if (opModeIsActive()) {


            robot.resetMotors();
            while (robot.lDistance.getDistance(DistanceUnit.CM) > 20.0 && robot.rDistance.getDistance(DistanceUnit.CM) > 20.0)
            {
            telemetry.addData("left:", robot.lDistance.getDistance(DistanceUnit.CM));
            telemetry.addData("right:", robot.rDistance.getDistance(DistanceUnit.CM));
            telemetry.update();

            robot.move(-.7, -.7, -.7, -.7);
        
            }

            //move than drop pixel

        }
        robot.move(0);
        
    }
}