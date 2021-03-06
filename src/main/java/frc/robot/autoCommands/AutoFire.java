// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Bolt;

public class AutoFire extends CommandBase {
   /**
   * Creates a new Bolt.
   *
   * @param Bolt The subsystem used by this command.
   */

  private final Bolt m_bolt;
 
   /** Creates a new Fire */
  public AutoFire(Bolt subsystem) {
    m_bolt = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_bolt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_bolt.fire();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_bolt.load();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
