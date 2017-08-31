//package com.acme.edu.iteration02;
//
//import com.acme.edu.Context;
//import com.acme.edu.FormattingSavingHandler;
//import com.acme.edu.SysoutCaptureAndAssertionAbility;
//import com.acme.edu.formatters.ConsoleFormatter;
//import com.acme.edu.writers.ConsoleWriter;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import java.io.IOException;
//
//public class contextTest implements SysoutCaptureAndAssertionAbility {
//    //region given
//    Context context;
//
//    @Before
//    public void setUpSystemOut() throws IOException {
//        resetOut();
//        captureSysout();
//        context = new Context(new FormattingSavingHandler(new ConsoleWriter(), new ConsoleFormatter()));
//    }
//
//    @After
//    public void tearDown() {
//        resetOut();
//    }
//    //endregion
//
//
//
//    //TODO: implement context solution to match specification as tests
//
//    @Test @Ignore
//    public void shouldLogSequentIntegersAsSum() throws IOException {
//        //region when
//        context.logEvent("str 1");
//        context.logEvent(1);
//        context.logEvent(2);
//        context.logEvent("str 2");
//        context.logEvent(0);
//        context.releaseBuffer();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "str 1\n" +
//            "3\n" +
//            "str 2\n" +
//            "0\n"
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
//        //region when
//        context.logEvent("str 1");
//        context.logEvent(10);
//        context.logEvent(Integer.MAX_VALUE);
//        context.logEvent("str 2");
//        context.logEvent(0);
//        context.releaseBuffer();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//                "str 1\n" +
//                        "10\n" +
//                        Integer.MAX_VALUE + "\n" +
//                        "str 2\n" +
//                        "0\n"
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
//        //region when
//        context.logEvent("str 1");
//        context.logEvent((byte)10);
//        context.logEvent((byte)Byte.MAX_VALUE);
//        context.logEvent("str 2");
//        context.logEvent(0);
//        context.releaseBuffer();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "str 1\n" +
//            "10\n" +
//            Byte.MAX_VALUE + "\n" +
//            "str 2\n" +
//            "0\n"
//        );
//        //endregion
//    }
//
//    @Test @Ignore
//    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
//        //region when
//        context.logEvent("str 1");
//        context.logEvent("str 2");
//        context.logEvent("str 2");
//        context.logEvent(0);
//        context.logEvent("str 2");
//        context.logEvent("str 3");
//        context.logEvent("str 3");
//        context.logEvent("str 3");
//        context.releaseBuffer();
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "str 1\n" +
//            "str 2 (x2)\n" +
//            "0\n" +
//            "str 2\n" +
//            "str 3 (x3)\n"
//        );
//        //endregion
//    }
//}