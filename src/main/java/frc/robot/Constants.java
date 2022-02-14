// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Drivetrain IDs
    public static final int[] LEFT_GROUP = {1, 3};
    public static final int[] RIGHT_GROUP = {2, 4};

    //Motor Controller Grouups
    public static final CANSparkMax leftLead = new CANSparkMax(Constants.LEFT_GROUP[0], MotorType.kBrushless);
    public static final CANSparkMax leftFollow = new CANSparkMax(Constants.LEFT_GROUP[1], MotorType.kBrushless);
    public static final CANSparkMax rightLead = new CANSparkMax(Constants.RIGHT_GROUP[0], MotorType.kBrushless);
    public static final CANSparkMax rightFollow = new CANSparkMax(Constants.RIGHT_GROUP[1], MotorType.kBrushless);
                                                            
    public static final DifferentialDrive drivetrain = new DifferentialDrive(leftLead, rightLead);
    
    //Shifting Pneumatics
    public static final Solenoid shiftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);  //Use CTREPCM for old PCM and REVPH for new pneumatics hub

    public static final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

}
