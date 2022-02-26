// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tilt extends SubsystemBase {
   
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.kTiltSolenoid);
  /** Constructor: Creates a new Shooter. */
  public Tilt() {
    //Sendables go here
    
    // Default Command
    //this.setDefaultCommand(StopTilt(this));
      
  }

  // Methods to control the solenoid
  public void tilt() {
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
