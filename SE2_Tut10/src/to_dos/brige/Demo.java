package to_dos.brige;

import to_dos.brige.devices.Device;
import to_dos.brige.devices.Radio;
import to_dos.brige.devices.Tv;
import to_dos.brige.remotes.AdvancedRemote;
import to_dos.brige.remotes.BasicRemote;

public class Demo {
	public static void main(String[] args) {
		testDevice(new Tv());
		testDevice(new Radio());
	}

	//TO-DO: Implement the method testDevice()
	public static void testDevice(Device device) {
		System.out.println("Tests with basic remote.");
		//Create the new BasicRemote instance
		BasicRemote remote = new BasicRemote(device);
		//Power on the device
		 remote.power();
		//Display the status of device
		 device.printStatus();
		 remote.power();

		System.out.println("Tests with advanced remote.");
		//Create the new AdvancedRemote instance
		AdvancedRemote advancedRemote = new AdvancedRemote(device);
		//Power on the device
		advancedRemote.power();
		//Mute the device
		 advancedRemote.mute();
		//Display the status of device
		device.printStatus();		 
	}
}
