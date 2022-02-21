// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Set;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.StopShooter;

public class Shooter extends SubsystemBase implements Command {
  //Shooter Motors
  private final CANSparkMax m_leftMotor = new CANSparkMax(Constants.kShooterMotors[0], MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(Constants.kShooterMotors[1], MotorType.kBrushless);
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
    set(Constants.kShooterSpeed);
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

  @Override
  public Set<Subsystem> getRequirements() {
    // TODO Auto-generated method stub
    return null;
  }
}
