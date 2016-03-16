package com.weijuly.learn.c2.music;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {

	private Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

	@Pointcut("execution(* com.weijuly.learn.c2.music.CompactDisc.playTrack(int)) && args(track)")
	public void playTrack(int track) {
	}

	@Before("playTrack(track)")
	public void count(int track) {
		System.out.println("Aspect: playing track:" + track);
		int count = getCount(track);
		counts.put(track, count + 1);
	}

	public int getCount(int track) {
		if (counts.containsKey(track)) {
			return counts.get(track);
		}
		return 0;
	}

}
