// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.driveTrainSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveTrainCommand extends Command {
  /** Creates a new DriveTrainCommand. */
private driveTrainSubsystem driveTrain;
private Supplier<Double> leftSpeed, rightSpeed, tSupplier ;
  
public DriveTrainCommand(Supplier<Double> tSupplier, Supplier<Double> leftSpeed, Supplier<Double> rightSpeed, DriveTrainSubsystem driveTrain) {
    this.leftSpeed = leftSpeed;
    this.tSupplier = tSupplier;
    this.rightSpeed = rightSpeed;
    this.driveTrain = driveTrain;
    addRequirements(driveTrain);
  }
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Double L = leftSpeed.get();
    Double R = rightSpeed.get();
   
    if(tSupplier.get() >0.4){
      driveTrain.moveRight(Constants.powerAdjusment*(L*0.5+R*Constants.turnAdjustments));
      driveTrain.moveLeft(Constants.powerAdjusment*(L*0.5-R*Constants.turnAdjustments));    
    }else{
      driveTrain.moveRight(Constants.powerAdjusment*(L+R*Constants.turnAdjustments));
      driveTrain.moveLeft(Constants.powerAdjusment*(L-R*Constants.turnAdjustments));    
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.moveRight(0);
    driveTrain.moveLeft(0);
    driveTrain.setMotorLocked();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
