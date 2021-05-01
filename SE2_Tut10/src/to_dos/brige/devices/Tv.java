package to_dos.brige.devices;

public class Tv implements Device {
	private boolean on = false;
	private int volume = 30;
	private int channel = 1;

	@Override
	public boolean isEnabled() {
		return on;
	}

	@Override
	public void enable() {
		on = true;
	}

	@Override
	public void disable() {
		on = false;
	}

	// TO-DO: Implement getVolume() method
	@Override
	public int getVolume() {
		return volume;
	}

	// TO-DO: Implement setVolume() method
	@Override
	public void setVolume(int volume) {
		// use 'if-elseif-else' structure to limit the volume from 0 to 100
		// outside the range is invalid
		if (volume < 0 || volume > 100) {
			return;
		}
		this.volume = volume;

	}

	// TO-DO: Implement getChannel() method
	@Override
	public int getChannel() {
		return channel;
	}

	// TO-DO: Implement setChannel() method
	@Override
	public void setChannel(int channel) {
		if (channel < 1) {
			return;
		}
		this.channel = channel;
	}

	@Override
	public void printStatus() {
		// Show the current device is radio
		System.out.println("Device: " + getClass().getSimpleName().toUpperCase());
		// Show the current status: enabled or disabled
		System.out.println("Status: " + (on ? "enabled" : "disabled"));
		// Show the current volume
		System.out.println("Volume: " + volume);
		// Show the current channel
		System.out.println("Channel # " + channel);
	}
}