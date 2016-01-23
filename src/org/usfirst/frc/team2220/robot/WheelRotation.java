package org.usfirst.frc.team2220.robot;

import edu.wpi.first.wpilibj.*;

public class WheelRotation {	//Please put more descriptive descriptions in your class explanations
	private final double kP;
	private TwilightTalon talon;
	private Encoder encoder;
	private Timer timer = new Timer();
	private double currPos = 0, prevPos = 0;
	private double desiredRPS;
	private double cap = 1.0;
	private boolean reversed = false;
	
	/**
	 * Wheel rotation, running two wheels from one motor
	 */
	public WheelRotation(TwilightTalon Talon, Encoder WheelEncoder, double KP) { //Need the encoder class
		kP = KP;
		talon = Talon;
		timer.start();
	}
	
	/**
	 * Gets the RPS since the last call of getRPS()
	 */
	public double getRPS() {
		currPos = encoder.getDistance();
		double out = 0;
		if(timer.get() != 0)
		{
			out = (currPos - prevPos) / timer.get();
		}
		prevPos = currPos;
		timer.reset();
		return out;
	}
	

	public void setDesiredRPS(double newRPS) {
		desiredRPS = newRPS;
	}
	
	/**
	 * What you want - what you got
	 * @return the error
	 */
	public double getError()
	{
		return desiredRPS - getRPS();
	}
	
	/**
	 * Determines how much to increment or decrement the wheel speed
	 */
	public void calculate() {
		double plusM = getError() * kP;
		if(desiredRPS == 0)
			runWheel(0);
		else
			runWheel(talon.get() + plusM);
	}
	
	/**
	 * caps and/or reverses wheel speed
	 * @param val speed to run at
	 */
	public void runWheel(double val)
	{
		if(val > cap)
			val = cap;
		else if(val < -cap)
			val = -cap;
			
		if(!reversed)
			talon.set(val);
		else
			talon.set(-val);
	}
	
	public void stop() {
		talon.set(0);
	}
	
	@Override
	public String toString() {
		double currentRPS = getRPS();
		double errorValue = getError();
		String report = "Current RPS: " + currentRPS + ", Current Margin of Error: " + errorValue;
		return report; //insert method that prints to dashboard
	}
}
