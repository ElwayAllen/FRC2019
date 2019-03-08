/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.commands.commandgroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
s
public class AutoHatch extends CommandGroup {

  public static final double VELOCITY = 12;

  public AutoHatch() {
    addSequential(new DriveVector(Robot.AutoStep.kIntercept, VELOCITY));
    addSequential(new DriveVector(Robot.AutoStep.kApproach, VELOCITY));
  }
}
