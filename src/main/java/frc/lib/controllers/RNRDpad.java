package frc.lib.controllers;

import edu.wpi.first.wpilibj.Joystick;
import frc.lib.controllers.RNRAxisButton.ThresholdType;
import frc.lib.controllers.RNRXboxController.XboxAxis;
import frc.lib.controllers.RNRXboxController.XboxDpad;

public class RNRDpad {
	public final Joystick joy;
	public RNRAxisButton Up;
	public RNRAxisButton Down;
	public RNRAxisButton Left;
	public RNRAxisButton Right;
	public RNRAxisButton UpLeft;
	public RNRAxisButton UpRight;
	public RNRAxisButton DownLeft;
	public RNRAxisButton DownRight;
	
	public RNRDpad(Joystick joystick) {
		this.joy = joystick;
		this.Up = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP.value, ThresholdType.POV);
		this.Down = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN.value, ThresholdType.POV);		
		this.Left = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.LEFT.value, ThresholdType.POV);
		this.Right = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.RIGHT.value, ThresholdType.POV);
		this.UpLeft = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP_LEFT.value, ThresholdType.POV);
		this.UpRight = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.UP_RIGHT.value, ThresholdType.POV);
		this.DownLeft = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN_LEFT.value, ThresholdType.POV);
		this.DownRight = new RNRAxisButton(joy, XboxAxis.DPAD, XboxDpad.DOWN_RIGHT.value, ThresholdType.POV);
	}
	
	public double getValue() {
		return joy.getRawAxis(XboxAxis.DPAD.value);
	}

}
