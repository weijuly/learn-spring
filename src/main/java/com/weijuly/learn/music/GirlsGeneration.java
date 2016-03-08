package com.weijuly.learn.music;

import org.springframework.stereotype.Component;

/**
 * Created a bean with id "snsd"
 *
 */
@Component("snsd")
public class GirlsGeneration implements CompactDisc {

    public void play() {
	System.out.print("Playing Girls and Peace by SNSD");
    }

}
