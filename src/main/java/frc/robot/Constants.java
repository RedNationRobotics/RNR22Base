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
    // Auto Constants *test*
    public static final double kAutoDriveDistanceInches = 84; 
    public static final double kAutoRotation = 0;
    public static final double kAutoDriveSpeed = 0.65;
    
    // Drivetrain IDs
    public static final int[] kLeftDrive = {1, 3};
    public static final int[] kRightDrive = {2, 4};

    public static final boolean kLeftEncoderReversed = false;
    public static final boolean kRightEncoderReversed = true;

    public static final int kEncoderCPR = 42;
    public static final double kWheelDiameterInches = 5.0;
    public static final double kFirstStage = 12.0/50.0;
    public static final double kLowStage = 34.0/50.0;
    public static final double kHighStage = 50.0/34.0;
    public static final double kThirdStage = 24.0/60.0;
    public static final double kFinalDriveLow = kFirstStage * kLowStage * kThirdStage;
    public static final double kFinalDriveHigh = kFirstStage * kHighStage * kThirdStage;
    public static final double kEncoderDPPLow = 1.0;
                //( kWheelDiameterInches *  kFinalDriveLow *  Math.PI) / (double) kEncoderCPR;
    public static final float kEncoderDPPHigh=
                ((float) kWheelDiameterInches * (float) kFinalDriveHigh *  (float) Math.PI) / (float) kEncoderCPR;

    // Shooter IDs
    public static final int[] kShooterMotors = {5, 6};

    // Inatke IDs
    public static final int[] kIntakeMotor = {7};

    // Convey IDs
    public static final int[] kConveyMotor = {8};

    // Climb IDs
    public static final int[] kClimbMotors = {9, 10};

    // Pneumatics
    public static final int kShiftSolenoid = 0;
    public static final int kBoltSolenoid = 3;
    public static final int kIntakeSolenoid = 1;
    public static final int kTiltSolenoid = 2;

    public static final int kph_ID = 1;
    public static final double kMin_PSI = 100.0;
    public static final double kMax_PSI = 120.0;

    public static final double kBoltPulse = 0.3;

    // Shooter Speed
    public static final double kShooterRev = 0.4;
    public static final double kShooterRPM0 = 7800.0;
    public static final double kShooterRPM1 = 5000.0;
    public static final double kFireVelocity0 = 7400.0;
    public static final double kFireVelocity1 = 4900.0;


    // Intake Speed
    public static final double kIntakeSpeed = 0.85;

    // Convey Speed
    public static final double kConveySpeed = 0.9;

    // Climb Speed
    public static final double kDeploySpeed = 0.2;
    public static final double kWenchSpeed = 0.7;




   
}
