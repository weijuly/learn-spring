package com.weijuly.develop.minstrel;

/**
 * A basic aspect point-cut that will be used before and after a method call
 * of knight class. Refer the AOP config in src/main/resources/spring-config.xml
 */
import java.io.PrintStream;

public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
	this.stream = stream;
    }

    public void singBeforeQuest() {
	stream.println("Knight is gonna embark a quest");
    }

    public void singAfterQuest() {
	stream.println("Knight has embarked a quest");
    }

}
