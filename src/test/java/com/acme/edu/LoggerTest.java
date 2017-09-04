package com.acme.edu;

import com.acme.edu.exceptions.FormatterException;
import com.acme.edu.exceptions.WriterException;
import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.handlers.FormattingSavingHandler;
import com.acme.edu.writers.ConsoleWriter;
import com.acme.edu.writers.Writer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private Writer mockedWriter;
    private AbstractFormatter mockedFormatter;
    private Context context;
    private FormattingSavingHandler formattingSavingHandler;

    @Before
    public void setUp() {
        mockedWriter = mock(Writer.class);
        mockedFormatter = mock(AbstractFormatter.class);
        formattingSavingHandler = new FormattingSavingHandler(mockedWriter, mockedFormatter);
        context = new Context(formattingSavingHandler);

    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenIntegerLog() {
        // region given
        int intMessage = Byte.MAX_VALUE + 10;
        // endregion

        // region act
        context.logEvent(intMessage);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(intMessage));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenStringLog() {
        // region given
        String stringMessage = "String to log";
        // endregion

        // region act
        context.logEvent(stringMessage);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains("String to log"));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenBooleanLog() {
        // region given
        Boolean booleanMessage = true;
        // endregion

        // region act
        context.logEvent(booleanMessage);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(true));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenObjectLog() {
        // region given
        Object objectMessage = new Object();
        // endregion

        // region act
        context.logEvent(objectMessage);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(objectMessage));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenByteLog() {
        // region given
        Byte byteMessage = Byte.MAX_VALUE - 10;
        // endregion

        // region act
        context.logEvent(byteMessage);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(byteMessage));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenArrayLog() {
        // region given
        int[] arrayMessage = {1, 2, 3};
        // endregion

        // region act
        context.logEvent(arrayMessage);
        // endregion

        //region then
        assertEquals(3, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(1));
        assertTrue(formattingSavingHandler.getBuffer().contains(2));
        assertTrue(formattingSavingHandler.getBuffer().contains(3));
        //endregion
    }

    @Test
    public void shouldContainMessageAndSizeIncrementedWhenCharacterLog() {
        // region given
        char charMessage = 'c';
        // endregion

        // region act
        context.logEvent(charMessage);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains('c'));
        //endregion
    }

    @Test
    public void shouldCallFormatAndWriteOnRelease() throws WriterException {
        // region act
        context.releaseBuffer();
        // endregion

        //region then
        try {
            verify(mockedFormatter).format(anyObject());
        } catch (FormatterException e) {
            e.printStackTrace();
        }
        verify(mockedWriter).write(anyObject());
        //endregion
    }

    @Test
    public void shouldSumIntegersWhenLog() {
        // region given
        int integerToSum1 = Byte.MAX_VALUE + 1000;
        int integerToSum2 = Byte.MAX_VALUE + 2000;
        int integerToSum3 = Byte.MAX_VALUE + 3000;
        int sum = integerToSum1 + integerToSum2 + integerToSum3;
        // endregion

        // region act
        context.logEvent(integerToSum1);
        context.logEvent(integerToSum2);
        context.logEvent(integerToSum3);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(sum));
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
        context.logEvent(byteToSum1);
        context.logEvent(byteToSum2);
        context.logEvent(byteToSum3);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(sum));
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
        context.logEvent(stringToLog1);
        context.logEvent(stringToLog2);
        // endregion

        //region then
        assertEquals(1, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(result));
        //endregion
    }

    @Test
    public void shouldOverflowCorrectlyWhenIntegerLog() {
        // region given
        int intToLog = 1000;
        int bigInt = Integer.MAX_VALUE - 300;
        // endregion

        // region act
        context.logEvent(intToLog);
        context.logEvent(bigInt);
        // endregion

        //region then
        assertEquals(2, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains(700));
        assertTrue(formattingSavingHandler.getBuffer().contains(Integer.MAX_VALUE));
        //endregion
    }

    @Test
    public void shouldOverflowCorrectlyWhenByteLog() {
        // region given
        byte byteToLog = 40;
        byte bigByte = Byte.MAX_VALUE - 30;
        // endregion

        // region act
        context.logEvent(byteToLog);
        context.logEvent(bigByte);
        // endregion

        //region then
        assertEquals(2, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains((byte)10));
        assertTrue(formattingSavingHandler.getBuffer().contains(Byte.MAX_VALUE));
        //endregion
    }

    @Test
    public void shouldNotAddMultiplierWhenSameStringLog() {
        // region given
        String stringToLog1 = "string1";
        String stringToLog2 = "string2";
        // endregion

        // region act
        context.logEvent(stringToLog1);
        context.logEvent(stringToLog2);
        // endregion

        //region then
        assertEquals(2, formattingSavingHandler.getBuffer().size());
        assertTrue(formattingSavingHandler.getBuffer().contains("string1"));
        assertTrue(formattingSavingHandler.getBuffer().contains("string2"));
        //endregion
    }
}
