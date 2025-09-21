// package org.firstinspires.ftc.teamcode.BlahBlah;

// import com.qualcomm.robotcore.hardware.DcMotor;
// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.hardware.Servo;


// public class Claw {

//     // todo: write your code here
    
//     private HardwareMap hwMap;
    
//     private double clawPos;
    
//     public Servo claw;
    
//     private boolean state;
//     private boolean lastPressed = false;
    
//     public Claw(HardwareMap hwMap) {
//         init(hwMap);
//     }
    
//     private void init(HardwareMap hwMap) {
//         initHardwareMap(hwMap);
//         hwMap.logDevices();
//     }
    
//     private void initHardwareMap(HardwareMap hwMap) {
//         try {
//             this.hwMap = hwMap;
//             claw = hwMap.servo.get("Claw");
//         } catch (Exception e) {}
//     }
//     public void openClaw(){
//         claw.setPosition(0);
//     }
    
//     public double setClawPos(boolean buttonPressed){
//       if (buttonPressed) state = !state;
//       if (state){
//              clawPos = 0.0;
//         }
//       else{
//           clawPos = .5;
//         }
//         claw.setPosition(clawPos);
//         return clawPos;
//     }
    
//     public void setClawPosin(boolean buttonPressed){
//         if(buttonPressed == false && lastPressed == true){
//             state = !state;
//         }
//         lastPressed = buttonPressed;
//     //   if (buttonPressed) state = !state;
//       if (state){
//              clawPos = 0.0;
//         }
//       else{
//           clawPos = .7;
//         }
//         claw.setPosition(clawPos);
//         //return clawPos;
//     }
    
    
    
    
    
    

    
    
    
// }
