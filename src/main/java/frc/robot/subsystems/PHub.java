// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PHub extends SubsystemBase {
  // Compressor
  private final PneumaticHub m_ph = new PneumaticHub(Constants.kph_ID);

  /** Constructor: Creates a new Shifting. */
  public PHub() {
    //Use this to set a default command for the subsystem
    //this.setDefaultCommand(new LowGear(this)); //commented out along with its import to determine if default command is neccessary
  }

  // Methods to control the compressor
  public void enable(){
    /**
    * Enable the compressor with analog pressure sensor control.
    *
    * This uses hysteresis between a minimum and maximum pressure value,
    * the compressor will run when the sensor reads below the minimum pressure
    * value, and the compressor will shut off once it reaches the maximum.
    *
    */
    m_ph.enableCompressorAnalog(Constants.kMin_PSI, Constants.kMax_PSI);
  }

  public void disable(){
    /**
    * Disable the compressor.
    */
      m_ph.disableCompressor();
  }
  
  public void toggle(){
    if (isEnabled()){
      disable();
    }else{
      enable();
    }
  }

  //gets solenoid state: true = on, false = off
  public boolean isEnabled(){
    return m_ph.getCompressor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Pressure 0", m_ph.getPressure(0));
    SmartDashboard.putBoolean("Comp", m_ph.getCompressor());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
