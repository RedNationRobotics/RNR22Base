// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.lib.controllers.RNRXboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.HighGear;
import frc.robot.commands.LowGear;
import frc.robot.commands.ToggleGear;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shifting;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    //Controllers
    public static final RNRXboxController driverController = new RNRXboxController(0);
    public static final RNRXboxController operatorController = new RNRXboxController(1);

    public static Compressor phcompressor = new Compressor(0, PneumaticsModuleType.REVPH);

  // The robot's subsystems are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static final Drivetrain drivetrain = new Drivetrain();
  public static final Shifting shifting = new Shifting();
  public static final Shooter shooter = new Shooter();

  // The robot's commands are defined here...
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Drive autoCommand = new Drive(drivetrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
   
    // Configure the button bindings method call
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   
    driverController.leftBumper.whenPressed(new LowGear());
    driverController.rightBumper.whenPressed(new HighGear());
    driverController.yButton.whenPressed(new ToggleGear());
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;  //this is the format generated by the template
    return autoCommand;
  }
}
