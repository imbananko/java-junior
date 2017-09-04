package com.acme.edu;

import com.acme.edu.exceptions.FormatterException;
import com.acme.edu.exceptions.WriterException;
import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import com.acme.edu.writers.Writer;
import org.hamcrest.core.AnyOf;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConsoleWriterTest implements SysoutCaptureAndAssertionAbility  {
    Writer mockedConsoleWriter;

    @Before
    public void setUp() throws FormatterException, WriterException {
        mockedConsoleWriter = mock(ConsoleWriter.class);
    }

    @Test
    public void shouldWriteToConsoleWhenWrite() throws WriterException {
        // region given
        // endregion

        // region act
        mockedConsoleWriter.write("Tested");
        // endregion

        //region then
        assertSysoutContains("Tested");
        //endregion
    }
}
