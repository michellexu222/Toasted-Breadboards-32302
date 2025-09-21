package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous

public class TestIMuRotate extends LinearOpMode{
    
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
        
        if (opModeIsActive()) {
            double startAngle = getIntegratedHeading();
            robot.moveForward(-68, 1);
            sleep(1000);
            
            robot.resetMotors();

            while (getIntegratedHeading() < startAngle + 90) {
                double power = Math.abs((startAngle + 90 - getIntegratedHeading())/100);
                if (power > 1.0) power = 1.0;
                else if (power < 0.4) power = 0.4;
                robot.rotate(false, true,power );

            }
        
        }
        

   }
   
    private double getIntegratedHeading() {
       return robot.imu.getAngularOrientation().firstAngle;
    }

    // todo: write your code here
}