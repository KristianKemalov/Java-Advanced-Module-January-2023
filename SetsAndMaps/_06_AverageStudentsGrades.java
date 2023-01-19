import java.util.*;

public class _06_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> grades = new TreeMap<>();
        for (int i = 0; i < n; i++) {

            String[] studentInfo = scanner.nextLine().split(" ");
            String name = studentInfo[0];
            Double currentGrade = Double.parseDouble(studentInfo[1]);


            if (grades.containsKey(name)) {
                grades.get(name).add(currentGrade);
            } else {
                grades.put(name, new ArrayList<>());
                grades.get(name).add(currentGrade);
            }


        }

        for (String student : grades.keySet()) {
            System.out.print(student + " -> ");
            double sum = 0;
            for (Double grade : grades.get(student)) {
                sum += grade;
                System.out.printf("%.2f ", grade);


            }
            System.out.printf("(avg: %.2f)", sum / grades.get(student).size());
            System.out.println();

        }
    }
}
