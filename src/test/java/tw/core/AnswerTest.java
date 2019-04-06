package tw.core;

import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.*;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test
    public void testAnswer_validate_function() {
        Answer answer = Answer.createAnswer("1 2 10 11");
        try {
            answer.validate();
            fail("Answer not throw exception");
        }catch(OutOfRangeAnswerException exception) {
            assertEquals(exception.getMessage(), "Answer format is incorrect");
        }
    }

    @Test
    public void testAnswer_check_function() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        Answer input_answer = Answer.createAnswer("1 3 4 5");

        assertEquals(answer.check(input_answer).getValue(), "1A2B");
    }

    @Test
    public void testAnswer_getIndexOfNum_function() {
        Answer answer = Answer.createAnswer("1 2 3 4");

        assertEquals(answer.getIndexOfNum("2"), 1);
        assertEquals(answer.getIndexOfNum("4"), 3);
    }

    @Test
    public void testAnswer_toString_function() {
        Answer answer = Answer.createAnswer("1 7 4 5");

        assertEquals(answer.toString(), "1 7 4 5");
    }

}
