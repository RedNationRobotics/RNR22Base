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

public class Shooter extends SubsystemBase {
  //Shooter Motors
  public static final CANSparkMax leftMotor = new CANSparkMax(Constants.kShooterMotors[0], MotorType.kBrushless);
  public static final CANSparkMax rightMotor = new CANSparkMax(Constants.kShooterMotors[1], MotorType.kBrushless);
  public static final Solenoid solenoidPH = new Solenoid(PneumaticsModuleType.REVPH, Constants.kShiftSolenoid);

  /** Creates a new Shooter. */
  public Shooter() {
    //Sendables go here
    
    // Default Command
    //this.setDefaultCommand(StopShooter(this));
    
    // Invert right
    rightMotor.setInverted(true);
   
  }

  // Methods to control shooter speed
  public void set(double speed){
     leftMotor.set(speed);
     rightMotor.set(speed);
  }

  public void shoot(){
    set(Constants.kShooterSpeed);
  }

  public void stop(){
      leftMotor.stopMotor();
      rightMotor.stopMotor();
  }

  // Methods to control the solenoid
  public void fire() {
    solenoidPH.set(true);
  }

  public void load() {
    solenoidPH.set(false);
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
