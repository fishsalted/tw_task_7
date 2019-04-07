package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tw.core.GameStatus.*;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {

    private Game game_;

    @Before
    public void setup() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");

        game_ = new Game(new AnswerGenerator(randomIntGenerator));
    }

    @Test
    public void testGame_guess_function() throws Exception { ;
        Answer inputAnswer = Answer.createAnswer("1 3 2 4");
        GuessResult guessResult = game_.guess(inputAnswer);

        assertEquals(guessResult.getResult(), "2A2B");
        assertEquals(guessResult.getInputAnswer().toString(), inputAnswer.toString());
    }

    @Test
    public void testGame_guessHistory_function() throws Exception {
        List<GuessResult> guessResultList = new ArrayList<>();

        guessResultList.add(game_.guess(Answer.createAnswer("1 3 2 4")));
        guessResultList.add(game_.guess(Answer.createAnswer("4 3 2 1")));

        assertEquals(game_.guessHistory(), guessResultList);
    }

    @Test
    public void testGame_checkCoutinue_function() throws Exception {
        assertTrue(game_.checkCoutinue());

        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));

        assertFalse(game_.checkCoutinue());
    }

    @Test
    public void testGame_checkStatus_function_continue() throws Exception {
        assertEquals(game_.checkStatus(), CONTINUE);
    }

    @Test
    public void testGame_checkStatus_function_fail() throws Exception {
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));

        assertEquals(game_.checkStatus(), FAIL);
    }

    @Test
    public void testGame_checkStatus_function_success() throws Exception {
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 3 2 4"));
        game_.guess(Answer.createAnswer("1 2 3 4"));

        assertEquals(game_.checkStatus(), SUCCESS);
    }

}
