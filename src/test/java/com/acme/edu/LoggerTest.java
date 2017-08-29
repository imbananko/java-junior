package com.acme.edu;

import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import com.acme.edu.writers.Writer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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


