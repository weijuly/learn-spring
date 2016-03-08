package com.weijuly.learn.c2.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.weijuly.learn.c2.music.CompactDisc;
import com.weijuly.learn.c2.music.GirlsGeneration;
import com.weijuly.learn.c2.music.MediaPlayer;
import com.weijuly.learn.c2.music.MusicPlayer;
import com.weijuly.learn.c2.music.SuperJunior;

@Configuration
public class MusicPlayerConditionConfig {

    @Bean
    public MediaPlayer player() {
	return new MusicPlayer();
    }

    @Bean
    @Conditional(EnvironmentCheck.class)
    public CompactDisc snsd() {
	return new GirlsGeneration();
    }

    @Bean
    public CompactDisc suju() {
	return new SuperJunior();
    }
}
