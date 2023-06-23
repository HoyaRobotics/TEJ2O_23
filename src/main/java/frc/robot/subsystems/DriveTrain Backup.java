/**
 * Made for Back Up purposes (uses SPARKs)
 * 
 * 
 * 
 * // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  Spark leftDrive = new Spark(0); // 0 is the RIO PWM port this is connected to
  Spark rightDrive = new Spark(0); // 0 is the RIO PWM port this is connected to
  
  DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);

  public static double acceleration = 0.0;

  // Creates a new DriveTrain. 
  public DriveTrain() {
    
    
    rightDrive.setInverted(true);

  }

  
   Example command factory method.
   
   @return a command
   
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> { one-time action goes here 
        });
  }



  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   
  public boolean DriveCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

public void arcadeDrive(double throttle, double rotation){
  // This method is called inorder to make the robot actually drive
  SmartDashboard.putNumber("Rotation", rotation);
  SmartDashboard.putNumber("Throttle", throttle);

  //drive.arcadeDrive is an import for the differential drive that actually makes the robot drive
  drive.arcadeDrive(throttle, rotation);
}

 */
