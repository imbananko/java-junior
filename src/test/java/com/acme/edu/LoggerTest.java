package com.acme.edu;

import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import com.acme.edu.writers.Writer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoggerTest {
    @Test
    public void shouldContainMessageAndSizeIncrementedWhenIntegerLog() {
        // region given
        Logger logger = new Logger(new ConsoleWriter(), new ConsoleFormatter());
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
        Logger logger = new Logger(new ConsoleWriter(), new ConsoleFormatter());
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
        Logger logger = new Logger(new ConsoleWriter(), new ConsoleFormatter());
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
        Logger logger = new Logger(new ConsoleWriter(), new ConsoleFormatter());
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
        Logger logger = new Logger(new ConsoleWriter(), new ConsoleFormatter());
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
    public void shouldCallFormatAndWriteOnRelease() {
        // region given
        Writer mockedWriter = mock(Writer.class);
        AbstractFormatter mockedFormatter = mock(AbstractFormatter.class);

        Logger logger = new Logger(mockedWriter, mockedFormatter);
        // endregion

        // region act
        logger.releaseBuffer();
        // endregion

        //region then
        verify(mockedFormatter).format(any());
        verify(mockedWriter).write(any());
        //endregion
    }

//    @Test
//    public void shouldFormatIncomeObjectOnRelease() {
//        // region given
//        Writer mockedWriter = mock(Writer.class);
//        AbstractFormatter mockedFormatter = mock(AbstractFormatter.class);
//        when(mockedFormatter.format(any())).thenReturn("Formatted");
//        when(mockedWriter.write(any())).then()
//
//        Logger logger = new Logger(mockedWriter, mockedFormatter);
//        // endregion

//        // region act
//        logger.releaseBuffer();
//        // endregion

//        //region then
//        verify(mockedFormatter).format(any());
//        verify(mockedWriter).write(any());
//        //endregion
//    }
}


