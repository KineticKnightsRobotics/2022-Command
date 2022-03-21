// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
//import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.cameraserver.CameraServer;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive m_drive = new Drive();
  private final Shooter m_shooter = new Shooter();
  private final Intake m_intake = new Intake();
  private final ShootTilt m_tilt = new ShootTilt();
  private final ClimbWinch m_winch = new ClimbWinch();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final JoystickDrive JoystickDrive = new JoystickDrive(m_drive);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  // motor speed variables
  public static double shootSpd = 0.7;
  public static double conveySpd = 0.9;
  public static double elevateSpd = 0.4;

    //Driver gamepad
  final static Joystick drvStick = new Joystick(Constants.drvStick);
  final JoystickButton drA = new JoystickButton(drvStick, Constants.drA);
  final JoystickButton drB = new JoystickButton(drvStick, Constants.drB);
  final JoystickButton drY = new JoystickButton(drvStick, Constants.drY);
  final JoystickButton drX = new JoystickButton(drvStick, Constants.drX);
  //final JoystickButton drLT = new JoystickButton(drvStick, Constants.drY);
  //final JoystickButton drRT = new JoystickButton(drvStick, Constants.drX);
  final JoystickButton drLB = new JoystickButton(drvStick, Constants.drLB);
  final JoystickButton drRB = new JoystickButton(drvStick, Constants.drRB);
  // Operator gamepad
  final static Joystick opStick = new Joystick(Constants.opStick);
  final JoystickButton op1 = new JoystickButton(opStick, Constants.op1);
  final JoystickButton op2 = new JoystickButton(opStick, Constants.op2);
  final JoystickButton op3 = new JoystickButton(opStick, Constants.op3);
  final JoystickButton op4 = new JoystickButton(opStick, Constants.op4);
  final JoystickButton op5 = new JoystickButton(opStick, Constants.op5);
  final JoystickButton op6 = new JoystickButton(opStick, Constants.op6);
  final JoystickButton op7 = new JoystickButton(opStick, Constants.op7);
  final JoystickButton op8 = new JoystickButton(opStick, Constants.op8);
  final JoystickButton op9 = new JoystickButton(opStick, Constants.op9);
  final JoystickButton op10 = new JoystickButton(opStick, Constants.op10);
  final JoystickButton op11 = new JoystickButton(opStick, Constants.op11);
  final JoystickButton op12 = new JoystickButton(opStick, Constants.op12);
  final JoystickButton op13 = new JoystickButton(opStick, Constants.op13);
  final JoystickButton op14 = new JoystickButton(opStick, Constants.op14);
  final JoystickButton op15 = new JoystickButton(opStick, Constants.op15);
  final JoystickButton op16 = new JoystickButton(opStick, Constants.op16);
  final JoystickButton op17 = new JoystickButton(opStick, Constants.op17);
  final JoystickButton op18 = new JoystickButton(opStick, Constants.op18);
  final JoystickButton op19 = new JoystickButton(opStick, Constants.op19);
  final JoystickButton op20 = new JoystickButton(opStick, Constants.op20);
  final JoystickButton op21 = new JoystickButton(opStick, Constants.op21);
  final JoystickButton op22 = new JoystickButton(opStick, Constants.op22);
  final JoystickButton op23 = new JoystickButton(opStick, Constants.op23);
  final JoystickButton op24 = new JoystickButton(opStick, Constants.op24);
  final JoystickButton op25 = new JoystickButton(opStick, Constants.op25);
  final JoystickButton op26 = new JoystickButton(opStick, Constants.op26);
  final JoystickButton op27 = new JoystickButton(opStick, Constants.op27);
  final JoystickButton op28 = new JoystickButton(opStick, Constants.op28);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drive.setDefaultCommand(JoystickDrive);
    CameraServer.startAutomaticCapture();
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /*
     These commands are place holders for when we have commands
    */
    drA.whileHeld(new IntakeIn(m_intake));
    drB.whileHeld(new UpElevator(m_intake));
    //drX.whenPressed(new TiltShooter(m_tilt));
    drY.whileHeld(new RunShooter(m_shooter));
    drRB.whileHeld(new ParallelCommandGroup( new RunShooter(m_shooter),
        new UpElevator(m_intake)));
    drLB.whileHeld(new IntakeIn(m_intake));

    // Operator commands
    op1.whileHeld(new ShootUp(m_tilt));
    op6.whileHeld(new ShootDn(m_tilt));
    op2.whileHeld(new WinchIn(m_winch));
    op7.whileHeld(new WinchOut(m_winch));
    op3.whileHeld(new ArmForward(m_winch));
    op8.whileHeld(new ArmBack(m_winch));
    //op2.whenPressed(new RunParascope(m_limelight, true));

    //op7.whenPressed( new RunParascope(m_limelight, false));

    //op11.whenPressed(new RunArm(s_arm, Constants.armVertical)); // Arm vertical
    //op12.whenPressed(new RunArm(s_arm, Constants.arm10ft)); // range 10 ft
    //op13.whenPressed(new RunArm(s_arm, Constants.armDown)); // arm down for intake
    //op14.whenPressed(new RunArm(s_arm, Constants.arm15ft)); // range 15 ft
    //op15.whenPressed(new RunArm(s_arm, Constants.armHome));  // Arm inside boundaries
    //op16.whenPressed(new RunArm(s_arm, Constants.arm20ft)); // range 20 ft
    /*op17.whileHeld(new SequentialCommandGroup(new RunArm(s_arm, Constants.armDown),
      new RunIntake(m_intake, 0.75))); */
    //op18.whileHeld(new RunIntake(m_intake, -0.75)); // intake backwards
    //op19.whileHeld(new RunShwoopShooter(m_shoot, 0.8));
    //op19.whileHeld(new RunShwoopShooter(m_shoot));
    //op20.whileHeld(new LimelightAim(m_drive, m_limelight));   // aim robot with limelight
    //op21.whileHeld(new RunShwoopShooter(m_shwoop, m_shoot, 0.9));
    //op22.whenPressed(new IncShoot(m_shoot, 0.03));
    //op23.whenPressed(new IncShoot(m_shoot, -0.03));
    //op24.whenPressed(new StopArm(s_arm));   // arm stops right away
    //op25.whenPressed(new RunArm(s_arm, s_arm.jogPos));
    //op26.whenPressed(new IncArm(s_arm, -4));
    //op27.whenPressed(new IncArm(s_arm, 4));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static double DriverY() {
    return drvStick.getRawAxis(1);
  }

  public static double DriverX() {
    return drvStick.getRawAxis(4);
  }
  /*
  public static double DriverLT() {
    return drvStick.getRawAxis(2);
  }

  public static double DriverRT() {
    return drvStick.getRawAxis(3);
  }

  public static double ArmY() {
    return opStick.getRawAxis(1);
  }
*/
}
