package frc.team4902.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4902.robot.Ports;
import frc.team4902.robot.commands.CargoCommand;

public class CargoSystem extends Subsystem {
	//Defines Instance of Cargo System
	private static final CargoSystem INSTANCE = new CargoSystem();
	//Defines Cargo Encoder
	public final PWMVictorSPX Motor = new PWMVictorSPX(Ports.CargoMotor.PORT);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CargoCommand());
	}
	
	private CargoSystem() {
		super();
	}

	public static CargoSystem getInstance() {
		return INSTANCE;
	}
	
	public void setSpeed(double speed) {
		Motor.set(speed);
    }
}