package frc.team4902.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4902.robot.Input;
import frc.team4902.robot.subsystems.CargoSystem;
import frc.team4902.robot.subsystems.DriveSystem;

public class CargoCommand extends Command {

    public CargoCommand() {
		  requires(DriveSystem.getInstance());
    }
    
    @Override
    protected void execute() {
      if (Input.primaryXBox.isPluggedIn()) {
          CargoSystem.getInstance().setSpeed(Input.primaryXBox.getLeftTrigger() - Input.primaryXBox.getRightTrigger());
      } 
    }

    @Override
	  protected boolean isFinished() {
	    return false;
	  }
}