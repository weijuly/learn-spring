package com.weijuly.learn.c2.music;

import java.util.ArrayList;
import java.util.List;

public class BlankDisc implements CompactDisc {

	private List<String> tracks = new ArrayList<String>();

	public void play() {
		for (String track : tracks) {
			System.out.println("Playing track:" + track);
		}
	}

	public void playTrack(int track) {
		System.out.println("Playing track:" + tracks.get(track));
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

}
