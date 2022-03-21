// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.StopShooter;

public class Shooter extends SubsystemBase {
  //Shooter Motors
  private final CANSparkMax m_leftMotor = new CANSparkMax(Constants.kShooterMotors[0], MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(Constants.kShooterMotors[1], MotorType.kBrushless);

  // Left side encoder
  private RelativeEncoder m_leftEncoder = m_leftMotor.getEncoder();
  
  // Right side encoder
  private RelativeEncoder m_rightEncoder = m_rightMotor.getEncoder();

  /** Constructor: Creates a new Shooter. */

  public Shooter() {
    //Sendables go here
    
    // Default Command
    this.setDefaultCommand(new StopShooter(this));
    
    // Invert right
    m_rightMotor.setInverted(true);
  
  }

  // Methods to control shooter speed
  public void set(double speed){
     m_leftMotor.set(speed);
     m_rightMotor.set(speed);
  }

  public void shoot(){
    m_leftMotor.set(-Constants.kShooterSpeed);
    m_rightMotor.set(-Constants.kShooterSpeed);
  }

  public void stop(){
      m_leftMotor.stopMotor();
      m_rightMotor.stopMotor();
  }

  /**
   * Gets the average distance of the TWO encoders.
   *
   * @return the average of the TWO encoder readings
   */
  public double getAverageEncoderVelocity() {
    return (getLeftEncoder() + getRightEncoder()) / 2.0;
  }

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
  public double getLeftEncoder() {
    return m_leftEncoder.getVelocity();
  }

  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
  public double getRightEncoder() {
    return m_rightEncoder.getVelocity();
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
