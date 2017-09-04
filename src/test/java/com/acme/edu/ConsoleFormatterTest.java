package com.acme.edu;

import com.acme.edu.exceptions.FormatterException;
import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.handlers.FormattingSavingHandler;
import com.acme.edu.writers.Writer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleFormatterTest {
    private ConsoleFormatter mockedConsoleFormatter;

    @Before
    public void setUp() throws FormatterException {
        mockedConsoleFormatter = mock(ConsoleFormatter.class);
        when(mockedConsoleFormatter.format(any())).thenCallRealMethod();
    }

    @Test(expected = FormatterException.class)
    public void shouldThrowFormatterExceptionWhenFormatNullBuffer() throws FormatterException {
        //region act
        mockedConsoleFormatter.format(null);
        //endregion

    }

    @Test(expected = FormatterException.class)
    public void shouldThrowFormatterExceptionWhenFormatEmptyBuffer() throws FormatterException {
        //region act
        mockedConsoleFormatter.format(new ArrayList<>());
        //endregion

    }

    @Test
    public void shouldReturnFormattedObjectWhenFormat() {
        // region given
        ArrayList<Object> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        // endregion

        // region act
        String formatted = null;
        try {
            formatted = mockedConsoleFormatter.format(list).toString();
        } catch (FormatterException e) {
            e.printStackTrace();
        }
        // endregion

        //region then
        assertEquals(formatted, "5\n2");
        //endregion
    }
}
