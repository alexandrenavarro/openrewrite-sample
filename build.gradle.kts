plugins {
    java
    checkstyle
    id("org.openrewrite.rewrite") version "6.1.19"
    id("org.sonarqube") version "4.0.0.2929"
    id("com.github.ben-manes.versions") version "0.46.0"
}

group = "com.github.alexandrenavarro"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("com.pushtorefresh:javac-warning-annotation:1.0.0")
    annotationProcessor("com.pushtorefresh:javac-warning-annotation:1.0.0")

    compileOnly("jakarta.validation:jakarta.validation-api:3.0.2")

//    <dependency>
//    <groupId>javax.validation</groupId>
//    <artifactId>validation-api</artifactId>
//    <version>2.0.1.Final</version>
//    </dependency>


    rewrite(platform("org.openrewrite:rewrite-bom:8.6.2"))
    rewrite(platform("org.openrewrite.recipe:rewrite-recipe-bom:2.3.0"))

    rewrite("org.openrewrite:rewrite-core")
    rewrite("org.openrewrite:rewrite-gradle")
    rewrite("org.openrewrite:rewrite-groovy")
    rewrite("org.openrewrite:rewrite-hcl")
    rewrite("org.openrewrite:rewrite-java")
    rewrite("org.openrewrite:rewrite-java-8")
    rewrite("org.openrewrite:rewrite-java-11")
    rewrite("org.openrewrite:rewrite-java-17")
    rewrite("org.openrewrite:rewrite-java-tck")
    rewrite("org.openrewrite:rewrite-java-test")
    rewrite("org.openrewrite:rewrite-json")
    rewrite("org.openrewrite:rewrite-maven")
    rewrite("org.openrewrite:rewrite-properties")
    rewrite("org.openrewrite:rewrite-protobuf")
    rewrite("org.openrewrite:rewrite-test")
    rewrite("org.openrewrite:rewrite-xml")
    rewrite("org.openrewrite:rewrite-yaml")

    rewrite("org.openrewrite.recipe:rewrite-java-security")
    rewrite("org.openrewrite.recipe:rewrite-java-dependencies")
    rewrite("org.openrewrite.recipe:rewrite-migrate-java")
    rewrite("org.openrewrite.recipe:rewrite-testing-frameworks")
    rewrite("org.openrewrite.recipe:rewrite-logging-frameworks")
    rewrite("org.openrewrite.recipe:rewrite-spring")
    rewrite("org.openrewrite.recipe:rewrite-quarkus")
    rewrite("org.openrewrite.recipe:rewrite-micronaut")
    rewrite("org.openrewrite.recipe:rewrite-jhipster")
    rewrite("org.openrewrite.recipe:rewrite-kubernetes")
    rewrite("org.openrewrite.recipe:rewrite-github-actions")
    rewrite("org.openrewrite.recipe:rewrite-circleci")
    rewrite("org.openrewrite.recipe:rewrite-concourse")
}

rewrite {


// See https://github.com/openrewrite/rewrite-docs/blob/master/SUMMARY.md
// Note (10 formating; 9 change code but must not change behavior; 8 change code but may change behavior in some cases; 7 tech migration; 6 change code but rare case, 5 change code but can break, 1 , 0 note tested; note -1 do not use it,

// Recipe, Category, Tested in the sample, Note, Violation in checkstyle, Violation in Sonar, Comment,


//activeRecipe("org.openrewrite.java.format.MethodParamPad")                                                                        // ,format, yes, 10, MethodParamPad, no,
//activeRecipe("org.openrewrite.java.format.NoWhitespaceAfter")                                                                     // ,format, yes, 10, NoWhitespaceAfter, no,
//activeRecipe("org.openrewrite.java.format.NoWhitespaceBefore")                                                                    // ,format, yes, 10, NoWhitespaceBefore, no,
//activeRecipe("org.openrewrite.java.format.TypecastParenPad")                                                                      // ,format, yes, 10, TypecastParenPad, java:S1905 (Remove this unnecessary cast to "String"),
//activeRecipe("org.openrewrite.java.format.BlankLines")                                                                            // ,format, yes, 10, no, no, Add some blank like between method
//activeRecipe("org.openrewrite.java.format.EmptyNewlineAtEndOfFile")                                                               // ,format, yes, 10, NewlineAtEndOfFile, no,
//activeRecipe("org.openrewrite.java.format.NormalizeTabsOrSpaces")                                                                 // ,format, yes, 10, FileTabCharacter, no,
//activeRecipe("org.openrewrite.java.format.RemoveTrailingWhitespace")                                                              // ,format, yes, 10, RegexpSingleline, no,
//activeRecipe("org.openrewrite.java.format.SingleLineComments")                                                                    // ,format, yes, 10, no, no, just a space after a single line comment
//activeRecipe("org.openrewrite.java.format.Spaces")                                                                                // ,format, yes, 10, WhitespaceAround ParenPad WhitespaceAfter GenericWhitespace, no, caution problem reformat with gradle, do exclusion of gradle file
//activeRecipe("org.openrewrite.java.format.PadEmptyForLoopComponents")                                                             // ,format, yes, 10, EmptyForIteratorPad, ?,
//activeRecipe("org.openrewrite.java.RemoveUnusedImports")                                                                          // ,format, yes, 10, yes, yes,
////activeRecipe("org.openrewrite.java.format.AutoFormat")                                                                          // ,format, no, -1, no, no, don't not format correct compared to intellij
////activeRecipe("org.openrewrite.java.format.TabsAndIndents")                                                                      // ,format, no, -1, no, no, do not format like intellij (1 or 2 indent for continuation)
////activeRecipe("org.openrewrite.java.format.WrappingAndBraces")                                                                   // ,format, no, -1, no, no, break all the formatting notably gradle.build, don't use it absolutely
////activeRecipe("org.openrewrite.java.format.NormalizeFormat")                                                                     // ,format, no, -1, no, no, do nothing except some stuff in the gradle.build
////activeRecipe("org.openrewrite.java.format.NormalizeLineBreaks")                                                                 // ,format, no, -1, no, no, Normalize LF / CRLF, weird behaviour to choose LF ou CRLF if different?

//activeRecipe("org.openrewrite.staticanalysis.EmptyBlock")                                                                         // ,staticanalysis, yes, 10, EmptyBlock, java:S108 (Nested blocks of code should not be left empty),
//activeRecipe("org.openrewrite.staticanalysis.ModifierOrder")                                                                      // ,staticanalysis, yes, 10, ModifierOrder, java:S1124 (Reorder the modifiers to comply with the Java Language Specification),
//activeRecipe("org.openrewrite.staticanalysis.NeedBraces")                                                                         // ,staticanalysis, yes, 10, NeedBraces, no,
//activeRecipe("org.openrewrite.staticanalysis.OperatorWrap")                                                                       // ,staticanalysis, yes, 10, OperatorWrap, no,
//activeRecipe("org.openrewrite.staticanalysis.RemoveExtraSemicolons")                                                              // ,staticanalysis, yes, 10, no, no,
//activeRecipe("org.openrewrite.staticanalysis.RemoveUnneededBlock")                                                                // ,staticanalysis, yes, 10, AvoidNestedBlocks, java:S1199 (Extract this nested code block into a method.),
//activeRecipe("org.openrewrite.staticanalysis.TypecastParenPad")                                                                   // ,staticanalysis, yes, 10, TypecastParenPad, java:S1905 (Remove this unnecessary cast to "String"),
//activeRecipe("org.openrewrite.staticanalysis.UnnecessaryParentheses")                                                             // ,staticanalysis, yes, 10, UnnecessaryParentheses (not by default), no,

//activeRecipe("org.openrewrite.staticanalysis.PrimitiveWrapperClassConstructorToValueOf")                                          // ,staticanalysis, yes, 9, IllegalInstantiation, no,
//activeRecipe("org.openrewrite.staticanalysis.MinimumSwitchCases")                                                                 // ,staticanalysis, yes, 9, MissingSwitchDefault, no, ok
//activeRecipe("org.openrewrite.staticanalysis.MultipleVariableDeclarations")                                                       // ,staticanalysis, yes, 9, MultipleVariableDeclarations, no,
//activeRecipe("org.openrewrite.staticanalysis.SimplifyBooleanExpression")                                                          // ,staticanalysis, yes, 9, SimplifyBooleanExpression, no,
//activeRecipe("org.openrewrite.staticanalysis.SimplifyBooleanReturn")                                                              // ,staticanalysis, yes, 9, SimplifyBooleanReturn, no,
//activeRecipe("org.openrewrite.staticanalysis.UpperCaseLiteralSuffixes")                                                           // ,staticanalysis, yes, 9, UpperEll, no,
//activeRecipe("org.openrewrite.staticanalysis.UseJavaStyleArrayDeclarations")                                                      // ,staticanalysis, yes, 9, ArrayTypeStyle, no,
//activeRecipe("org.openrewrite.staticanalysis.HideUtilityClassConstructor")                                                        // ,staticanalysis, yes, 9, HideUtilityClassConstructor, no, vs @Utility
//activeRecipe("org.openrewrite.staticanalysis.NoDoubleBraceInitialization")                                                        // ,staticanalysis, yes, 9, AvoidDoubleBraceInitialization (not by default), no,
//activeRecipe("org.openrewrite.staticanalysis.CovariantEquals")                                                                    // ,staticanalysis, yes, 9, CovariantEquals  (not by default), no,
//activeRecipe("org.openrewrite.staticanalysis.DefaultComesLast")                                                                   // ,staticanalysis, yes, 9, DefaultComesLast (not by default), no,
//activeRecipe("org.openrewrite.staticanalysis.EqualsAvoidsNull")                                                                   // ,staticanalysis, yes, 9, EqualsAvoidNull (not by default), no,
//activeRecipe("org.openrewrite.staticanalysis.ExplicitInitialization")                                                             // ,staticanalysis, yes, 9, ExplicitInitialization (not by default), no,
//activeRecipe("org.openrewrite.staticanalysis.UseCollectionInterfaces")                                                            // ,staticanalysis, yes, 9, IllegalType (not by default), no,
//activeRecipe("org.openrewrite.staticanalysis.StringLiteralEquality")                                                              // ,staticanalysis, yes, 9, StringLiteralEquality, no,
//activeRecipe("org.openrewrite.staticanalysis.FallThrough")                                                                        // ,staticanalysis, yes, 9, FallThrough, no,
//activeRecipe("org.openrewrite.staticanalysis.NoFinalizer")                                                                        // ,staticanalysis, yes, 9, NoFinalizer, no, Remove code.of finalize
//activeRecipe("org.openrewrite.staticanalysis.UnnecessaryCloseInTryWithResources")                                                 // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.InlineVariable")                                                                     // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.RemoveRedundantTypeCast")                                                            // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.UnnecessaryThrows")                                                                  // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.UseDiamondOperator")                                                                 // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.StaticMethodNotFinal")                                                               // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.MissingOverrideAnnotation")                                                          // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.AddSerialVersionUidToSerializable")                                                  // ,staticanalysis, yes, 9, no, no, does not generate the uid, weird?
//activeRecipe("org.openrewrite.staticanalysis.CompareEnumsWithEqualityOperator")                                                   // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.NestedEnumsAreNotStatic")                                                            // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.UseLambdaForFunctionalInterface")                                                    // ,staticanalysis, yes, 9, no, no,
//activeRecipe("org.openrewrite.staticanalysis.NoRedundantJumpStatements")                                                          // ,staticanalysis, yes, 9, no, ?,
//activeRecipe("org.openrewrite.staticanalysis.IsEmptyCallOnCollections")                                                           // ,staticanalysis, yes, 9, ?, yes sonar , transform size() -> .isEmpty()
//activeRecipe("org.openrewrite.staticanalysis.IndexOfReplaceableByContains")                                                       // ,staticanalysis, yes, 9, ?, ?, ok, transform (path.indexOf("/")>-1){ -> contains
//activeRecipe("org.openrewrite.staticanalysis.RemoveUnusedPrivateMethods")                                                         // ,staticanalysis, yes, 9, ?, java:s1144,  ok on a big project
//activeRecipe("org.openrewrite.staticanalysis.UseStringReplace")                                                                   // ,staticanalysis, yes, 9, ?, java:s5351, replaceAll -> replace, ok on a big project, let regex with replaceAll
//activeRecipe("org.openrewrite.staticanalysis.NoToStringOnStringType")                                                             // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.SimplifyConstantIfBranchExecution")                                                  // ,staticanalysis, yes, 9, ?, ?, sample (a == true) -> (a)
//activeRecipe("org.openrewrite.staticanalysis.SimplifyCompoundStatement")                                                          // ,staticanalysis, yes, 9, ?, ?, `b &= false` with `b = false` (not used a lot)

//activeRecipe("org.openrewrite.migrate.util.OptionalNotEmptyToIsPresent")                                                          // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.migrate.util.OptionalNotPresentToIsEmpty")                                                          // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.migrate.util.MigrateCollectionsSingletonList")                                                      // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.migrate.util.MigrateCollectionsSingletonMap")                                                       // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.migrate.util.MigrateCollectionsSingletonSet")                                                       // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.migrate.util.MigrateCollectionsUnmodifiableList")                                                   // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.migrate.util.MigrateCollectionsUnmodifiableSet")                                                    // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.migrate.util.UseMapOf")                                                                             // ,staticanalysis, yes, 9, ?, ?,

//activeRecipe("org.openrewrite.staticanalysis.ReplaceStringBuilderWithString")                                                     // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ChainStringBuilderAppendCalls")                                                      // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ReplaceThreadRunWithThreadStart")                                                    // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.BigDecimalRoundingConstantsToEnums")                                                 // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.BooleanChecksNotInverted")                                                           // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.CaseInsensitiveComparisonsDoNotChangeCase")                                          // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.FixStringFormatExpressions")                                                         // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.InstanceOfPatternMatch")                                                             // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ExternalizableHasNoArgsConstructor")                                                 // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ForLoopIncrementInUpdate")                                                           // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.IndexOfChecksShouldUseAStartPosition")                                               // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.IndexOfShouldNotCompareGreaterThanZero")                                             // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.NoPrimitiveWrappersForToStringOrCompareTo")                                          // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.NewStringBuilderBufferWithCharArgument")                                             // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.NoEmptyCollectionWithRawType")                                                       // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.NoValueOfOnStringType")                                                              // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ObjectFinalizeCallsSuper")                                                           // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.RenameMethodsNamedHashcodeEqualOrTostring")                                          // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.UnnecessaryExplicitTypeArguments")                                                   // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.UnnecessaryPrimitiveAnnotations")                                                    // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.WhileInsteadOfFor")                                                                  // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.WriteOctalValuesAsDecimal")                                                          // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.RedundantFileCreation")                                                              // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.CatchClauseOnlyRethrows")                                                            // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.AtomicPrimitiveEqualsUsesGet")                                                       // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.NoEqualityInForCondition")                                                           // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.UseMapContainsKey")                                                                  // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ReplaceStackWithDeque")                                                              // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ReferentialEqualityToObjectEquals")                                                  // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.UnwrapRepeatableAnnotations")                                                        // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.UseStandardCharset")                                                                 // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.RemoveUnneededAssertion")                                                            // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.AvoidBoxedBooleanExpressions")                                                       // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.UseObjectNotifyAll")                                                                 // ,staticanalysis, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ReplaceRedundantFormatWithPrintf")                                                   // ,staticanalysis, yes, 9, ?, ?,

//activeRecipe("org.openrewrite.staticanalysis.FinalClass")                                                                         // ,staticanalysis, yes, 8, FinalClass, no, ?, set only on private class or private constructor, seems ok, ok on a big project.
//activeRecipe("org.openrewrite.staticanalysis.RemoveUnusedLocalVariables")                                                         // ,staticanalysis, yes, 8, UnusedLocalVariable, no,  (not by default, present in doc but does not work?), ?, is it ok always?, ok on big project
//activeRecipe("org.openrewrite.staticanalysis.HiddenField")                                                                        // ,staticanalysis, yes, 8, HiddenField, no,, rename a argument with arg1 if attribute in the class except for setter / constructor


////activeRecipe("org.openrewrite.staticanalysis.LowercasePackage")                                                                 // ,staticanalysis, yes, 5, PackageName, no, can break if the project is a lib.
////activeRecipe("org.openrewrite.staticanalysis.MethodNameCasing")                                                                 // ,staticanalysis, yes, 5, MethodName, no, can break if the project is a lib.
////activeRecipe("org.openrewrite.staticanalysis.RenamePrivateFieldsToCamelCase")                                                   // ,staticanalysis, yes, 5, MemberName, no, can break if the project is a lib.

//activeRecipe("org.openrewrite.java.migrate.UseJavaUtilBase64")                                                                    // ,staticanalysis, no (not possible in jdk 17 without ), 0, ?, ?, Not anymore really

////activeRecipe("org.openrewrite.staticanalysis.FinalizeLocalVariables")                                                           // ,staticanalysis, yes, -1, FinalLocalVariable, no, ?, controversial, have some problem like finalvar on a big project
////activeRecipe("org.openrewrite.staticanalysis.RenameLocalVariablesToCamelCase")                                                  // ,staticanalysis, yes, -1, LocalFinalVariableName LocalVariableName, no, problem error some times (error between Class and variable, does not compile)
////activeRecipe("org.openrewrite.staticanalysis.ReplaceDuplicateStringLiterals")                                                   // ,staticanalysis, yes, -1, MultipleStringLiterals, no, create String final and reference it on all ok on the principle but errors on a big project on interface with private static String (not allowed)
////activeRecipe("org.openrewrite.migrate.util.UseEnumSetOf")                                                                       // ,staticanalysis, yes, -1, ?, ?, Error caused by: java.lang.IllegalArgumentException: This template requires 1 parameters., at org.openrewrite.java.JavaTemplate.withTemplate(JavaTemplate.java:65)
////activeRecipe("org.openrewrite.staticanalysis.ExplicitCharsetOnStringGetBytes")                                                  // ,staticanalysis, yes, -1, ?, ?, Generate error : CharSet.<error>
////activeRecipe("org.openrewrite.staticanalysis.FinalizeMethodArguments")                                                          // ,staticanalysis, yes, -2, FinalParameters, no, controversial, use ParameterAssignment in checkstyle instead
////activeRecipe("org.openrewrite.staticanalysis.ReplaceStreamToListWithCollect")                                                   // ,staticanalysis, yes, -2, ?, ?, not ok to migrate toList -> collect(Collectors.toList()) (sonar has the opposite rules)
////activeRecipe("org.openrewrite.staticanalysis.RemoveInstanceOfPatternMatch")                                                     // ,staticanalysis, yes, -2, ?, ?, does not want remove instanceOfPattern (jdk 14 features)

////activeRecipe("org.openrewrite.java.staticanalysis.SimplifyConsecutiveAssignments")                                              // ,staticanalysis, not yet, -1, ?, ?, generate error in the code with comment
////activeRecipe("org.openrewrite.java.staticanalysis.LambdaBlockToExpression")                                                     // ,staticanalysis, not yet, -1, ?, ?, do not use, reformat gradle.build
////activeRecipe("org.openrewrite.java.staticanalysis.ReplaceLambdaWithMethodReference")                                            // ,staticanalysis, not yet, -1, ?, problem if 2 classes with the same for the class
////activeRecipe("org.openrewrite.java.staticanalysis.CombineSemanticallyEqualCatchBlocks")                                         // ,staticanalysis, not yet, -1, ?, ? error in comments in source code
////activeRecipe("org.openrewrite.java.staticanalysis.ControlFlowIndentation")                                                      // ,staticanalysis, not yet, -1, ?, ? reformat code incorrectly
////activeRecipe("org.openrewrite.java.staticanalysis.RenameExceptionInEmptyCatch")                                                 // ,staticanalysis, not yet, -1, ?, ? error in comments in source code
////activeRecipe("org.openrewrite.java.staticanalysis.UnnecessaryCatch")                                                            // ,staticanalysis, not yet, -1, IllegalCatch, ?, do not use, change the behaviour if NPE occurs for instance

////activeRecipe("org.openrewrite.java.staticanalysis.CommonStaticAnalysis")                                                        // ,staticanalysis, not yet, -2, ?, ?, list of recipes, some are not ok
////activeRecipe("org.openrewrite.java.staticanalysis.CodeCleanup")                                                                 // ,staticanalysis, not yet, -2, ?, ?, list of recipes, some are not ok
////activeRecipe("org.openrewrite.java.staticanalysis.RemoveUnusedPrivateFields")                                                   // ,staticanalysis, not yet, -2, ?, ?,, NotFound, can break notably in unit or Autowired field
////activeRecipe("org.openrewrite.java.staticanalysis.FinalizePrivateFields")                                                       // ,staticanalysis, not yet, -2, ?, ?, nonFound, controversial
////activeRecipe("org.openrewrite.java.staticanalysis.ExplicitLambdaArgumentTypes")                                                 // ,staticanalysis, not yet, -2, ?, ?, controversial, some case ok some other not
////activeRecipe("org.openrewrite.java.staticanalysis.ForLoopControlVariablePostfixOperators")                                      // ,staticanalysis, not yet, -2, ?, ? --i -> i--, can change the behaviour
////activeRecipe("org.openrewrite.java.staticanalysis.ReplaceTextBlockWithString")                                                  // ,staticanalysis, not yet, -2, ?, ?, Does not want to do that (do the contrary)
////activeRecipe("org.openrewrite.java.staticanalysis.NoFinalizedLocalVariables")                                                   // ,staticanalysis, not yet, -2, ?, ?, controversial, generally ok, some case ok some other not


//activeRecipe("org.openrewrite.java.staticanalysis.RemoveCallsToObjectFinalize")                                                   // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.CommonDeclarationSiteTypeVariances")                                            // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.RemoveCallsToSystemGc")                                                         // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.UseListSort")                                                                   // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.UseForEachRemoveInsteadOfSetRemoveAll")                                         // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.UseSystemLineSeparator")                                                        // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.SimplifyDurationCreationUnits")                                                 // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.ReplaceApacheCommonsLang3ValidateNotNullWithObjectsRequireNonNull")             // ,staticanalysis, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.RemoveEmptyJavaDocParameters")                                                  // ,staticanalysis, not yet, 0, ?, ?,


//activeRecipe("org.openrewrite.java.staticanalysis.ReplaceDeprecatedRuntimeExecMethods")                                           // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.ReplaceValidateNotNullHavingSingleArgWithObjectsRequireNonNull")                // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.ReplaceValidateNotNullHavingVarargsWithObjectsRequireNonNull")                  // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.analysis.controlflow.ControlFlowVisualization")                                                     // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.UseStaticImport")                                                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.NoStaticImport")                                                                               // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RandomizeId")                                                                                  // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReplaceConstant")                                                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReplaceStringLiteralWithConstant")                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.SimplifyMethodChain")                                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.staticanalysis.DeclarationSiteTypeVariance")                                                   // ,?, not yet, 0, ?, ?,

//activeRecipe("org.openrewrite.java.staticanalysis.JavaApiBestPractices")                                                          // ,?, not yet, 0, ?, ?,

//activeRecipe("org.openrewrite.java.OrderImports")                                                                                 // ,?, not yet, 0, ?, ?,

//activeRecipe("org.openrewrite.java.AddApache2LicenseHeader")                                                                      // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.AddLicenseHeader")                                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.AddOrUpdateAnnotationAttribute")                                                               // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ChangeMethodAccessLevel")                                                                      // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ChangeMethodName")                                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ChangeMethodTargetToStatic")                                                                   // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ChangeMethodTargetToVariable")                                                                 // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ChangePackage")                                                                                // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ChangeStaticFieldToMethod")                                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ChangeType")                                                                                   // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.UseAsBuilder")                                                                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.DeleteMethodArgument")                                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.UpdateSourcePositions")                                                                        // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RecipeMarkupDemonstration")                                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReorderMethodArguments")                                                                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.RemoveJavaDocAuthorTag")                                                               // ,?, not yet, 0, ?, ?, no effect on a big project, to be tested

//activeRecipe("org.openrewrite.java.dependencies.AddDependency")                                                                   // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.ChangeDependency")                                                                // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.DependencyLicenseCheck")                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.DependencyList")                                                                  // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.DependencyVulnerabilityCheck")                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.RemoveDependency")                                                                // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.UpgradeDependencyVersion")                                                        // ,?, not yet, 0, ?, ?,

//activeRecipe("org.openrewrite.staticanalysis.EqualsToContentEquals")                                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.RemoveHashCodeCallsFromArrayInstances")                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.RemoveSystemOutPrintln")                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.RemoveToStringCallsFromArrayInstances")                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ReplaceOptionalIsPresentWithIfPresent")                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.ReplaceWeekYearWithYear")                                                            // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.SortedSetStreamToLinkedHashSet")                                                     // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.staticanalysis.TernaryOperatorsShouldNotBeNested")                                                  // ,?, not yet, 0, ?, ?,

//activeRecipe("org.openrewrite.java.ReplaceConstantWithAnotherConstant")                                                           // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ShortenFullyQualifiedTypeReferences")                                                          // ,?, not yet, 0, ?, ?,

//activeRecipe("org.openrewrite.java.upgrade.MigrateToRewrite8")                                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.upgrade.UpdateStaticAnalysisPackage")                                                          // ,?, not yet, 0, ?, ?,


////activeRecipe("org.openrewrite.java.GoogleJavaFormat")                                                                           // ,?, not yet, 0, ?, ?,
////activeRecipe("org.openrewrite.java.IntelliJ")                                                                                   // ,?, not yet, 0, ?, ?,
////activeRecipe("org.openrewrite.java.jhipster.FixCwe338")                                                                         // ,?, not yet, 0, ?, ?,



// Global latest Java  (To retest)
//activeRecipe("org.openrewrite.java.migrate.UpgradeToJava17")                                                                      // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.JavaVersion17")                                                                        // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.Java8toJava11")                                                                        // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.JavaVersion11")                                                                        // ,java, no, 9, ?, ?,
////activeRecipe("org.openrewrite.java.migrate.JavaVersion20")                                                                      // ,java, no, 9, ?, ?,
////activeRecipe("org.openrewrite.java.migrate.UpgradeToJava20")
//activeRecipe("org.openrewrite.java.migrate.lang.UseTextBlocks")                                                                   // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.JavaUtilAPIs")                                                                    // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.JavaConcurrentAPIs")                                                        // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicBooleanWeakCompareAndSetToWeakCompareAndSetPlain")             // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicIntegerArrayWeakCompareAndSetToWeakCompareAndSetPlain")        // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicIntegerWeakCompareAndSetToWeakCompareAndSetPlain")             // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicLongArrayWeakCompareAndSetToWeakCompareAndSetPlain")           // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicLongWeakCompareAndSetToWeakCompareAndSetPlain")                // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicReferenceArrayWeakCompareAndSetToWeakCompareAndSetPlain")      // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicReferenceWeakCompareAndSetToWeakCompareAndSetPlain")           // ,java, no, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.io.ReplaceFileInOrOutputStreamFinalizeWithClose")                                      // ,java, no, 9, ?, ?,



// Guava / Commons-jakarta
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuava")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaAtomicsNewReference")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaCreateTempDir")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaDirectExecutor")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaImmutableListOf")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaImmutableMapOf")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaImmutableSetOf")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaListsNewArrayList")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaListsNewCopyOnWriteArrayList")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaListsNewLinkedList")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaMapsNewLinkedHashMap")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaOptionalFromJavaUtil")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaOptionalToJavaUtil")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaSetsNewConcurrentHashSet")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaSetsNewHashSet")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaSetsNewLinkedHashSet")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferCharCompare")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerCompare")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerCompareUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerDivideUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerParseUnsignedInt")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerRemainderUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaNioCharsetStandardCharsets")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilCollectionsSynchronizedNavigableMap")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilCollectionsUnmodifiableNavigableMap")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilFunction")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilObjectsEquals")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilObjectsHashCode")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilObjectsRequireNonNull")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilOptional")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilOptionalOrElseNull")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilOptionalOrSupplier")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilPredicate")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilSupplier")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferLongCompare")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferLongCompareUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferLongDivideUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferLongParseUnsignedLong")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferLongRemainderUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferMathAddExact")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferMathMultiplyExact")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferMathSubtractExact")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferShortCompare")


// Commons-jakarta
//activeRecipe("org.openrewrite.java.migrate.apache.commons.codec.ApacheBase64ToJavaBase64")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.ApacheCommonsFileUtilsRecipes")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.ApacheFileUtilsToJavaFiles")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.ApacheIOUtilsUseExplicitCharset")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.RelocateApacheCommonsIo")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.UseStandardCharsets")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.UseSystemLineSeparator")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.lang.ApacheCommonsStringUtilsRecipes")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.lang.IsNotEmptyToJdk")


// Global Jakarta (to retest)
//activeRecipe("org.openrewrite.java.migrate.jakarta.ChangeJavaxAnnotationToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.EhcacheJavaxToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JacksonJavaxToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxActivationMigrationToJakartaActivation")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxAnnotationMigrationToJakartaAnnotation")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxAnnotationPackageToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxAnnotationSecurityPackageToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxAnnotationSqlPackageToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxAuthenticationMigrationToJakartaAuthentication")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxAuthorizationMigrationToJakartaAuthorization")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxBatchMigrationToJakartaBatch")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxDecoratorToJakartaDecorator")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxEjbToJakartaEjb")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxElToJakartaEl")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxEnterpriseToJakartaEnterprise")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxFacesToJakartaFaces")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxInjectMigrationToJakartaInject")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxInterceptorToJakartaInterceptor")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxJmsToJakartaJms")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxJsonToJakartaJson")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxJwsToJakartaJws")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxMailToJakartaMail")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxPersistenceXmlToJakartaPersistenceXml")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxResourceToJakartaResource")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxSecurityToJakartaSecurity")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxServletToJakartaServlet")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxTransactionMigrationToJakartaTransaction")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxWebsocketToJakartaWebsocket")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxWsToJakartaWs")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxXmlBindMigrationToJakartaXmlBind")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxXmlSoapToJakartaXmlSoap")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JavaxXmlWsMigrationToJakartaXmlWs")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JohnzonJavaxToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.MaybeAddJakartaServletApi")
//activeRecipe("org.openrewrite.java.migrate.jakarta.RestAssuredJavaxToJakarta")



// Global Logging
// Logging (to retest)
////activeRecipe("org.openrewrite.java.logging.log4j.Log4j1ToLog4j2")
//activeRecipe("org.openrewrite.java.logging.log4j.ParameterizedLogging")
//activeRecipe("org.openrewrite.java.logging.log4j.PrependRandomName")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jAppenderToLogback")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jLayoutToLogback")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jToLogback")
//activeRecipe("org.openrewrite.java.logging.ParameterizedLogging")
//activeRecipe("org.openrewrite.java.logging.PrintStackTraceToLogError")
//activeRecipe("org.openrewrite.java.logging.slf4j.ChangeLogLevel")
//activeRecipe("org.openrewrite.java.logging.slf4j.CompleteExceptionLogging")
//activeRecipe("org.openrewrite.java.logging.slf4j.Log4j1ToSlf4j1")
//activeRecipe("org.openrewrite.java.logging.slf4j.Log4j2ToSlf4j1")
//activeRecipe("org.openrewrite.java.logging.slf4j.Log4jToSlf4j")
//activeRecipe("org.openrewrite.java.logging.slf4j.LoggersNamedForEnclosingClass")
//activeRecipe("org.openrewrite.java.logging.slf4j.ParameterizedLogging")
//activeRecipe("org.openrewrite.java.logging.slf4j.Slf4jBestPractices")
//activeRecipe("org.openrewrite.java.logging.slf4j.Slf4jLogShouldBeConstant")
//activeRecipe("org.openrewrite.java.logging.SystemErrToLogging")
//activeRecipe("org.openrewrite.java.logging.SystemOutToLogging")
//activeRecipe("org.openrewrite.java.logging.SystemPrintToLogging")



// Global Junit (to retest)
//activeRecipe("org.openrewrite.java.testing.assertj.Assertj")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertArrayEqualsToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertEqualsToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertFalseToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertNotEqualsToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertNotNullToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertNullToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertSameToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertThrowsToAssertExceptionType")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitAssertTrueToAssertThat")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitFailToAssertJFail")
//activeRecipe("org.openrewrite.java.testing.assertj.JUnitToAssertj")
//activeRecipe("org.openrewrite.java.testing.assertj.SimplifyChainedAssertJAssertion")
//activeRecipe("org.openrewrite.java.testing.assertj.SimplifyChainedAssertJAssertions")
//activeRecipe("org.openrewrite.java.testing.assertj.StaticImports")

//activeRecipe("org.openrewrite.java.testing.cleanup.AssertEqualsNullToAssertNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseEqualsToAssertNotEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseNegationToAssertTrue")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseNullToAssertNotNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertionsArgumentOrder")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueComparisonToAssertEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueEqualsToAssertEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueNegationToAssertFalse")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueNullToAssertNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.BestPractices")
//activeRecipe("org.openrewrite.java.testing.cleanup.RemoveEmptyTests")
//activeRecipe("org.openrewrite.java.testing.cleanup.RemoveTestPrefix")
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldIncludeAssertions")
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldNotBePublic")

//activeRecipe("org.openrewrite.java.testing.hamcrest.AddHamcrestIfUsed")
//activeRecipe("org.openrewrite.java.testing.hamcrest.AssertThatBooleanToAssertJ")
//activeRecipe("org.openrewrite.java.testing.hamcrest.HamcrestIsMatcherToAssertJ")
//activeRecipe("org.openrewrite.java.testing.hamcrest.HamcrestMatcherToAssertJ")
//activeRecipe("org.openrewrite.java.testing.hamcrest.HamcrestNotMatcherToAssertJ")
//activeRecipe("org.openrewrite.java.testing.hamcrest.HamcrestOfMatchersToAssertJ")
//activeRecipe("org.openrewrite.java.testing.hamcrest.MigrateHamcrestToAssertJ")
//activeRecipe("org.openrewrite.java.testing.hamcrest.RemoveIsMatcher")

//activeRecipe("org.openrewrite.java.testing.junit5.AddMissingNested")
//activeRecipe("org.openrewrite.java.testing.junit5.AddParameterizedTestAnnotation")
//activeRecipe("org.openrewrite.java.testing.junit5.AssertToAssertions")
//activeRecipe("org.openrewrite.java.testing.junit5.AssertTrueInstanceofToAssertInstanceOf")
//activeRecipe("org.openrewrite.java.testing.junit5.CategoryToTag")
//activeRecipe("org.openrewrite.java.testing.junit5.CleanupAssertions")
//activeRecipe("org.openrewrite.java.testing.junit5.CleanupJUnitImports")
//activeRecipe("org.openrewrite.java.testing.junit5.EnclosedToNested")
//activeRecipe("org.openrewrite.java.testing.junit5.ExpectedExceptionToAssertThrows")
//activeRecipe("org.openrewrite.java.testing.junit5.IgnoreToDisabled")
//activeRecipe("org.openrewrite.java.testing.junit5.JUnit4to5Migration")
//activeRecipe("org.openrewrite.java.testing.junit5.JUnit5BestPractices")
//activeRecipe("org.openrewrite.java.testing.junit5.JUnitParamsRunnerToParameterized")
//activeRecipe("org.openrewrite.java.testing.junit5.LifecycleNonPrivate")
//activeRecipe("org.openrewrite.java.testing.junit5.MigrateAssumptions")
//activeRecipe("org.openrewrite.java.testing.junit5.MigrateJUnitTestCase")
//activeRecipe("org.openrewrite.java.testing.junit5.MockitoJUnitToMockitoExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.ParameterizedRunnerToParameterized")
//activeRecipe("org.openrewrite.java.testing.junit5.RemoveDuplicateTestTemplates")
//activeRecipe("org.openrewrite.java.testing.junit5.RemoveObsoleteRunners")
//activeRecipe("org.openrewrite.java.testing.junit5.RemoveTryCatchFailBlocks")
//activeRecipe("org.openrewrite.java.testing.junit5.RunnerToExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.StaticImports")
//activeRecipe("org.openrewrite.java.testing.junit5.TempDirNonFinal")
//activeRecipe("org.openrewrite.java.testing.junit5.TemporaryFolderToTempDir")
//activeRecipe("org.openrewrite.java.testing.junit5.TestRuleToTestInfo")
//activeRecipe("org.openrewrite.java.testing.junit5.ThrowingRunnableToExecutable")
//activeRecipe("org.openrewrite.java.testing.junit5.UpdateBeforeAfterAnnotations")
//activeRecipe("org.openrewrite.java.testing.junit5.UpdateMockWebServer")
//activeRecipe("org.openrewrite.java.testing.junit5.UpdateTestAnnotation")
//activeRecipe("org.openrewrite.java.testing.junit5.UpgradeOkHttpMockWebServer")
//activeRecipe("org.openrewrite.java.testing.junit5.UseHamcrestAssertThat")
//activeRecipe("org.openrewrite.java.testing.junit5.UseMockitoExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.UseTestMethodOrder")
//activeRecipe("org.openrewrite.java.testing.junit5.UseWiremockExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.UseXMLUnitLegacy")
//activeRecipe("org.openrewrite.java.testing.junit5.VertxUnitToVertxJunit5")

//activeRecipe("org.openrewrite.java.testing.mockito.AnyStringToNullable")
//activeRecipe("org.openrewrite.java.testing.mockito.AnyToNullable")
//activeRecipe("org.openrewrite.java.testing.mockito.CleanupMockitoImports")
//activeRecipe("org.openrewrite.java.testing.mockito.Mockito1to3Migration")
//activeRecipe("org.openrewrite.java.testing.mockito.Mockito1to4Migration")
//activeRecipe("org.openrewrite.java.testing.mockito.MockitoJUnitRunnerSilentToExtension")
//activeRecipe("org.openrewrite.java.testing.mockito.MockUtilsToStatic")
//activeRecipe("org.openrewrite.java.testing.mockito.PowerMockitoMockStaticToMockito")
//activeRecipe("org.openrewrite.java.testing.mockito.ReplacePowerMockito")

// Spring (to test)

//activeRecipe("org.openrewrite.java.spring.AddSpringProperty")
//activeRecipe("org.openrewrite.java.spring.amqp.UseTlsAmqpConnectionString")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementChunkListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementJobExecutionListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementRepeatListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementSkipListenerSupportDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementStepExecutionListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.MigrateItemWriterWrite")
//activeRecipe("org.openrewrite.java.spring.batch.MigrateJobBuilderFactory")
//activeRecipe("org.openrewrite.java.spring.batch.RemoveDefaultBatchConfigurer")
//activeRecipe("org.openrewrite.java.spring.batch.ReplaceSupportClassWithItsInterface")
//activeRecipe("org.openrewrite.java.spring.BeanMethodsNotPublic")
//activeRecipe("org.openrewrite.java.spring.boot2.AddConfigurationAnnotationIfBeansPresent")
//activeRecipe("org.openrewrite.java.spring.boot2.ChangeEmbeddedServletContainerCustomizer")
//activeRecipe("org.openrewrite.java.spring.boot2.ConditionalOnBeanAnyNestedCondition")
//activeRecipe("org.openrewrite.java.spring.boot2.DatabaseComponentAndBeanInitializationOrdering")
//activeRecipe("org.openrewrite.java.spring.boot2.GetErrorAttributes")
//activeRecipe("org.openrewrite.java.spring.boot2.HeadersConfigurerLambdaDsl")
//activeRecipe("org.openrewrite.java.spring.boot2.HttpSecurityLambdaDsl")
//activeRecipe("org.openrewrite.java.spring.boot2.MergeBootstrapYamlWithApplicationYaml")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateActuatorMediaTypeToApiVersion")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateApplicationHealthIndicatorToPingHealthIndicator")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateConfigurationPropertiesBindingPostProcessorValidatorBeanName")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateDatabaseCredentials")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateDiskSpaceHealthIndicatorConstructor")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateErrorControllerPackageName")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateErrorPropertiesIncludeStackTraceConstants")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateHibernateConstraintsToJavax")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateHsqlEmbeddedDatabaseConnection")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateHttpMessageConvertersPackageName")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateLocalServerPortAnnotation")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateLoggingSystemPropertyConstants")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateMultipartConfigFactory")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateRestClientBuilderCustomizerPackageName")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateRestTemplateBuilderBasicAuthorization")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateRestTemplateBuilderTimeoutByInt")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateSpringBootServletInitializerPackageName")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateToWebServerFactoryCustomizer")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateUndertowServletWebServerFactoryIsEagerInitFilters")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateUndertowServletWebServerFactorySetEagerInitFilters")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateWebTestClientBuilderCustomizerPackageName")
//activeRecipe("org.openrewrite.java.spring.boot2.MoveAutoConfigurationToImportsFile")
//activeRecipe("org.openrewrite.java.spring.boot2.OutputCaptureExtension")
//activeRecipe("org.openrewrite.java.spring.boot2.RemoveObsoleteSpringRunners")
//activeRecipe("org.openrewrite.java.spring.boot2.ReplaceDeprecatedEnvironmentTestUtils")
//activeRecipe("org.openrewrite.java.spring.boot2.ReplaceExtendWithAndContextConfiguration")
//activeRecipe("org.openrewrite.java.spring.boot2.RestTemplateBuilderRequestFactory")
//activeRecipe("org.openrewrite.java.spring.boot2.SamlRelyingPartyPropertyApplicationPropertiesMove")
//activeRecipe("org.openrewrite.java.spring.boot2.search.CustomizingJooqDefaultConfiguration")
//activeRecipe("org.openrewrite.java.spring.boot2.search.FindUpgradeRequirementsSpringBoot_2_5")
//activeRecipe("org.openrewrite.java.spring.boot2.search.IntegrationSchedulerPoolRecipe")
//activeRecipe("org.openrewrite.java.spring.boot2.search.LoggingShutdownHooks")
//activeRecipe("org.openrewrite.java.spring.boot2.search.MessagesInTheDefaultErrorView")
//activeRecipe("org.openrewrite.java.spring.boot2.ServerHttpSecurityLambdaDsl")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBoot2BestPractices")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootMavenPluginMigrateAgentToAgents")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_0")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_1")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_2")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_3")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_4")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_5")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_6")
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBootProperties_2_7")
//activeRecipe("org.openrewrite.java.spring.boot2.UnnecessarySpringExtension")
//activeRecipe("org.openrewrite.java.spring.boot2.UnnecessarySpringRunWith")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_0")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_1")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_2")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_3")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6")
//activeRecipe("org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7")
//activeRecipe("org.openrewrite.java.spring.boot3.ActuatorEndpointSanitization")
//activeRecipe("org.openrewrite.java.spring.boot3.AddRouteTrailingSlash")
//activeRecipe("org.openrewrite.java.spring.boot3.AddSetUseTrailingSlashMatch")
//activeRecipe("org.openrewrite.java.spring.boot3.ConfigurationOverEnableSecurity")
//activeRecipe("org.openrewrite.java.spring.boot3.DowngradeServletApiWhenUsingJetty")
//activeRecipe("org.openrewrite.java.spring.boot3.MaintainTrailingSlashURLMappings")
//activeRecipe("org.openrewrite.java.spring.boot3.MigrateMaxHttpHeaderSize")
//activeRecipe("org.openrewrite.java.spring.boot3.MigrateThymeleafDependencies")
//activeRecipe("org.openrewrite.java.spring.boot3.PreciseBeanType")
//activeRecipe("org.openrewrite.java.spring.boot3.RemoveConstructorBindingAnnotation")
//activeRecipe("org.openrewrite.java.spring.boot3.RemoveEnableBatchProcessing")
//activeRecipe("org.openrewrite.java.spring.boot3.SpringBatch4To5Migration")
//activeRecipe("org.openrewrite.java.spring.boot3.SpringBootProperties_3_0")
//activeRecipe("org.openrewrite.java.spring.boot3.SpringBootProperties_3_1")
//activeRecipe("org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0")
//activeRecipe("org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1")
//activeRecipe("org.openrewrite.java.spring.ChangeSpringPropertyKey")
//activeRecipe("org.openrewrite.java.spring.ChangeSpringPropertyValue")
//activeRecipe("org.openrewrite.java.spring.cloud2022.AddLoggingPatternLevelForSleuth")
//activeRecipe("org.openrewrite.java.spring.cloud2022.MavenPomUpgrade")
//activeRecipe("org.openrewrite.java.spring.cloud2022.MigrateCloudSleuthToMicrometerTracing")
//activeRecipe("org.openrewrite.java.spring.cloud2022.UpgradeSpringCloud_2022")
//activeRecipe("org.openrewrite.java.spring.data.MigrateJpaSort")
//activeRecipe("org.openrewrite.java.spring.data.MigrateQuerydslJpaRepository")
//activeRecipe("org.openrewrite.java.spring.data.UpgradeSpringData_2_3")
//activeRecipe("org.openrewrite.java.spring.data.UpgradeSpringData_2_5")
//activeRecipe("org.openrewrite.java.spring.data.UseJpaRepositoryDeleteAllInBatch")
//activeRecipe("org.openrewrite.java.spring.data.UseJpaRepositoryGetById")
//activeRecipe("org.openrewrite.java.spring.data.UseTlsJdbcConnectionString")
//activeRecipe("org.openrewrite.java.spring.DeleteSpringProperty")
//activeRecipe("org.openrewrite.java.spring.ExpandProperties")
//activeRecipe("org.openrewrite.java.SpringFormat")
//activeRecipe("org.openrewrite.java.spring.framework.EnvironmentAcceptsProfiles")
//activeRecipe("org.openrewrite.java.spring.framework.JdbcTemplateObjectArrayArgToVarArgs")
//activeRecipe("org.openrewrite.java.spring.framework.MigrateHandlerInterceptor")
//activeRecipe("org.openrewrite.java.spring.framework.MigrateInstantiationAwareBeanPostProcessorAdapter")
//activeRecipe("org.openrewrite.java.spring.framework.MigrateUtf8MediaTypes")
//activeRecipe("org.openrewrite.java.spring.framework.MigrateWebMvcConfigurerAdapter")
//activeRecipe("org.openrewrite.java.spring.framework.UpgradeSpringFramework_5_0")
//activeRecipe("org.openrewrite.java.spring.framework.UpgradeSpringFramework_5_1")
//activeRecipe("org.openrewrite.java.spring.framework.UpgradeSpringFramework_5_2")
//activeRecipe("org.openrewrite.java.spring.framework.UpgradeSpringFramework_5_3")
//activeRecipe("org.openrewrite.java.spring.framework.UpgradeSpringFrameworkDependencies")
//activeRecipe("org.openrewrite.java.spring.framework.UseObjectUtilsIsEmpty")
//activeRecipe("org.openrewrite.java.spring.http.ReplaceStringLiteralsWithHttpHeadersConstants")
//activeRecipe("org.openrewrite.java.spring.http.ReplaceStringLiteralsWithMediaTypeConstants")
//activeRecipe("org.openrewrite.java.spring.http.SimplifyMediaTypeParseCalls")
//activeRecipe("org.openrewrite.java.spring.http.SpringWebDependency")
//activeRecipe("org.openrewrite.java.spring.ImplicitWebAnnotationNames")
//activeRecipe("org.openrewrite.java.spring.NoAutowiredOnConstructor")
//activeRecipe("org.openrewrite.java.spring.NoRepoAnnotationOnRepoInterface")
//activeRecipe("org.openrewrite.java.spring.NoRequestMappingAnnotation")
//activeRecipe("org.openrewrite.java.spring.PropertiesToKebabCase")
//activeRecipe("org.openrewrite.java.spring.RenameBean")
//activeRecipe("org.openrewrite.java.spring.search.FindApiCalls")
//activeRecipe("org.openrewrite.java.spring.search.FindApiEndpoints")
//activeRecipe("org.openrewrite.java.spring.search.FindSpringComponents")
//activeRecipe("org.openrewrite.java.spring.security5.AuthorizeHttpRequests")
//activeRecipe("org.openrewrite.java.spring.security5.RenameNimbusdsJsonObjectPackageName")
//activeRecipe("org.openrewrite.java.spring.security5.ReplaceGlobalMethodSecurityWithMethodSecurity")
//activeRecipe("org.openrewrite.java.spring.security5.ReplaceGlobalMethodSecurityWithMethodSecurityXml")
//activeRecipe("org.openrewrite.java.spring.security5.search.FindEncryptorsQueryableTextUses")
//activeRecipe("org.openrewrite.java.spring.security5.UpdateArgon2PasswordEncoder")
//activeRecipe("org.openrewrite.java.spring.security5.UpdatePbkdf2PasswordEncoder")
//activeRecipe("org.openrewrite.java.spring.security5.UpdateSCryptPasswordEncoder")
//activeRecipe("org.openrewrite.java.spring.security5.UpgradeSpringSecurity_5_7")
//activeRecipe("org.openrewrite.java.spring.security5.UpgradeSpringSecurity_5_8")
//activeRecipe("org.openrewrite.java.spring.security5.UseNewRequestMatchers")
//activeRecipe("org.openrewrite.java.spring.security5.UseNewSecurityMatchers")
//activeRecipe("org.openrewrite.java.spring.security5.WebSecurityConfigurerAdapter")
//activeRecipe("org.openrewrite.java.spring.security6.oauth2.client.OAuth2ClientLambdaDsl")
//activeRecipe("org.openrewrite.java.spring.security6.oauth2.client.OAuth2LoginLambdaDsl")
//activeRecipe("org.openrewrite.java.spring.security6.oauth2.server.resource.OAuth2ResourceServerLambdaDsl")
//activeRecipe("org.openrewrite.java.spring.security6.PropagateAuthenticationServiceExceptions")
//activeRecipe("org.openrewrite.java.spring.security6.RemoveFilterSecurityInterceptorOncePerRequest")
//activeRecipe("org.openrewrite.java.spring.security6.RemoveOauth2LoginConfig")
//activeRecipe("org.openrewrite.java.spring.security6.RemoveUseAuthorizationManager")
//activeRecipe("org.openrewrite.java.spring.security6.RequireExplicitSavingOfSecurityContextRepository")
//activeRecipe("org.openrewrite.java.spring.security6.UpdateEnableReactiveMethodSecurity")
//activeRecipe("org.openrewrite.java.spring.security6.UpdateRequestCache")
//activeRecipe("org.openrewrite.java.spring.security6.UpgradeSpringSecurity_6_0")
//activeRecipe("org.openrewrite.java.spring.security6.UpgradeSpringSecurity_6_1")
//activeRecipe("org.openrewrite.java.spring.security6.UseSha256InRememberMe")
//activeRecipe("org.openrewrite.java.spring.SeparateApplicationYamlByProfile")
//activeRecipe("org.openrewrite.java.spring.UpdateApiManifest")


// Migrate Security
//activeRecipe("org.openrewrite.java.security.FindTextDirectionChanges")
//activeRecipe("org.openrewrite.java.security.JavaSecurityBestPractices")
//activeRecipe("org.openrewrite.java.security.marshalling.SecureJacksonDefaultTyping")
//activeRecipe("org.openrewrite.java.security.marshalling.SecureSnakeYamlConstructor")
//activeRecipe("org.openrewrite.java.security.OwaspA01")
//activeRecipe("org.openrewrite.java.security.OwaspA02")
//activeRecipe("org.openrewrite.java.security.OwaspA03")
//activeRecipe("org.openrewrite.java.security.OwaspA05")
//activeRecipe("org.openrewrite.java.security.OwaspA06")
//activeRecipe("org.openrewrite.java.security.OwaspA08")
//activeRecipe("org.openrewrite.java.security.OwaspA10")
//activeRecipe("org.openrewrite.java.security.OwaspTopTen")
//activeRecipe("org.openrewrite.java.security.PartialPathTraversalVulnerability")
//activeRecipe("org.openrewrite.java.security.RegularExpressionDenialOfService")
//activeRecipe("org.openrewrite.java.security.search.FindJacksonDefaultTypeMapping")
//activeRecipe("org.openrewrite.java.security.search.FindSensitiveApiEndpoints")
//activeRecipe("org.openrewrite.java.security.search.FindVulnerableJacksonJsonTypeInfo")
//activeRecipe("org.openrewrite.java.security.secrets.FindArtifactorySecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindAwsSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindAzureSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindDiscordSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindGenericSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindGitHubSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindGoogleSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindHerokuSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindJwtSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindMailChimpSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindMailgunSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindNpmSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindPasswordInUrlSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindPayPalSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindPgpSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindPicaticSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindRsaSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindSecretsByPattern")
//activeRecipe("org.openrewrite.java.security.secrets.FindSendGridSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindSlackSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindSquareSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindSshSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindStripeSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindTelegramSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindTwilioSecrets")
//activeRecipe("org.openrewrite.java.security.secrets.FindTwitterSecrets")
//activeRecipe("org.openrewrite.java.security.SecureRandom")
//activeRecipe("org.openrewrite.java.security.SecureRandomPrefersDefaultSeed")
//activeRecipe("org.openrewrite.java.security.SecureTempFileCreation")
//activeRecipe("org.openrewrite.java.security.spring.CsrfProtection")
//activeRecipe("org.openrewrite.java.security.spring.PreventClickjacking")
//activeRecipe("org.openrewrite.java.security.UseFilesCreateTempDirectory")
//activeRecipe("org.openrewrite.java.security.XmlParserXXEVulnerability")
//activeRecipe("org.openrewrite.java.security.ZipSlip")


// Migrate hibernate (to test)
//activeRecipe("org.openrewrite.hibernate.MigrateToHibernate61")
//activeRecipe("org.openrewrite.hibernate.MigrateToHibernate62")
//activeRecipe("org.openrewrite.hibernate.MigrateToHibernateDependencies61")
//activeRecipe("org.openrewrite.hibernate.MigrateToHypersistenceUtilsHibernate6.0")
//activeRecipe("org.openrewrite.hibernate.MigrateToHypersistenceUtilsHibernate6.2")
//activeRecipe("org.openrewrite.hibernate.TypeAnnotationParameter")
//activeRecipe("org.openrewrite.hibernate.TypeDescriptorToType")


// Migrate httpclient (to test)
//activeRecipe("org.openrewrite.java.apache.httpclient4.MappingDeprecatedClasses")
//activeRecipe("org.openrewrite.java.apache.httpclient4.MigrateDefaultHttpClient")
//activeRecipe("org.openrewrite.java.apache.httpclient4.UpgradeApacheHttpClient_4_5")
//activeRecipe("org.openrewrite.java.apache.httpclient5.AddTimeUnitArgument")
//activeRecipe("org.openrewrite.java.apache.httpclient5.NewStatusLine")
//activeRecipe("org.openrewrite.java.apache.httpclient5.StatusLine")
//activeRecipe("org.openrewrite.java.apache.httpclient5.UpgradeApacheHttpClient_5")
//activeRecipe("org.openrewrite.java.apache.httpclient5.UpgradeApacheHttpClient_5_ClassMapping")
//activeRecipe("org.openrewrite.java.apache.httpclient5.UpgradeApacheHttpClient_5_DeprecatedMethods")
//activeRecipe("org.openrewrite.java.apache.httpclient5.UpgradeApacheHttpClient_5_TimeUnit")


// Recipes
//activeRecipe("org.openrewrite.java.recipes.ExecutionContextParameterName")
//activeRecipe("org.openrewrite.java.recipes.FindRecipes")
//activeRecipe("org.openrewrite.java.recipes.MigrateJavaTemplateToRewrite8")
//activeRecipe("org.openrewrite.java.recipes.MigrateMarkersSearchResult")
//activeRecipe("org.openrewrite.java.recipes.MigrateRecipeToRewrite8")
//activeRecipe("org.openrewrite.java.recipes.MigrateTestToRewrite8")
//activeRecipe("org.openrewrite.java.recipes.RemoveApplicabilityTestFromYamlRecipe")
//activeRecipe("org.openrewrite.java.recipes.SelectRecipeExamples")
//activeRecipe("org.openrewrite.java.recipes.SetDefaultEstimatedEffortPerOccurrence")
//activeRecipe("org.openrewrite.java.recipes.SourceSpecTextBlockIndentation")
//activeRecipe("org.openrewrite.java.recipes.UpdateMovedPackageClassName")
//activeRecipe("org.openrewrite.java.recipes.UpdateMovedRecipe")
//activeRecipe("org.openrewrite.java.recipes.UpdateMovedRecipeXml")
//activeRecipe("org.openrewrite.java.recipes.UpdateMovedRecipeYaml")
//activeRecipe("org.openrewrite.java.recipes.UseJavaParserBuilderInJavaTemplate")

// Migrate on javax (not anymore needed?)
//activeRecipe("org.openrewrite.java.migrate.javax.AddInjectDependencies")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxbDependencies")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxbRuntime")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxwsDependencies")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxwsRuntime")
//activeRecipe("org.openrewrite.java.migrate.javax.AddScopeToInjectedClass")
//activeRecipe("org.openrewrite.java.migrate.javax.JavaxLangModelUtil")
//activeRecipe("org.openrewrite.java.migrate.javax.JavaxManagementMonitorAPIs")
//activeRecipe("org.openrewrite.java.migrate.javax.JavaxXmlStreamAPIs")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateAbstractAnnotationValueVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateAbstractElementVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateAbstractTypeVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateCounterMonitorSetThresholdToSetInitThreshold")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateElementKindVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateElementScanner6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateSimpleAnnotationValueVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateSimpleElementVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateSimpleTypeVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateTypeKindVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateXMLEventFactoryNewInstanceToNewFactory")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateXMLInputFactoryNewInstanceToNewFactory")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateXMLOutputFactoryNewInstanceToNewFactory")



// Migrate Other

//activeRecipe("org.openrewrite.java.migrate.AddJDeprScanPlugin")
//activeRecipe("org.openrewrite.java.migrate.AddSuppressionForIllegalReflectionWarningsPlugin")
//activeRecipe("org.openrewrite.java.migrate.cobertura.RemoveCoberturaMavenPlugin")
//activeRecipe("org.openrewrite.java.migrate.jacoco.UpgradeJaCoCoMavenPluginVersion")



//activeRecipe("org.openrewrite.java.migrate.lang.JavaLangAPIs")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateCharacterIsJavaLetterOrDigitToIsJavaIdentifierPart")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateCharacterIsJavaLetterToIsJavaIdentifierStart")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateCharacterIsSpaceToIsWhitespace")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateClassLoaderDefineClass")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateClassNewInstanceToGetDeclaredConstructorNewInstance")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateRuntimeVersionMajorToFeature")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateRuntimeVersionMinorToInterim")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateRuntimeVersionSecurityToUpdate")
//activeRecipe("org.openrewrite.java.migrate.lang.MigrateSecurityManagerMulticast")
//activeRecipe("org.openrewrite.java.migrate.lang.RemoveThreadDestroyMethod")
//activeRecipe("org.openrewrite.java.migrate.lang.StringFormatted")
//activeRecipe("org.openrewrite.java.migrate.lang.StringRulesRecipes")
//activeRecipe("org.openrewrite.java.migrate.lang.UseStringIsEmptyRecipe")
//activeRecipe("org.openrewrite.java.migrate.lang.UseVar")
//activeRecipe("org.openrewrite.java.migrate.lang.var.UseVarForGenericMethodInvocations")
//activeRecipe("org.openrewrite.java.migrate.lang.var.UseVarForGenericsConstructors")
//activeRecipe("org.openrewrite.java.migrate.lang.var.UseVarForObject")
//activeRecipe("org.openrewrite.java.migrate.lang.var.UseVarForPrimitive")

//activeRecipe("org.openrewrite.java.migrate.logging.JavaLoggingAPIs")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateGetLoggingMXBeanToGetPlatformMXBean")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateInterfaceLoggingMXBeanToPlatformLoggingMXBean")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateLoggerGlobalToGetGlobal")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateLoggerLogrbToUseResourceBundle")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateLogRecordSetMillisToSetInstant")
//activeRecipe("org.openrewrite.java.migrate.lombok.LombokValToFinalVar")
//activeRecipe("org.openrewrite.java.migrate.lombok.UpdateLombokToJava11")
//activeRecipe("org.openrewrite.java.migrate.maven.shared.MavenSharedStringUtilsRecipes")
//activeRecipe("org.openrewrite.java.migrate.maven.UseMavenCompilerPluginReleaseConfiguration")
//activeRecipe("org.openrewrite.java.migrate.metrics.SimplifyMicrometerMeterTags")
//activeRecipe("org.openrewrite.java.migrate.net.JavaNetAPIs")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateHttpURLConnectionHttpServerErrorToHttpInternalError")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateMulticastSocketGetTTLToGetTimeToLive")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateMulticastSocketSetTTLToSetTimeToLive")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateURLDecoderDecode")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateURLEncoderEncode")
//activeRecipe("org.openrewrite.java.migrate.plexus.PlexusFileUtilsRecipes")
//activeRecipe("org.openrewrite.java.migrate.plexus.PlexusStringUtilsRecipes")
//activeRecipe("org.openrewrite.java.migrate.search.AboutJavaVersion")
//activeRecipe("org.openrewrite.java.migrate.sql.JavaSqlAPIs")
//activeRecipe("org.openrewrite.java.migrate.sql.MigrateDriverManagerSetLogStream")
//activeRecipe("org.openrewrite.java.migrate.UpgradeJavaVersion")
//activeRecipe("org.openrewrite.java.migrate.util.RemoveFinalizerFromZip")
//activeRecipe("org.openrewrite.java.migrate.util.UseLocaleOf")
//activeRecipe("org.openrewrite.java.migrate.wro4j.UpgradeWro4jMavenPluginVersion")
}

checkstyle {
    isIgnoreFailures = true
}


tasks.withType<Test> {
    useJUnitPlatform()
}


