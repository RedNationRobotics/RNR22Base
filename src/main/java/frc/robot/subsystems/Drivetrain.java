// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Drive;

public class Drivetrain extends SubsystemBase {
  /**  Motor Controller Groups 
   * 
   * Need to check functionality as private objects
  */
  private final CANSparkMax m_leftLead = new CANSparkMax(Constants.kLeftDrive[0], MotorType.kBrushless);
  private final CANSparkMax m_leftFollow = new CANSparkMax(Constants.kLeftDrive[1], MotorType.kBrushless);
  private final CANSparkMax m_rightLead = new CANSparkMax(Constants.kRightDrive[0], MotorType.kBrushless);
  private final CANSparkMax m_rightFollow = new CANSparkMax(Constants.kRightDrive[1], MotorType.kBrushless);
    
  // The Robot's Drive                                                              
  private final DifferentialDrive m_drivetrain = new DifferentialDrive(m_leftLead, m_rightLead);

  // Left side encoder
  private RelativeEncoder m_leftEncoder = m_leftLead.getEncoder();
  
  // Right side encoder
  private RelativeEncoder m_rightEncoder = m_rightLead.getEncoder();

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    SendableRegistry.add(m_drivetrain, "Drive");
    
    // Use this to set a default command for the subsystem
    this.setDefaultCommand(new Drive(this));

    // Invert right
    m_leftLead.setInverted(true);
    m_rightLead.setInverted(false);

    //Setup followers
    m_leftFollow.follow(m_leftLead);
    m_rightFollow.follow(m_rightLead);

    // Set the distance per pulse for encoders
    m_leftEncoder.setPositionConversionFactor(Constants.kEncoderDPPLow);
    m_rightEncoder.setPositionConversionFactor(Constants.kEncoderDPPLow);
    
  }

  // Drive actions
  public void arcadeDrive(double speed, double rotation){
      m_drivetrain.arcadeDrive(speed, rotation); //rotation sign changed to accomodate functional front of bot
  }

  public void setMotors(double speed, double rotation){
    m_leftLead.set(speed);
    m_rightLead.set(speed);
  }

  public void stop(){
      m_drivetrain.stopMotor();
  }

  /** Resets the drive encoders to currently read a position of 0. */
  public void resetEncoders() {
    m_leftEncoder.setPosition(0.0);
    m_rightEncoder.setPosition(0.0);
  }

  /**
   * Gets the average distance of the TWO encoders.
   *
   * @return the average of the TWO encoder readings
   */
  public double getAverageEncoderDistance() {
    return (getLeftEncoder() + getRightEncoder()) / 2.0;
  }

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
  public double getLeftEncoder() {
    return -m_leftEncoder.getPosition();
  }

  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
  public double getRightEncoder() {
    return m_rightEncoder.getPosition();
  }

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  /*
  public void setMaxOutput(double maxOutput) {
    m_drivetrain.setMaxOutput(maxOutput);
  }
  */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
