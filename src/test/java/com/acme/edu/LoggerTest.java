package com.acme.edu;

import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import com.acme.edu.writers.Writer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoggerTest {

    Writer mockedWriter;
    AbstractFormatter mockedFormatter;
    Logger logger;

    @Before
    public void setUp() {
        mockedWriter = mock(Writer.class);
        mockedFormatter = mock(AbstractFormatter.class);
        logger = new Logger(mockedWriter, mockedFormatter);
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenIntegerLog() {
        // region given
        int intMessage = 5;
        // endregion

        // region act
        logger.log(intMessage);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains(5));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenStringLog() {
        // region given
        String stringMessage = "String to log";
        // endregion

        // region act
        logger.log(stringMessage);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains("String to log"));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenBooleanLog() {
        // region given
        Boolean booleanMessage = true;
        // endregion

        // region act
        logger.log(booleanMessage);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains(true));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenObjectLog() {
        // region given
        Object objectMessage = new Object();
        // endregion

        // region act
        logger.log(objectMessage);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains(objectMessage));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenByteLog() {
        // region given
        Byte byteMessage = 2;
        // endregion

        // region act
        logger.log(byteMessage);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains(byteMessage));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenArrayLog() {
        // region given
        int[] arrayMessage = {1, 2, 3};
        // endregion

        // region act
        logger.log(arrayMessage);
        // endregion

        //region then
        assertEquals(3, logger.buffer.size());
        assertTrue(logger.buffer.contains(1));
        assertTrue(logger.buffer.contains(2));
        assertTrue(logger.buffer.contains(3));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenCharacterLog() {
        // region given
        char charMessage = 'c';
        // endregion

        // region act
        logger.log(charMessage);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains('c'));
        //endregion
    }

    @Test
    public void shouldCallFormatAndWriteOnRelease() {
        // region act
        logger.releaseBuffer();
        // endregion

        //region then
        verify(mockedFormatter).format(anyObject());
        verify(mockedWriter).write(anyObject());
        //endregion
    }

    @Test
    public void shouldSumIntegersWhenLog() {
        // region given
        int integerToSum1 = 1000;
        int integerToSum2 = 2000;
        int integerToSum3 = 3000;
        int sum = integerToSum1 + integerToSum2 + integerToSum3;
        // endregion

        // region act
        logger.log(integerToSum1);
        logger.log(integerToSum2);
        logger.log(integerToSum3);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains(sum));
        //endregion
    }

    @Test
    public void shouldSumByteWhenLog() {
        // region given
        byte byteToSum1 = 1;
        byte byteToSum2 = 2;
        byte byteToSum3 = 3;
        byte sum = (byte) (byteToSum1 + byteToSum2 + byteToSum3);
        // endregion

        // region act
        logger.log(byteToSum1);
        logger.log(byteToSum2);
        logger.log(byteToSum3);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains(sum));
        //endregion
    }

    @Test
    public void shouldAddMultiplierWhenSameStringLog() {
        // region given
        String stringToLog1 = "string1";
        String stringToLog2 = "string1";
        String result = "string1 (x2)";
        // endregion

        // region act
        logger.log(stringToLog1);
        logger.log(stringToLog2);
        // endregion

        //region then
        assertEquals(1, logger.buffer.size());
        assertTrue(logger.buffer.contains(result));
        //endregion
    }

    @Test
    public void shouldCorrectHandleMaxValueWhenIntegerLog() {
        // region given
        int intToLog = 1111;
        int overValue = Integer.MAX_VALUE - 50;

        int firstIntToCheck = (intToLog + overValue) % Integer.MAX_VALUE;
        int secondIntToCheck = Integer.MAX_VALUE;
        // endregion

        // region act
        logger.log(intToLog);
        logger.log(secondIntToCheck);
        // endregion

        //region then
        assertEquals(2, logger.buffer.size());
        assertTrue(logger.buffer.contains(5));
        assertTrue(logger.buffer.contains(Integer.MAX_VALUE - 5));
        //endregion
    }

    @Test
    public void shouldCorrectHandleMaxValueWhenByteLog() {
        // region given
        //byte byteToLog = 10;
        //byte maxValue = Byte.MAX_VALUE - 5;
        //// endregion
//
        //// region act
        //logger.log(intToLog);
        //logger.log(maxValue);
        //// endregion
//
        ////region then
        //assertEquals(2, logger.buffer.size());
        //assertTrue(logger.buffer.contains(5));
        //assertTrue(logger.buffer.contains(Integer.MAX_VALUE - 5));
        //endregion
    }
}


