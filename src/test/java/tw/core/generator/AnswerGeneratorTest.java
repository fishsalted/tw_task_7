package tw.core.generator;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {

    @Test
    public void testAnswerGenerator_generate_function() throws Exception {

        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        when(randomIntGenerator.generateNums(9, 4)).thenReturn("2 5 7 3");
        assertEquals(answerGenerator.generate().toString(), "2 5 7 3");

        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        assertNotEquals(answerGenerator.generate().toString(), "2 5 7 3");
    }

}

