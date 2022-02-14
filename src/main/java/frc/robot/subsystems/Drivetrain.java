// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Drive;

public class Drivetrain extends SubsystemBase {
  //Motor Controller Grouups
  public static CANSparkMax leftLead = new CANSparkMax(Constants.kLeftDrive[0], MotorType.kBrushless);
  public static CANSparkMax leftFollow = new CANSparkMax(Constants.kLeftDrive[1], MotorType.kBrushless);
  public static CANSparkMax rightLead = new CANSparkMax(Constants.kRightDrive[0], MotorType.kBrushless);
  public static CANSparkMax rightFollow = new CANSparkMax(Constants.kRightDrive[1], MotorType.kBrushless);
    
                                                                
  public static DifferentialDrive drivetrain = new DifferentialDrive(leftLead, rightLead);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    SendableRegistry.add(drivetrain, "Drive");
    
    //Use this to set a default command for the subsystem
    this.setDefaultCommand(new Drive(this));

    //Invert right
    rightLead.setInverted(true);

    //Setup followers
    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);
    
    
  }

  // Drive actions
  public void arcadeDrive(double speed, double rotation){
      drivetrain.arcadeDrive(-speed, -rotation); //rotation sign changed to accomodate functional front of bot
  }

  public void stop(){
      drivetrain.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
