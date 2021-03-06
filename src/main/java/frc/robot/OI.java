/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.LineFollow;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick rightJoy;
    public Joystick leftJoy;

    public JoystickButton lineFollow_1;

    public OI() {
        rightJoy = new Joystick(0);
        leftJoy = new Joystick(1);

        lineFollow_1 = new JoystickButton(leftJoy, 7);
        lineFollow_1.whileHeld(new LineFollow(0.2));

        SmartDashboard.putData("Line Follow", new LineFollow(0.2));
    }

    public double getLeftJoyX() {
        return leftJoy.getX();
    }

    public double getRightJoyX() {
        return rightJoy.getX();
    }

    public double getLeftJoyY() {
        return -leftJoy.getY();
    }

    public double getRightJoyY() {
        return -rightJoy.getY();
    }
}
