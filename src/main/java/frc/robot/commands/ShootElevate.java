// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Command to run shooter, delay then elevate ball */
public class ShootElevate extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter m_subsystem;
  private final Intake m_subsystem1;
  private int counter = 0;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShootElevate(Shooter subsystem, Intake subsystem1) {
    m_subsystem = subsystem;
    m_subsystem1 = subsystem1;
  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem, m_subsystem1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.runShoot();
    counter = 0;
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    counter += 1;
    if (counter == 50) m_subsystem1.runElevator();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.stopShoot();
    m_subsystem1.stopElevator();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
