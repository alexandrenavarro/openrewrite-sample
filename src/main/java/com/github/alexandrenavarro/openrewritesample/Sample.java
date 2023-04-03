package com.github.alexandrenavarro.openrewritesample;


import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PipedReader;
import java.io.Reader;
import java.io.Serializable;
// org.openrewrite.java.RemoveUnusedImports [UnusedImports]
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Currency;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
// [RedundantImport]
import java.util.List;
import java.util.Scanner;
import java.net.*; //[AvoidStarImport]
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;


import sun.misc.Unsafe; //[IllegalImport]

import javax.annotation.Nullable;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author
 * @version abc
 * @unknownTag value [JavadocType]
 */
// org.openrewrite.java.cleanup.AddSerialVersionUidToSerializable
public final class Sample implements Serializable

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

    // org.openrewrite.java.cleanup.ExplicitInitialization [ExplicitInitialization]
    private boolean boolField1 = false;

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
    int methodParamPad(int param) {

        // org.openrewrite.java.cleanup.OperatorWrap [OperatorWrap]
        final String helloWorld = "Hello " +
                "world";

        // org.openrewrite.java.cleanup.TypecastParenPad [TypecastParenPad]
        final String test = (String) helloWorld;

        // org.openrewrite.java.cleanup.NeedBraces [NeedBraces]
        if (param == 1)
            return 1;

        // [EmptyStatement]
        if (param == 1) ;

        // org.openrewrite.java.cleanup.NoWhitespaceAfter [NoWhitespaceAfter]
        if (!true) {
            return -1;
        }

        // org.openrewrite.java.cleanup.UnnecessaryParentheses [UnnecessaryParentheses]
        if ((true)) {
            return 1;
        }

        // org.openrewrite.java.cleanup.NoWhitespaceBefore [NoWhitespaceBefore]
        return Math.max(0, 1);
    }

    // org.openrewrite.java.format.BlankLines
    void aMethodWithoutBlankLineBefore() {
    }

    // org.openrewrite.java.format.NormalizeTabsOrSpaces [FileTabCharacter]
    void methodWithTab() {
    }

    boolean methodWithTrailingSpace() {
        // org.openrewrite.java.cleanup.RemoveExtraSemicolons
        ;
        try (Scanner scanner = new Scanner(new File("test.txt"));) {
        } catch (FileNotFoundException fnfe) {
        }

        // org.openrewrite.java.cleanup.RemoveUnneededBlock [AvoidNestedBlocks]
        {
            String s = "";
        }

        if (true) {
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
        for (Iterator it = Map.of().entrySet().iterator(); it.hasNext(); ) ;

        // org.openrewrite.java.format.Spaces [GenericWhitespace]
        List<String> l;

        // org.openrewrite.java.format.Spaces [WhitespaceAround]
        if (true) {
            return true;
        }
        // org.openrewrite.java.format.Spaces [ParenPad]
        if (true) {
            return true;
        }

        if (true) {
            // [Indentation]
            return true;
        }

        // org.openrewrite.java.format.Spaces [WhitespaceAfter]
        if (true) {
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
        // org.openrewrite.java.cleanup.PrimitiveWrapperClassConstructorToValueOf [IllegalInstantiation]
        Boolean bo = new Boolean(Boolean.TRUE);
    }

    void innerAssignment() {
        int a;
        int b;
        // [InnerAssignment] [MagicNumber]
        a = b = 5;
        // org.openrewrite.java.cleanup.ReplaceDuplicateStringLiterals [MultipleVariableDeclarations]
        int c, d;
    }

    void switchWithoutDefault(String s) {
        // org.openrewrite.java.cleanup.MinimumSwitchCases [MissingSwitchDefault]
        switch (s) {
            case "a":
                System.out.println("a");
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

        // org.openrewrite.java.cleanup.MissingOverrideAnnotation [DesignForExtension]
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
        private MyClass() {
        }
    }


    // [InterfaceIsType]
    public interface Test1 { // violation
        int a = 3;
    }

    // org.openrewrite.java.cleanup.NoDoubleBraceInitialization
    public void noDoubleBraceInit() {

        // org.openrewrite.java.cleanup.NoDoubleBraceInitialization [AvoidDoubleBraceInitialization]
        Map<String, Integer> map = new HashMap<>() {{
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

    public void defaultInSwitch(int i) {
        switch (i) {
            case 1:
                break;
            // org.openrewrite.java.cleanup.DefaultComesLast [DefaultComesLast]
            default: // violation, 'default' before 'case'
                break;
            case 2:
                break;
        }
    }

    public boolean equalsAvoidsNull(String s) {
        //org.openrewrite.java.cleanup.EqualsAvoidsNull EqualsAvoidNull
        return s.equals("42");
    }

    public void illegalType() {
        // org.openrewrite.java.cleanup.UseCollectionInterfaces [IllegalType]
        HashMap<String, String> map = new HashMap();

        // org.openrewrite.java.cleanup.RemoveUnusedLocalVariables
        final String s = "aString";
        // [MultipleStringLiterals]
        final String s2 = "aString";
        final String s3 = "aString";

        // org.openrewrite.java.cleanup.StringLiteralEquality [StringLiteralEquality]
        if (s2 == "aString") {
        }

        // org.openrewrite.java.cleanup.RemoveRedundantTypeCast
        final String s4 = (String) "aString4";
    }

    // org.openrewrite.java.cleanup.UnnecessaryThrows
    public String inlineString() throws FileNotFoundException {
        // org.openrewrite.java.cleanup.UseDiamondOperator
        Map<String, String> map = new HashMap<String, String>();

        // org.openrewrite.java.cleanup.FinalizeLocalVariables [FinalLocalVariable]
        String aNonFinalString = "aNonFinalString";

        // org.openrewrite.java.cleanup.InlineVariable
        String ret = "Return";
        return ret;
    }

    // org.openrewrite.java.cleanup.StaticMethodNotFinal
    public static final boolean staticFinalMethod() {
        List.of("a")
                .stream()
                // org.openrewrite.java.cleanup.UseLambdaForFunctionalInterface
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return (s.startsWith("a"));
                    }
                })
                .toList();


        // org.openrewrite.java.cleanup.CompareEnumsWithEqualityOperator
        return TimeUnit.DAYS.equals(TimeUnit.MINUTES);
    }

    // org.openrewrite.java.cleanup.NestedEnumsAreNotStatic
    public static enum Currency {
        EUR, USD, GBP
    }

    // org.openrewrite.java.cleanup.NoFinalizer [NoFinalizer]
    protected void finalize() {
        // org.openrewrite.java.cleanup.ObjectFinalizeCallsSuper
    }

    void switchCaseWithoutBreak(String s) {
        int i = 0;
        switch (s) {
            case "a":
                i++;
                // org.openrewrite.java.cleanup.FallThrough [FallThrough]
            case "b":
                i++;
                break;
            default:
        }
    }

    void methodWithUnnecessaryClose() throws IOException {
        // org.openrewrite.java.cleanup.UnnecessaryCloseInTryWithResources
        try (Reader r1 = new PipedReader();) {
            r1.close();
        }
    }

    void methodWithJustAReturn() {
        // org.openrewrite.java.cleanup.NoRedundantJumpStatements
        return;
    }

    boolean isEmptyCollection(List<String> strings) {
        // org.openrewrite.java.cleanup.IsEmptyCallOnCollections
        return strings.size() == 0;
    }

    boolean containsDash(String s) {
        // org.openrewrite.java.cleanup.IndexOfReplaceableByContains
        return s.indexOf("-") > -1;
    }

    // org.openrewrite.java.cleanup.RemoveUnusedPrivateMethods
    private void unusedPrivateMethod() {
    }

    String replaceString(String s) {
        // org.openrewrite.java.cleanup.UseStringReplace
        return s.replaceAll("a", "A");
    }

    String convertToSTring(String s, boolean a) {
        boolean b = false;
        // org.openrewrite.java.cleanup.SimplifyCompoundStatement
        b &= false;
        // org.openrewrite.java.cleanup.SimplifyConstantIfBranchExecution"
        if (a == true) {
            return "TOTO";
        }

        Optional<String> optional = Optional.of("a");
        // org.openrewrite.java.migrate.util.OptionalNotEmptyToIsPresent
        if (!optional.isEmpty()) {
            return "";
        }

        // org.openrewrite.java.migrate.util.OptionalNotPresentToIsEmpty
        if (!optional.isPresent()) {
            return "";
        }


        // org.openrewrite.java.cleanup.NoToStringOnStringType
        return s.toString();
    }

    void createCollection() {
        // org.openrewrite.java.migrate.util.MigrateCollectionsSingletonList
        List<Integer> list = Collections.singletonList(Integer.valueOf(1));

        // org.openrewrite.java.migrate.util.MigrateCollectionsSingletonMap
        Map<String, String> stringStringMap = Collections.singletonMap("key", "value");

        // org.openrewrite.java.migrate.util.MigrateCollectionsSingletonSet
        Set<String> set = Collections.singleton("1");

        // org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableList
        List<String> unmodifiableList = Collections.unmodifiableList(Arrays.asList("1", "2", "3"));

        // org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableSet
        Set<String> unmodifiableSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("1", "2", "3")));

        // org.openrewrite.java.migrate.util.UseEnumSetOf
        Set<TimeUnit> enumSet = Set.of(TimeUnit.MINUTES, TimeUnit.SECONDS);

        // org.openrewrite.java.migrate.util.UseMapOf
        Map<String, String> map = new HashMap<>() {{
            put("1", "One");
            put("2", "Two");
        }};

        // org.openrewrite.java.cleanup.NoEmptyCollectionWithRawType
        List<String> emptyList = Collections.EMPTY_LIST;

        // org.openrewrite.java.cleanup.UnnecessaryExplicitTypeArguments
        List<String> unmodifiableList2 = Collections.<String>unmodifiableList(Arrays.asList("1", "2", "3", "4"));
    }

    void createString() {
        // org.openrewrite.java.cleanup.ReplaceStringBuilderWithString
        String s = new StringBuilder().append("a").append("b").append("c").toString();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        String numbers = stringBuilder.toString();

        // org.openrewrite.java.cleanup.ChainStringBuilderAppendCalls
        StringBuilder sb = new StringBuilder();
        String op = "+";
        sb.append("A" + "B" + "C" + op + "D" + "E");

        // org.openrewrite.java.cleanup.NoValueOfOnStringType
        String string = String.valueOf("s");
    }

    void startThread() {
        // org.openrewrite.java.cleanup.ReplaceThreadRunWithThreadStart
        Thread thread = new Thread();
        thread.run();
    }

    void testNumber() {
        boolean condition = true;
        // org.openrewrite.java.cleanup.BooleanChecksNotInverted
        if (!(condition != true)) {
            // org.openrewrite.java.cleanup.BigDecimalRoundingConstantsToEnums
            BigDecimal result = BigDecimal.valueOf(1L).divide(BigDecimal.valueOf(2L), 0);
        }

        // org.openrewrite.java.cleanup.WriteOctalValuesAsDecimal
        int octal = 0757;
    }

    boolean testEquals() {
        String upperA = "A";
        String lowerA = "a";

        // org.openrewrite.java.cleanup.CaseInsensitiveComparisonsDoNotChangeCase
        return (upperA.toUpperCase().equalsIgnoreCase(lowerA));
    }

    void testFile() throws FileNotFoundException {
        // org.openrewrite.java.cleanup.UseStandardCharset
        final Charset iso88591 = Charset.forName("ISO_8859_1");

        try {
            // org.openrewrite.java.cleanup.RedundantFileCreation
            FileInputStream fileInputStream = new FileInputStream(new File("a.txt"));
        } catch (FileNotFoundException e) {
            // org.openrewrite.java.cleanup.CatchClauseOnlyRethrows
            throw e;
        }
    }

    void testAtomic() {
        AtomicBoolean atomicBoolean1 = new AtomicBoolean();
        atomicBoolean1.set(true);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean();
        atomicBoolean2.set(true);
        // org.openrewrite.java.cleanup.AtomicPrimitiveEqualsUsesGet
        if (atomicBoolean1.equals(atomicBoolean2)) {

        }
    }

    void testAssert() {
        // org.openrewrite.java.cleanup.RemoveUnneededAssertion
        assert true;
    }

    boolean testSomeStringMethods() {
        // org.openrewrite.java.cleanup.FixStringFormatExpressions
        String s = String.format("string:%s\n", "myString");

        // org.openrewrite.java.cleanup.IndexOfChecksShouldUseAStartPosition
        if (s.indexOf("s") > 2) {
            return true;
        }

        // org.openrewrite.java.cleanup.IndexOfShouldNotCompareGreaterThanZero
        if (s.indexOf("s") > 0) {
            return true;
        }

        // org.openrewrite.java.cleanup.NewStringBuilderBufferWithCharArgument
        StringBuilder sb = new StringBuilder('c');

        return false;
    }

    void testFor() {
        int nb = 0;
        // org.openrewrite.java.cleanup.NoEqualityInForCondition
        for (int i = 0; i != 0; i++) {
            nb += i;
        }

        int nb2 = 0;
        // org.openrewrite.java.cleanup.ForLoopIncrementInUpdate
        for (int i = 0; i < 10; ) {
            nb2 += i;
            i++;
        }

        boolean flag = true;

        // org.openrewrite.java.cleanup.WhileInsteadOfFor
        for (; flag; ) {
            flag = false;
        }
    }

    String testInstantPattern(Object obj) {
        // org.openrewrite.java.cleanup.InstanceOfPatternMatch
        if (obj instanceof String) {
            return (String) obj;
        } else {
            return "";
        }
    }


    void testWrapper() {
        // org.openrewrite.java.cleanup.NoPrimitiveWrappersForToStringOrCompareTo
        String s = new Long(1L).toString();
    }

    // org.openrewrite.java.cleanup.UnnecessaryPrimitiveAnnotations
    void testAnnotation(@Nullable int i) {
    }

    // org.openrewrite.java.cleanup.RenameMethodsNamedHashcodeEqualOrTostring
    public int hashcode() {
        return this.hashCode();
    }

    public void testString() {
        String s = "a";
        // org.openrewrite.java.cleanup.ExplicitCharsetOnStringGetBytes
        s.getBytes();
    }

    public void testStream() {
        // org.openrewrite.java.cleanup.ReplaceStreamToListWithCollect
        List<String> list = List.of("1", "2")
                .stream()
                .toList();
    }

    public void testMap() {
        // org.openrewrite.java.cleanup.UseMapContainsKey
        Map.of("One", "1", "Two", "2").keySet().contains("One");
    }

    public void testQueue() {
        // org.openrewrite.java.cleanup.ReplaceStackWithDeque
        final Stack<String> stack = new Stack<String>();
        stack.push("One");
    }

    public void testEquality() {
        final String s1 = "s1";
        final String s2 = "s1";
        // org.openrewrite.java.cleanup.ReferentialEqualityToObjectEquals
        final boolean notEqual = s1 == s2;
    }

    public void testInstanceOf() {
        Object object = (new Random().nextBoolean()) ? "string" : 1;
        // org.openrewrite.java.cleanup.RemoveInstanceOfPatternMatch
        if (object instanceof String s) {
            int length = s.length();
        }
    }

    // org.openrewrite.java.cleanup.UnwrapRepeatableAnnotations
    @NamedQueries({@NamedQuery(name = "name1"), @NamedQuery(name = "name2")})
    public void testAnnotations() {
    }


    static class External implements Externalizable {
        private String attribute;

        // org.openrewrite.java.cleanup.ExternalizableHasNoArgsConstructor
        public External(String attribute) {
            this.attribute = attribute;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        }
    }

    @Target({METHOD})
    @Retention(RUNTIME)
    public @interface NamedQueries {
        NamedQuery[] value();
    }

    @Target({METHOD})
    @Retention(RUNTIME)
    @Repeatable(NamedQueries.class)
    public @interface NamedQuery {
        String name();
    }


} // org.openrewrite.java.format.EmptyNewlineAtEndOfFile [NewlineAtEndOfFile]