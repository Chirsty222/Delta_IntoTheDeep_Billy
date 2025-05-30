package org.firstinspires.ftc.teamcode.common.hardware;

import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;


public class RobotHardware {
/* Declare OpMode members. */
HardwareMap hwMap =  null;

    // Define Motor and Servo objects  (Make them private so they can't be accessed externally)
    public DcMotor motorfl = null;
    public DcMotor motorfr = null;
    public DcMotor motorbr = null;

    public DcMotor motorbl = null;

//  public DcMotor liftHex = null;

//  public DcMotor liftArm = null;

//  public DcMotor launcher = null;

    //public DcMotor linearSlider = null;


    //public DistanceSensor distanceR = null;
    //public DistanceSensor distanceL = null;


// public Servo tiltServoRight = null;
//  public Servo grabServoRight = null;

// public Servo tiltServoLeft = null;
// public Servo grabServoLeft = null;


    //public Servo airplaneLauncher = null;

    public IMU imu;

    // Initial robot orientation
    public YawPitchRollAngles orientation0;
    public AngularVelocity angularVelocity0;
    public double yaw0;

    // Define a constructor that allows the OpMode to pass a reference to itself.
    public RobotHardware() {}

    /**
     * Initialize all the robot's hardware.
     * This method must be called ONCE when the OpMode is initialized.
     *
     * All of the hardware devices are accessed via the hardware map, and initialized.
     */
    public void init(HardwareMap ahwMap)    {
        // save reference to hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors (note: need to use reference to actual OpMode).
        motorfl = hwMap.get(DcMotor.class, "motorfl");
        motorfr = hwMap.get(DcMotor.class, "motorfr");
        motorbl = hwMap.get(DcMotor.class, "motorbl");
        motorbr = hwMap.get(DcMotor.class, "motorbr");
        //launcher = hwMap.get(DcMotor.class, "launcher");

      //  liftHex = hwMap.get(DcMotor.class, "liftHex");
      //  liftArm = hwMap.get(DcMotor.class, "liftArm");

        // set Brake zero power behavior
        motorfr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorfl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorfr.setDirection(DcMotor.Direction.REVERSE);
        motorbr.setDirection(DcMotor.Direction.REVERSE);
        motorbl.setDirection(DcMotor.Direction.REVERSE);

        //motorbr.setDirection(DcMotor.Direction.REVERSE);


        // Define and initialize ALL installed servos.

        //airplaneLauncher = hwMap.get(Servo.class, "feeder");
        //tiltServoRight = hwMap.get(Servo.class, "tiltServoR");
        //grabServoRight = hwMap.get(Servo.class, "grabServoR");
       // tiltServoLeft = hwMap.get(Servo.class, "tiltServoL");
      // grabServoLeft = hwMap.get(Servo.class, "grabServoL");
        //autoPixel.setPosition(0.5);
        //boardPixel.setPosition(0);
        //grabServo.setPosition(0.4);

        // Get distance sensors
        //distanceR = hwMap.get(DistanceSensor.class, "distanceR");
        //distanceL = hwMap.get(DistanceSensor.class, "distanceL");

        // Set airplane launcher default servo position
        //airplaneLauncher.setPosition(0);

        // reverse motor directions
        //motorbl.setDirection(DcMotor.Direction.REVERSE);
        //motorfl.setDirection(DcMotorSimple.Direction.REVERSE);

        // If there are encoders connected, switch to RUN_USING_ENCODER mode for greater accuracy
        setDrivetrainMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        // Initialize IMU in the control hub
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu = hwMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(orientationOnRobot));
        imu.resetYaw();

        // Retrieve the very initial Rotational Angles and Velocities
        orientation0 = imu.getRobotYawPitchRollAngles();
        angularVelocity0 = imu.getRobotAngularVelocity(AngleUnit.DEGREES);
        yaw0 = orientation0.getYaw(AngleUnit.DEGREES);
    }

    public void setAutoDriveMotorMode() {
        motorfr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorfl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorbr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorbl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorfr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorfl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorbr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorbl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorfr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorfl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorbl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public double getCurrentYaw() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public void setDrivetrainMode(DcMotor.RunMode mode) {
        motorfl.setMode(mode);
        motorfr.setMode(mode);
        motorbl.setMode(mode);
        motorbr.setMode(mode);
    }
    public void setArmsMode(DcMotor.RunMode mode) {
        //linearSlider.setMode(mode);
    }
    public void setDriveForward(double fl, double fr, double bl, double br){
        if (fl > 1.0)
            fl = 1.0;
        else if (fl < -1.0)
            fl = -1.0;

        if (fr > 1.0)
            fr = 1.0;
        else if (fr < -1.0)
            fr = -1.0;

        if (bl > 1.0)
            bl = 1.0;
        else if (bl < -1.0)
            bl = -1.0;

        if (br > 1.0)
            br = 1.0;
        else if (br < -1.0)
            br = -1.0;

        motorfl.setPower((-1) * fl);
        motorfr.setPower(fr);
        motorbl.setPower(bl);
        motorbr.setPower(br);
    }


    public void setDrivePower(double fl, double fr, double bl, double br) {
        if (fl > 1.0)
            fl = 1.0;
        else if (fl < -1.0)
            fl = -1.0;

        if (fr > 1.0)
            fr = 1.0;
        else if (fr < -1.0)
            fr = -1.0;

        if (bl > 1.0)
            bl = 1.0;
        else if (bl < -1.0)
            bl = -1.0;

        if (br > 1.0)
            br = 1.0;
        else if (br < -1.0)
            br = -1.0;

        motorfl.setPower(fl);
        motorfr.setPower(fr);
        motorbl.setPower(bl);
        motorbr.setPower(br);
    }

    public void setAllDrivePower(double p){ setDrivePower(p,p,p,p);}
// public void setArmPower(double armPower){
//   linearSlider.setPower(armPower);
//}






}
/*
port 1 motorfl
port 2 motorbl
port 3 motorap
extension hub port 0 motorfr
extension hub port 1 motorbr
extension hub port 2 liftArm
extension hub port 3 liftHex

Servos
port 0 boardPixel
port 1 grabServo
port 2 tiltServo

extension hub port 0 autoPixel
extension hub port 1 feeder


//Controls//
Gamepad 1:

     */



