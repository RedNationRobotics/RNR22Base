// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveForward extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final double m_distance;

  /** Creates a new DriveForward. */
  public DriveForward(Drivetrain drivetrain, double distance) {
    m_drivetrain = drivetrain;
    m_distance = Constants.kAutoDriveDistanceInches;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(Constants.kAutoDriveSpeed, Constants.kAutoRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_drivetrain.getAverageEncoderDistance() > m_distance)
        return true;
    else 
        return false;
    
  }
}
