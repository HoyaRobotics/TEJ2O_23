// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {

  CANSparkMax Intake_Motor = new CANSparkMax(IntakeConstants.Intake_Motor, MotorType.kBrushless); // 2 is the RIO PWM port this is connected to
  private double voltage;
  
  /** Creates a new Intake. */
  public Intake() {
    REVPhysicsSim.getInstance().addSparkMax(Intake_Motor, DCMotor.getNEO(1));
    voltage = 12.0;
  }

  /**
   * Example command factory method.
   * @param SpindexerSpeed
   * @param Intake
   *
   * @return a command
   */
  public CommandBase Run_Intake(Intake Intake, double IntakeSpeed) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          
          
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

  public void intake(double IntakeSpeed){
    SmartDashboard.putNumber("Intake Speed", IntakeSpeed);
    Intake_Motor.setVoltage(voltage);
    Intake_Motor.set(IntakeSpeed); // Control mode?
    
    REVPhysicsSim.getInstance().run();
  }

}
