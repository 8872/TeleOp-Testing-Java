package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class DefaultDriveRobotCentric extends CommandBase {

    private final DriveSubsystem drive;

    private final DoubleSupplier forward, strafe, rotation;

    public DefaultDriveRobotCentric(DriveSubsystem drive, DoubleSupplier forward, DoubleSupplier strafe,
                                    DoubleSupplier rotation){
        this.drive = drive;
        this.forward = forward;
        this.strafe = strafe;
        this.rotation = rotation;
        addRequirements(drive);
    }

    @Override
    public void execute(){
        drive.driveRobotCentric(strafe.getAsDouble(), forward.getAsDouble(), rotation.getAsDouble());
    }
}
