// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.StopShooter;

public class Shooter extends SubsystemBase {
  //Shooter Motors
  private final CANSparkMax m_leftMotor = new CANSparkMax(Constants.kShooterMotors[0], MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(Constants.kShooterMotors[1], MotorType.kBrushless);

  // Left side encoder
  private RelativeEncoder m_leftEncoder = m_leftMotor.getEncoder();
  
  // Right side encoder
  private RelativeEncoder m_rightEncoder = m_rightMotor.getEncoder();

  // PID Controller
  public SparkMaxPIDController m_pidController = m_leftMotor.getPIDController();

  public double kP = 0.0005, kI = 0.0, kD = 0.0, kIz = 0.0, kFF = 0.000015, kMaxOutput = 1, kMinOutput = 0, maxRPM = Constants.kShooterRPM;

  // Shooter bolt solenoid
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.kShootSolenoid);

  /** Constructor: Creates a new Shooter. */
  public Shooter() {
    //Sendables go here
    
    // Default Command
    this.setDefaultCommand(new StopShooter(this));
    
    // Restore Defaults
    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();

    // Set Current Limits
    m_leftMotor.setSmartCurrentLimit(40);
    m_rightMotor.setSmartCurrentLimit(40); 
    
    // Invert and follow
    m_leftMotor.setInverted(true);
    m_rightMotor.follow(m_leftMotor, true);

    // set PID coefficients
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);

    // display PID coefficients on SmartDashboard
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
      
  }

  // Methods to control shooter speed
  public void set(){
    double setPoint = maxRPM;
    m_pidController.setReference(setPoint, CANSparkMax.ControlType.kVelocity);
    

    SmartDashboard.putNumber("SetPoint", setPoint);
    SmartDashboard.putNumber("ProcessVariable", m_leftEncoder.getVelocity());
    SmartDashboard.putNumber("Output", m_leftMotor.getAppliedOutput());
  }

  public void shoot(){
    m_leftMotor.set(-Constants.kShooterSpeed);
    m_rightMotor.set(-Constants.kShooterSpeed);
  }

  public void stop(){
      m_leftMotor.stopMotor();
      m_rightMotor.stopMotor();
  }

  // Methods to control the solenoid
  
  public void fire() {
    m_solenoid.set(true);
  }

  public void load() {
    m_solenoid.set(false);
  }

  /**
   * Gets the average distance of the TWO encoders.
   *
   * @return the average of the TWO encoder readings
   */
  public double getAvgVelocity() {
    return (getLeftEncoder() + getRightEncoder()) / 2.0;
  }

  /**
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   */
  public double getLeftEncoder() {
    return -m_leftEncoder.getVelocity();
  }

  /**
   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   */
  public double getRightEncoder() {
    return -m_rightEncoder.getVelocity();
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
