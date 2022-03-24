// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Bolt;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LowGoal extends ParallelCommandGroup {
    /** Creates a new HighGoal. 
   * 
   * @param Shooter The shooter subsystem this command will run on.
   * @param Bolt The bolt subsystem this command will run on.
   * 
  */
  private final Shooter m_shooter;
  private final Bolt m_bolt;
  private final Fire m_fire;
  private final StopShooter m_stopShooter;

  public LowGoal(Shooter shooter, Bolt bolt) {
    m_shooter = shooter;
    m_bolt = bolt;
    m_fire = new Fire(m_bolt);
    m_stopShooter = new StopShooter(m_shooter);
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new RunCommand(() -> m_shooter.lowGoal(), m_shooter),
      new SequentialCommandGroup(
        new WaitCommand(0.3),
        new ScheduleCommand(m_fire),
        new WaitCommand(1.0),
        new ScheduleCommand(m_stopShooter)));
  }
}
