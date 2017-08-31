package com.acme.edu.iteration01;

import com.acme.edu.Context;
import com.acme.edu.EventHandler;
import com.acme.edu.FormattingSavingHandler;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.formatters.ConsoleFormatter;
import com.acme.edu.writers.ConsoleWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    Context context;
    //region given
    FormattingSavingHandler formattingSavingHandler;
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
        context = new Context(new FormattingSavingHandler(null,null));
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test @Ignore
    public void shouldLogInteger() throws IOException {
        //region when
        context.logEvent(1);
        context.logEvent(0);
        context.logEvent(-1);
        context.releaseBuffer();
        //endregion

        //region then
        assertSysoutContains("0\n");
        //endregion
    }

    @Test @Ignore
    public void shouldLogByte() throws IOException {
        //region when
        context.logEvent((byte)1);
        context.logEvent((byte)0);
        context.logEvent((byte)-1);
        context.releaseBuffer();
        //endregion

        //region then
        assertSysoutContains("0\n");
        //endregion
    }

    @Test @Ignore
    public void shouldLogChar() throws IOException {
        //region when
        context.logEvent('a');
        context.logEvent('b');
        context.releaseBuffer();
        //endregion

        //region then
        assertSysoutContains("a\n");
        assertSysoutContains("b\n");
        //endregion
    }

    @Test @Ignore
    public void shouldLogString() throws IOException {
        //region when
        context.logEvent("test string 1");
        context.logEvent("other str");
        context.releaseBuffer();
        //endregion

        //region then
        assertSysoutContains("test string 1\n");
        assertSysoutContains("other str\n");
        //endregion
    }

    @Test @Ignore
    public void shouldLogBoolean() throws IOException {
        //region when
        context.logEvent(true);
        context.logEvent(false);
        context.releaseBuffer();
        //endregion

        //region then
        assertSysoutContains("true\n");
        assertSysoutContains("false\n");
        //endregion
    }

    @Test @Ignore
    public void shouldLogReference() throws IOException {
        //region when
        context.logEvent(new Object());
        context.releaseBuffer();
        //endregion

        //region then
        assertSysoutContains("@");
        //endregion
    }
}