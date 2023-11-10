// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  WPI_TalonSRX topRoller = new WPI_TalonSRX(16);
  WPI_TalonSRX bottomRoller = new WPI_TalonSRX(17);

  /** Creates a new Intake. */
  public Intake() {
    topRoller.configFactoryDefault();
    bottomRoller.configFactoryDefault();
    
    SupplyCurrentLimitConfiguration supplyLimit = new SupplyCurrentLimitConfiguration(true, 50, 60, 1.0);
    topRoller.configSupplyCurrentLimit(supplyLimit);
    bottomRoller.configSupplyCurrentLimit(supplyLimit);



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setIntakeSpeed(double speed){
    topRoller.set(-speed);
    bottomRoller.set(speed);
  }
}
