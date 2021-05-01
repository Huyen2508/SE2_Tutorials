package to_dos.brige.remotes;

import to_dos.brige.devices.Device;

public class BasicRemote implements Remote {
	protected Device device;

	public BasicRemote() {
	}

	public BasicRemote(Device device) {
		this.device = device;
	}

	@Override
	public void power() {
		System.out.println("Remote: power toggle");
		if (device.isEnabled()) {
			device.disable();
		} else {
			device.enable();
		}
	}

	//TO-DO: Implement the volumeDown() method
	@Override
	public void volumeDown() {
		//Display the current status is 'volume down'
        System.out.println("VOLUMING DOWN!");
        //Decrease the current volume for 10
		int currentVol = device.getVolume();
		if (currentVol <=0) {
			return;
		}
		device.setVolume(currentVol - 10); 
	}

	//TO-DO: Implement the volumeUp() method
	@Override
	public void volumeUp() {
		//Display the current status is 'volume up'
        System.out.println("VOLUMING UP!");
        //Increase the current volume for 10
		int currentVol = device.getVolume();
		if (currentVol >=100) { 
			return;
		}
		device.setVolume(currentVol + 10); 
	}

	//TO-DO: Implement the channelDown() method
	@Override
	public void channelDown() {
		//Display the current status is 'channel down'
        System.out.println("CHANNELING DOWN!");
        //Decrease the current channel for 1
        int currentChannel = device.getChannel();
        if (currentChannel < 1) {
        	return;
        }
        device.setChannel(currentChannel - 1);
	}
	
	//TO-DO: Implement the channelUp() method
	@Override
	public void channelUp() {
		//Display the current status is 'channel up'
        System.out.println("CHANNELING UP");
        //Increase the current channel for 1
        device.setChannel(device.getChannel() + 1);
	}
}
