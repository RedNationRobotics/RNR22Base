// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final int[] kLeftDrive = {1, 3};
    public static final int[] kRightDrive = {2, 4};

    //Shooter IDs
    public static final int[] kShooterMotors = {5, 6};

<<<<<<< HEAD
                                                            
    public static final DifferentialDrive drivetrain = new DifferentialDrive(leftLead, rightLead);
    
    //Shifting Pneumatics
    public static final Solenoid shiftSolenoid = new Solenoid(PneumaticsModuleType.REVPH, 0);  //Use CTREPCM for old PCM and REVPH for new pneumatics hub

    public static final Compressor compressor = new Compressor(PneumaticsModuleType.REVPH);

}
=======
    //Pneumatics
    public static final int kShiftSolenoid = 1;
    public static final int kShootSolenoid = 2;

    //Shooter Speed
    public static final double kShooterSpeed = 0.9;
   
}
>>>>>>> origin/ShooterV2
