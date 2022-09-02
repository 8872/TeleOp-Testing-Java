package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {

    private MecanumDrive drive;

    public DriveSubsystem(MotorEx leftFront, MotorEx leftBack, MotorEx rightFront, MotorEx rightBack) {
        drive = new MecanumDrive(leftFront, rightFront, leftBack, rightBack);
    }

    public DriveSubsystem(HardwareMap hardwareMap, String leftFrontName, String leftBackName,
                          String rightFrontName, String rightBackName) {
        this(new MotorEx(hardwareMap, leftFrontName), new MotorEx(hardwareMap, leftBackName),
                new MotorEx(hardwareMap, rightFrontName), new MotorEx(hardwareMap, rightBackName));
    }

    public void driveFieldCentric(double strafeSpeed, double forwardSpeed, double turnSpeed, double gyroAngle){
        drive.driveFieldCentric(strafeSpeed, forwardSpeed, turnSpeed, gyroAngle);
    }

    public void driveRobotCentric(double strafeSpeed, double forwardSpeed, double turnSpeed){
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, turnSpeed);
    }

}
