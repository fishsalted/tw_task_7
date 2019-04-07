package tw.core;

import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.Assert.*;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    @Test
    public void testRandomIntGenerator_generateNums_function() {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();

        try {
            randomIntGenerator.generateNums(4,6);
            fail("RandomIntGenerator not throw exception");
        }catch(IllegalArgumentException exception) {
            assertEquals(exception.getMessage(), "Can't ask for more numbers than are available");
        }
    }

}