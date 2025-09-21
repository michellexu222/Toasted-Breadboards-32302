package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@TeleOp(name="testarm", group="arm")
public class Test_Arm extends LinearOpMode{
    private Arm arm;
    
    @Override
    public void runOpMode(){
        try {
            arm = new Arm(hardwareMap);
        } catch (Exception e) {}
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            telemetry.addData("DPD", gamepad1.dpad_down);
            telemetry.addData("DPU", gamepad1.dpad_up);
            telemetry.addData("Y", gamepad1.y);
            //gamepad1.a , etc, return a boolean value
            //if(gamepad1.DPU || gamepad1.DPD){ // }
            //telemetry.addData("arm", arm.setArmPos(gamepad1.y));
            telemetry.addData("arm", arm.armMove(gamepad1.dpad_down, gamepad1.dpad_up));
            telemetry.update();
        }
        
}
        
    }