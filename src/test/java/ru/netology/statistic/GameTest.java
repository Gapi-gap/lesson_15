package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class GameTest {
    Player player1 = new Player(0, "Светлана", 100);
    Player player2 = new Player(0, "Артем", 64);
    Player player3 = new Player(0, "Иван", 64);
    Player player4 = new Player(0, "Арсений", 123);
    Game game = new Game();

    void Initalizator() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void checkingVictoryFirstPlayer() {
        Initalizator();
        Assertions.assertEquals(1, game.round("Светлана", "Артем"));
    }

    @Test
    public void checkingVictoryTwoPlayer() {
        Initalizator();
        Assertions.assertEquals(2, game.round("Светлана", "Арсений"));
    }

    @Test
    public void checkingForDraw() {
        Initalizator();
        Assertions.assertEquals(0, game.round("Иван", "Артем"));
    }

    @Test
    public void checkingLastPlayerNotRegistered() {
        Initalizator();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Артем");
        });
    }

    @Test
    public void checkingFirstPlayerNotRegistered() {
        Initalizator();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Артем", "Игорь");
        });
    }
}
