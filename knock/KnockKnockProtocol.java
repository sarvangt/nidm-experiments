public class KnockKnockProtocol {
    private int state = 0;
    private int currentJoke = 0;

    private static final String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
    private static final String[] answers = {
        "Turnip the heat, it's cold in here!",
        "I didn't know you could yodel!",
        "Bless you!",
        "Is there an owl in here?",
        "Is there an echo in here?"
    };

    public String processInput(String input) {
        if (state == 0) {
            state = 1;
            return "Knock! Knock!";
        } else if (state == 1) {
            if (input.equalsIgnoreCase("Who's there?")) {
                state = 2;
                return clues[currentJoke];
            } else {
                return "You're supposed to say \"Who's there?\"";
            }
        } else if (state == 2) {
            if (input.equalsIgnoreCase(clues[currentJoke] + " who?")) {
                String response = answers[currentJoke];
                currentJoke++;
                if (currentJoke == clues.length) {
                    currentJoke = 0;
                    state = 0;
                    return response + " That's all. Bye!";
                } else {
                    state = 0;
                    return response + " Want another? Say anything.";
                }
            } else {
                return "You're supposed to say \"" + clues[currentJoke] + " who?\"";
            }
        }
        return "Huh?";
    }
}
