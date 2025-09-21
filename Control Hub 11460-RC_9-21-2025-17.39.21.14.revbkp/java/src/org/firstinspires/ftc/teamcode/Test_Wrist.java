package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="testwrist", group="wrist")
public class Test_Wrist extends LinearOpMode{
    private Wrist wrist;
    
    @Override
    public void runOpMode(){
        try {
            wrist = new Wrist(hardwareMap);
        } catch (Exception e) {}
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("B", gamepad1.b);

            //gamepad1.a , etc, return a boolean value
            telemetry.addData("wrist", wrist.setWristPos(gamepad1.b));
            telemetry.update();
        }
        
}
        
    }