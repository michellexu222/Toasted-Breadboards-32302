
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

public class Test_IMU extends LinearOpMode{
    
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private BNO055IMU imu;
    private Drivetrain robot; 
    private Claw claw; 
    private Wrist wrist;
    private Arm arm;

     

   @Override
   public void runOpMode() {


       
        // robot = new Drivetrain(hardwareMap);
        // claw = new Claw(hardwareMap);
        // wrist = new Wrist(hardwareMap);
        // arm = new Arm(hardwareMap);
        initializeHardware();
        //coneLift = new Lift(hardwareMap);
        //robot.setAuto();

 
       waitForStart();


       if (opModeIsActive()) {
             int time = 0;
        //     switchMotorsStraight();
            
         
            
            
            
        //     //move than drop pixel
        //     robot.moveForward(88, 1);
        //     robot.drop_pixel();
        //     sleep(1000);
            
        //     //Move to the board
        //     robot.moveForward(-19, 1);
            
        //     switchMotorsTurn();
         
        //////// 
        imuTurn(-90);
        ////////  
        
        //     switchMotorsStraight();
        
        //   robot.moveForward(-240, 1);
            
        //     sleep(1000);
            
            
        //     //Drop Arm and drop pixel
        //     while(time < 16){
        //         arm.armMoveIn(false, true);
        //         time++;
        //     }
        //     while(time > 16){
        //         arm.armMove(false, false);
        //     }
        //     sleep(2000);
        //     claw.openClaw();
            
        //     sleep(2000);
            
        //     time = 0;
        //     while(time < 16){
        //         arm.armMoveIn(true, false);
        //         time++;
        //     }
        //     while(time > 16){
        //         arm.armMove(false, false);
        //     }
            
        //     //Park
        //     robot.moveForward(10, 0.5);
        //     robot.moveRight(-70, 0.5);
        //     robot.moveForward(-50, 0.5);
       }
   }


   private void initializeHardware() {
       frontLeft = hardwareMap.dcMotor.get("frontL");
       frontRight = hardwareMap.dcMotor.get("frontR");
       backLeft = hardwareMap.dcMotor.get("backL");
       backRight = hardwareMap.dcMotor.get("backR");


       frontLeft.setDirection(DcMotor.Direction.FORWARD);
       frontRight.setDirection(DcMotor.Direction.REVERSE);
       backLeft.setDirection(DcMotor.Direction.FORWARD);
       backRight.setDirection(DcMotor.Direction.REVERSE);


       // Initialize IMU
       BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
       parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
       imu = hardwareMap.get(BNO055IMU.class, "imu");
       imu.initialize(parameters);


       telemetry.addData("Status", "Initialized");
       telemetry.update();
   }
   
   private void switchMotorsStraight() {
    frontLeft.setDirection(DcMotor.Direction.FORWARD);
    frontRight.setDirection(DcMotor.Direction.FORWARD);
    backLeft.setDirection(DcMotor.Direction.REVERSE);
    backRight.setDirection(DcMotor.Direction.FORWARD);
   }
   
    private void switchMotorsTurn() {
    frontLeft.setDirection(DcMotor.Direction.FORWARD);
    frontRight.setDirection(DcMotor.Direction.REVERSE);
    backLeft.setDirection(DcMotor.Direction.FORWARD);
    backRight.setDirection(DcMotor.Direction.REVERSE);
   }


   private double getIntegratedHeading() {
       return imu.getAngularOrientation().firstAngle;
   }


   private void setMecanumPower(double forward, double strafe, double rotate) {
       double frontLeftPower = forward + strafe + rotate;
       double frontRightPower = forward - strafe - rotate;
       double backLeftPower = forward - strafe + rotate;
       double backRightPower = forward + strafe - rotate;


       // Normalize wheel speeds
       double max = Math.max(
               Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower)),
               Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))
       );


       if (max > 1.0) {
           frontLeftPower /= max;
           frontRightPower /= max;
           backLeftPower /= max;
           backRightPower /= max;
       }


       frontLeft.setPower(frontLeftPower);
       frontRight.setPower(frontRightPower);
       backLeft.setPower(backLeftPower);
       backRight.setPower(backRightPower);
       
       telemetry.addData("flPower", frontLeftPower);
       telemetry.addData("frPower", frontRightPower);
       telemetry.update();
   }
   
   private void imuTurn(double target){
       double targetAngle = target; // Set your desired target angle here
        double currentAngle = getIntegratedHeading();
            
        while(Math.abs(currentAngle-targetAngle) > 1.0){
           currentAngle = getIntegratedHeading();


           double error = targetAngle - currentAngle;
           double steer = Range.clip(error * 0.03, -1, 1); // adjust the constant for desired turn speed


           setMecanumPower(0, 0, steer);

           telemetry.addData("Target Angle", targetAngle);
           telemetry.addData("Current Angle", currentAngle);
           telemetry.update();
            
        }
   }
}


