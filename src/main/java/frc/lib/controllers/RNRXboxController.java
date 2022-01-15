package frc.lib.controllers;

import edu.wpi.first.wpilibj.Joystick;
import frc.lib.controllers.RNRAxisButton.ThresholdType;

public class RNRXboxController extends Joystick {

	public RNRXboxController(final int port) {
		super(port);
	}
	
	public RNRXboxController(final int port, final double xDeadband, final double yDeadband) {
		this(port);
		this.leftStick.setDeadband(xDeadband, yDeadband);
		this.rightStick.setDeadband(xDeadband, yDeadband);
	}

	public RNRButton xButton = new RNRButton(this, XboxButton.X);
	public RNRButton yButton = new RNRButton(this, XboxButton.Y);
	public RNRButton aButton = new RNRButton(this, XboxButton.A);
	public RNRButton bButton = new RNRButton(this, XboxButton.B);
	public RNRButton rightBumper = new RNRButton(this, XboxButton.RIGHT_BUMPER);
	public RNRButton leftBumper = new RNRButton(this, XboxButton.LEFT_BUMPER);
	public RNRButton startButton = new RNRButton(this, XboxButton.START);
	public RNRButton selectButton = new RNRButton(this, XboxButton.SELECT);
	public RNRButton leftStickButton = new RNRButton(this, XboxButton.LEFT_STICK);
	public RNRButton rightStickButton = new RNRButton(this, XboxButton.RIGHT_STICK);
	
	public RNRAxisButton leftTriggerButton = new RNRAxisButton(this, XboxAxis.LEFT_TRIGGER, .05, ThresholdType.GREATER_THAN);
	public RNRAxisButton rightTriggerButton = new RNRAxisButton(this, XboxAxis.RIGHT_TRIGGER, .05, ThresholdType.GREATER_THAN);
	public RNRDpad Dpad = new RNRDpad(this);
	
	public RNRThumbStick leftStick = new RNRThumbStick(this, XboxAxis.LEFT_X, XboxAxis.LEFT_Y);
	public RNRThumbStick rightStick = new RNRThumbStick(this, XboxAxis.RIGHT_X, XboxAxis.RIGHT_Y);
	
	public RNRTriggers triggers = new RNRTriggers(this);
	
	public void setRumble(final double leftValue, final double rightValue) {
		setRumble(RumbleType.kLeftRumble, leftValue);
		setRumble(RumbleType.kRightRumble, rightValue);
	}
	
	static enum XboxButton
	{
		
		A(1), B(2), X(3), Y(4),
		LEFT_BUMPER(5), RIGHT_BUMPER(6),
		SELECT(7), START(8), 
		LEFT_STICK(9), RIGHT_STICK(10);
		
		final int value;
		
		XboxButton(final int value){
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
	}
	
	public static enum XboxAxis
	{
			LEFT_X(0), LEFT_Y(1),
			LEFT_TRIGGER(2), RIGHT_TRIGGER(3),
			RIGHT_X(4), RIGHT_Y(5),
			DPAD(6);
		
			final int value;
			
			XboxAxis(final int value){
				this.value = value;
			}
			
			public int getValue() {
				return this.value;
			}
		}
	
	public static enum XboxDpad
	{
		UNPRESSED(-1), UP(0), UP_RIGHT(45),
		RIGHT(90), DOWN_RIGHT(135), 
		DOWN(180), DOWN_LEFT(225),
		LEFT(270), UP_LEFT(315);
		
			final int value;
			
			XboxDpad(final int value){
				this.value = value;
			}
			
			public int getValue() {
				return this.value;
			}
		}

}
