// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShootTilt extends SubsystemBase {
  private CANSparkMax tilt;
  private RelativeEncoder m_encoder;

  /** Creates a new Shooter tilt subsystem */
  public ShootTilt() {
  tilt = new CANSparkMax(Constants.tiltMotor, MotorType.kBrushless);
  m_encoder = tilt.getEncoder();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Tilt Posn", m_encoder.getPosition());
  }

  public void doNothing() {}

  public void tiltUp(){
    tilt.set(0.1);
  }

  public void tiltDn(){
    tilt.set(-0.1);
  }

  public void tiltStop(){
    tilt.set(0.0);
  }
  
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
