// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;



public class HighFire extends CommandBase {
/**
 * 
 * @param Shooter The subsystem used by this command
 * 
 */
  
 private final Shooter m_shooter;
 private final double m_velocity;

  /** Creates a new AutomatedFire. */
  
  public HighFire(Shooter subsystem) {
    m_shooter = subsystem;
    m_velocity = -Constants.kFireVelocity0;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.highGoal(); // hange to set() after PID is tuned
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_shooter.getAvgVelocity() >= m_velocity)  
      m_shooter.fire();
      Timer.delay(0.5);
      m_shooter.load();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.stop();  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
