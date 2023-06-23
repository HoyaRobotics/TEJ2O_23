// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  Spark frontShooter = new Spark(0); // 2 is the RIO PWM port this is connected to
  Spark backShooter = new Spark(1); // 3 is the RIO PWM port this is connected to
  
  /** Creates a new Shooter. */
  public Shooter() {
    backShooter.setInverted(true);
  }

  /**
   * Example command factory method.
   * @param shooterSpeed
   * @param shooter
   *
   * @return a command
   */
  public CommandBase Shoot_Ball(Shooter shooter, double FrontshooterSpeed, double BackshooterSpeed) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          
          shooter.shoot(2.0, 2.0);
        });
  }



  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

    
  }

  public void shoot(double FrontshooterSpeed, double BackshooterSpeed){
    SmartDashboard.putNumber("ShooterSpeed", FrontshooterSpeed);
    frontShooter.set(FrontshooterSpeed); // Control mode?
    backShooter.set(BackshooterSpeed); // Control mode?
  }
  
}
