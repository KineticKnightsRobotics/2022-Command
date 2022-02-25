// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class AirSyst extends SubsystemBase {
  DoubleSolenoid STilt = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  /** Creates a new ExampleSubsystem. */
  public AirSyst() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shTiltF(){
    STilt.set(Value.kForward);
  }
  
  public void shTiltR(){
    STilt.set(Value.kReverse);
  }

  public void shTiltTog(){
    if (STilt.get() == Value.kForward) {
      STilt.set(Value.kReverse);
    } else {
      STilt.set(Value.kForward);
    }
  }
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
