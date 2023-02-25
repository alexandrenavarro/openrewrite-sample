package com.github.alexandrenavarro.openrewritesample;

// org.openrewrite.java.RemoveUnusedImports
import java.util.Set;

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
    // org.openrewrite.java.format.BlankLines
    void aMethodWithoutBlankLineBefore() {
    }

    // org.openrewrite.java.format.NormalizeTabsOrSpaces
    	void methodWithTab() {
    }

    // org.openrewrite.java.format.RemoveTrailingWhitespace
    boolean methodWithTrailingSpace() {
        if(true) {
           return true; 
        }
        return false;
    }
    
    // org.openrewrite.java.format.SingleLineComments
    //Single line Comment with space after //

} // org.openrewrite.java.format.EmptyNewlineAtEndOfFile