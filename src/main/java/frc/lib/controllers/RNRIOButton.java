package frc.lib.controllers;

import edu.wpi.first.wpilibj2.command.button.Button;
import frc.lib.drivers.RNRDigitalInput;

public class RNRIOButton extends Button {

	RNRDigitalInput
 input;

	public RNRIOButton(RNRDigitalInput
 i) {
		input = i;
	}

	public boolean get(){
		return !input.get();
	}
}
