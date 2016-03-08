package com.weijuly.learn.c2.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.weijuly.learn.c2.music.CompactDisc;
import com.weijuly.learn.c2.music.GirlsGeneration;
import com.weijuly.learn.c2.music.MediaPlayer;
import com.weijuly.learn.c2.music.MusicPlayer;
import com.weijuly.learn.c2.music.SuperJunior;

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
