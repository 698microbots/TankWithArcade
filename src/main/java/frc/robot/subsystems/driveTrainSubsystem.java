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
  public driveTrainSubsystem() {
  
  private double velocity;

  //PIDturn variables
  private double turnTarget;
  private double turnError;
  private double turnPrevError;
  private double turnP;
  private double turnI;
  private double turnD;
  private double turnOutput;
  private double turnPrevOutput;
  

  //PIDdrive variables
  private double driveTarget;
  private double driveError;
  private double drivePrevError;
  private double driveP;
  private double driveI;
  private double driveD;
  private double driveOutput;
  private double potDriveOutput;
  private double drivePrevOutput;

  //BalancePID variables
  private double balanceTarget;
  private double balanceError;
  private double balancePrevError;
  private double balanceP;
  private double balanceI;
  private double balanceD;
  private double balanceOutput;

  }

  public void setRightSpeed(double speed){
    front_right.set(ControlMode.PercentOutput, speed);
    back_right.set(ControlMode.PercentOutput, speed);
  }
  public void setLeftSpeed(double speed){
    front_left.set(ControlMode.PercentOutput, speed);
    back_left.set(ControlMode.PercentOutput, speed);
  }

  // PIDs reset
  public void resetDrivePID(){
    driveTarget = 0;
    driveError = 0;
    drivePrevError = 0;
    driveP = 0;
    driveI = 0;
    driveD = 0;
    driveOutput = 0;
    potDriveOutput = 0;
    drivePrevOutput = 0;
  }

  public void resetTurnPID(){
    turnTarget = 0;
    turnError = 0;
    turnPrevError = 0;
    turnP = 0;
    turnI = 0;
    turnD = 0;
    turnOutput = 0;
  }

  //takes in sensor input to turn robot into the correct angle
  public void PIDturn(double sensorInput){
    turnError = turnTarget - sensorInput;
    turnP = turnError;
    turnD = turnError - turnPrevError;

    turnOutput = Constants.turnkP*turnP + Constants.turnkI*turnI + Constants.turnkD*turnD;
    turnPrevError = turnError;
    turnPrevOutput = turnOutput;

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
