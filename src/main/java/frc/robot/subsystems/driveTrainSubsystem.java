// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrainSubsystem extends SubsystemBase {

  // create the motor objects
  VictorSP front_left = new VictorSP(Constants.front_leftID);
  VictorSP front_right = new VictorSP(Constants.front_rightID);
  VictorSP back_left = new VictorSP(Constants.back_leftID);
  VictorSP back_right = new VictorSP(Constants.back_rightID);

  /** Creates a new driveTrainSubsystem. */
  public driveTrainSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
