// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Drive;

public class Drivetrain extends SubsystemBase {
    private DifferentialDrive drive = Constants.drivetrain;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    SendableRegistry.add(drive, "Drive");
    //Use this to set a default command for the subsystem
    this.setDefaultCommand(new Drive(this));
  }

  // Drive actions
  public void arcadeDrive(double speed, double rotation){
      drive.arcadeDrive(-speed, -rotation); //rotation sign changed to accomodate functional front of bot
  }

  public void stop(){
      drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
