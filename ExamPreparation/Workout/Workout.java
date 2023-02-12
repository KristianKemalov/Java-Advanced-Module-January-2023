package ExamPreparation.Workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;


    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises
                = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises
                .size() < this.exerciseCount) {
            this.exercises
                    .add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {

        for (Exercise exercise : this.exercises
        ) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises
                        .remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises
        ) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }

        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        int max = 0;
        Exercise maxCal = null;
        for (Exercise exercise : this.exercises
        ) {
            if (exercise.getBurnedCalories() > max) {
                max = exercise.getBurnedCalories();
                maxCal = exercise;
            }
        }

        if (max != 0) {
            return maxCal;
        }
        return null;

    }

    public int getExerciseCount() {
        return this.exercises
                .size();
    }


    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Workout type: %s", this.type));
        builder.append(System.lineSeparator());

        for (Exercise exercise : this.exercises) {
            builder.append(exercise);
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
