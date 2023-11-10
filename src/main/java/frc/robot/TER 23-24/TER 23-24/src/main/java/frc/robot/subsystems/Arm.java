// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  CANSparkMax armLeft = new CANSparkMax(15, MotorType.kBrushless);
  SparkMaxPIDController leftArmPID;
  CANSparkMax armRight = new CANSparkMax(14, MotorType.kBrushless);
  SparkMaxPIDController rightArmPID;
  /** Creates a new Arm. */
  public Arm() {
  
  


    armLeft.restoreFactoryDefaults();
    //^^This line was not working, it was because you were using an outdated REV library for your code
    //And so the method it was trying to run did not exist in the library it was looking through
    armLeft.setIdleMode(IdleMode.kCoast);
    armLeft.setSmartCurrentLimit(35);
    armLeft.setInverted(true);
    armLeft.enableVoltageCompensation(10.5);
    armLeft.setOpenLoopRampRate(0.1);
    armLeft.setClosedLoopRampRate(0.1);
    armLeft.getEncoder().setPosition(0);

    leftArmPID = armLeft.getPIDController();
    leftArmPID.setP(0.05);

    armRight.restoreFactoryDefaults();
    armRight.setIdleMode(IdleMode.kCoast);
    armRight.setSmartCurrentLimit(35);
    armRight.setInverted(false);
    armRight.enableVoltageCompensation(10.5);
    armRight.setOpenLoopRampRate(0.1);
    armRight.setClosedLoopRampRate(0.1);
    armRight.getEncoder().setPosition(0);

    rightArmPID = armRight.getPIDController();
    rightArmPID.setP(0.05);


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
  public void setArmAnglePID(double angle) {
  leftArmPID.setReference(angle, CANSparkMax.ControlType.kPosition, 0);
  rightArmPID.setReference(angle, CANSparkMax.ControlType.kPosition, 0);

  }

  public boolean armInPosition(double armAngle){
    if(armAngle <= armLeft.getEncoder().getPosition()+1 || armAngle >= armLeft.getEncoder().getPosition()-1){
      return true;
    } else {
      return false;
    }
  }

  public double getIntakeEncoder() {
    return armLeft.getEncoder().getPosition();
  }

public boolean isArmInPosition(double position) {
  if(position <= armLeft.getEncoder().getPosition()+1 && position >= armLeft.getEncoder().getPosition()-1) {
      return true;
    }else{
      return false;
    }
  }

  public void setP(double newP){
    leftArmPID.setP(newP);
    rightArmPID.setP(newP);

  }
}
