// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveTrainSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class JoystickDrive extends Command {
  /** Creates a new JoystickDrive. */
  private driveTrainSubsystem drivetrain;
  private Supplier<Double> x_axis, y_axis, z_axis;
  private double X, Y, Z;

  public JoystickDrive(driveTrainSubsystem drivetrain, Supplier<Double> x_axis, Supplier<Double> y_axis, Supplier<Double> z_axis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this. x_axis = x_axis;
    this.y_axis = y_axis;
    this.z_axis = z_axis;
    this.X = 0;
    this.Y = 0;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    X =  x_axis.get();
    Y = y_axis.get();
    Z = -z_axis.get();
    if(Z>0){
      drivetrain.setRightSpeed((Y + X/3)*Z);
      drivetrain.setLeftSpeed((Y-X/3)*Z);  
    }
    if(Z<0){
      drivetrain.setRightSpeed((Y-X/2)*Z);
      drivetrain.setLeftSpeed((Y+X/2)*Z);
    }
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
