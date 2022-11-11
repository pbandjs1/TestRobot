// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.WPI_AutoFeedEnable;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import javax.swing.text.Position;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static frc.robot.Constants.*;


public class IntakeSubsystem extends SubsystemBase {
  public static enum Position {
    OUT,
    IN
  }

  private TalonSRX leftIntake = new TalonSRX(INTAKE_LEFT_MOTOR);
  private TalonSRX rightIntake = new TalonSRX(INTAKE_RIGHT_MOTOR);

  private Solenoid rightSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, LEFT_SOLENOID);
  private Solenoid leftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, RIGHT_SOLENOID);

  private double intakeSpeed = 0.0;

  public IntakeSubsystem() {


    // right side is inverted
    rightIntake.setInverted(true);
    leftIntake.setInverted(false);
  }

  @Override
  public void periodic() {
    rightIntake.set(TalonSRXControlMode.PercentOutput, intakeSpeed);
    leftIntake.set(TalonSRXControlMode.PercentOutput, intakeSpeed);
  }

  public void setLeftArm(Position position) {
    leftSolenoid.set(position == Position.OUT);
  }

  public void setRightArm(Position position) {
    rightSolenoid.set(position == Position.IN);
  }

  public void setIntakeSpeed(double intakeSpeed) {
    this.intakeSpeed = intakeSpeed;
  }



}