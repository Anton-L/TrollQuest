import java.util.Scanner;

public class Game {
    public final static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        Player player = new Player(100, 100, 10);

        boolean gameOver = false;
        int action;

        while (!gameOver) {
            clearConsole();

            Troll troll = new Troll();

            System.out.format("Stats: \nHP: %d/100 \nStamina: %d/100 \nCharisma: %d/100 \n\n", player.getHP(), player.getStamina(), player.getCharisma());
            System.out.print("You have been walking through the forest and suddenly met a very hungry and bored Troll. What will you do?\n" +
                    "  1) FIGHT \n" +
                    "  2) RUN \n" +
                    "  3) TELL him a story \n" +
                    "Choose a number: ");

            if (reader.hasNextInt()) {
                action = reader.nextInt();
            } else {
                action = 0;
            }

            System.out.println();

            switch (action) {
                case 1:
                    fight(player, troll);
                    break;
                case 2:
                    flee(player, troll);
                    break;
                case 3:
                    story(player, troll);
                    break;
                default:
                    break;
            }

            if (player.isDead()) {
                gameOver = true;
            }
        }

        System.out.println("=== GAME OVER === \nAll good stories eventually come to an end. Now yours did too.");

    }

    public static void fight(Player player, Troll troll) {
        if (player.getHP() > troll.getHP()) {
            player.takeDamage(5, 10);
            player.memorizeStory(10);
            System.out.print("The troll was an easy enemy. You leave the battlefield with only a couple of scratches.");
            java.awt.Toolkit.getDefaultToolkit().beep();
            reader.nextLine();

        } else {
            player.takeDamage(10, 20);
            System.out.print("You were too weak for this battle and the troll didn't hesitate to take the advantage.");
            reader.nextLine();
        }
    }

    public static void flee(Player player, Troll troll) {
        if (player.getStamina() > troll.getHunger()) {
            player.getTired(30);
            System.out.print("♫ Just beeeaat it, beeeaaat it!\n" +
                    "♪ Nooo one wants to be defeeeated!\n" +
                    "♫ Showin' how funky and strong is your fight\n" +
                    "♪ It doesn't matter who's wrong or right\n" +
                    "♫ Just beat it, beat it!\n" +
                    "\n" +
                    "You had enough stamina to outrun the troll, good job!");
            reader.nextLine();
        } else {
            player.getTired(15);
            player.takeDamage(5, 10);
            player.memorizeStory(15);
            System.out.print("The troll was too hungry to give up the chase and managed to take a bite of you. Well, at least now you have a funny story to tell.");
            reader.nextLine();
        }
    }

    public static void story(Player player, Troll troll) {
        if (player.getCharisma() > troll.getBoredom()) {
            player.rest(50);
            player.heal(25);
            player.memorizeStory(5);
            System.out.print("You should seriously consider becoming a stand-up comedian, because the troll literally died from laughter. \nYou rest a little and continue your quest.");
            reader.nextLine();
        } else {
            player.getTired(5);
            player.takeDamage(3, 8);
            player.getOffended(5);
            System.out.print("The troll didn't like the story and threw a stone at you, severely damaging your ego.");
            reader.nextLine();
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("\n==============================================\n");
        }
    }
}
