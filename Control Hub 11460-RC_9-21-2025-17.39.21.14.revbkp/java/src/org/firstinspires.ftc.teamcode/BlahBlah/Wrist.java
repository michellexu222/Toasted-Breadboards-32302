// package org.firstinspires.ftc.teamcode.BlahBlah;

// import com.qualcomm.robotcore.hardware.HardwareMap;
// import com.qualcomm.robotcore.hardware.Servo;


// public class Wrist {

//     // todo: write your code here
    
//     private HardwareMap hwMap;
    
//     private double wristPos;
    
//     public Servo wrist;
    
//     private boolean state;
//     private boolean lastPressed = false;
    
//     public Wrist(HardwareMap hwMap) {
//         init(hwMap);
//     }
    
//     private void init(HardwareMap hwMap) {
//         initHardwareMap(hwMap);
//         hwMap.logDevices();
//     }
    
//     private void initHardwareMap(HardwareMap hwMap) {
//         try {
//             this.hwMap = hwMap;
//             wrist = hwMap.servo.get("Wrist");
//         } catch (Exception e) {}
//     }
    
    
//     public double setWristPos(boolean buttonPressed){
//       if (buttonPressed) state = !state;
//       if (state){
//              wristPos = 0.0;
//         }
//       else{
//           wristPos = 1.0;
//         }
//         wrist.setPosition(wristPos);
//         return wristPos;
//     }
    
//     public void wristOut(){
//         wrist.setPosition(0.0);
        
//     }
    
//     public void wristIn(){
//         wrist.setPosition(1.0);
        
//     }
    
//     public void setWristPosin(boolean buttonPressed){
//         if(buttonPressed == false && lastPressed == true){
//             state = !state;
//         }
//         lastPressed = buttonPressed;
//       //if (buttonPressed) state = !state;
//       if (state){
//              wristPos = 0.1;
//         }
//       else{
//           wristPos = 1.0;
//         }
//         wrist.setPosition(wristPos);
        
//     }
// }
