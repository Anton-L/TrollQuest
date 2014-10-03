import java.util.Random;

public class Troll {
    int HP;
    int Hunger;
    int Boredom;
    Random random = new Random();

    public Troll(int hp, int hunger, int boredom) {
        HP = hp;
        Hunger = hunger;
        Boredom = boredom;
    }

    public Troll() {
        HP = random.nextInt(90 - 30) + 30;
        Hunger = random.nextInt(90 - 30) + 30;
        Boredom = random.nextInt(90 - 30) + 30;
    }
}
