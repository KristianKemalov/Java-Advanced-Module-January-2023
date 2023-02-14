import java.util.*;

public class AutumnCocktails {
    static final int PEAR_SOUR = 150;
    static final int THE_HARVEST = 250;
    static final int APLLE_HINNY = 300;
    static final int HIGH_FASHION = 400;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> result=new TreeMap<>();

        String[] bucketInfo = sc.nextLine().split(" ");
        String[] freshInfo = sc.nextLine().split(" ");

        Deque<Integer> ingredients = new ArrayDeque<>();
        Deque<Integer> fresh = new ArrayDeque<>();

        for (String inge : bucketInfo) {
            ingredients.offer(Integer.parseInt(inge));
        }
        for (String fre : freshInfo) {
            fresh.push(Integer.parseInt(fre));
        }

        int pear=0;
        int harvest=0;
        int apple=0;
        int fashion=0;

        while (!ingredients.isEmpty() && !fresh.isEmpty()) {
            int currentIngredient = ingredients.peek();
            int currentFresh = fresh.peek();

            if (currentIngredient == 0) {
                ingredients.poll();
                continue;
            }
            int possibleCocktail = currentFresh * currentIngredient;

            switch (possibleCocktail) {
                case PEAR_SOUR:ingredients.poll();fresh.pop();pear++;break;
                case THE_HARVEST:ingredients.poll();fresh.pop();harvest++;break;
                case APLLE_HINNY:ingredients.poll();fresh.pop();apple++;break;
                case HIGH_FASHION:ingredients.poll();fresh.pop();fashion++;break;
                default:fresh.pop();ingredients.poll();ingredients.offer(currentIngredient+5);
            }
        }
        if (pear>0 && harvest>0 & apple>0 && fashion>0){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sum=0;
        for (Integer s:ingredients){
            sum+=s;
        }
        result.put("Pear Sour",pear);
        result.put("The Harvest",harvest);
        result.put("Apple Hinny",apple);
        result.put("High Fashion",fashion);

        if (sum!=0) {
            System.out.printf("Ingredients left: %d%n",sum);
        }
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue()>0){
            System.out.printf(" # %s --> %d%n",entry.getKey(),entry.getValue());
             }
        }

    }
}
