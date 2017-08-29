package com.acme.edu;

import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
}
