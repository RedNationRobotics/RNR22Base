package frc.lib.controllers;

import edu.wpi.first.wpilibj2.command.button.Button;

public class RNRAndNotButton extends Button {

	Button b1;
	Button b2;

	public RNRAndNotButton(Button button, Button button2) {
		b1 = button;
		b2 = button2;
	}

	public boolean get(){
		return b1.get() && !b2.get();
	}

}
