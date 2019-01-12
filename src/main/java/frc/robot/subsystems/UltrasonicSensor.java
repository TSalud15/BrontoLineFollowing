/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Ultrasonic.Unit;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UltrasonicSensor extends Subsystem {
  
  private final AnalogInput m_ultra;
  //private final Ultrasonic m_ultra;

  private final int factor = 50;

  //private final DigitalInput m_echo;
  //private final DigitalOutput m_ping;

  public UltrasonicSensor() {
    //m_echo = new DigitalInput(1);
    //m_ping = new DigitalOutput(2);
    //m_ultra = new Ultrasonic(m_ping, m_echo);
  
    //m_ultra.setAutomaticMode(true);
    //m_ultra.setEnabled(true);

    m_ultra = new AnalogInput(1);

    m_ultra.setOversampleBits(2);
    m_ultra.setAverageBits(5);
  }
  
  public double getVoltage() {
    return m_ultra.getVoltage();
  }

  public double getAvgVoltage() {
    return m_ultra.getAverageVoltage();
  }

  public double getInches() {
    return ((getAvgVoltage() -.27) * factor) + 10;
  }
  
  public int getValue() {
    return m_ultra.getValue();
  }

  public int getAvgValue() {
    return m_ultra.getAverageValue();
  }
  /*
  public double getRangeInches() {
    m_ultra.ping();
    return m_ultra.getRangeInches();
  }

  public double getRangeMM() {
    m_ultra.ping();
    return m_ultra.getRangeMM();
  }

  public double getPIDRange() {
    m_ultra.ping();
    return m_ultra.pidGet();
  } 
  */
  public void reportToSmartDashboard() {
    SmartDashboard.putNumber("Value", getValue());
    SmartDashboard.putNumber("Average Value", getAvgValue());
    SmartDashboard.putNumber("Voltage", getVoltage());
    SmartDashboard.putNumber("Average Voltage", getAvgVoltage());
    SmartDashboard.putNumber("Distance", getInches());
    //SmartDashboard.putNumber("PID Range", getPIDRange());
    //SmartDashboard.putNumber("Range Inches", getRangeInches());
    //SmartDashboard.putNumber("Range MM", getRangeMM());
    //SmartDashboard.putBoolean("Enabled", m_ultra.isEnabled());
    //SmartDashboard.putBoolean("Valid Range", m_ultra.isRangeValid());
  } 

  @Override
  public void initDefaultCommand() {
  }
}
