import java.util.Random;

public class Player {

    private int hp;
    private int stamina;
    private int charisma;
    private Random random = new Random();

    public Player(int hp, int stamina, int charisma) {
        this.hp = hp;
        this.stamina = stamina;
        this.charisma = charisma;
    }

    public int getHP(){
        return hp;
    }

    public int getStamina(){
        return stamina;
    }

    public int getCharisma(){
        return charisma;
    }

    public boolean isDead() {
        return (hp == 0);
    }

    public void takeDamage(int min, int max) {
        hp -= random.nextInt(max + 1 - min) + min;
        if (hp < 0) {
            hp = 0;
        }
    }

    public void heal(int amount) {
        hp += amount;
        if (hp > 100) {
            hp = 100;
        }
    }

    public void rest(int amount) {
        stamina += amount;
        if (stamina > 100) {
            stamina = 100;
        }
    }

    public void memorizeStory(int amount) {
        charisma += amount;
        if (charisma > 100) {
            charisma = 100;
        }
    }

    public void getTired(int amount) {
        stamina -= amount;
        if (stamina < 0) {
            stamina = 0;
        }
    }

    public void getOffended(int amount) {
        charisma -= amount;
        if (charisma < 0) {
            charisma = 0;
        }
    }

}
