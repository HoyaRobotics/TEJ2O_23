// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {
  public final Arm arm;
  /** Creates a new MoveArm. */
  public MoveArm(Arm arm) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.arm = arm;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.arm.setArmAnglePID(0);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  arm.armSpeed(0.3, 0.3);

  if(arm.armInPosition(8)){
    arm.armSpeed(0.0, 0.0);
  }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(arm.armInPosition(11)){
      return true;
    }
   else{
    return false; 
  }
  }
}

