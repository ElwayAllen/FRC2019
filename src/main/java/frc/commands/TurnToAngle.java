/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnToAngle extends Command {

  double degrees; //placeholder value that will be updated in the future
  Robot.AutoStep step = null;
  
  public TurnToAngle(double angle) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.kDriveTrain);
    degrees = angle;
  }

  public TurnToAngle(Robot.AutoStep a) {
    requires(Robot.kDriveTrain);
    step = a;
    degrees = 180.0; // should be reset later in initialize
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (step != null) {
      switch(step) {
        case kApproach:
          degrees = Robot.getCurrentRoute().getNormalVec().getTheta();
          break;
        default:
        case kIntercept:
          degrees = Robot.getCurrentRoute().getInterceptVec().getTheta();
          break;
      }
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.kDriveTrain.turnToAngle(degrees);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.kDriveTrain.isTurnToAngleFinished();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.kDriveTrain.disableTurnController();
    Robot.kDriveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
