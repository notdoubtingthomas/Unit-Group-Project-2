/*
 Part 2 (Starter) — Study Plan Advisor
 Modules 4–5: Making Decisions & Looping

 Goal:
 - Read user inputs (courses, difficulty, weekly hours)
 - Validate inputs
 - Classify workload using decisions
 - Print a 7-day schedule using a loop
 - Print a summary

 Teaching Cues:
 - Validation first (guardrails), then logic
 - Branching must cover all cases (easy/medium/hard)
 - Loops remove repetition and reduce mistakes
*/

import java.util.Scanner;

public class Part2_StudyPlanAdvisor_Starter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // TODO 1: Prompt/read number of courses (int). Validate numCourses > 0.
        // Use a while loop to reprompt.
        System.out.print("Enter number of courses: ");
        int numCourses = input.nextInt();
        input.nextLine();

        while (numCourses < 0) {
            System.out.println("Enter number of courses: ");
        }

        // TODO 2: Prompt/read difficulty (String): easy, medium, hard
        // Convert to lowercase and validate.
        System.out.print("Enter difficulty level (easy, medium, hard): ");
        String difficulty = input.nextLine().toLowerCase();

        while (!difficulty.equals("easy") && !difficulty.equals("medium") && !difficulty.equals("hard")) {
            System.out.print("Error: invalid input. Please try again.");
            System.out.print("Enter difficulty level (easy, medium, hard): ");
            difficulty = input.nextLine().toLowerCase();
        }

        // TODO 3: Prompt/read weekly study hours (double). Validate weeklyHours >= 0.

        System.out.print("Enter number of study hours: ");
        double weeklyHours = input.nextDouble();

        while (weeklyHours <= 0) {
            System.out.print("Enter number of study hours: ");
        }
        // TODO 4: Call classifyWorkload(numCourses, difficulty) and store result.
        String workloadCategory = classifyWorkload(numCourses, difficulty);
        // TODO 5: Print a header and call generateWeeklySchedule(weeklyHours).
        System.out.println("=== Weekly Schedule ===");
        generateWeeklySchedule(weeklyHours);
        // TODO 6: Call printSummary(numCourses, difficulty, workloadCategory, weeklyHours).
        printSummary(numCourses, difficulty, workloadCategory, weeklyHours);

        input.close();
    }

    /*
     Decision rules example:
     - If difficulty = hard AND numCourses >= 4 → "High Risk: Overloaded"
     - Else if difficulty = medium AND numCourses >= 3 → "Balanced"
     - Else → "Low Risk: Manageable"
    */
    public static String classifyWorkload(int numCourses, String difficulty) {
        // TODO
        if (difficulty.equals("hard") && numCourses >= 4) {
            return "High Risk: Overloaded";
        } else if (difficulty.equals("medium") && numCourses >= 3) {
            return "Balanced";
        } else {
            return "Low Risk: Manageable";
        }
    }

    // Print Day 1..7 study hours (weeklyHours / 7.0) using a loop.
    public static void generateWeeklySchedule(double weeklyHours) {
        // TODO

        for (int i = 1; i < 8; i++) {
            System.out.print("Day " + i + " |");
            System.out.printf(" Study Hours: %.2f%n", weeklyHours / 7.0);
        }
    }

    public static void printSummary(int numCourses, String difficulty,
                                    String workloadCategory, double weeklyHours) {
        // TODO

        System.out.println();
        System.out.println("=== Summary ===");
        System.out.println("Number of courses: " + numCourses);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Workload Category: " + workloadCategory);
        System.out.println("Weekly Hours: " + weeklyHours);
    }
}
