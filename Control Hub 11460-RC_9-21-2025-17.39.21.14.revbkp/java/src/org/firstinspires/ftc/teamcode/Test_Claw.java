package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="testclaw", group="claw")
public class Test_Claw extends LinearOpMode{
   private Claw claw;
    private Drivetrain robot;
    
    @Override
    public void runOpMode(){
        
        try {
            robot = new Drivetrain(hardwareMap);
            claw = new Claw(hardwareMap);
        } catch (Exception e) {}
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("A", gamepad1.a);
            if(gamepad1.b){
                robot.drop_pixel();
            }
            
            //gamepad1.a , etc, return a boolean value
            telemetry.addData("claw", claw.setClawPos(gamepad1.a));
            telemetry.update();
        }
         
    }
}