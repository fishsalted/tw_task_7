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

        String randomIntResult = "2 5 7 3";
        when(randomIntGenerator.generateNums(9, 4)).thenReturn(randomIntResult);

        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        assertEquals(answerGenerator.generate().toString(), randomIntResult);

    }

}

