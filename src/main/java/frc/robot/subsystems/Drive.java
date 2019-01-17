/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.nerdherd.lib.drivers.NerdyTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  
  private NerdyTalon m_leftmaster, m_leftslave;
  private NerdyTalon m_rightmaster, m_rightslave;


  public Drive() {
    m_leftmaster = new NerdyTalon(1);
    m_leftslave = new NerdyTalon(5);
    m_rightmaster = new NerdyTalon(2);
    m_rightslave = new NerdyTalon(4);

    m_leftslave.follow(m_leftmaster);
    m_rightslave.follow(m_rightmaster);

    m_leftmaster.setInverted(false);
    m_leftslave.setInverted(false);

    m_rightmaster.setInverted(true);
    m_rightslave.setInverted(true);

    m_leftmaster.setNeutralMode(NeutralMode.Brake);
    m_leftslave.setNeutralMode(NeutralMode.Brake);

    m_rightmaster.setNeutralMode(NeutralMode.Brake);
    m_rightslave.setNeutralMode(NeutralMode.Brake);
  }
  
  public void setPower(double leftPower, double rightPower) {
    m_leftmaster.set(ControlMode.PercentOutput, leftPower);
    m_rightmaster.set(ControlMode.PercentOutput, rightPower);
  }

  public void setVoltage(double leftPower, double rightPower) {
    m_leftmaster.set(ControlMode.PercentOutput, leftPower/12);
    m_rightmaster.set(ControlMode.PercentOutput, rightPower/12);
  }

  public double getLeftPercent() {
    return m_leftmaster.getMotorOutputPercent();
  }

  public double getRightPercent() {
    return m_rightmaster.getMotorOutputPercent();
  }

  public void reportToSmartDashboard() {
    SmartDashboard.putNumber("Left Master Output", getLeftPercent());
    SmartDashboard.putNumber("Right Master Output", getRightPercent());
  }

  @Override
  public void initDefaultCommand() {
  }
}
