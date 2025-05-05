package org.firstinspires.ftc.teamcode.opmode.OpMode;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.common.hardware.RobotHardware;
//
@TeleOp(name = "OpMode3")

public class OpMode3 extends LinearOpMode {
    public ElapsedTime mRunTime = new ElapsedTime();

    RobotHardware robot = new RobotHardware();

    private int sleepMs1 = 0;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @SuppressLint("DefaultLocale")
    @Override
    public void runOpMode() throws InterruptedException {

        robot.init(hardwareMap);
        boolean intakeToggle = false;

//        robot.liftHex.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        robot.liftHex.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        robot.liftHex.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Put initialization blocks here.
        waitForStart();
        while (opModeIsActive()) {
            double horizontal = -1.0 * gamepad1.right_stick_x * 0.6;
            double vertical = gamepad1.right_stick_y * 0.6;
            double turn = -1.0 * gamepad1.left_stick_x * 0.6;

            double flPower = vertical + turn + horizontal;
            double frPower = vertical - turn - horizontal;
            double blPower = vertical + turn - horizontal;
            double brPower = vertical - turn + horizontal;
            double scaling = Math.max(1.0,
                    Math.max(Math.max(Math.abs(flPower), Math.abs(frPower)),
                            Math.max(Math.abs(blPower), Math.abs(brPower))));
            flPower = flPower / scaling;
            frPower = frPower / scaling;
            blPower = blPower / scaling;
            brPower = brPower / scaling;
            robot.setDrivePower(flPower, frPower, blPower, brPower);

            // robot.setDrivePower(vertical + turn + horizontal, vertical - turn - horizontal, vertical + turn - horizontal, vertical - turn + horizontal);

            telemetry.addLine(String.format("FL: %d \nBL %d \nFR: %d \nBR: %d ",
                    robot.motorfl.getCurrentPosition(),
                    robot.motorbl.getCurrentPosition(),
                    robot.motorfr.getCurrentPosition(),
                    robot.motorbr.getCurrentPosition()
            ));

//test
//make sure one of the directions is correct/reversed


            //lift arm start

            if (gamepad1.y) { //if button y pressed
                robot.linearSlide.setPower(-0.8);
                //tilt the lift to be upright
                sleep(200);
            }
            robot.linearSlide.setPower(-0.1);

            //robot.linearSlide.setPower(0);



            while (gamepad1.a) { //if button a pressed
                // robot.liftHex.setPower(1.0);
                robot.linearSlide.setPower(0.8);
                //tilt the lift to be upright
                sleep(1000);

            }
            robot.linearSlide.setPower(-0.1);



      //      while (gamepad2.a) { //if button a pressed
          //      robot.linearSlide.setPower(0.5);
                //tilt the lift to be upright
       //     }
       //     robot.liftArm.setPower(0);


      //      while (gamepad2.y) {
       //         robot.linearSlide.setPower(1.0);
        //    }
      //      robot.linearSlide.setPower(0);



         //   if(gamepad1.right_trigger > 0.7){
          //  robot.rotator.setPosition(1.0);



            if (gamepad1.left_trigger > 0.5 || gamepad1.dpad_left) {
                robot.rotator.setPosition(0.44); //up

            } else if ( gamepad1.left_bumper || gamepad1.dpad_right) {
                robot.rotator.setPosition(1.0); //down
            }


//tilt servo
            /*
            if (gamepad1.right_bumper) {
                robot.intake.setPosition(0.5);
            } else if (gamepad1.right_trigger > 0.5) {
                if(intakeToggle){
                    robot.intake.setPosition(1.0);
                    intakeToggle = false;
                }else {
                    intakeToggle = true;
                    robot.intake.setPosition(0.0);
                }
            }

             */

            if(gamepad1.dpad_up || gamepad1.right_bumper){
                robot.intake.setPosition(1.0);
            }else if (gamepad1.dpad_down || gamepad1.right_trigger > 0.5){
                robot.intake.setPosition(0.0);
            } else {
                robot.intake.setPosition(0.5);
            }
            robot.intake.setPosition(gamepad1.left_stick_y*0.5+0.5);
            /*
            if((gamepad1.dpad_up || gamepad1.right_bumper) && robot.intake.getPosition() == 1){
                robot.intake.setPosition(0.5);
            }
            if((gamepad1.dpad_down || gamepad1.right_trigger > 0.5) && robot.intake.getPosition() == 0){
                robot.intake.setPosition(0.5);
            }

             */
            /*
//tilt servo #2
            if (gamepad2.left_stick_y > 0.7) {
                robot.tiltServoLeft.setPosition(0.0);

            } else if (gamepad2.left_stick_y < -0.7) {
                robot.tiltServoLeft.setPosition(0.6);
            }


        }


        //emergency releases
    }


    void liftHexArm(int ticks, double power, long timeOutMills) {
        long timeCurrent, timeBegin;
        timeBegin = timeCurrent = System.currentTimeMillis();
        {

        }



     /*

        robot.liftHex.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.liftHex.setTargetPosition(ticks);
        robot.liftHex.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.liftHex.setPower(power);
        while(opModeIsActive()
                && robot.liftHex.isBusy()
                && (timeCurrent - timeBegin) < timeOutMills) {
            timeCurrent = System.currentTimeMillis();






    private void TiltLiftOne ( double crankPowerBegin, int crankTimeMs, double crankPowerEnd,
        double liftPowerBegin, int liftTimeMs, double liftPowerEnd){
            //tilt the lift to be upright
            robot.liftHex.setPower(crankPowerBegin);   //set motor power
            sleep(crankTimeMs);          // let motor run for some time seconds.
            robot.liftHex.setPower(crankPowerEnd);   //set lower motor power to maintain the position

            // Extend liftArm
            robot.liftArm.setPower(liftPowerBegin);
            sleep(liftTimeMs);             // let motor run for some time seconds.
            robot.liftArm.setPower(liftPowerEnd);

        }

        }


             */




    }
}}