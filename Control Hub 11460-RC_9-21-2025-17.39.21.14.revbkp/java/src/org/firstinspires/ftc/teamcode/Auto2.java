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


@Autonomous
//Red side
//Parks Left Side
//Pixel at fron
public class Auto2 extends LinearOpMode {
    
    private Drivetrain robot; 
    private Claw claw; 
    private Wrist wrist;
    private Arm arm;
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
       
        if (opModeIsActive()) {
            int time = 0;
            
            //move than drop pixel
            robot.moveForward(87, 1);
            robot.drop_pixel();
            sleep(1000);
            
            //Move to the board
            robot.moveForward(-25, 1);
            robot.turnLeft(97, 0.5);
            robot.moveForward(-115, 1);
            
            sleep(1000);
            
            
            //Drop Arm and drop pixel
            while(time < 16){
                arm.armMoveIn(false, true);
                time++;
            }
            while(time > 16){
                arm.armMove(false, false);
            }
            sleep(2000);
            claw.openClaw();
            
            sleep(2000);
            
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
            robot.moveRight(80, 0.5);
            robot.moveForward(-50, 0.5);
        }
        
    }
}