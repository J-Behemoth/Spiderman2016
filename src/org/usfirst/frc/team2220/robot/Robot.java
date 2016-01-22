
package org.usfirst.frc.team2220.robot;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is 2220's test code
 */
//potatoe potatoe 
public class Robot extends SampleRobot {
    SmartDashboard dashboard;

    public Robot() {
        
    }

    /**
     * Autonomous 
     * @TODO
     */
    public void autonomous() {
       
    }

    /**
     * TeleOp
     * @TODO
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
         
        	
        	
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Test mode
     * @TODO diagnostics
     */
    public void test() {
    }
}
