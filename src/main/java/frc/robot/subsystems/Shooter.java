// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

  public double kP0 = 0.000009999, kI0 = 0.0, kD0 = 0.0, kIz0 = 0.0, kFF0 = 0.00009, kMaxOutput0 = 1, kMinOutput0 = 0, maxRPM0 = Constants.kShooterRPM0;
  public double kP1 = 0.000009999, kI1 = 0.0, kD1 = 0.0, kIz1 = 0.0, kFF1 = 0.00009, kMaxOutput1 = 1, kMinOutput1 = 0, maxRPM1 = Constants.kShooterRPM1;

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

    // set PID0 coefficients
    m_pidController.setP(kP0, 0);
    m_pidController.setI(kI0, 0);
    m_pidController.setD(kD0, 0);
    m_pidController.setIZone(kIz0, 0);
    m_pidController.setFF(kFF0, 0);
    m_pidController.setOutputRange(kMinOutput0, kMaxOutput0, 0);

    // set PID1 coefficients
    m_pidController.setP(kP0, 1);
    m_pidController.setI(kI0, 1);
    m_pidController.setD(kD0, 1);
    m_pidController.setIZone(kIz0, 1);
    m_pidController.setFF(kFF0, 1);
    m_pidController.setOutputRange(kMinOutput0, kMaxOutput0, 1);

    /* display PID coefficients on SmartDashboard
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
    */
      
  }

  // Methods to control shooter speed for high goal
  public void highGoal(){
    double setPoint = maxRPM0;
    m_pidController.setReference(setPoint, CANSparkMax.ControlType.kVelocity, 0);
    
    /*
    SmartDashboard.putNumber("SetPoint", setPoint);
    SmartDashboard.putNumber("ProcessVariable", m_leftEncoder.getVelocity());
    SmartDashboard.putNumber("Output", m_leftMotor.getAppliedOutput());
    */
  }

  // Methods to control shooter speed for low goal
  public void lowGoal(){
    double setPoint = maxRPM1;
    m_pidController.setReference(setPoint, CANSparkMax.ControlType.kVelocity, 1);
    
  }  

  public void shoot(){
    m_leftMotor.set(-Constants.kShooterRev);
    m_rightMotor.set(-Constants.kShooterRev);
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
    SmartDashboard.putNumber("rEncoder", getRightEncoder());
    SmartDashboard.putNumber("lEncoder", getLeftEncoder());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
