// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  CANSparkMax armLeft;
  CANSparkMax armRight;
  /** Creates a new Arm. */
  public Arm() {
  
    this.armLeft = new CANSparkMax(15, MotorType.kBrushless);
    this.armLeft.restoreFactoryDefaults();
    //^^This line was not working, it was because you were using an outdated REV library for your code
    //And so the method it was trying to run did not exist in the library it was looking through
    armLeft.setIdleMode(IdleMode.kCoast);
    armLeft.setSmartCurrentLimit(30);
    armLeft.setInverted(true);
    armLeft.enableVoltageCompensation(10);
    armLeft.setOpenLoopRampRate(0.1);
    armLeft.setClosedLoopRampRate(0.1);
    armLeft.getEncoder().setPosition(0);
    this.armRight = new CANSparkMax(14, MotorType.kBrushless);
  armRight.restoreFactoryDefaults();
    armRight.setIdleMode(IdleMode.kCoast);
    armRight.setSmartCurrentLimit(30);
    armRight.setInverted(true);
    armRight.enableVoltageCompensation(10);
    armRight.setOpenLoopRampRate(0.1);
    armRight.setClosedLoopRampRate(0.1);
    armRight.getEncoder().setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("IntakeEncoder", getIntakeEncoder());

    //Rest postiion is 0
    //Extended position is 11
  }
  public void armSpeed(double leftSpeed, double rightSpeed) {
    armLeft.set(leftSpeed);
    armRight.set(rightSpeed);
  }
  public void armStop() {
    armLeft.stopMotor();
    armRight.stopMotor();
  }
  public double getIntakeEncoder() {
    return armLeft.getEncoder().getPosition();
  }
}
