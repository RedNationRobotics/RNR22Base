// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autoCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootNScoot extends ParallelCommandGroup {
  /** Creates a new ShootNScoot. 
   * 
   * @param Drivetrain The Drive subsystem this command will run on.
   * @param Bolt The Bolt subsystem this command will run on.
   * @param Shooter The shooter subsystem this command will run on.
   * 
  */
  private final Drivetrain m_drivetrain;
  private final Shooter m_shooter;
  private final AutoFire m_fire;
  private final DriveForward m_driveForward;
  private final double m_distance;
  private final AutoStopShooter m_stopShooter;

  public ShootNScoot(Drivetrain drivetrain, Shooter shooter) {
    m_drivetrain = drivetrain;
    m_shooter = shooter;
    m_distance = Constants.kAutoDriveDistanceInches;
    m_fire = new AutoFire(m_shooter);
    m_driveForward = new DriveForward(m_drivetrain, m_distance);
    m_stopShooter = new AutoStopShooter(m_shooter);

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // Start shooter
      new RunCommand(() -> m_shooter.shoot(), m_shooter),
            new SequentialCommandGroup(
              // Wait for shooter to spool up
              new WaitCommand(1.5),
              // Fire bolt
              new ScheduleCommand(m_fire),
              new WaitCommand(0.2),
              new ScheduleCommand(m_driveForward),
              new ScheduleCommand(m_stopShooter)            
            )
    );
  }
}
