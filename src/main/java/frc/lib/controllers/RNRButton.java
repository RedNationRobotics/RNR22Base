package frc.lib.controllers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.lib.controllers.RNRXboxController.XboxButton;

public class RNRButton extends JoystickButton {

	public RNRButton(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
	}

	public RNRButton(XboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

	public RNRButton(RNRXboxController joystick, XboxButton button) {
		super(joystick, button.value);
	}

}
