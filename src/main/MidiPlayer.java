package main;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;

public class MidiPlayer {
	Sequencer sequencer;

	MidiPlayer() throws MidiUnavailableException {
		this.sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
		if (sequencer == null) {
			System.err.println("Sequencer device not supported");
			return;
		}
	}

	public void play(File file) {
		NoteReceiver noteReceiver = new NoteReceiver();
		try {
			this.sequencer.open();
		 // Open device
		// Create sequence, the File must contain MIDI file data.
		Sequence sequence = MidiSystem.getSequence(file);
		Transmitter transmitter = this.sequencer.getTransmitter();
		transmitter.setReceiver(noteReceiver);
		sequencer.setSequence(sequence); // load it into sequencer
		sequencer.start(); // start the playback
		} catch (MidiUnavailableException | InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		}
	}
}
