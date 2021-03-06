// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shifting;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** LowGear command that uses an Shifting subsystem. */
public class LowGear extends CommandBase {
   /**
   * Creates a new Shift.
   *
   * @param Shifting The subsystem used by this command.
   */
  private final Shifting m_shifting;

  public LowGear(Shifting subsystem) {
     m_shifting = subsystem;
     // Use addRequirements() here to declare subsystem dependencies.
     addRequirements(m_shifting);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shifting.lowGear();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Send joystick commands to the shifting subsystem
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
