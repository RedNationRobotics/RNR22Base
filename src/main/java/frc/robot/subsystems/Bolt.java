// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Bolt extends SubsystemBase {
   
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.kBoltSolenoid);
  
  /** Constructor: Creates a new bolt. */
  public Bolt() {
    //Sendables go here
    
    // Default Command
    //this.setDefaultCommand(StopTilt(this));
    
    // Set fire solenoid pulse duration
    m_solenoid.setPulseDuration(Constants.kBoltPulse);
  }

  // Methods to control the solenoid
  public void fire() {
    m_solenoid.startPulse();
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
