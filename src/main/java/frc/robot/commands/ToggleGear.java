// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Shift command that uses an Shifting subsystem. */
public class ToggleGear extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    /**
   * Creates a new Shift.
   *
   * @param Shifting The subsystem used by this command.
   */

  public ToggleGear() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.shifting);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.shifting.shift();;
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
