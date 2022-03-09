// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tilt;

public class ClimbTilt extends CommandBase {
   /**
   * Creates a new Bolt.
   *
   * @param Tilt The subsystem used by this command.
   */

  private final Tilt m_tilt;
 
   /** Creates a new Tilt */
  public ClimbTilt(Tilt subsystem) {
    m_tilt = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_tilt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_tilt.tilt();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
