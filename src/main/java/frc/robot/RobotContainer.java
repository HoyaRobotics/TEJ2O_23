// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Increase_Speed;
import frc.robot.subsystems.ExampleSubsystem;

import frc.robot.subsystems.Intake;
import frc.robot.commands.Run_Intake;
import frc.robot.commands.Reverse_Intake;

import frc.robot.subsystems.Loader;
import frc.robot.commands.Load_Ball;

import frc.robot.subsystems.Shooter;
import frc.robot.commands.Shoot_Ball;
import frc.robot.commands.Reverse_Shoot_Ball;

import frc.robot.commands.Drive_With_Joystick;
import frc.robot.subsystems.DriveTrain;

import frc.robot.commands.Load_and_Shoot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain driveTrain = new DriveTrain();
  private final Shooter shooter = new Shooter();
  private final Loader loader = new Loader();
  private final Intake intake = new Intake();
  

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public final CommandXboxController driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

  driveTrain.setDefaultCommand(new Drive_With_Joystick(
      driveTrain,
      () -> -driverController.getLeftX(),
      () -> -driverController.getLeftY()));

    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
  

    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    driverController.a().whileTrue(m_exampleSubsystem.exampleMethodCommand());




    
    // Schedule `Shoot_Ball` when the Xbox controller's Left Trigger button is pressed, cancelling on release.
    driverController.y().whileTrue(new Load_and_Shoot(shooter,loader, 0.25, 0.25, 0.25));
    driverController.b().whileTrue(new Shoot_Ball(shooter, 0.4, 0.5));
    driverController.x().whileTrue(new Reverse_Shoot_Ball(shooter, -0.4, -0.5));
    driverController.rightTrigger().whileTrue(new Load_Ball(loader, 0.25));
    driverController.leftTrigger().whileTrue(new Load_Ball(loader, -0.25));
    driverController.rightBumper().whileTrue(new Run_Intake(intake, 0.25));
    driverController.leftBumper().whileTrue(new Reverse_Intake(intake, -0.25));
    driverController.povUp().whileTrue(new Increase_Speed(shooter, 0.1, 0.1));
    // Ask Soph about controller bindings for the shooter
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
