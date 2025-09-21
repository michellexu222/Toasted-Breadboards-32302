package org.firstinspires.ftc.teamcode;
/**
 * Created by 23spatel on 5/26/22.
 */

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name="Driver", group="Drive")
public class Driver extends LinearOpMode {

    private double y, x, botHeading, rotX, rotY, denominator;
    private double frontLeftPower, backRightPower, frontRightPower, backLeftPower;
    private double clawPos;
    private Drivetrain robot;
    private BNO055IMU imu;
    private Claw claw; 
    private Wrist wrist;
    private Arm arm;
    private BNO055IMU.Parameters parameters;
    
    @Override
    public void runOpMode(){
        //Initialize the hardware variables.
 
        robot = new Drivetrain(hardwareMap);
        claw = new Claw(hardwareMap);
        wrist = new Wrist(hardwareMap);
        arm = new Arm(hardwareMap);
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu.initialize(parameters);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("MSG", "Robot init");
        telemetry.update();
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            robot.drive(
              robot, claw, wrist, arm, gamepad2.a, gamepad2.b, gamepad2.x, gamepad2.y, gamepad2.left_trigger, gamepad2.right_trigger, gamepad2.left_stick_y, 
              gamepad2.left_stick_x, gamepad2.right_stick_x, gamepad2.dpad_right, gamepad2.dpad_left, gamepad2.right_bumper,
              gamepad2.left_bumper, gamepad1.a, gamepad1.b, gamepad1.y,  gamepad1.x,
              gamepad1.left_bumper, gamepad1.right_bumper, gamepad1.dpad_up, gamepad1.dpad_down, gamepad2.dpad_up, gamepad2.dpad_down,imu
            );
            sleep(10);
            telemetry.addData("Wrist", gamepad2.b);
            telemetry.addData("Arm", gamepad2.right_bumper);
            telemetry.addData("left Distance", robot.lDistance.getDistance(DistanceUnit.CM));
            telemetry.update();
        }
    }
}