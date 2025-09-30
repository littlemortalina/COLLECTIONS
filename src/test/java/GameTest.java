import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Max", 10);
    Player player2 = new Player(2, "Alex", 15);
    Player player3 = new Player(3, "John", 4);
    Player player4 = new Player(4, "Sam", 10);

    @Test
    public void ShouldSecondPlayerWin() { // второй игрок сильнее
        game.register(player1);
        game.register(player2);

        int expected = game.round("Max", "Alex");
        int actual = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldFirstPlayerWin() { // первый игрок сильнее

        game.register(player1);
        game.register(player4);

        int expected = game.round("Max", "Sam");
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldBothPlayersEquals() { // оба игрока обладают одинаковой силой
        game.register(player4);
        game.register(player3);

        int expected = game.round("Sam", "John");
        int actual = 1;

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void ShouldFirstPlayerNotRegistred() { // первый пользователь не зарегистрирован
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Sam");
        });
    }

    @Test
    public void ShouldSecondPlayerNotRegistred() { // второй пользователь не зарегистрирован
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("John", "Sam");
        });
    }
}
