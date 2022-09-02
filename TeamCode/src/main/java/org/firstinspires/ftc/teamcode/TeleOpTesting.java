package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp Test")
public class TeleOpTesting extends CommandOpMode {

    private GamepadEx driverOp;
    private RevIMU imu;
    private DriveSubsystem driveSubsystem;
    private DefaultDriveFieldCentric driveFieldCentric;
    private DefaultDriveRobotCentric driveRobotCentric;
    private Button driveMode;

    private MotorEx lF, lB, rF, rB;

    @Override
    public void initialize() {

        telemetry.addData("lf power", )

        imu.init();
        driverOp = new GamepadEx(gamepad1);

        imu = new RevIMU(hardwareMap);

        driveSubsystem = new DriveSubsystem(new MotorEx(hardwareMap, "leftFront"),
                new MotorEx(hardwareMap, "leftBack"), new MotorEx(hardwareMap, "rightFront"),
                new MotorEx(hardwareMap, "rightBack"));

        driveFieldCentric = new DefaultDriveFieldCentric(driveSubsystem, driverOp::getLeftY,
                driverOp::getLeftX, driverOp::getRightX, imu::getHeading);

        driveRobotCentric = new DefaultDriveRobotCentric(driveSubsystem, driverOp::getLeftY,
                driverOp::getLeftX, driverOp::getRightX);


        driveMode = (new GamepadButton(driverOp, GamepadKeys.Button.A)
                .toggleWhenPressed(driveFieldCentric));

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveRobotCentric);

    }
}
