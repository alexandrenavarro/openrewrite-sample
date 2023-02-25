package com.github.alexandrenavarro.openrewritesample;

public class Sample {

    // org.openrewrite.java.cleanup.ModifierOrder
    public final static double PI = 3.141592;
    
    // org.openrewrite.java.cleanup.EmptyBlock
    {

    }

    // org.openrewrite.java.cleanup.MethodParamPad
    int methodParamPad (int param) {
        // org.openrewrite.java.cleanup.NeedBraces
        if (param == 1)
            return 1;

        // org.openrewrite.java.cleanup.NoWhitespaceAfter
        if (! true) {
            return -1;
        }

        // org.openrewrite.java.cleanup.NoWhitespaceBefore
        return Math.max(0 ,1);
    }
}
