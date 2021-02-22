package main;

import javax.sound.midi.*;
public class NoteReceiver implements Receiver {

	@Override
	public void send(MidiMessage message, long timeStamp) {
		if(message instanceof ShortMessage) {
	        ShortMessage sm = (ShortMessage) message;
	        int channel = sm.getChannel();

	        if (sm.getCommand() == sm.NOTE_ON) {

	            int key = sm.getData1();
	            int velocity = sm.getData2();
	            Note note = new Note(key);
	            System.out.println( note + " Velocity:" + velocity);

	        } else if (sm.getCommand() == sm.NOTE_OFF) {

	            int key = sm.getData1();
	            int velocity = sm.getData2();
	            Note note = new Note(key);
	            System.out.println( note + " Velocity:" + velocity);
	        } else {
	            //System.out.println("Command:" + sm.getCommand());
	        }
	    }
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
