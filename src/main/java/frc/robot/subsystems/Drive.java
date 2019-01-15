/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.nerdherd.lib.drivers.NerdyTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  
  private NerdyTalon m_leftmaster, m_leftslave1, m_leftslave2;
  private NerdyTalon m_rightmaster, m_rightslave1, m_rightslave2;


  public Drive() {
    m_leftmaster = new NerdyTalon(1);
    m_leftslave1 = new NerdyTalon(2);
    m_leftslave2 = new NerdyTalon(3);
    m_rightmaster = new NerdyTalon(4);
    m_rightslave1 = new NerdyTalon(5);
    m_rightslave2 = new NerdyTalon(6);

    m_leftslave1.follow(m_leftmaster);
    m_rightslave1.follow(m_rightmaster);
    m_leftslave2.follow(m_leftmaster);
    m_rightslave2.follow(m_rightmaster);

    m_leftmaster.setInverted(true);
    m_leftslave1.setInverted(true);
    m_leftslave2.setInverted(true);

    m_rightmaster.setInverted(false);
    m_rightslave1.setInverted(false);
    m_rightslave2.setInverted(false);
  }
  
  public void setPower(double leftPower, double rightPower) {
    m_leftmaster.set(ControlMode.PercentOutput, leftPower);
    m_rightmaster.set(ControlMode.PercentOutput, rightPower);
  }

  public void setVoltage(double leftPower, double rightPower) {
    m_leftmaster.set(ControlMode.PercentOutput, leftPower/12);
    m_rightmaster.set(ControlMode.PercentOutput, rightPower/12);
  }

  @Override
  public void initDefaultCommand() {
  }
}
