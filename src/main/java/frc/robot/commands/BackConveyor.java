// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;
import edu.wpi.first.wpilibj.Timer;


public class BackConveyor extends CommandBase {
   /**
   * Creates a new RunConveyor.
   *
   * @param Conveyor The subsystem used by this command.
   */

  private final Conveyor m_conveyor;

 
   /** Creates a new RunConveyor. */
  public BackConveyor(Conveyor subsystem) {
    m_conveyor = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_conveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_conveyor.backConveyor();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Timer.delay(0.1);
    m_conveyor.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}

