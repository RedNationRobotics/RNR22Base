package frc.lib.controllers;

import edu.wpi.first.wpilibj.Joystick;
import frc.lib.controllers.RNRXboxController.XboxAxis;

public class RNRTriggers {
	Joystick controller;
	
	public RNRTriggers(Joystick controller) {
		this.controller = controller;
	}

	public double getLeft() {
		return this.controller.getRawAxis(XboxAxis.LEFT_TRIGGER.value);
	}
	
	public double getRight() {
		return this.controller.getRawAxis(XboxAxis.RIGHT_TRIGGER.value);
	}
	
	public double getTwist() {
		return - getLeft() + getRight();
	}
}
