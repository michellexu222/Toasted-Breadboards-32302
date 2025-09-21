package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp

public class TestDrone extends LinearOpMode{

    // todo: write your code here   private Claw claw;
    private Drivetrain robot;
    
    @Override
    public void runOpMode(){
        
        try {
            robot = new Drivetrain(hardwareMap);

        } catch (Exception e) {}
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("A", gamepad1.a);
            if(gamepad1.b){
                robot.launch();
                telemetry.addData("B:", gamepad1.b);
                telemetry.update();
            }
            if (gamepad1.y){
                robot.reload();
            }
            
            if (gamepad1.a) {
                robot.closeHook();
            }
            
            //gamepad1.a , etc, return a boolean value

        }
        
    }
}