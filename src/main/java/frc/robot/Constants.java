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

    //Inatke IDs
    public static final int[] kIntakeMotor = {7};

    //Convey IDs
    public static final int[] kConveyMotor = {8};



    //Pneumatics
    public static final int kShiftSolenoid = 2;
    public static final int kShootSolenoid = 3;
    public static final int kIntakeSolenoid = 1;
    public static final int kClimbSolenoid = 0;
    //Shooter Speed
    public static final double kShooterSpeed = 0.9;

    //Intake Speed
    public static final double kIntakeSpeed = 0.5;

    //Convey Speed
    public static final double kConveySpeed = 0.9;


   
}
