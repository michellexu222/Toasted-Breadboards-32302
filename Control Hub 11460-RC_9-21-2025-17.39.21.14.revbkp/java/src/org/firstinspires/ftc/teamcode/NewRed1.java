package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;



@Autonomous
//Red side
//Parks Right side
//Pixel at fron
public class NewRed1 extends LinearOpMode {
    
    
    private Drivetrain robot; 
    private Claw claw; 
    private Wrist wrist;
    private Arm arm;
    
    
    int side = 2;
    //private Detector sleeveReader; 
    //private Lift coneLift;

    public void runOpMode() throws InterruptedException { 
        robot = new Drivetrain(hardwareMap);
        claw = new Claw(hardwareMap);
        wrist = new Wrist(hardwareMap);
        arm = new Arm(hardwareMap);
        //coneLift = new Lift(hardwareMap);
        
        robot.setAuto();
        
        waitForStart();
        
       // int redVal = robot.colorSensor.red();
        
        double flPower, blPower, frPower, brPower;
        double startAngle = getIntegratedHeading();
       
        if (opModeIsActive()) {
            int time = 0;
            //double startAngle = getIntegratedHeading();
            
            robot.moveForward(-60, 0.5);
            
            if (robot.lDistance.getDistance(DistanceUnit.CM) < 20.0 || robot.rDistance.getDistance(DistanceUnit.CM) < 20.0)
            {
                robot.resetMotors();
                while(robot.colorSensor.red()<65)
                {
                  robot.move(-.5,-.5,-.5,-.5);
                }
                robot.move(0,0,0,0);
                robot.moveForward(7, 0.5);
                sleep(1000);
                robot.drop_pixel();
                sleep(1500);
                robot.setAuto();
                robot.moveForward(53, 0.5);
                robot.resetMotors();
                
                while (getIntegratedHeading() > startAngle - 88) {
                    double power = Math.abs((startAngle - 88 + getIntegratedHeading())/100);
                    if (power < -1.0) power = -1.0;
                    else if (power > -0.4) power = -0.4;
                    robot.rotate(false, true,power );
                 }
                 
                robot.setAuto();
                robot.resetMotors();
                while (robot.lDistance.getDistance(DistanceUnit.CM) > 12.0 || robot.rDistance.getDistance(DistanceUnit.CM) > 12.0)
                     {
                         robot.move(-.7, -.7, -.7, -.7);
                     }
                     robot.move(0.0, 0.0, 0.0, 0.0);
                     
            }
            
            else
            {
                robot.resetMotors();
                while (getIntegratedHeading() > startAngle - 88) {
                    double power = Math.abs((startAngle - 88 + getIntegratedHeading())/100);
                    if (power < -1.0) power = -1.0;
                    else if (power > -0.4) power = -0.4;
                    robot.rotate(false, true,power );
                 }
                robot.resetMotors();
                robot.setAuto();
                robot.moveRight(15, 0.5);
                if (robot.lDistance.getDistance(DistanceUnit.CM) < 10.0 || robot.rDistance.getDistance(DistanceUnit.CM) < 10.0)
                {
                    robot.setAuto();
                    robot.moveRight(-10, 0.5);
                    robot.resetMotors();
                    while(robot.colorSensor.red()<65)
                    {
                      robot.move(-.5,-.5,-.5,-.5);
                    }
                    robot.move(0,0,0,0);
                    robot.moveForward(5, 0.5);
                    sleep(1000);
                    robot.drop_pixel();
                    sleep(1500);
                    robot.setAuto();
                    
                    robot.moveForward(15, 0.5);
                    robot.moveRight(-33, 0.5);
                    robot.moveForward(-30, 0.5);
                    //robot.moveRight(30, 0.5);
                    
                    robot.resetMotors();
                    while (robot.lDistance.getDistance(DistanceUnit.CM) > 12.0 || robot.rDistance.getDistance(DistanceUnit.CM) > 12.0)
                     {
                         robot.move(-.7, -.7, -.7, -.7);
                     }
                     robot.move(0.0, 0.0, 0.0, 0.0);
                    
                    
                }
                
                else
                
                {
                    robot.moveRight(-15, 0.5);
                    robot.resetMotors();
                    
                    while(robot.colorSensor.red()<65)
                    {
                      robot.move(.5,.5,.5,.5);
                    }
                    robot.move(0,0,0,0);
                    robot.setAuto();
                    robot.moveForward(-5, 0.5);
                    sleep(1000);
                    robot.drop_pixel();
                    sleep(1500);

                    robot.setAuto();
                    robot.resetMotors();
                    
                    while (robot.lDistance.getDistance(DistanceUnit.CM) > 12.0 || robot.rDistance.getDistance(DistanceUnit.CM) > 12.0)
                     {
                         robot.move(-.7, -.7, -.7, -.7);
                     }
                     robot.move(0.0, 0.0, 0.0, 0.0);
                     robot.setAuto();
                     robot.moveRight(5, 0.5);
                    
                }
                
                 
                
            
                /*
                robot.resetMotors();
                while(robot.colorSensor.red()<55)
                {
                  robot.move(-.5,-.5,-.5,-.5);
                }
                robot.move(0,0,0,0);
                robot.moveForward(5, 0.5);
                sleep(1000);
                robot.drop_pixel();
                sleep(2000);
                robot.setAuto();
                robot.moveForward(30, 0.5);
                robot.resetMotors();
                */
                
            }
            
            
            //Drop Arm and drop pixel
            /*
            while(time < 1){
                arm.armMoveIn(false, true);
                time++;
            }
            while(time > 1){
                arm.armMove(false, false);
                arm.armStop();
            }
            */
            claw.closeClaw();
            arm.armMoveIn(false, true);
            
            
            sleep(2000);
            arm.armStop();
            sleep(400);
            wrist.wristOut();
            
            sleep(500);
            
            claw.openClaw();
            
            sleep(500);
            robot.moveForward(10, 0.5);
            sleep(500);
            wrist.wristIn();
            
            arm.armMoveIn(true, false);
        
            sleep(2000);
            arm.armStop();
            
            sleep(500);
            /*sleep(2300);
            wrist.wristOut();
            arm.armStop();
            sleep(1000);
            
            claw.openClaw();
            
            sleep(2000);
            wrist.wristIn();
            
            time = 0;
            while(time < 3){
                arm.armMoveIn(true, false);
                time++;
            }
            while(time > 3){
                arm.armMove(false, false);
            }
            
            robot.moveForward(-10, 0.5);
            robot.moveRight(30, 0.5);
            */
            
            
    }
    }
    private double getIntegratedHeading() {
       return robot.imu.getAngularOrientation().firstAngle;
    } 
    }
    


    
    