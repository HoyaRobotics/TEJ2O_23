// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Drive_With_Joystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain driveTrain;
  DoubleSupplier throttle;
  DoubleSupplier rotation;

  /**
   * Creates a new Drive_With_Joystick.
   *
   * @param subsystem Drive Train.
   */
  public Drive_With_Joystick(DriveTrain subsystem, DoubleSupplier rotation, DoubleSupplier throttle) {
    this.driveTrain = subsystem;
    this.throttle = throttle;
    this.rotation = rotation;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called every time the scheduler runs while the command is scheduled
  public void execute(){
    driveTrain.arcadeDrive(applyDriveDeadband(throttle.getAsDouble()), applyDriveDeadband(rotation.getAsDouble()));
  }
  
  // Called once the command ends or is interrupted
  public void end(boolean interrupted){
    driveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public double applyDriveDeadband(double value){

    if (value < 0.01){
      if(value < -0.01){
        return value;
      }
      else {
        return 0.0;
      }
    } else{
      return value;
    }
  }
}
