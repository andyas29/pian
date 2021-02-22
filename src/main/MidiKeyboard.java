package main;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

public class MidiKeyboard {
	MidiDevice device;
	MidiDevice.Info[] infos;
	Transmitter transmitter;

	public void selectDevice(int index) throws MidiUnavailableException {
		this.device = MidiSystem.getMidiDevice(infos[index]);
		transmitter = this.device.getTransmitter();
	}
	public void selectReceiver(Receiver receiver) throws MidiUnavailableException {
		transmitter.setReceiver(receiver);
		device.open();
	}
	public void searchDevices() throws MidiUnavailableException {
		this.infos = MidiSystem.getMidiDeviceInfo();
		for (int i = 0; i < this.infos.length; i++) {
			// does the device have any transmitters?
			// if it does, add it to the device list
			System.out.println(this.infos[i].toString() + " [" + i + "]");
		}
	}
}