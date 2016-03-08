package com.weijuly.learn.c2.music;

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
