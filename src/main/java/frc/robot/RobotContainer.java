// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.swing.text.StyleContext.SmallAttributeSet;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.lib.controllers.RNRXboxController;
import frc.robot.commands.RunConveyor;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunShooter;
import frc.robot.commands.StopConveyor;
import frc.robot.commands.StopIntake;
import frc.robot.commands.StopShooter;
import frc.robot.commands.ToggleCompressor;
import frc.robot.autoCommands.DriveForward;
import frc.robot.commands.ClimbTilt;
import frc.robot.commands.Deploy;
import frc.robot.commands.Drive;
import frc.robot.commands.Fire;
import frc.robot.commands.HighGear;
import frc.robot.commands.LowGear;
import frc.robot.commands.ToggleGear;
import frc.robot.commands.Wench;
import frc.robot.subsystems.Bolt;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.PHub;
import frc.robot.subsystems.Shifting;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tilt;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */ 
@SuppressWarnings("unused")
public class RobotContainer {
  private final PneumaticHub m_ph = new PneumaticHub(Constants.kph_ID);
  //Controllers
  public static final RNRXboxController driverController = new RNRXboxController(0);
  public static final RNRXboxController operatorController = new RNRXboxController(1);

  // The robot's subsystems are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Bolt m_bolt = new Bolt();
  private final Conveyor m_conveyor = new Conveyor();
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Intake m_intake = new Intake();
  private final PHub m_PHub = new PHub();
  private final Shifting m_shifting = new Shifting();
  private final Shooter m_shooter = new Shooter();
  private final Climb m_climb = new Climb();
  private final Tilt m_tilt = new Tilt();

  
    // The robot's commands are defined here...
 
  private final Fire m_fire = new Fire(m_bolt);
  private final HighGear m_highGear = new HighGear(m_shifting);
  private final LowGear m_lowGear = new LowGear(m_shifting);
  private final RunConveyor m_runConveyor = new RunConveyor(m_conveyor);
  private final RunIntake m_runIntake = new RunIntake(m_intake);
  private final RunShooter m_runShooter = new RunShooter(m_shooter);
  private final StopConveyor m_stopConveyor = new StopConveyor(m_conveyor);
  private final StopIntake m_stopIntake = new StopIntake(m_intake);
  private final StopShooter m_stopShooter = new StopShooter(m_shooter);
  private final ToggleCompressor m_toggleCompressor = new ToggleCompressor(m_PHub);
  private final ToggleGear m_toggleGear = new ToggleGear(m_shifting);
  private final Wench m_wench = new Wench(m_climb);
  private final Deploy m_depoly = new Deploy(m_climb);
  private final ClimbTilt m_climbtilt = new ClimbTilt(m_tilt);
  private final DriveForward m_driveForward = new DriveForward(m_drivetrain, Constants.kAutoDriveDistanceInches);





  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
    private final DriveForward m_autoCommand = new DriveForward(m_drivetrain, Constants.kAutoDriveDistanceInches);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
   
    // Configure the button bindings method call
    configureButtonBindings();
    m_PHub.enable();
    
  }

  public void checkSomething() {
    System.out.println(m_drivetrain.getLeftEncoder() + ", " + m_drivetrain.getRightEncoder()); //use this to print to console for debug
  }

  public void pneumaticStats() {
    SmartDashboard.putNumber("Pressure 0", m_ph.getPressure(0));
    SmartDashboard.putBoolean("Comp", m_ph.getCompressor());
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Method for binding COMMANDS to triggers
    driverController.leftBumper.whenPressed(m_lowGear);
    driverController.rightBumper.whenPressed(m_highGear);
    driverController.yButton.whenPressed(m_toggleGear);
    driverController.bButton.whileHeld(m_climbtilt);
    driverController.xButton.whenHeld(m_depoly);
    driverController.aButton.whileHeld(m_wench);
    driverController.selectButton.whenPressed(m_toggleCompressor);



    operatorController.aButton.whenHeld(m_runShooter);
    operatorController.bButton.whenHeld(m_runIntake);
    operatorController.xButton.whileHeld(m_runConveyor);
    operatorController.rightBumper.whileHeld(m_fire);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;  //this is the format generated by the template
    return m_autoCommand;
  }
}
