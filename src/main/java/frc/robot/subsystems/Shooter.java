// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  //Shooter Motors
  private final CANSparkMax m_leftMotor = new CANSparkMax(Constants.kShooterMotors[0], MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(Constants.kShooterMotors[1], MotorType.kBrushless);
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.REVPH, 1);
  /** Constructor: Creates a new Shooter. */
  public Shooter() {
    //Sendables go here
    
    // Default Command
    //this.setDefaultCommand(StopShooter(this));
    
    // Invert right
    m_rightMotor.setInverted(true);
   
  }

  // Methods to control shooter speed
  public void set(double speed){
     m_leftMotor.set(speed);
     m_rightMotor.set(speed);
  }

  public void shoot(){
    set(Constants.kShooterSpeed);
  }

  public void stop(){
      m_leftMotor.stopMotor();
      m_rightMotor.stopMotor();
  }

  // Methods to control the solenoid
  public void fire() {
    m_solenoid.set(true);
  }

  public void load() {
    m_solenoid.set(false);
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
