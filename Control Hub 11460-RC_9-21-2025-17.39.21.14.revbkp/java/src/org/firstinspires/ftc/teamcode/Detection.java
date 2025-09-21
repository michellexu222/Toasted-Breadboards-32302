/*
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="detect", group="detection")
public class Detection extends LinearOpMode {
    OpenCvWebcam camera;
    @Override
     public void runOpMode(){
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = new OpenCvWebcam(new WebcamName("Webcam 1"), new RedDetector());
        
       waitForStart();

        // run until the end of the match (driver presses STOP)
       while (opModeIsActive()) {
            camera.openCameraDevice();
            camera.setPipeline(new RedDetector());
            camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
           sleep(100);
         }
        
    }
}
*/
// }