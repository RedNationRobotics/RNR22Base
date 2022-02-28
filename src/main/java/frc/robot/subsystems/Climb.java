// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
  //Shooter Motors
  private final CANSparkMax m_leftMotor = new CANSparkMax(Constants.kClimbMotors[0], MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(Constants.kClimbMotors[1], MotorType.kBrushless);
    /** Constructor: Creates a new Shooter. */
  public Climb() {
    //Sendables go here
    
    // Default Command
    //this.setDefaultCommand(new StopClimb(this));
    
    //Invert right
    m_rightMotor.setInverted(true);
  
  }

  // Methods to control shooter speed
  public void set(double speed){
     m_leftMotor.set(speed);
     m_rightMotor.set(speed);
  }

  public void wench(){
    m_leftMotor.set(Constants.kWenchSpeed);
    m_rightMotor.set(Constants.kWenchSpeed);
  }

  public void deploy(){
    m_leftMotor.set(-Constants.kDeploySpeed);
    m_rightMotor.set(-Constants.kDeploySpeed);
  }


  public void stop(){
      m_leftMotor.stopMotor();
      m_rightMotor.stopMotor();
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
