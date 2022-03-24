// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.commands.LowGear;


public class Shifting extends SubsystemBase {
  // Shifting solenoid
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.kShiftSolenoid);  //Use CTREPCM for old PCM and REVPH for new pneumatics hub  
  // Compressor
  private final Compressor m_compressor = new Compressor(1, PneumaticsModuleType.REVPH);

  /** Constructor: Creates a new Shifting. */
  public Shifting() {
    SendableRegistry.add(m_solenoid, "Shift");
    //Use this to set a default command for the subsystem
    //this.setDefaultCommand(new LowGear(this)); //commented out along with its import to determine if default command is neccessary
    
    m_compressor.enableDigital(); // up for deletion

  }

  // Methods to control the shift solenoid
  public void lowGear(){
    m_solenoid.set(false);
  }

  public void highGear(){
    m_solenoid.set(true);
  }
  
  public void shift(){
    m_solenoid.toggle();
  }
  
  //gets solenoid state: true = on, false = off
  public boolean isHighGear(){
    return m_solenoid.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("High Gear", isHighGear());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
