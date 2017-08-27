package com.acme.edu.iteration01;

import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import com.acme.edu.formatters.TypeFormatter;
import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    Logger logger;
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
        logger = new Logger(new ConsoleWriter(), new ConsoleFormatter());
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        logger.log(1);
        logger.log(0);
        logger.log(-1);
        logger.releaseBuffer();
        //endregion

        //region then
        assertSysoutContains("0\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        logger.log((byte)1);
        logger.log((byte)0);
        logger.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains("0\n");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        logger.log('a');
        logger.log('b');
        //endregion

        //region then
        assertSysoutContains("a\n");
        assertSysoutContains("b\n");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        logger.log("test string 1");
        logger.log("other str");
        //endregion

        //region then
        assertSysoutContains("test string 1\n");
        assertSysoutContains("other str\n");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        logger.log(true);
        logger.log(false);
        //endregion

        //region then
        assertSysoutContains("true\n");
        assertSysoutContains("false\n"
);
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        logger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("@");
        //endregion
    }
}