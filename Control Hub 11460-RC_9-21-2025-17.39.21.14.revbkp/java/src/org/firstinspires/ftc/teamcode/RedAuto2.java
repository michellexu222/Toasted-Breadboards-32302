package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.harware.bosch.BNO055IMU;
import com.qualcomm.robotcore.util.Range;


@Autonomous
//Red side
//Parks Right side
//Pixel at fron
public class RedAuto2 extends LinearOpMode {
    
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
        
        double flPower, blPower, frPower, brPower;
       // double startAngle = getIntegratedHeading();
       
        if (opModeIsActive()) {
            int time = 0;
            double startAngle = getIntegratedHeading();
            claw.closeClaw();
            robot.close_pixel();
            //move than drop pixel
            robot.moveLeft(-25, 0.5);
            robot.moveForward(-50, 1);
          //  robot.drop_pixel();
            sleep(1000);
            //Avacodo at Right Line
            if (robot.lDistance.getDistance(DistanceUnit.CM) < 20.0 || robot.rDistance.getDistance(DistanceUnit.CM) < 20.0)
            {
                telemetry.addData("Avacado: ", "BottomSide");
                telemetry.update();
                side = 3;
                robot.moveLeft(-10, 0.5);

                robot.moveForward(-40, 1);
                robot.moveForward(20, 1);
                sleep(500);
 
                sleep(500);
                //turn and go forward x
                
                robot.resetMotors();
                    while (getIntegratedHeading() > startAngle - 88) {
                        double power = Math.abs((startAngle - 88 + getIntegratedHeading())/100);
                        if (power < -1.0) power = -1.0;
                        else if (power > -0.4) power = -0.4;
                        robot.rotate(false, true,power );
                     }
                 
                robot.setAuto();
                robot.moveForward(-27, 0.5);
                robot.moveLeft(-15, 0.5);
                sleep(1000);
                
                robot.drop_pixel();
                sleep(1000);
                robot.moveForward(-10, 0.5);
                robot.moveRight(-10, 0.5);
                //robot.moveRight(5,0.5);
                robot.moveForward(-125, .7);
                
                robot.resetMotors();
                while (robot.lDistance.getDistance(DistanceUnit.CM) > 11.0 && robot.rDistance.getDistance(DistanceUnit.CM) > 11.0)
                {
                    robot.move(-.7, -.7, -.7, -.7);
                }
            
            robot.move(0, 0, 0, 0);
                
            }
            
            else
            {
                robot.moveRight(-24, 0.5);
                robot.moveForward(-15, 1);
                sleep(250);
                if (robot.lDistance.getDistance(DistanceUnit.CM) < 20.0 || robot.rDistance.getDistance(DistanceUnit.CM) < 20.0)
                {
                    telemetry.addData("Avacado: ", "MiddleSide");
                    side = 2;
                    telemetry.update();
                      //robot.moveLeft(10, 0.5);
                      robot.moveForward(-51, 0.5);

                      //turn and go forward x
                      sleep(1000);
                      robot.drop_pixel();
                      sleep(1000);
                      robot.moveForward(50, 0.5);
                      sleep(2000);
                       robot.resetMotors();
                    while (getIntegratedHeading() > startAngle - 88) {
                        double power = Math.abs((startAngle - 88 + getIntegratedHeading())/100);
                        if (power < -1.0) power = -1.0;
                        else if (power > -0.4) power = -0.4;
                        robot.rotate(false, true,power );
                     }
                    
                    robot.setAuto();
                    robot.moveLeft(-5, 0.5);
                    robot.moveForward(-110, 0.5);
                    robot.resetMotors();
                    while (robot.lDistance.getDistance(DistanceUnit.CM) > 11.0 && robot.rDistance.getDistance(DistanceUnit.CM) > 11.0)
                     {
                         robot.move(-.7, -.7, -.7, -.7);
                     }
                     robot.move(0.0, 0.0, 0.0, 0.0);
                      
                }
                
                
                else
                {
                    telemetry.addData("Avacado: ", "TopSide");
                    telemetry.update();
                    side = 1;
                    robot.resetMotors();
                    while (getIntegratedHeading() > startAngle - 88) {
                        double power = Math.abs((startAngle - 88 + getIntegratedHeading())/100);
                        if (power < -1.0) power = -1.0;
                        else if (power > -0.4) power = -0.4;
                        robot.rotate(false, true,power );
                     }
                    robot.setAuto();
                    robot.moveLeft(-7, 0.5);
                    robot.moveForward(-50, 0.5);
                    sleep(1000);
                    robot.drop_pixel();
                    robot.moveForward(-190, 1);
                    robot.resetMotors();

            {
                robot.resetMotors();
                while (robot.lDistance.getDistance(DistanceUnit.CM) > 11.0 && robot.rDistance.getDistance(DistanceUnit.CM) > 11.0)
                {
                    robot.move(-.7, -.7, -.7, -.7);
                }
            
            robot.move(0, 0, 0, 0);
            robot.moveLeft(5, 0.5);
        
            }
                }
            }
            robot.setAuto();
            if(side == 1){
                robot.moveRight(-20, 0.5);
            }else if(side == 3){
                robot.moveRight(10, 0.5);
            }
            //Drop Arm and drop pixel
            while(time < 6){
                arm.armMoveIn(false, true);
                time++;
            }
            while(time > 6){
                arm.armMove(false, false);
                arm.armStop();
            }
            
            sleep(3000);
            wrist.wristOut();
            sleep(1000);
            
            claw.openClaw();
            
            sleep(2000);
            wrist.wristIn();
            
            time = 0;
            while(time < 16){
                arm.armMoveIn(true, false);
                time++;
            }
            while(time > 16){
                arm.armMove(false, false);
            }
            
            //Park
            robot.moveForward(10, 0.5);
            robot.moveRight(60, 0.5);
            robot.moveForward(-50, 0.5);
            //robot.moveRight(20, 0.5);
    
    
        }  
    
    
    }
    
    private double getIntegratedHeading() {
       return robot.imu.getAngularOrientation().firstAngle;
    }
    

}