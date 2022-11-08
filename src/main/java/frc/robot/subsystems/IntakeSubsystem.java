// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import org.usfirst.frc.team2910.robot.Robot;
import org.usfirst.frc.team2910.robot.RobotMap;
import org.usfirst.frc.team2910.robot.commands.GathererCommand;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeSubsystem extends SubsystemBase {

  public IntakeSubsystem() {


  }

  public void setLeftArm(Position position) {
    leftSolenoid.set(position == Position.OUT);
  }

  public void setRightArm(Position position) {
    rightSolenoid.set(position == Position.IN);
  }

  public void activateIntake(double out, double rot) {
    intakeDriver.arcadeDrove(out, rot);
  }




}