// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;



public class AutomatedFire extends CommandBase {
/**
 * 
 * @param Shooter The subsystem used by this command
 * 
 */
  
 private final Shooter m_shooter;
 private final double m_velocity;

  /** Creates a new AutomatedFire. */
  
  public AutomatedFire(Shooter subsystem) {
    m_shooter = subsystem;
    m_velocity = -Constants.kFireVelocity;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_shooter.set(); // hange to set() after PID is tuned
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Timer.delay(0.5);
    m_shooter.fire();
    Timer.delay(0.5);
    m_shooter.load();
    m_shooter.stop();  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_shooter.getAvgVelocity() >= m_velocity)
      return true;
    else 
      return false;
  }
}
