package frc.team4902.robot;

//Specifies the ports that motor groups are plugged into on the roborio

public enum Ports {

	DriveTrainLeftSide(0), DriveTrainRightSide(9), //Ports for both sides of robot

	HatchMotor(8), CargoMotor(3); //Ports for the motors that run the Hatch and Cargo systems

	public final int PORT;
	
	private Ports(int p) {
		this.PORT = p;
	}
	
}
