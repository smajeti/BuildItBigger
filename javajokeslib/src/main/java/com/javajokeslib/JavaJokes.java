package com.javajokeslib;

import java.util.Random;

public class JavaJokes {

    private static final String[] jokesArray = {"Q. What do Santa’s elves learn in school? A. The Elfabet.",
                                                "Q. What does Santa like to do in the garden? A. Hoe, hoe, hoe!",
                                                "Q: What do Santa’s elves drive? A: Minivans.",
                                                "Q: What do Santa’s elves drink? A: Minnesoda.",
                                                "Q: Why does everybody like Frosty the Snowman? A: Because he is so cool!",
                                                "Q.Which reindeer likes to clean? A.Comet" };
    private static final Random random = new Random();

    public static String getJoke() {
        int indx = random.nextInt(jokesArray.length);
        return jokesArray[indx];
    }

}
