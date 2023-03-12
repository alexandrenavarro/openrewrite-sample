package com.github.alexandrenavarro.openrewritesample;

// org.openrewrite.java.RemoveUnusedImports [UnusedImports]
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.List;
import java.util.Scanner;
import java.net.*; //[AvoidStarImport]
import sun.misc.Unsafe; //[IllegalImport]

/**
 * @author
 * @version abc
 * @unknownTag value [JavadocType]
 */
public final class Sample
// [LeftCurly]
{
    // [ConstantName] [JavadocVariable]
    public static final double pi = 3.141592;

    // org.openrewrite.java.cleanup.ModifierOrder [ModifierOrder]
    public final static double PI = 3.141592;

    // [StaticVariableName]
    private static String STATIC_NAME;
    // "org.openrewrite.java.format.RemoveTrailingWhitespace" [RegexpSingleline]

    // org.openrewrite.java.cleanup.RenamePrivateFieldsToCamelCase [MemberName]
    private String NAME;

    private String field1;

    // [VisibilityModifier]
    public final int someIntValue = 1;

    // org.openrewrite.java.cleanup.EmptyBlock
    {
    }

    // [MissingJavadocMethod]
    public Sample() throws FileNotFoundException {
    }

    /**
     * Some description here [JavadocStyle]
     */
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

        // [EmptyStatement]
        if (param == 1);

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

    // org.openrewrite.java.format.NormalizeTabsOrSpaces [FileTabCharacter]
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

    // [RedundantModifier]
    final boolean methodWithSpaceErrors() {

        // org.openrewrite.java.cleanup.RenameLocalVariablesToCamelCase [LocalFinalVariableName]
        final double FINAL_LOCAL_PI = 3.14;

        // org.openrewrite.java.cleanup.RenameLocalVariablesToCamelCase [LocalVariableName]
        double LOCAL_PI = 3.14;

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

        if (true) {
            // [Indentation]
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

    // org.openrewrite.java.cleanup.MethodNameCasing [MethodName]
    void WrongMethodName() {
    }

    // [ParameterName]
    void wrongParameter(String Toto) {
        // [LineLength]
        // Really long line, 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
    }

    @Deprecated
    /**
     * [InvalidJavadocPosition]
     */
    void invalidJavadocPosition() {
    }

    /**
     * [JavadocMethod]
     */
    void javadoc(String arg1) {
    }

    @Override
    // [EqualsHashCode]
    public boolean equals(Object obj) {
        return Objects.equals(this, obj);
    }

    void defaultField1() {
        //  [HiddenField]
        final String field1 = "default";
        this.field1 = field1;
    }

    void illegal() {
        // [IllegalInstantiation]
        Boolean bo = new Boolean(Boolean.TRUE);
    }

    void innerAssignment() {
        int a;
        int b;
        // [InnerAssignment] [MagicNumber]
        a = b = 5;
        // org.openrewrite.java.cleanup.MultipleVariableDeclarations [MultipleVariableDeclarations]
        int c, d;
    }

    void switchWithoutDefault(String s) {
        // org.openrewrite.java.cleanup.MinimumSwitchCases [MissingSwitchDefault]
        switch (s) {
            case "a" : System.out.println("a");
        }
    }

    // org.openrewrite.java.cleanup.FinalizeMethodArguments [FinalParameters]
    boolean simplifyExpression(boolean a) {
        // org.openrewrite.java.cleanup.SimplifyBooleanExpression [SimplifyBooleanExpression]
        if (a == true) {
        }

        // org.openrewrite.java.cleanup.UpperCaseLiteralSuffixes [UpperEll]
        long l = 100l;

        // "org.openrewrite.java.cleanup.UseJavaStyleArrayDeclarations" [ArrayTypeStyle]
        String strings[];

        // org.openrewrite.java.cleanup.SimplifyBooleanReturn [SimplifyBooleanReturn]
        if (a == true) {
            return true;
        } else {
            return false;
        }



        // [TodoComment]
        // TODO:
    }



    public abstract class Plant {
        private String roots;
        private String trunk;

        protected void validate() {
            if (roots == null) throw new IllegalArgumentException("No roots!");
            if (trunk == null) throw new IllegalArgumentException("No trunk!");
        }

        public abstract void grow();
    }

    public class Tree extends Plant {
        private List leaves;

        @Override
        protected void validate() {
            super.validate();
            if (leaves == null) throw new IllegalArgumentException("No leaves!");
        }

        // [DesignForExtension]
        public void grow() {
            validate();
        }
    }

    //["TypeName"]
    public class lowerClass {
    }

    // [ParameterNumber]
    public void veryLongListOfArgs(
            String a1,
            String a2,
            String a3,
            String a4,
            String a5,
            String a6,
            String a7,
            String a8,
            String a9,
            String a10) {
    }

    // [FinalClass]
    class MyClass { // violation, class should be declared final
        private MyClass() { }
    }


    // [InterfaceIsType]
    public interface Test1 { // violation
        int a = 3;
    }

    // org.openrewrite.java.cleanup.NoDoubleBraceInitialization
    public void noDoubleBraceInit() {

        // org.openrewrite.java.cleanup.NoDoubleBraceInitialization [AvoidDoubleBraceInitialization]
        Map<String, Integer> map = new HashMap<>(){{
            put("one", 1);
            put("tow", 2);
        }};

    }

    class Test {

        // org.openrewrite.java.cleanup.CovariantEquals [CovariantEquals]
        public boolean equals(Test i) {  // violation
            return false;
        }
    }

} // org.openrewrite.java.format.EmptyNewlineAtEndOfFile [NewlineAtEndOfFile]