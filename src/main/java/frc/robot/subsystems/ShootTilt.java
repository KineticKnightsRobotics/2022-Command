// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.SparkMaxLimitSwitch.Type;
//import com.revrobotics.SparkMaxLimitSwitch;

public class ShootTilt extends SubsystemBase {
  private CANSparkMax tilt;
  private RelativeEncoder m_encoder;
  //private SparkMaxLimitSwitch m_forwardLimit;
  //private SparkMaxLimitSwitch m_reverseLimit;
  DigitalInput tiltLimit = new DigitalInput(0);

  /** Creates a new Shooter tilt subsystem */
  public ShootTilt() {
  tilt = new CANSparkMax(Constants.tiltMotor, MotorType.kBrushless);
  m_encoder = tilt.getEncoder();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Tilt Posn", m_encoder.getPosition());
    if (!(tiltLimit.get()) && (tilt.get() > 0.0)) {
      tilt.set(0.0);
      m_encoder.setPosition(0.0);
    }
  }

  public void tiltUp(){
    tilt.set(0.08);
  }

  public void tiltDn(){
    tilt.set(-0.08);
  }

  public void tiltStop(){
    tilt.set(0.0); 
  }
  
  /** run tilt down slowly until limit switch made */
  public void tiltHome(){
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
