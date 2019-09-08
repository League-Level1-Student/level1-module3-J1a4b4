package _03_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	JFrame frame;
	JPanel panel;
	JButton buttonI;
	JButton buttonII;
	JButton buttonIII;
	JButton buttonIV;
	
	Song theRun = new Song("TheRun.mp3");
	Song vibraphone = new Song("Vibraphone.mp3");
	Song guitar = new Song("GuitarMusic.mp3");
	Song expressions = new Song("ExpressionsOfTheMind.mp3");
	
    public void run() {
		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3

		// 3. Play the Song

		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
    	frame = new JFrame();
    	panel = new JPanel();
    	buttonI = new JButton();
    	buttonII = new JButton();
    	buttonIII = new JButton();
    	buttonIV = new JButton();
    	panel.add(buttonI);
    	panel.add(buttonII);
    	panel.add(buttonIII);
    	panel.add(buttonIV);
    	frame.add(panel);
    	buttonI.addActionListener(this);
    	buttonII.addActionListener(this);
    	buttonIII.addActionListener(this);
    	buttonIV.addActionListener(this);
    	buttonI.setSize(50, 50);
    	buttonI.setText("The Run");
    	buttonII.setSize(50, 50);
    	buttonII.setText("Vibraphone");
    	buttonIII.setSize(50, 50);
    	buttonIII.setText("Guitar Music");
    	buttonIV.setSize(50, 50);
    	buttonIV.setText("Expressions of the Mind");
    	frame.setVisible(true);
    	frame.pack();
    }
    
    
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource();
		if (buttonClicked == buttonI) {
			vibraphone.stop();
			expressions.stop();
			guitar.stop();
			theRun.play();
		}else if (buttonClicked == buttonII) {
			guitar.stop();
			expressions.stop();
			theRun.stop();
			vibraphone.play();
		}else if (buttonClicked == buttonIII) {
			expressions.stop();
			theRun.stop();
			vibraphone.stop();
			guitar.play();
		}else if (buttonClicked == buttonIV) {
			guitar.stop();
			theRun.stop();
			vibraphone.stop();
			expressions.play();
		}
		
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

