// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.LowGear;


public class Shifting extends SubsystemBase {
  public static Solenoid solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.kShiftSolenoid);  //Use CTREPCM for old PCM and REVPH for new pneumatics hub  

  private Compressor c = RobotContainer.phcompressor; //up for deletion

  /** Constructor: Creates a new Shifting. */
  public Shifting() {
    SendableRegistry.add(solenoid, "Shift");
    //Use this to set a default command for the subsystem
    this.setDefaultCommand(new LowGear()); //commented out along with its import to determine if default command is neccessary
    
    c.enableDigital(); // up for deletion

  
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
