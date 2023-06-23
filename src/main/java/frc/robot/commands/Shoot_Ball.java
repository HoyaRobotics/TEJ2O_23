// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Shoot_Ball extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  Shooter shooter;
  double FrontshooterSpeed;
  double BackshooterSpeed;
  /**
   * Creates a new Shoot_Ball
   *.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Shoot_Ball(Shooter subsystem, double FrontshooterSpeed, double BackshooterSpeed) {
    this.shooter = subsystem;
    this.FrontshooterSpeed = FrontshooterSpeed;
    this.BackshooterSpeed = BackshooterSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

   // Called when the command is initially scheduled.
   @Override
   public void initialize() {
     shooter.shoot(FrontshooterSpeed, BackshooterSpeed);
 
   }
 
   // Called every time the scheduler runs while the command is scheduled.
   @Override
   public void execute() {
    
   }
 
   // Called once the command ends or is interrupted.
   @Override
   public void end(boolean interrupted) {
     shooter.shoot(0.0, 0.0);
   }
 
   // Returns true when the command should end.
   @Override
   public boolean isFinished() {
     
     return false;
   }
}
