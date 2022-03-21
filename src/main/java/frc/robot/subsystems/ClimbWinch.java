// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ClimbWinch extends SubsystemBase {
  private CANSparkMax winch;
  private RelativeEncoder m_encoder;
  private TalonSRX arm;

  /** Creates a new Climber Winch subsystem. */
  public ClimbWinch() {
    winch = new CANSparkMax(Constants.winch, MotorType.kBrushless);
    m_encoder = winch.getEncoder();
    arm = new TalonSRX(Constants.ClimbArm);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Winch Posn", m_encoder.getPosition());

  }

  public void winchIn() {
    winch.set(0.5);
  }

  public void winchOut() {
    winch.set(-0.5);
  }

  public void winchStop(){
    winch.set(0.0);
  }
  
  public void armF(){
    arm.set(ControlMode.PercentOutput, 0.2);
  }

  public void armR(){
    arm.set(ControlMode.PercentOutput, -0.2);
  }

  public void armS(){
    arm.set(ControlMode.Disabled, 0.0);
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
