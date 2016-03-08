package com.weijuly.learn.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.weijuly.learn.music.CompactDisc;
import com.weijuly.learn.music.GirlsGeneration;
import com.weijuly.learn.music.MediaPlayer;
import com.weijuly.learn.music.MusicPlayer;
import com.weijuly.learn.music.SuperJunior;

@Configuration
public class MusicPlayerConfig {

    @Bean
    @Profile("dev")
    public CompactDisc snsd() {
	return new GirlsGeneration();
    }

    @Bean
    @Profile("prod")
    public CompactDisc suju() {
	return new SuperJunior();
    }

    @Bean
    public MediaPlayer player() {
	return new MusicPlayer();
    }
}
