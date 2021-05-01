package to_dos.brige.remotes;

import to_dos.brige.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    //TO-DO: Implement the mute() method
    public void mute() {
    	
    	//Display the current volume status is 'mute'
    	System.out.println("Volume: MUTED");
        //Set the volume to 0
    	device.setVolume(0);
        
    }
}
