// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.*;

import frc.robot.Constants;
//import frc.robot.RobotContainer;

public class Drive extends SubsystemBase {
  private CANSparkMax leftM;
  private CANSparkMax leftS;

  private CANSparkMax rightM;
  private CANSparkMax rightS;
  double speed, steer, lDrive, rDrive;

  public Drive() {
    leftM = new CANSparkMax(Constants.lMaster, MotorType.kBrushless);
    leftS = new CANSparkMax(Constants.lSlave1, MotorType.kBrushless);
    rightM = new CANSparkMax(Constants.rMaster, MotorType.kBrushless);
    rightS = new CANSparkMax(Constants.rSlave1, MotorType.kBrushless);

    leftM.restoreFactoryDefaults();
    leftS.restoreFactoryDefaults();
    rightM.restoreFactoryDefaults();
    rightS.restoreFactoryDefaults();

    leftM.setInverted(true);
    leftS.setInverted(true);


    //leftS.follow(leftM);
    //rightS.follow(rightM);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void ArcadeDrive(double speed, double steer) {     
    speed = speed * speed * speed * 0.8 * Constants.maxSpd;
    steer = steer * steer * steer * 0.5 * Constants.maxSpd;
    lDrive = speed + steer;
    leftM.set(lDrive);
    leftS.set(lDrive);
    rDrive = speed - steer;
    rightM.set(rDrive);
    rightS.set(rDrive);
    SmartDashboard.putNumber("drive speed", lDrive);
    SmartDashboard.putNumber("drive steer", rDrive);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
