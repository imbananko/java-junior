package com.acme.edu;

import com.acme.edu.exceptions.FormatterException;
import com.acme.edu.exceptions.WriterException;
import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import com.acme.edu.writers.Writer;
import org.hamcrest.core.AnyOf;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class ConsoleWriterTest implements SysoutCaptureAndAssertionAbility  {
    Writer consoleWriter;

    @Before
    public void setUp() throws FormatterException, WriterException {
        consoleWriter = new ConsoleWriter();
        resetOut();
        captureSysout();
    }

    @Test
    public void shouldWriteToConsoleWhenWrite() throws WriterException {
        // region act
        consoleWriter.write("Tested");
        // endregion

        //region then
        assertSysoutContains("Tested");
        //endregion
    }

    @Test(expected = WriterException.class)
    public void shouldThrowWriterExceptionWhenMessageIsNull() throws WriterException {
        // region act
        consoleWriter.write(null);
        // endregion
    }

    public void shouldHandleWriterExceptionCorrectlyWhenMessageIsNull() {
        // region act
        Object message = null;
        // endregion

        // region act
        try {
            consoleWriter.write(null);
        } catch (WriterException e) {
            message = e.getLogObject();
        }
        // endregion

        //region then
        assertEquals(null, message);
        //endregion
    }
}
