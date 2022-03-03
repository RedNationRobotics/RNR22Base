// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PHub;

public class ToggleCompressor extends CommandBase {
   /**
   * Creates a new PHub.
   *
   * @param PHub The subsystem used by this command.
   */

  private final PHub m_PHub;
 
   /** Creates a new Fire */
  public ToggleCompressor(PHub subsystem) {
    m_PHub = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_PHub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_PHub.toggle();
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
