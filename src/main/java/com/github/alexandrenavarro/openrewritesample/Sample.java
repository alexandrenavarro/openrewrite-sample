package com.github.alexandrenavarro.openrewritesample;

// org.openrewrite.java.RemoveUnusedImports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Sample {

    // org.openrewrite.java.cleanup.ModifierOrder
    public final static double PI = 3.141592;
    
    // org.openrewrite.java.cleanup.EmptyBlock
    {
    }

    public Sample() throws FileNotFoundException {
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

        // org.openrewrite.java.cleanup.UnnecessaryParentheses
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

    boolean methodWithTrailingSpace() {
        // org.openrewrite.java.cleanup.RemoveExtraSemicolons
        try (Scanner scanner = new Scanner(new File("test.txt"));) {
        } catch (FileNotFoundException fnfe) {
        }

        // org.openrewrite.java.cleanup.RemoveUnneededBlock
        {
            String s = "";
        }

        // org.openrewrite.java.format.RemoveTrailingWhitespace
        if(true) {
           return true; 
        }
        return false;
    }
    
    // org.openrewrite.java.format.SingleLineComments
    //Single line Comment with space after //

    boolean methodW() {
        // org.openrewrite.java.format.Spaces
        if  (true){
            return true;
        }
        // org.openrewrite.java.format.Spaces
        if ( true) {
            return true;
        }
        // org.openrewrite.java.format.Spaces
        if(true) {
            return true;
        }

        return false;
    }


} // org.openrewrite.java.format.EmptyNewlineAtEndOfFile 