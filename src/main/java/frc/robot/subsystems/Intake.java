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

public class Intake extends SubsystemBase {
  //Intake Motors
  private final CANSparkMax m_IntakeMotor = new CANSparkMax(Constants.kIntakeMotor[0], MotorType.kBrushless);
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.kIntakeSolenoid);
  /** Constructor: Creates a new Intake. */
  public Intake() {
    //Sendables go here
    
    // Default Command
    //this.setDefaultCommand(StopIntake(this));
  
  }

  // Methods to control Intake  speed
  public void set(double speed){
     m_IntakeMotor.set(speed);
  }

  public void intake(){
    set(-Constants.kIntakeSpeed);
  }

  public void stop(){
      m_IntakeMotor.stopMotor();
  }

  // Methods to control the solenoid
  public void lower() {
    m_solenoid.set(true);
  }

  public void raise() {
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
