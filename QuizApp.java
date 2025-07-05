import java.util.*;

class Question {
    String questionText;
    List<String> options;
    int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctAnswerIndex + 1;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Add questions
        questions.add(new Question(
            "What are Java loops?",
            Arrays.asList("Conditional branches", "Code that repeats", "Objects", "Methods"),
            1
        ));
        questions.add(new Question(
            "What is an enhanced for-loop?",
            Arrays.asList("A loop with no body", "A loop that replaces while", "A cleaner for-loop", "A switch-case"),
            2
        ));
        questions.add(new Question(
            "How do you handle multiple user inputs?",
            Arrays.asList("With threads", "Using Scanner and loops", "With JDBC", "Using FileReader"),
            1
        ));
        questions.add(new Question(
            "How is a switch-case different from if-else?",
            Arrays.asList("It’s slower", "Only supports numbers", "Uses 'case' instead of 'if'", "It loops automatically"),
            2
        ));
        questions.add(new Question(
            "What is ArrayList?",
            Arrays.asList("An interface", "A primitive type", "A resizable array", "A classloader"),
            2
        ));

        Collections.shuffle(questions); // Shuffle the questions
        int score = 0;

        for (Question q : questions) {
            q.display();
            System.out.print("Enter your choice (1-4): ");
            int userChoice = scanner.nextInt();
            if (q.isCorrect(userChoice)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
            }
        }

        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());

        scanner.close();
    }
}
