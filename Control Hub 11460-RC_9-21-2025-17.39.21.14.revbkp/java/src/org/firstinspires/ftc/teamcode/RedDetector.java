package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;

public class RedDetector extends OpenCvPipeline {
    public RedDetector() {
        
    }
    
    @Override
    public Mat processFrame(Mat input) {
        // Convert the frame to HSV color space
        Mat hsv = new Mat();
        Imgproc.cvtColor(input, hsv, Imgproc.COLOR_RGB2HSV);

        // Define the range for red color in HSV
        Scalar lowerRed = new Scalar(0, 100, 100);
        Scalar upperRed = new Scalar(10, 255, 255);

        // Threshold the HSV image to get only red regions
        Mat mask = new Mat();
        Core.inRange(hsv, lowerRed, upperRed, mask);

        // Return the processed frame with detected red objects
        return mask;
    }
}