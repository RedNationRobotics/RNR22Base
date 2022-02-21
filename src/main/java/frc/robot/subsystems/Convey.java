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

public class Convey extends SubsystemBase implements Command {
  //Convey Motors
  private final CANSparkMax m_convey = new CANSparkMax(Constants.kConveyMotor[0], MotorType.kBrushless);
  /** Constructor: Creates a new Intake. */
  public Convey() {
    //Sendables go here
    
    // Default Command
    //this.setDefaultCommand(StopConvey(this));
  
   
  }

  // Methods to control Convey  speed
  public void set(double speed){
    m_convey.set(speed);
  }

  public void Convey(){
    set(Constants.kConveySpeed);
  }

  public void stop(){
    m_convey.stopMotor();
  }

  // Methods to control the solenoid


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
