import java.util.Random;

public class Troll {
    private int hp;
    private int hunger;
    private int boredom;
    private Random random = new Random();

    public Troll(int hp, int hunger, int boredom) {
        this.hp = hp;
        this.hunger = hunger;
        this.boredom = boredom;
    }

    public int getHP(){
        return hp;
    }

    public int getHunger(){
        return hunger;
    }

    public int getBoredom(){
        return boredom;
    }

    public Troll() {
        hp = random.nextInt(90 - 30) + 30;
        hunger = random.nextInt(90 - 30) + 30;
        boredom = random.nextInt(90 - 30) + 30;
    }
}
