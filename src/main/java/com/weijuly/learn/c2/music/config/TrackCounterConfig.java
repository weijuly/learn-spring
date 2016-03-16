package com.weijuly.learn.c2.music.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.weijuly.learn.c2.music.BlankDisc;
import com.weijuly.learn.c2.music.CompactDisc;
import com.weijuly.learn.c2.music.TrackCounter;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {
	@Bean
	public CompactDisc cd() {
		BlankDisc disc = new BlankDisc();
		List<String> tracks = new ArrayList<String>();
		tracks.add("Lingua Franca");
		tracks.add("Kissing You");
		tracks.add("Gee");
		tracks.add("I Got A Boy");
		tracks.add("Mr Mr");
		disc.setTracks(tracks);
		return disc;
	}

	@Bean
	public TrackCounter counter() {
		return new TrackCounter();
	}

}
