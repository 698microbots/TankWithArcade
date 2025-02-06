// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new DriveTrainSubsystem. */
  // intiliaize four motors talonfx
  private VictorSPX frontLeft = new VictorSPX(Constants.frontLeftID);
  private VictorSPX backLeft = new VictorSPX(Constants.backLeftID);
  private VictorSPX frontRight = new VictorSPX(Constants.frontRightID);
  private VictorSPX backRight = new VictorSPX(Constants.backRightID);

  public DriveTrainSubsystem() {
  }

  // create a method called move left that sets speed to motor
  public void moveLeft(double speed) {
    frontLeft.set(VictorSPXControlMode.PercentOutput, speed);
    backLeft.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void moveRight(double speed) {
    frontRight.set(VictorSPXControlMode.PercentOutput, speed);
    backRight.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void setMotorLocked() {
    frontLeft.setNeutralMode(NeutralMode.Brake);
    backLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    backRight.setNeutralMode(NeutralMode.Brake);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
