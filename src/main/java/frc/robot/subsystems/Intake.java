// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Intake extends SubsystemBase {
    TalonSRX conveyor = new TalonSRX(Constants.convey);
    TalonSRX elevator = new TalonSRX(Constants.elevate);
    //private double inSpd = 0.5, upSpd = 0.5;

  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //inSpd = SmartDashboard.getNumber("Intake Speed", RobotContainer.conveySpd);
    //upSpd = SmartDashboard.getNumber("Elevator Speed", RobotContainer.elevateSpd);
  }

  public void runConveyor(){
    conveyor.set(ControlMode.PercentOutput, RobotContainer.conveySpd);
  }

  public void revConveyor() {
    conveyor.set(ControlMode.PercentOutput, -0.5);
  }

  public void stopConveyor(){
    conveyor.set(ControlMode.PercentOutput, 0.0);
  }

  public void runElevator(){
    elevator.set(ControlMode.PercentOutput, RobotContainer.elevateSpd);
  }
  public void revElevator(){
    elevator.set(ControlMode.PercentOutput, -(RobotContainer.elevateSpd/2));
  }
 public void stopElevator(){
        elevator.set(ControlMode.PercentOutput, 0.0);
  }
  
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
