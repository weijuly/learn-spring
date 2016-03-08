package com.weijuly.learn.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * An unnamed bean, and will be injected by spring when asked for a 
 * MusicPlayer bean
 *
 */
@Component
public class MusicPlayer implements MediaPlayer {
    
    @Autowired
    private CompactDisc cd;

    public void play(){
	cd.play();
    }
    
}
