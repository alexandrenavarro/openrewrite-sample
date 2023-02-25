package com.github.alexandrenavarro.openrewritesample;

public class Sample {

    // org.openrewrite.java.cleanup.ModifierOrder
    public final static double PI = 3.141592;
    
    // org.openrewrite.java.cleanup.EmptyBlock
    {
    }

    // org.openrewrite.java.cleanup.MethodParamPad
    int methodParamPad (int param) {

        // org.openrewrite.java.cleanup.OperatorWrap
        final String helloWorld = "Hello " +
                "world";

        // org.openrewrite.java.cleanup.TypecastParenPad
        final String test = ( String) helloWorld; 

        // org.openrewrite.java.cleanup.NeedBraces
        if (param == 1)
            return 1;

        // org.openrewrite.java.cleanup.NoWhitespaceAfter
        if (! true) {
            return -1;
        }

        if ((true)) {
            return 1;
        }

        // org.openrewrite.java.cleanup.NoWhitespaceBefore
        return Math.max(0 ,1);
    }
    //org.openrewrite.java.format.BlankLines
    void aMethodWithoutBlankLineBefore() {
    }
}
