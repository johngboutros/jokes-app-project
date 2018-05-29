package com.example.android.jokelib;

import java.util.Random;

public class JokeFactory {

    private static final String[] jokes = {
            "Why did the Integer drown?\n" +
                    "‘Coz he couldn’t Float!",
            "Yo mama’s so fat… she get an ArrayIndexOutOfBoundException!",
            "Yo mama’s so po… she does garbage collection for a living!",
            "Yo mama’s so ugly… her java.lang.reflect took down the mirror site!",
            "Your mama’s so fat… that not even Dijkstra is able to find a shortest path around her.",
            "When your hammer is C++, everything begins to look like a thumb.",
            "Q: How many programmers does it take to screw in a light bulb?\n" +
                    "A: None. It's a hardware problem.",
            "Definition, Programmer: An organism that turns caffeine and pizza into software.",
            "Software developers like to solve problems. If there are no problems available, " +
                    "they will create their own problems. It’s an addiction.",
            "Definition, Algorithm: Word used by programmers when they do not want to explain what they did.",
            "An optimist says: “the glass is half full.”\n" +
                    "A pessimist says: “the glass is half empty.”\n" +
                    "A programmer says: “the glass is twice as large as necessary.”",
            "I’d like to make the world a better place. But they won’t give me the source code…",
            "A programmer puts two glasses on his bedside table before going to sleep. " +
                    "A full one, in case he gets thirsty, and an empty one, in case he doesn’t.",
            "Java and C were telling jokes. It was C's turn, so he writes something on the wall, " +
                    "points to it and says \"Do you get the reference?\" But Java didn't."
    };

    public static String getJoke() {
        Random r = new Random();
        return jokes[r.nextInt(jokes.length)];
    }
}
