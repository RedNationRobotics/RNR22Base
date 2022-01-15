// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shifting extends SubsystemBase {
    private Solenoid solenoid = Constants.shiftSolenoid;

    private Compressor c = Constants.compressor;

  /** Constructor: Creates a new Shifting. */
  public Shifting() {
    SendableRegistry.add(solenoid, "Shift");
    
  c.enableDigital();

    //Use this to set a default command for the subsystem
    //this.setDefaultCommand(new LowGear(this)); //commented out along with its import to determine if default command is neccessary
  }

  // Methods to control the shift solenoid
  public void lowGear(){
    solenoid.set(false);
  }

  public void highGear(){
    solenoid.set(true);
  }
  
  public void shift(){
    solenoid.toggle();
  }
  
  //gets solenoid state: true = on, false = off
  public boolean isHighGear(){
    return solenoid.get();
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
