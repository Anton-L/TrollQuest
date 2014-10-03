import java.util.Random;

public class Player {

    int HP;
    int Stamina;
    int Charisma;
    Random random = new Random();

    public Player(int hp, int stamina, int charisma) {
        HP = hp;
        Stamina = stamina;
        Charisma = charisma;
    }

    public boolean isDead() {
        return (HP == 0);
    }

    public void takeDamage(int min, int max) {
        HP -= random.nextInt(max + 1 - min) + min;
        if (HP < 0) {
            HP = 0;
        }
    }

    public void heal(int amount) {
        HP += amount;
        if (HP > 100) {
            HP = 100;
        }
    }

    public void rest(int amount) {
        Stamina += amount;
        if (Stamina > 100) {
            Stamina = 100;
        }
    }

    public void memorizeStory(int amount) {
        Charisma += amount;
        if (Charisma > 100) {
            Charisma = 100;
        }
    }

    public void getTired(int amount) {
        Stamina -= amount;
        if (Stamina < 0) {
            Stamina = 0;
        }
    }

    public void getOffended(int amount) {
        Charisma -= amount;
        if (Charisma < 0) {
            Charisma = 0;
        }
    }

}
