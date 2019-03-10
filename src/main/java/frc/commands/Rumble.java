/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Rumble extends Command {

  double time;

  public Rumble(double seconds) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    time = seconds;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(time);
    Robot.m_oi.getController().setRumble(RumbleType.kLeftRumble, 1.0);
    Robot.m_oi.getController().setRumble(RumbleType.kRightRumble, 1.0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_oi.getController().setRumble(RumbleType.kLeftRumble, 0.0);
    Robot.m_oi.getController().setRumble(RumbleType.kRightRumble, 0.0);
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
