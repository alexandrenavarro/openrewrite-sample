package com.github.alexandrenavarro.openrewritesample;

// org.openrewrite.java.RemoveUnusedImports [UnusedImports]
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Sample
// [LeftCurly]
{

    // org.openrewrite.java.cleanup.ModifierOrder [ModifierOrder]
    public final static double PI = 3.141592;
    
    // org.openrewrite.java.cleanup.EmptyBlock
    {
    }

    public Sample() throws FileNotFoundException {
    }

    // org.openrewrite.java.cleanup.MethodParamPad  [MethodParamPad]
    int methodParamPad (int param) {

        // org.openrewrite.java.cleanup.OperatorWrap [OperatorWrap]
        final String helloWorld = "Hello " +
                "world";

        // org.openrewrite.java.cleanup.TypecastParenPad [TypecastParenPad]
        final String test = ( String) helloWorld; 

        // org.openrewrite.java.cleanup.NeedBraces [NeedBraces]
        if (param == 1)
            return 1;

        // org.openrewrite.java.cleanup.NoWhitespaceAfter [NoWhitespaceAfter]
        if (! true) {
            return -1;
        }

        // org.openrewrite.java.cleanup.UnnecessaryParentheses
        if ((true)) {
            return 1;
        }

        // org.openrewrite.java.cleanup.NoWhitespaceBefore [NoWhitespaceBefore]
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

        // org.openrewrite.java.cleanup.RemoveUnneededBlock [AvoidNestedBlocks]
        {
            String s = "";
        }

        if(true) {
            // org.openrewrite.java.format.RemoveTrailingWhitespace
           return true; 
        }
        return false;
    }
    
    // org.openrewrite.java.format.SingleLineComments
    //Single line Comment with space after //

    boolean methodWithSpaceErrors() {

        // org.openrewrite.java.cleanup.PadEmptyForLoopComponents [EmptyForIteratorPad]
        for (Iterator it = Map.of().entrySet().iterator(); it.hasNext(); );

        // org.openrewrite.java.format.Spaces [GenericWhitespace]
        List< String> l;

        // org.openrewrite.java.format.Spaces [WhitespaceAround]
        if  (true){
            return true;
        }
        // org.openrewrite.java.format.Spaces [ParenPad]
        if ( true) {
            return true;
        }
        // org.openrewrite.java.format.Spaces [WhitespaceAfter]
        if(true) {
            return true;
        } // [RightCurly]
        else {
            return false;
        }
    }


} // org.openrewrite.java.format.EmptyNewlineAtEndOfFile [NewlineAtEndOfFile]