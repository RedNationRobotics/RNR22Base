// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.commands.Fire;
import frc.robot.commands.HighShot;
import frc.robot.commands.StopShooter;
import frc.robot.subsystems.Bolt;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class HighShootNScoot extends ParallelCommandGroup {
  /** Creates a new ShootNScoot. 
   * 
   * @param Drivetrain The Drive subsystem this command will run on.
   * @param Shooter The shooter subsystem this command will run on.
   * @param Bolt The Bolt subsystem this command will run on.
   * 
  */
  private final Drivetrain m_drivetrain;
  private final Shooter m_shooter;
  private final Bolt m_bolt;
  private final HighShot m_highShot;
  private final Fire m_fire;
  private final StopShooter m_stopShooter;
  private final DriveForward m_driveForward;
  private final double m_distance;

  public HighShootNScoot(Drivetrain drivetrain, Shooter shooter, Bolt bolt) {
    m_drivetrain = drivetrain;
    m_shooter = shooter;
    m_bolt = bolt;
    m_distance = Constants.kAutoDriveDistanceInches;
    m_highShot = new HighShot(m_shooter);
    m_fire = new Fire(m_bolt);
    m_stopShooter = new StopShooter(m_shooter);
    m_driveForward = new DriveForward(m_drivetrain, m_distance);
    //m_highGoal = new HighGoal(m_shooter, m_bolt);

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // Start shooter
      m_highShot,
      new SequentialCommandGroup(
        // Wait for shooter to spool up
        new WaitCommand(1.0),
        // Fire bolt
        m_fire,
        new WaitCommand(1.0),
        m_driveForward,
        new ScheduleCommand(m_stopShooter)));
  }
}
