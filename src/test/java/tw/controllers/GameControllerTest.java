package tw.controllers;

import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import tw.GuessNumberModule;
import tw.commands.GuessInputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static com.google.inject.Guice.createInjector;
import static org.junit.Assert.*;
import static tw.core.GameStatus.FAIL;
import static tw.core.GameStatus.SUCCESS;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGameController_beginGame_function() throws Exception {

        Injector injector = createInjector(new GuessNumberModule());
        GameController gameController = injector.getInstance(GameController.class);

        gameController.beginGame();

        assertTrue(outContent.toString().endsWith("------Guess Number Game, You have 6 chances to guess!  ------\n"));
    }

    @Test
    public void testGameController_play_function_success() throws Exception {

        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        Game game = new Game(new AnswerGenerator(randomIntGenerator));

        GuessInputCommand guessInputCommand = mock(GuessInputCommand.class);
        when(guessInputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));

        GameController gameController = new GameController(game, new GameView());
        gameController.play(guessInputCommand);

        assertTrue(outContent.toString().endsWith(SUCCESS + "\n"));
    }

    @Test
    public void testGameController_play_function_fail() throws Exception {

        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        Game game = new Game(new AnswerGenerator(randomIntGenerator));

        GuessInputCommand guessInputCommand = mock(GuessInputCommand.class);
        when(guessInputCommand.input()).thenReturn(Answer.createAnswer("4 3 2 1"));

        GameController gameController = new GameController(game, new GameView());
        gameController.play(guessInputCommand);

        assertTrue(outContent.toString().endsWith(FAIL + "\n"));
    }

}