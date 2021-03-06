package frc.lib.controllers;

import edu.wpi.first.wpilibj.Joystick;
import frc.lib.controllers.RNRXboxController.XboxAxis;

//Based on Code form Bob319 2017
public class RNRThumbStick {
	Joystick controller;
	XboxAxis xAxis;
	XboxAxis yAxis;
	double yDeadband = 0.0;
	double xDeadband = 0.0;
	
	public RNRThumbStick(Joystick controller, XboxAxis xAxis, XboxAxis yAxis) {
		this.controller = controller;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	public RNRThumbStick(Joystick controller, XboxAxis xAxis, XboxAxis yAxis, double yDeadband, double xDeadband) {
		this(controller, xAxis, yAxis);
		this.yDeadband = Math.abs(yDeadband);
		this.xDeadband = Math.abs(xDeadband);
	}

	public double getX() {
		double value = this.controller.getRawAxis(xAxis.value);
		return handleDeadband(value, xDeadband);
	}
	
	public double getY() {
		double value = this.controller.getRawAxis(yAxis.value) * -1;
		return handleDeadband(value, yDeadband);
	}
	
	public void setXDeadband(double deadband) {
		this.xDeadband = deadband;
	}
	
	public void setYDeadband(double deadband) {
		this.yDeadband = deadband;
	}
	
	public void setDeadband(double xDeadband, double yDeadband) {
		setXDeadband(xDeadband);
		setYDeadband(yDeadband);
	}
	
	public double handleDeadband(double input, double deadband) {
		if (input > -deadband && input < deadband) {
			return 0;
		}else {
			//Rescale the input to remove deadband but keep are low end control.
			//deadband to 1 becomes 0 to 1.
			return Math.copySign((Math.abs(input)-deadband)/(1-deadband) ,input);
		}
	}
	
	public double getDirectionRadians() {
		return Math.atan2(getX(), -getY());
	}
	
	public double getDirectionDegrees() {
		    return Math.toDegrees(getDirectionRadians());
	}

}
