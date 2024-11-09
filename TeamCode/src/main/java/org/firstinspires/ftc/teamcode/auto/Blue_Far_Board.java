/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.andyscode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/*
 * This OpMode illustrates the concept of driving a path based on time.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: RobotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backward for 1 Second
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@Autonomous(name=" Auto Drive: Blue Far ", group="Robot")
public class Blue_Far_Board extends AutoCommon {

    @Override
    public void runOpMode() {

        initAll();
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
        grabberTilt.setPosition(0.1);
        // Step 1:  Drive forward for 3 seconds
        String line = detectTeamPropLine("blue far");
        visionPortal.close();
        //line = "left";

        if (line.equals("middle")) {
            //driveToMiddleLine();
            encoderDrive(0.1,  31,  31, 5.0);
            dropPixelOnLine();
            //forward(0.2, 1000);
            encoderDrive(0.2,   -10, -10, 4.0);
            //encoderDrive(1,   -5, 5, 4.0);
            //shiftLeft(0.2, 2000);
            //turn(-0.5, 0.3,1260);
            //turnToTargetYaw(110+yaw0, 0.4, 5000);
            //encoderDrive(0.2,  -5,  -5, 5.0);
            //turnToTargetYaw(90+yaw0, 0.4, 5000);
            //encoderDrive(0.4,  -75,  -75, 5.0);
            //turnToTargetYaw(45+yaw0, 0.4, 5000);
            //encoderDrive(0.4,  -35,  -35, 5.0);
            //turnToTargetYaw(90+yaw0, 0.4, 5000);
            //encoderDrive(0.2,  -30,  -30, 5.0);
            //turnToTargetYaw(-90+yaw0, 0.4, 5000);
            //encoderDrive(0.5,   , -6, 4.0);
            //driveToBackBoardNearSide(2);
            //encoderDrive(0.2,  -50,  -50, 5.0);
            //backward(0.2, 5000);
            //dropPixelOnBoard();
        }
        else if (line.equals("right")) {
            encoderDrive(0.1,  4,  4, 5.0);
            turn(0.8,-0.8, 200);
            //turnToTargetYaw(-15+yaw0, 0.8, 5000);
            encoderDrive(0.1,  18,  18, 5.0);
            dropPixelOnLine();
            encoderDrive(0.1,  -10,  -10, 5.0);
            //driveToLeftLine();
            //backward(0.2, 2500);
            /*
            encoderDrive(0.2,  -4,  -4, 5.0);
            turnToTargetYaw(-18+yaw0, 0.4, 5000);
            encoderDrive(0.2,  -25,  -25, 5.0);
            encoderDrive(0.2,  25,  25, 5.0);
            turnToTargetYaw(90+yaw0, 0.4, 5000);

            encoderDrive(0.4,  -75,  -75, 5.0);
            turnToTargetYaw(45+yaw0, 0.4, 5000);
            encoderDrive(0.4,  -45,  -45, 5.0);
            turnToTargetYaw(90+yaw0, 0.4, 5000);
            encoderDrive(0.2,  -30,  -30, 5.0);

             */
            //encoderDrive(0.2,  -48,  -48, 5.0);
            //turnToTargetYaw(yaw0, 0.4, 5000);
            //encoderDrive(0.2,  -25,  -25, 5.0);
            //turnToTargetYaw(50+yaw0, 0.4, 5000);
            //turn(-0.2, 0.2,800);
            //encoderDrive(0.2,  -10,  -10, 5.0);
            //sleep(100);
            //encoderDrive(0.2,  13,  13, 5.0);
            //turnToTargetYaw(90+yaw0, 0.4, 5000);
            //dropPixelOnLine();
            //forward(0.2, 800);
            //turn(-0.5, 0.3, 1000);
            //driveToBackBoardNearSide(1);
            //backward(0.2, 4500);
            //encoderDrive(0.2,  -48,-48, 5.0);
            //dropPixelOnBoard();
        }
        else {
            encoderDrive(0.1,  20,  20, 5.0);
            //turn(0.1, -0.5,1000);
            turn(-0.8,0.8,600);
            encoderDrive(0.1,  8,  8, 5.0);
            dropPixelOnLine();

            //turnToTargetYaw(-40+yaw0, 0.8, 5000);
            encoderDrive(0.1,  -17,  -17, 5.0);
            //driveToRightLine();
            //encoderDrive(0.3,  -16,  -16, 5.0);
            //turn(0.1, -0.5,1000);
            //turnToTargetYaw(40+yaw0, 0.4, 5000);
            //encoderDrive(0.3,  -21,  -21, 5.0);
            /*
            encoderDrive(0.3,  -4,  -4, 5.0);
            turnToTargetYaw(15+yaw0, 0.4, 5000);
            encoderDrive(0.3,  -12,  -12, 5.0);
            turnToTargetYaw(45+yaw0, 0.4, 5000);
            encoderDrive(0.3,  -12,  -12, 5.0);
            */

            //turn(0.1, -0.5,1000);
            //turnToTargetYaw(45+yaw0, 0.4, 5000);
            //encoderDrive(0.3,  -20,  -20, 5.0);
            //sleep(100);
            //encoderDrive(0.3,  37,  37, 5.0);
            //sleep(100);
            //turnToTargetYaw(90+yaw0, 0.4, 5000);
            //sleep(100);
            //encoderDrive(0.3,  -28,  -28, 5.0);
            //sleep(100);
            //turnToTargetYaw(-90+yaw0, 0.4, 5000);
            //dropPixelOnLine();
            //forward(0.2, 2500);
            //turn(-0.4, 0.1, 2200);
            //driveToBackBoardNearSide(3);
            //backward(0.2, 4500);
            //encoderDrive(0.2,  -38,  -38, 5.0);
            //encoderDrive(0.4,  -85,  -85, 5.0);
            //turnToTargetYaw(45+yaw0, 0.4, 5000);
            //encoderDrive(0.4,  -30,  -30, 5.0);
            //turnToTargetYaw(90+yaw0, 0.4, 5000);
            //encoderDrive(0.2,  -30,  -30, 5.0);
            //dropPixelOnBoard();
        }

        visionPortal.close();
    }
}
