// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Loader extends SubsystemBase {

  Spark Spindexer = new Spark(2); // 2 is the RIO PWM port this is connected to

  
  /** Creates a new Loader. */
  public Loader() {}

  /**
   * Example command factory method.
   * @param SpindexerSpeed
   * @param Loader
   *
   * @return a command
   */
  public CommandBase Load_Ball(Loader Loader, double SpindexerSpeed) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          
          Loader.load(1.0);
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

  public void load(double SpindexerSpeed){
    SmartDashboard.putNumber("SpindexerSpeed", SpindexerSpeed);
    Spindexer.set(SpindexerSpeed); // Control mode?
    
  }
  
}
