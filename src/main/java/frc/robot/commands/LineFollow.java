/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class LineFollow extends Command {

  private int m_threshold; 
  private double m_power;
  private double m_offset;

  public LineFollow(double power) {
    m_power = power;
    m_threshold = 3150;
    m_offset = 0.06;
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putBoolean("Line Found, Left", Robot.sensor.getValue0() < m_threshold);
    SmartDashboard.putBoolean("Line Found, Right", Robot.sensor.getValue2() < m_threshold);

    if (Robot.sensor.getValue1() < m_threshold) {
      if (Robot.sensor.getValue0() < m_threshold + 200) {
        Robot.drive.setPower(m_power - (m_offset + 0.02), m_power + (m_offset + 0.02));
      } 
  
      if (Robot.sensor.getValue2() < m_threshold + 100) {
        Robot.drive.setPower(m_power + (m_offset - 0.00), m_power - (m_offset - 0.00));
      }

      else if (Robot.sensor.getValue0() > m_threshold && Robot.sensor.getValue2() > m_threshold 
                && Robot.sensor.getValue1() < m_threshold) {
        Robot.drive.setPower(m_power, m_power);
      } 
  }

  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive.setPower(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
