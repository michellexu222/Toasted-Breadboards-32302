// package org.firstinspires.ftc.teamcode;

// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.hardware.DcMotor;

// import org.firstinspires.ftc.robotcore.external.navigation.Position;
// import com.qualcomm.robotcore.hardware.DcMotorSimple;

// public class Arm {

//     // todo: write your code here
    
    
//     private HardwareMap hwMap;
    
//     public DcMotor arm1;
//     public DcMotor arm2;
    
    
//     boolean moving = false;
//     public double armPos;
//     boolean down = false;
//     int initialPos;
//     private double clicksPerCm = 16;
//     private int power = 0;
    
//     public Arm(HardwareMap hwMap) {
//         init(hwMap);
//     }
    
//     private void init(HardwareMap hwMap) {
//         initHardwareMap(hwMap);
//         hwMap.logDevices();
        
//     }
    
//     private void initHardwareMap(HardwareMap hwMap) {
//         this.hwMap = hwMap;
//         arm1 = hwMap.dcMotor.get("Lift1");
//         arm2 = hwMap.dcMotor.get("Lift2");
//     }
    
//     public void armStop(){
//         arm1.setPower(0);
//         arm2.setPower(0);
//         arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//         arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//     }
    
//     public void armMoveDist(int dist, double speed){
//         int arm1Pos = arm1.getCurrentPosition();
//         int arm2Pos = arm2.getCurrentPosition();
        
//         initialPos = arm1Pos;

//         // calculate new targets
//         arm1Pos += dist * clicksPerCm;
//         arm2Pos += dist * clicksPerCm;
        
        
//         execute(arm1Pos, speed);
//     }

 
//     public double armMove(boolean buttonUp, boolean buttonDown){
//         if (!(buttonUp || buttonDown)){
//             arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//             arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//             power = 0;
//         }
//         if(buttonUp) power++;
//         if(buttonDown) power--;
        
//         arm1.setPower(-power);
//         arm2.setPower(power);
        
//         return power;
//     }
    
    
//     public void armMoveIn(boolean buttonUp, boolean buttonDown){
//         double power = 0;
        
//         //if(buttonUp) power ++;
//       // if(buttonDown) power --;
        
//       // arm1.setPower(power);
//       //  arm2.setPower(power);
        
//         if(buttonUp) power += .5;
//         if(buttonDown) power -= .5;
        
//         arm1.setPower(-power);
//         arm2.setPower(power);
        
//         // if(power == 0){
//         //     arm1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//         //     arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//         // }
        
        
//     }
    
//     public void moveUp(int pos, double speed){
//         arm1.setTargetPosition(pos);
//         arm2.setTargetPosition(pos);
        
//         arm1.setPower(-speed);
//         arm2.setPower(speed);
        
//         while(arm1.isBusy() && arm2.isBusy()){
            
//         }
        
//         arm1.setPower(0);
//         arm2.setPower(0);
//     }

// /*
//     public void armMove(int distance, double speed) {
//         int pos = arm1.getCurrentPosition();
//         pos += distance * clicksPerCm;
//         execute(pos, speed);
//     }
// */
//     public void execute(int pos, double speed){
//         // move robot to new position
//         arm1.setTargetPosition(pos);
//         arm2.setTargetPosition(pos);
//         move(speed);

//         // wait for move to complete
//         while (arm1.isBusy() && arm2.isBusy()) {
//             //if (brPos > 0.5*initialPos){
//                 // speed /= 2;
//                 // move(speed);
//                 // initialPos = arm1.getCurrentPosition();
//             //}
//         }

//         // Stop all motion;
//         move(0);
//     } 
    
//     public void move(double power){ //temp public
//         arm1.setPower(power);
//         arm2.setPower(-power);
        
//     }

// } 
    
    
