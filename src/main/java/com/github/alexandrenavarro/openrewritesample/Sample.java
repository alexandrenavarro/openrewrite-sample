package com.github.alexandrenavarro.openrewritesample;

public class Sample {

    // org.openrewrite.java.cleanup.ModifierOrder
    public final static double PI = 3.141592;
    
    // org.openrewrite.java.cleanup.EmptyBlock
    {

    }

    // org.openrewrite.java.cleanup.MethodParamPad
    int methodParamPad (boolean param) {
        // org.openrewrite.java.cleanup.NeedBraces
        if (param)
            return 0;

        return -1;
    }
}
