package frc.team4902.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4902.robot.Ports;
import frc.team4902.robot.HatchOpen;
import frc.team4902.robot.HatchClose;

public class CargoSystem extends Subsystem {
	//Defines Instance of Cargo System
	private static final HatchSystem INSTANCE = new HatchSystem();
	//Defines Cargo Encoder
	public final PWMVictorSPX Motor = new PWMVictorSPX(Ports.CargoMotor.PORT);
	
	@Override
	protected void initDefaultCommand() {}
	
	private CargoSystem() {
		super();
	}

	public static CargoSystem getInstance() {
		return INSTANCE;
	}
	
	public void setSpeed(double speed) {
			Motor.set(speed);
    }
    
    public void open(){
        Motor.set(1.0);
    }

    public void close(){
        Motor.set(-1.0);
    }
}