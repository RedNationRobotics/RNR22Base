// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PHub extends SubsystemBase {
  // Compressor
  private final PneumaticHub m_ph = new PneumaticHub(Constants.kph_ID);
  // Get values from Shuffleboard
  private final double m_minPressure = SmartDashboard.getNumber("Minimum Pressure (PSI)", 0.0);
  private final double m_maxPressure = SmartDashboard.getNumber("Maximum Pressure (PSI)", 0.0);
 

  /** Constructor: Creates a new Shifting. */
  public PHub() {
    //SmartDashboard.putBoolean("Compressor Running", m_ph.getCompressor());
    SmartDashboard.setDefaultBoolean("Enable Compressor Analog", false);
    SmartDashboard.setDefaultBoolean("Disable Compressor", false);
  
    // Add number inputs for minimum and maximum pressure
    SmartDashboard.setDefaultNumber("Minimum Pressure (PSI)", 100.0);
    SmartDashboard.setDefaultNumber("Maximum Pressure (PSI)", 120.0);
    //Use this to set a default command for the subsystem
    //this.setDefaultCommand(new LowGear(this)); //commented out along with its import to determine if default command is neccessary
    
    /**
     * Get pressure from analog channel 0 and display on Shuffleboard.
     */
    SmartDashboard.putNumber("Pressure", m_ph.getPressure(0));

    /**
     * Get compressor running status and display on Shuffleboard.
     */
    SmartDashboard.putBoolean("Compressor Running", m_ph.getCompressor());

  }

  // Methods to control the shift solenoid
  public void DB_Enable(){
        // Enable Compressor Analog button
    if (SmartDashboard.getBoolean("Enable Compressor Analog", false)) {
      SmartDashboard.putBoolean("Enable Compressor Analog", false);

       /**
       * Enable the compressor with analog pressure sensor control.
       *
       * This uses hysteresis between a minimum and maximum pressure value,
       * the compressor will run when the sensor reads below the minimum pressure
       * value, and the compressor will shut off once it reaches the maximum.
       *
       *
       */
      m_ph.enableCompressorAnalog(m_minPressure,m_maxPressure);
    }
  }

  public void DB_Disable(){
        // Disable Compressor button
    if (SmartDashboard.getBoolean("Disable Compressor", false)) {
      SmartDashboard.putBoolean("Disable Compressor", false);

      /**
       * Disable the compressor.
       */
      m_ph.disableCompressor();
    }
  }
  
  public void toggle(){
    if (isEnabled()){
      m_ph.disableCompressor();
    }else{
      m_ph.enableCompressorAnalog(m_minPressure,m_maxPressure);
    }
  }

  //gets solenoid state: true = on, false = off
  public boolean isEnabled(){
    return m_ph.getCompressor();
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
