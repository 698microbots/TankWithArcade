// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.driveTrainSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class driveTrainCommand extends Command {
  // create objects
  private driveTrainSubsystem driveTrain = new driveTrainSubsystem();

  private Supplier<Double> speedLeft, speedRight, tSupplier;

  /** Creates a new driveTrainCommand. */
  public driveTrainCommand(Supplier<Double> speedLeft, Supplier<Double> speedRight, Supplier<Double> tSupplier) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.speedLeft = speedLeft;
    this.speedRight = speedRight;
    this.tSupplier = tSupplier;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Double L = speedLeft.get();
    Double R = speedRight.get();

    if(tSupplier.get() >0.4){
      driveTrain.moveRight(Constants.powerAdjustment*(L*0.5+R*Constants.turnAdjustment));
      driveTrain.moveLeft(Constants.powerAdjustment*(L*0.5-R*Constants.turnAdjustment));  
    }else{
      driveTrain.moveRight(Constants.powerAdjustment*(L+R*Constants.turnAdjustment));
      driveTrain.moveLeft(Constants.powerAdjustment*(L-R*Constants.turnAdjustment));  
    }  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
