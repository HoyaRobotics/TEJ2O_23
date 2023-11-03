// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {


  private final WPI_TalonSRX frontLeftDrive = new WPI_TalonSRX(11);
  private final WPI_TalonSRX rearLeftDrive = new WPI_TalonSRX(13);
  private final WPI_TalonSRX frontRightDrive = new WPI_TalonSRX(10);
  private final WPI_TalonSRX rearRightDrive = new WPI_TalonSRX(12);


  //private final MotorControllerGroup leftGroup = new MotorControllerGroup(frontLeftDrive, rearLeftDrive);
  //private final MotorControllerGroup rightGroup = new MotorControllerGroup(frontRightDrive, rearRightDrive);


  private final DifferentialDrive drive = new DifferentialDrive(frontLeftDrive, frontRightDrive);



  /** Creates a new DriveTrain. */
  public DriveTrain() {
    

    frontLeftDrive.configFactoryDefault();
    rearLeftDrive.configFactoryDefault();
    frontRightDrive.configFactoryDefault();
    rearRightDrive.configFactoryDefault();

    SupplyCurrentLimitConfiguration supplyLimit = new SupplyCurrentLimitConfiguration(true, 50, 60, 1.0);
    frontLeftDrive.configSupplyCurrentLimit(supplyLimit);
    frontRightDrive.configSupplyCurrentLimit(supplyLimit);
    rearLeftDrive.configSupplyCurrentLimit(supplyLimit);
    rearRightDrive.configSupplyCurrentLimit(supplyLimit);

    frontLeftDrive.setNeutralMode(NeutralMode.Brake);
    frontRightDrive.setNeutralMode(NeutralMode.Brake);
    rearLeftDrive.setNeutralMode(NeutralMode.Brake);
    rearRightDrive.setNeutralMode(NeutralMode.Brake);

    rearLeftDrive.follow(frontLeftDrive);
    rearRightDrive.follow(frontRightDrive);

    frontRightDrive.setInverted(true);
    rearRightDrive.setInverted(false);

    drive.setDeadband(0.02);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double throttle, double rotation) {
    //rotation*=-1;

    drive.arcadeDrive(throttle, rotation);
  }

  public void setCoastMode(){
    frontLeftDrive.setNeutralMode(NeutralMode.Coast);
    frontRightDrive.setNeutralMode(NeutralMode.Coast);
    rearLeftDrive.setNeutralMode(NeutralMode.Coast);
    rearRightDrive.setNeutralMode(NeutralMode.Coast);
  }
}