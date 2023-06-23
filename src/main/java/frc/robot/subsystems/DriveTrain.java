// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
//import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveBaseConstants;

public class DriveTrain extends SubsystemBase {

  CANSparkMax leftDrive = new CANSparkMax(DriveBaseConstants.leftDriveMotor, MotorType.kBrushless);
  CANSparkMax rightDrive = new CANSparkMax(DriveBaseConstants.rightDriveMotor, MotorType.kBrushless);
  private double voltage;
  DifferentialDrive drive = new DifferentialDrive(leftDrive, rightDrive);

  public static double acceleration = 0.0;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    
    rightDrive.setInverted(true);
    REVPhysicsSim.getInstance().addSparkMax(leftDrive, DCMotor.getNEO(1));
    REVPhysicsSim.getInstance().addSparkMax(rightDrive, DCMotor.getNEO(1));
    voltage = 0.0;
    System.out.print("in Drivetrain constructor");
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }



  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
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
    leftDrive.setVoltage(voltage);
    rightDrive.setVoltage(voltage);
    REVPhysicsSim.getInstance().run();
//    System.out.println("****************************\n\n\n\n in SimulationPeriodic \n\n\n\n");
  }

public void arcadeDrive(double throttle, double rotation){
  // This method is called inorder to make the robot actually drive
  SmartDashboard.putNumber("Rotation", rotation);
  SmartDashboard.putNumber("Throttle", throttle);

  //drive.arcadeDrive is an import for the differential drive that actually makes the robot drive
  drive.arcadeDrive(throttle, rotation);
  voltage = throttle;
  REVPhysicsSim.getInstance().run();
 // drive.arcadeDrive(0.5, 0.5);
}

public double applyDriveDeadband(double value){

  if (value < 0.01){
    if(value < -0.01){
      return value;
    }
    else {
      acceleration = 0.0;
      return 0.0;

    }
  } else{
    return value;
  }
}

}
