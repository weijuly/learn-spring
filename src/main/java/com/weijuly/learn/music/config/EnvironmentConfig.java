package com.weijuly.learn.music.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.weijuly.learn.music.CompactDisc;
import com.weijuly.learn.music.GirlsGeneration;
import com.weijuly.learn.music.MediaPlayer;
import com.weijuly.learn.music.MusicPlayer;
import com.weijuly.learn.music.SuperJunior;
/**
 * Akin to conditional configuration, except that the values are decided by an 
 * outside properties file
 *
 */
@Configuration
@PropertySource("classpath:environment.properties")
public class EnvironmentConfig {

    @Autowired
    Environment env;

    @Bean
    public CompactDisc album() {
	if (env.getProperty("music.album").equals("snsd")) {
	    return new GirlsGeneration();
	} else {
	    return new SuperJunior();
	}
    }

    @Bean
    public MediaPlayer player() {
	return new MusicPlayer();
    }
}
