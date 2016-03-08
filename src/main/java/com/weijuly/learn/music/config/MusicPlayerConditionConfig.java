package com.weijuly.learn.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.weijuly.learn.music.CompactDisc;
import com.weijuly.learn.music.GirlsGeneration;
import com.weijuly.learn.music.MediaPlayer;
import com.weijuly.learn.music.MusicPlayer;
import com.weijuly.learn.music.SuperJunior;

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
