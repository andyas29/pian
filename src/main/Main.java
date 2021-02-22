package main;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;

public class Main {

	public static void main(String[] args) throws MidiUnavailableException {
		NoteReceiver receiver = new NoteReceiver();
		MidiPlayer midiPlayer=new MidiPlayer();
		MidiKeyboard midiKeyboard = new MidiKeyboard();
		midiKeyboard.searchDevices();
		midiKeyboard.selectDevice(5);
		midiKeyboard.selectReceiver(receiver);
		//midiPlayer.play(new File("Undertale - Waterfall.mid"));
	}

}
