package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;

import java.util.function.DoubleSupplier;

public class DefaultDriveFieldCentric extends CommandBase {

    private final DriveSubsystem drive;

    private final DoubleSupplier forward, strafe, rotation, angle;

    public DefaultDriveFieldCentric(DriveSubsystem drive, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier rotation,
                                    DoubleSupplier angle) {
        this.drive = drive;
        this.forward = forward;
        this.strafe = strafe;
        this.rotation = rotation;
        this.angle = angle;
        addRequirements(drive);
    }

    @Override
    public void execute(){
        drive.driveFieldCentric(strafe.getAsDouble(), forward.getAsDouble(),
                rotation.getAsDouble(), angle.getAsDouble());
    }


}
