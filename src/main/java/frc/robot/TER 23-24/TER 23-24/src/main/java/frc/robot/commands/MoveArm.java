// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {
  public final Arm arm;
  public final double angle;
  public boolean isExtended;
  public final double newP;
  public boolean direction;
  /** Creates a new MoveArm. */
  public MoveArm(Arm arm, double angle, double newP, boolean direction) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.arm = arm;
    this.angle = angle;
    this.direction = direction;
    this.isExtended = false;
    this.newP = newP;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.arm.setP(newP);
    this.arm.setArmAnglePID(angle);
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //check if direction is false AND encoder < 6
    //set p to 0.05
  if(!direction && this.arm.getIntakeEncoder() > 7){
      this.arm.setP(0.65);
  }else if(!direction && this.arm.getIntakeEncoder() < 7){
      this.arm.setP(0.03);
    }else{
      return;
    }

    /*if(!isExtended && this.arm.getIntakeEncoder() < 9){
      arm.armSpeed(0.25, 0.25);
      System.out.println("TESTSTARTED");
    } else if(!isExtended && this.arm.getIntakeEncoder() >= 9){
      isExtended = true;
      arm.armSpeed(0.0, 0.0);
      System.out.println("TESTFINISHED");
    }*/ //Works but no PID control so kinda useless



    /*if(!isExtended && this.arm.getIntakeEncoder()< 10){
      arm.armSpeed(0.3, 0.3);
      if(this.arm.getIntakeEncoder() > 10){
      this.isExtended = true;
      }
    }else if(isExtended && this.arm.getIntakeEncoder() > 1){
      arm.armSpeed(-0.3, -0.3);
      if(this.arm.getIntakeEncoder() < 1){
      this.isExtended = false;
      }
    }else{
      arm.armSpeed(0.0, 0.0);

    }*/
  
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
       if(arm.isArmInPosition(angle)) {
      return true;
    }else{
      return false;
    }
}
}

