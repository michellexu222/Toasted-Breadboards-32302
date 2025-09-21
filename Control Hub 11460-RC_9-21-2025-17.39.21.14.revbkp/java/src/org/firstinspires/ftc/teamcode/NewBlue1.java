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

public class NewBlue1 extends LinearOpMode {
    
    
    private Drivetrain robot; 
    private Claw claw; 
    private Wrist wrist;
    private Arm arm;
    
    
    int side = 3;
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
        
      //  int blueVal = robot.colorSensor.blue();
        
        double flPower, blPower, frPower, brPower;
        double startAngle = getIntegratedHeading();
       
        if (opModeIsActive()) {
            int time = 0;
            //double startAngle = getIntegratedHeading();

            robot.moveForward(-60, 0.5);

            //if (robot.lDistance.getDistance(DistanceUnit.CM) < 20.0 || robot.rDistance.getDistance(DistanceUnit.CM) < 20.0)
            //{
            if (robot.lDistance.getDistance(DistanceUnit.CM) < 20.0)
            {
                
                telemetry.addData("center", 1);
                telemetry.update();
                
                robot.resetMotors();
                while(robot.colorSensor.blue()<115)
                {
                  robot.move(-.5,-.5,-.5,-.5);
                }
                robot.move(0,0,0,0);
                robot.moveForward(5, 0.5);
                sleep(1000);
                robot.drop_pixel();
                sleep(2000);
                robot.close_pixel();
                robot.setAuto();
                robot.moveForward(45, 0.5);
                robot.resetMotors();
                
                while (getIntegratedHeading() < startAngle + 88) {
                    double power = Math.abs((startAngle + 88 - getIntegratedHeading())/100);
                    if (power > 1.0) power = 1.0;
                    else if (power < 0.4) power = 0.4;
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
                telemetry.addData("heading", getIntegratedHeading());
                sleep(2000);
                telemetry.update();
                robot.resetMotors();
                
                while (getIntegratedHeading() < startAngle + 88) {
                    double power = Math.abs((startAngle + 88 - getIntegratedHeading())/100);
                    if (power > 1.0) power = 1.0;
                    else if (power < 0.4) power = 0.4;
                    robot.rotate(false, true,power );
                 }
                 
                robot.resetMotors();
                robot.setAuto();
                robot.moveRight(-20, 0.5);
                if (robot.lDistance.getDistance(DistanceUnit.CM) < 10.0 || robot.rDistance.getDistance(DistanceUnit.CM) < 10.0)
                {
                    side = 1;
                    robot.resetMotors();
                    
                    int blue = robot.colorSensor.blue();
                    
                    telemetry.addData("measureblue", blue);
                    telemetry.update();
                    
                    sleep(500);
                    telemetry.addData("measureblue", robot.colorSensor.blue());
                    telemetry.update();
                    //while(robot.colorSensor.blue()<115)
                    while(robot.colorSensor.blue() < blue + 10)
                    {
                      robot.move(-.5,-.5,-.5,-.5);
                      telemetry.addData("measureblue", robot.colorSensor.blue());
                      telemetry.update();
                    }
                    robot.move(0,0,0,0);
                    robot.setAuto();
                    //robot.moveForward(5, 0.5);
                    sleep(1000);
                    robot.drop_pixel();
                    sleep(2000);
                    //robot.close_pixel();
                    
                    robot.moveForward(15, 0.5);
                    robot.moveRight(45, 0.5);
                    robot.moveForward(-45, 0.5);
                    robot.moveRight(-50, 0.5);
                    robot.moveRight(10, 0.5);
                    //robot.moveRight(-30, 0.5);
                    
                    robot.resetMotors();
                    while (robot.lDistance.getDistance(DistanceUnit.CM) > 12.0 || robot.rDistance.getDistance(DistanceUnit.CM) > 12.0)
                     {
                         robot.move(-.7, -.7, -.7, -.7);
                     }
                     robot.move(0.0, 0.0, 0.0, 0.0);
                    
                    
                }
                
                else
                
                {
                    telemetry.addData("last", 1);
                    telemetry.update();
                    robot.moveRight(17, 0.5);//original 13
                    //robot.resetMotors();
                    
                    /*
                    while(robot.colorSensor.blue()<115)
                    {
                      robot.move(.5,.5,.5,.5);
                    }
                    robot.move(0,0,0,0);
                    */
                    robot.setAuto();
                    robot.moveForward(12, 0.5);
                    robot.moveLeft(10, 0.5);
                    //robot.moveForward(-5, 0.5);
                    sleep(1000);
                    robot.drop_pixel();
                    sleep(2000);
                    robot.close_pixel();

                    robot.setAuto();
                    robot.moveLeft(-7, 0.5);
                    robot.resetMotors();
                    
                    
                    while (robot.lDistance.getDistance(DistanceUnit.CM) > 12.0 || robot.rDistance.getDistance(DistanceUnit.CM) > 12.0)
                     {
                         robot.move(-.7, -.7, -.7, -.7);
                     }
                     robot.move(0.0, 0.0, 0.0, 0.0);
                    
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
            
            robot.setAuto();
            //Drop Arm and drop pixel
            claw.closeClaw();
            arm.armMoveIn(false, true);
            if(side == 3){
                robot.moveRight(-20, 0.5);
            }
            
            sleep(1500);
            arm.armStop();
            sleep(400);
            wrist.wristOut();
            
            sleep(500);
            
            claw.openClaw();
            
            sleep(500);
            robot.moveForward(10, 0.5);
            sleep(500);
            wrist.wristIn();
            
            time = 0;
            arm.armMoveIn(true, false);
            // while(time < 5){
            //     arm.armMoveIn(true, false);
            //     time++;
            // }
            sleep(2000);
            arm.armStop();
            // while(time > 3){
            //     arm.armMove(false, false);
            // }
            sleep(500);
            
            
            robot.moveRight(70, 0.5);
            
            
            
    }
    }
    private double getIntegratedHeading() {
       return robot.imu.getAngularOrientation().firstAngle;
    } 
    }
    


    
    