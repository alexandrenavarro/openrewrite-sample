plugins {
    java
    checkstyle
    id("org.openrewrite.rewrite") version "5.38.0"
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
    compileOnly("com.pushtorefresh:javac-warning-annotation:1.0.0")
    annotationProcessor("com.pushtorefresh:javac-warning-annotation:1.0.0")

    rewrite(platform("org.openrewrite:rewrite-bom:7.38.0"))
    rewrite(platform("org.openrewrite.recipe:rewrite-recipe-bom:1.16.3"))

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

//activeRecipe("org.openrewrite.java.cleanup.EmptyBlock")                                                                           // ,format, yes, 10, EmptyBlock, java:S108 (Nested blocks of code should not be left empty),
//activeRecipe("org.openrewrite.java.cleanup.MethodParamPad")                                                                       // ,format, yes, 10, MethodParamPad, no,
//activeRecipe("org.openrewrite.java.cleanup.ModifierOrder")                                                                        // ,format, yes, 10, ModifierOrder, java:S1124 (Reorder the modifiers to comply with the Java Language Specification),
//activeRecipe("org.openrewrite.java.cleanup.NeedBraces")                                                                           // ,format, yes, 10, NeedBraces, no,
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceAfter")                                                                    // ,format, yes, 10, NoWhitespaceAfter, no,
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceBefore")                                                                   // ,format, yes, 10, NoWhitespaceBefore, no,
//activeRecipe("org.openrewrite.java.cleanup.OperatorWrap")                                                                         // ,format, yes, 10, OperatorWrap, no,
//activeRecipe("org.openrewrite.java.cleanup.RemoveExtraSemicolons")                                                                // ,format, yes, 10, no, no,
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnneededBlock")                                                                  // ,format, yes, 10, AvoidNestedBlocks, java:S1199 (Extract this nested code block into a method.),
//activeRecipe("org.openrewrite.java.cleanup.TypecastParenPad")                                                                     // ,format, yes, 10, TypecastParenPad, java:S1905 (Remove this unnecessary cast to "String"),
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryParentheses")                                                               // ,format, yes, 10, UnnecessaryParentheses (not by default), no,
//activeRecipe("org.openrewrite.java.format.BlankLines")                                                                            // ,format, yes, 10, no, no, Add some blank like between method
//activeRecipe("org.openrewrite.java.format.EmptyNewlineAtEndOfFile")                                                               // ,format, yes, 10, NewlineAtEndOfFile, no,
//activeRecipe("org.openrewrite.java.format.NormalizeTabsOrSpaces")                                                                 // ,format, yes, 10, FileTabCharacter, no,
//activeRecipe("org.openrewrite.java.format.RemoveTrailingWhitespace")                                                              // ,format, yes, 10, RegexpSingleline, no,
//activeRecipe("org.openrewrite.java.format.SingleLineComments")                                                                    // ,format, yes, 10, no, no, just a space after a single line comment
//activeRecipe("org.openrewrite.java.RemoveUnusedImports")                                                                          // ,format, yes, 10, yes, yes,
//activeRecipe("org.openrewrite.java.format.Spaces")                                                                                // ,format, yes, 10, WhitespaceAround ParenPad WhitespaceAfter GenericWhitespace, no, caution problem reformat with gradle, do exclusion of gradle file
//activeRecipe("org.openrewrite.java.cleanup.PadEmptyForLoopComponents")                                                            // ,format, yes, 10, EmptyForIteratorPad, ?,
////activeRecipe("org.openrewrite.java.format.AutoFormat")                                                                          // ,format, no, -1, no, no, don't not format correct compared to intellij
////activeRecipe("org.openrewrite.java.format.TabsAndIndents")                                                                      // ,format, no, -1, no, no, do not format like intellij (1 or 2 indent for continuation)
////activeRecipe("org.openrewrite.java.format.WrappingAndBraces")                                                                   // ,format, no, -1, no, no, break all the formatting notably gradle.build, don't use it absolutely
////activeRecipe("org.openrewrite.java.format.NormalizeFormat")                                                                     // ,format, no, -1, no, no, do nothing except some stuff in the gradle.build
////activeRecipe("org.openrewrite.java.format.NormalizeLineBreaks")                                                                 // ,format, no, -1, no, no, Normalize LF / CRLF, weird behaviour to choose LF ou CRLF if different?

//activeRecipe("org.openrewrite.java.cleanup.PrimitiveWrapperClassConstructorToValueOf")                                            // ,cleanup, yes, 9, IllegalInstantiation, no,
//activeRecipe("org.openrewrite.java.cleanup.MinimumSwitchCases")                                                                   // ,cleanup, yes, 9, MissingSwitchDefault, no, ok
//activeRecipe("org.openrewrite.java.cleanup.MultipleVariableDeclarations")                                                         // ,cleanup, yes, 9, MultipleVariableDeclarations, no,
//activeRecipe("org.openrewrite.java.cleanup.SimplifyBooleanExpression")                                                            // ,cleanup, yes, 9, SimplifyBooleanExpression, no,
//activeRecipe("org.openrewrite.java.cleanup.SimplifyBooleanReturn")                                                                // ,cleanup, yes, 9, SimplifyBooleanReturn, no,
//activeRecipe("org.openrewrite.java.cleanup.UpperCaseLiteralSuffixes")                                                             // ,cleanup, yes, 9, UpperEll, no,
//activeRecipe("org.openrewrite.java.cleanup.UseJavaStyleArrayDeclarations")                                                        // ,cleanup, yes, 9, ArrayTypeStyle, no,
//activeRecipe("org.openrewrite.java.cleanup.HideUtilityClassConstructor")                                                          // ,cleanup, yes, 9, HideUtilityClassConstructor, no, vs @Utility
//activeRecipe("org.openrewrite.java.cleanup.NoDoubleBraceInitialization")                                                          // ,cleanup, yes, 9, AvoidDoubleBraceInitialization (not by default), no,
//activeRecipe("org.openrewrite.java.cleanup.CovariantEquals")                                                                      // ,cleanup, yes, 9, CovariantEquals  (not by default), no,
//activeRecipe("org.openrewrite.java.cleanup.DefaultComesLast")                                                                     // ,cleanup, yes, 9, DefaultComesLast (not by default), no,
//activeRecipe("org.openrewrite.java.cleanup.EqualsAvoidsNull")                                                                     // ,cleanup, yes, 9, EqualsAvoidNull (not by default), no,
//activeRecipe("org.openrewrite.java.cleanup.ExplicitInitialization")                                                               // ,cleanup, yes, 9, ExplicitInitialization (not by default), no,
//activeRecipe("org.openrewrite.java.cleanup.UseCollectionInterfaces")                                                              // ,cleanup, yes, 9, IllegalType (not by default), no,
//activeRecipe("org.openrewrite.java.cleanup.StringLiteralEquality")                                                                // ,cleanup, yes, 9, StringLiteralEquality, no,
//activeRecipe("org.openrewrite.java.cleanup.FallThrough")                                                                          // ,cleanup, yes, 9, FallThrough, no,
//activeRecipe("org.openrewrite.java.cleanup.NoFinalizer")                                                                          // ,cleanup, yes, 9, NoFinalizer, no, Remove code.of finalize
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryCloseInTryWithResources")                                                   // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.InlineVariable")                                                                       // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.RemoveRedundantTypeCast")                                                              // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryThrows")                                                                    // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.UseDiamondOperator")                                                                   // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.StaticMethodNotFinal")                                                                 // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.MissingOverrideAnnotation")                                                            // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.AddSerialVersionUidToSerializable")                                                    // ,cleanup, yes, 9, no, no, does not generate the uid, weird?
//activeRecipe("org.openrewrite.java.cleanup.CompareEnumsWithEqualityOperator")                                                     // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.NestedEnumsAreNotStatic")                                                              // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.UseLambdaForFunctionalInterface")                                                      // ,cleanup, yes, 9, no, no,
//activeRecipe("org.openrewrite.java.cleanup.NoRedundantJumpStatements")                                                            // ,cleanup, yes, 9, no, ?,
//activeRecipe("org.openrewrite.java.cleanup.IsEmptyCallOnCollections")                                                             // ,cleanup, yes, 9, ?, yes sonar , transform size() -> .isEmpty()
//activeRecipe("org.openrewrite.java.cleanup.IndexOfReplaceableByContains")                                                         // ,cleanup, yes, 9, ?, ?, ok, transform (path.indexOf("/")>-1){ -> contains
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedPrivateMethods")                                                           // ,cleanup, yes, 9, ?, java:s1144,  ok on a big project
//activeRecipe("org.openrewrite.java.cleanup.UseStringReplace")                                                                     // ,cleanup, yes, 9, ?, java:s5351, replaceAll -> replace, ok on a big project, let regex with replaceAll
//activeRecipe("org.openrewrite.java.cleanup.NoToStringOnStringType")                                                               // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.SimplifyConstantIfBranchExecution")                                                    // ,cleanup, yes, 9, ?, ?, sample (a == true) -> (a)
//activeRecipe("org.openrewrite.java.cleanup.SimplifyCompoundStatement")                                                            // ,cleanup, yes, 9, ?, ?, `b &= false` with `b = false` (not used a lot)
//activeRecipe("org.openrewrite.java.migrate.util.OptionalNotEmptyToIsPresent")                                                     // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.OptionalNotPresentToIsEmpty")                                                     // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonList")                                                 // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonMap")                                                  // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonSet")                                                  // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableList")                                              // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableSet")                                               // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.migrate.util.UseMapOf")                                                                        // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceStringBuilderWithString")                                                       // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ChainStringBuilderAppendCalls")                                                        // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceThreadRunWithThreadStart")                                                      // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.BigDecimalRoundingConstantsToEnums")                                                   // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.BooleanChecksNotInverted")                                                             // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.CaseInsensitiveComparisonsDoNotChangeCase")                                            // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.FixStringFormatExpressions")                                                           // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.InstanceOfPatternMatch")                                                               // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ExternalizableHasNoArgsConstructor")                                                   // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ForLoopIncrementInUpdate")                                                             // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.IndexOfChecksShouldUseAStartPosition")                                                 // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.IndexOfShouldNotCompareGreaterThanZero")                                               // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.NoPrimitiveWrappersForToStringOrCompareTo")                                            // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.NewStringBuilderBufferWithCharArgument")                                               // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.NoEmptyCollectionWithRawType")                                                         // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.NoValueOfOnStringType")                                                                // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ObjectFinalizeCallsSuper")                                                             // ,cleanup, yes, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.RenameMethodsNamedHashcodeEqualOrTostring")                                            // ,cleanup, yes, 9, ?, ?,


//activeRecipe("org.openrewrite.java.cleanup.FinalClass")                                                                           // ,cleanup, yes, 8, FinalClass, no, ?, set only on private class or private constructor, seems ok, ok on a big project.
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedLocalVariables")                                                           // ,cleanup, yes, 8, UnusedLocalVariable, no,  (not by default, present in doc but does not work?), ?, is it ok always?, ok on big project

//activeRecipe("org.openrewrite.java.migrate.UseJavaUtilBase64")                                                                    // ,cleanup, no (not possible in jdk 17 without ), 2, ?, ?, Not anymore really

////activeRecipe("org.openrewrite.java.cleanup.LowercasePackage")                                                                   // ,cleanup, yes, 1, PackageName, no, can break if the project is a lib.
////activeRecipe("org.openrewrite.java.cleanup.MethodNameCasing")                                                                   // ,cleanup, yes, 1, MethodName, no, can break if the project is a lib.
////activeRecipe("org.openrewrite.java.cleanup.RenamePrivateFieldsToCamelCase")                                                     // ,cleanup, yes, 1, MemberName, no, can break if the project is a lib.

////activeRecipe("org.openrewrite.java.cleanup.HiddenField")                                                                        // ,cleanup, yes, ?, HiddenField, no,, rename a ragument with arg1 if attribute in the class except for setter / constructor
//activeRecipe("org.openrewrite.java.cleanup.NoEqualityInForCondition")                                                             // ,cleanup, yes, ?, ?, ?, no effect on a big project, to be tested
//// RemoveTestPrefix

////activeRecipe("org.openrewrite.java.cleanup.FinalizeLocalVariables")                                                             // ,cleanup, yes, -1, FinalLocalVariable, no, ?, controversial, have some problem like finalvar on a big project
////activeRecipe("org.openrewrite.java.cleanup.RenameLocalVariablesToCamelCase")                                                    // ,cleanup, yes, -1, LocalFinalVariableName LocalVariableName, no, problem error some times (error between Class and variable, does not compile)
////activeRecipe("org.openrewrite.java.cleanup.ReplaceDuplicateStringLiterals")                                                     // ,cleanup, yes, -1, MultipleStringLiterals, no, create String final and reference it on all ok on the principle but errors on a big project on interface with private static String (not allowed)
////activeRecipe("org.openrewrite.java.migrate.util.UseEnumSetOf")                                                                  // ,cleanup, yes, -1, ?, ?, Error caused by: java.lang.IllegalArgumentException: This template requires 1 parameters., at org.openrewrite.java.JavaTemplate.withTemplate(JavaTemplate.java:65)
////activeRecipe("org.openrewrite.java.cleanup.FinalizeMethodArguments")                                                            // ,cleanup, yes, -2, FinalParameters, no, controversial, use ParameterAssignment in checkstyle instead


////activeRecipe("org.openrewrite.java.cleanup.SimplifyConsecutiveAssignments")                                                     // ,cleanup, not yet, -1, ?, ?, generate error in the code with comment
////activeRecipe("org.openrewrite.java.cleanup.LambdaBlockToExpression")                                                            // ,cleanup, not yet, -1, ?, ?, do not use, reformat gradle.build
////activeRecipe("org.openrewrite.java.cleanup.ReplaceLambdaWithMethodReference")                                                   // ,cleanup, not yet, -1, ?, problem if 2 classes with the same for the class
////activeRecipe("org.openrewrite.java.cleanup.CombineSemanticallyEqualCatchBlocks")                                                // ,cleanup, not yet, -1, ?, ? error in comments in source code
////activeRecipe("org.openrewrite.java.cleanup.ControlFlowIndentation")                                                             // ,cleanup, not yet, -1, ?, ? reformat code incorrectly
////activeRecipe("org.openrewrite.java.cleanup.RenameExceptionInEmptyCatch")                                                        // ,cleanup, not yet, -1, ?, ? error in comments in source code
////activeRecipe("org.openrewrite.java.cleanup.UnnecessaryCatch")                                                                   // ,cleanup, not yet, -1, IllegalCatch, ?, do not use, change the behaviour if NPE occurs for instance

//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedPrivateFields")                                                            // ,cleanup, not yet, -2, ?, ?,, NotFound, can break notably in unit or Autowired field
//activeRecipe("org.openrewrite.java.cleanup.FinalizePrivateFields")                                                                // ,cleanup, not yet, -2, ?, ?, nonFound, controversial
//activeRecipe("org.openrewrite.java.cleanup.ExplicitLambdaArgumentTypes")                                                          // ,cleanup, not yet, -2, ?, ?, controversial, some case ok some other not
//activeRecipe("org.openrewrite.java.cleanup.ForLoopControlVariablePostfixOperators")                                               // ,cleanup, not yet, -2, ?, ? --i -> i--, can change the behaviour
//activeRecipe("org.openrewrite.java.cleanup.ReplaceTextBlockWithString")                                                           // ,cleanup, not yet, -2, ?, ?, Does not want to do that (do the contrary)
//activeRecipe("org.openrewrite.java.cleanup.NoFinalizedLocalVariables")                                                            // ,cleanup, not yet, -2, ?, ?, controversial, generally ok, some case ok some other not

//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryExplicitTypeArguments")                                                     // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryPrimitiveAnnotations")                                                      // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.WhileInsteadOfFor")                                                                    // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.WriteOctalValuesAsDecimal")                                                            // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.RedundantFileCreation")                                                                // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.CatchClauseOnlyRethrows")                                                              // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested

//activeRecipe("org.openrewrite.java.cleanup.UseMapContainsKey")                                                                    // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ReplaceStackWithDeque")                                                                // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ReferentialEqualityToObjectEquals")                                                    // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ExplicitCharsetOnStringGetBytes")                                                      // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UnwrapRepeatableAnnotations")                                                          // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UseStandardCharset")                                                                   // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnneededAssertion")                                                              // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.AtomicPrimitiveEqualsUsesGet")                                                         // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.AvoidBoxedBooleanExpressions")                                                         // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ReplaceApacheCommonsLang3ValidateNotNullWithObjectsRequireNonNull")                    // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UseObjectNotifyAll")                                                                   // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.ReplaceRedundantFormatWithPrintf")                                                     // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.RemoveCallsToObjectFinalize")                                                          // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.CommonDeclarationSiteTypeVariances")                                                   // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.RemoveCallsToSystemGc")                                                                // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.UseListSort")                                                                          // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.UseForEachRemoveInsteadOfSetRemoveAll")                                                // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.UseSystemLineSeparator")                                                               // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.SimplifyDurationCreationUnits")                                                        // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.RemoveEmptyJavaDocParameters")                                                         // ,cleanup, not yet, 0, ?, ?, not found

//activeRecipe("org.openrewrite.java.cleanup.DeclarationSiteTypeVariance")                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.FixSerializableFields")                                                                // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceStreamToListWithCollect")                                                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.RemoveInstanceOfPatternMatch")                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceDeprecatedRuntimeExecMethods")                                                  // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceValidateNotNullHavingSingleArgWithObjectsRequireNonNull")                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceValidateNotNullHavingVarargsWithObjectsRequireNonNull")                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.controlflow.ControlFlowVisualization")                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.UseStaticImport")                                                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.NoStaticImport")                                                                               // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RandomizeId")                                                                                  // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReplaceConstant")                                                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReplaceStringLiteralWithConstant")                                                             // ,?, not yet, 0, ?, ?,

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
//activeRecipe("org.openrewrite.java.cleanup.UseAsBuilder")                                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.DeleteMethodArgument")                                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.DependencyLicenseCheck")                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.DependencyVulnerabilityCheck")                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.DoesNotUseRewriteSkip")                                                                        // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.UpdateSourcePositions")                                                                        // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.SimplifyMethodChain")                                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RecipeExceptionDemonstration")                                                                 // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RecipeMarkupDemonstration")                                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RemoveAnnotation")                                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RemoveImplements")                                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RemoveObjectsIsNull")                                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReorderMethodArguments")                                                                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.RemoveJavaDocAuthorTag")                                                               // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.JavaApiBestPractices")                                                                 // ,?, not yet, 0, ?, ?,




// https://github.com/openrewrite/rewrite-docs/blob/master/SUMMARY.md
// Global Java CommonStaticAnalysis

//////activeRecipe("org.openrewrite.java.cleanup.CommonStaticAnalysis")                                                             // ,cleanup, not yet, -1, ?, ? group some others receipe, some are not ok
//    - org.openrewrite.java.cleanup.AddSerialVersionUidToSerializable                                                              // already tested ok
//    - org.openrewrite.java.cleanup.AtomicPrimitiveEqualsUsesGet
//    - org.openrewrite.java.cleanup.BigDecimalRoundingConstantsToEnums                                                             // already tested, ok
//    - org.openrewrite.java.cleanup.BooleanChecksNotInverted                                                                       // already tested, ok
//    - org.openrewrite.java.cleanup.CaseInsensitiveComparisonsDoNotChangeCase
//    - org.openrewrite.java.cleanup.CatchClauseOnlyRethrows
//    - org.openrewrite.java.cleanup.ChainStringBuilderAppendCalls                                                                  // already tested, ok
//    - org.openrewrite.java.cleanup.CovariantEquals                                                                                // already tested, ok
//    - org.openrewrite.java.cleanup.DefaultComesLast                                                                               // already tested, ok
//    - org.openrewrite.java.cleanup.EmptyBlock                                                                                     // already tested, ok
//    - org.openrewrite.java.cleanup.EqualsAvoidsNull                                                                               // already tested, ok
//    - org.openrewrite.java.cleanup.ExplicitInitialization                                                                         // already tested, ok
//    - org.openrewrite.java.cleanup.ExternalizableHasNoArgsConstructor
//    - org.openrewrite.java.cleanup.FinalizePrivateFields                                                                          // already tested, ko
//    - org.openrewrite.java.cleanup.FallThrough                                                                                    // already tested, ok
//    - org.openrewrite.java.cleanup.FinalClass                                                                                     // already tested, ok
//    - org.openrewrite.java.cleanup.FixStringFormatExpressions
//    - org.openrewrite.java.cleanup.ForLoopIncrementInUpdate
//    - org.openrewrite.java.cleanup.IndexOfChecksShouldUseAStartPosition
//    - org.openrewrite.java.cleanup.IndexOfReplaceableByContains                                                                   // already tested, ok
//    - org.openrewrite.java.cleanup.IndexOfShouldNotCompareGreaterThanZero
//    - org.openrewrite.java.cleanup.InlineVariable                                                                                 // already tested, ok
//    - org.openrewrite.java.cleanup.IsEmptyCallOnCollections                                                                       // already tested, ok
//    - org.openrewrite.java.cleanup.LambdaBlockToExpression                                                                        // already tested, ko
//    - org.openrewrite.java.cleanup.LowercasePackage                                                                               // already tested, only on application not lib
//    - org.openrewrite.java.cleanup.MethodNameCasing                                                                               // already tested, only on application not lib
//    - org.openrewrite.java.cleanup.MinimumSwitchCases                                                                             // already tested, ok
//    - org.openrewrite.java.cleanup.ModifierOrder                                                                                  // already tested, ok
//    - org.openrewrite.java.cleanup.MultipleVariableDeclarations                                                                   // already tested, ok
//    - org.openrewrite.java.cleanup.NeedBraces                                                                                     // already tested, ok
//    - org.openrewrite.java.cleanup.NestedEnumsAreNotStatic                                                                        // already tested, ok
//    - org.openrewrite.java.cleanup.NewStringBuilderBufferWithCharArgument
//    - org.openrewrite.java.cleanup.NoDoubleBraceInitialization                                                                    // already tested, ok
//    - org.openrewrite.java.cleanup.NoEmptyCollectionWithRawType
//    - org.openrewrite.java.cleanup.NoEqualityInForCondition
//    - org.openrewrite.java.cleanup.NoFinalizer                                                                                    // already tested, ok
//    - org.openrewrite.java.cleanup.NoPrimitiveWrappersForToStringOrCompareTo
//    - org.openrewrite.java.cleanup.NoRedundantJumpStatements                                                                      // already tested, ok
//    - org.openrewrite.java.cleanup.NoToStringOnStringType                                                                         // already tested, ok
//    - org.openrewrite.java.cleanup.NoValueOfOnStringType
//    - org.openrewrite.java.cleanup.ObjectFinalizeCallsSuper
//    - org.openrewrite.java.cleanup.PrimitiveWrapperClassConstructorToValueOf                                                      // already tested, ok
//    - org.openrewrite.java.cleanup.RedundantFileCreation
//    - org.openrewrite.java.cleanup.RemoveExtraSemicolons                                                                          // already tested, ok
//    - org.openrewrite.java.cleanup.RenameLocalVariablesToCamelCase                                                                // already tested, ko
//    - org.openrewrite.java.cleanup.RenameMethodsNamedHashcodeEqualOrTostring
//    - org.openrewrite.java.cleanup.RenamePrivateFieldsToCamelCase                                                                 // already tested, only on application not lib
//    - org.openrewrite.java.cleanup.ReplaceLambdaWithMethodReference                                                               // already tested, ko
//    - org.openrewrite.java.cleanup.ReplaceStringBuilderWithString                                                                 // already tested, ok
//    - org.openrewrite.java.cleanup.SimplifyBooleanExpression                                                                      // already tested, ok
//    - org.openrewrite.java.cleanup.SimplifyBooleanReturn                                                                          // already tested, ok
//    - org.openrewrite.java.cleanup.StaticMethodNotFinal                                                                           // already tested, ok
//    - org.openrewrite.java.cleanup.StringLiteralEquality                                                                          // already tested, ok
//    - org.openrewrite.java.cleanup.UnnecessaryCloseInTryWithResources                                                             // already tested, ok
//    - org.openrewrite.java.cleanup.UnnecessaryExplicitTypeArguments
//    - org.openrewrite.java.cleanup.UnnecessaryParentheses                                                                         // already tested, ok
//    - org.openrewrite.java.cleanup.UnnecessaryPrimitiveAnnotations
//    - org.openrewrite.java.cleanup.UpperCaseLiteralSuffixes                                                                       // already tested, ok
//    - org.openrewrite.java.cleanup.UseDiamondOperator                                                                             // already tested, ok
//    - org.openrewrite.java.cleanup.UseJavaStyleArrayDeclarations                                                                  // already tested, ok
//    - org.openrewrite.java.cleanup.UseLambdaForFunctionalInterface                                                                // already tested, ok
//    - org.openrewrite.java.cleanup.WhileInsteadOfFor
//    - org.openrewrite.java.cleanup.WriteOctalValuesAsDecimal


// Global Java Clean Up (checkstyle)
////activeRecipe("org.openrewrite.java.cleanup.Cleanup")

//    - org.openrewrite.java.cleanup.DefaultComesLast                                                                               // already tested, ok
//    - org.openrewrite.java.cleanup.EmptyBlock                                                                                     // already tested, ok
//    - org.openrewrite.java.format.EmptyNewlineAtEndOfFile                                                                         // already tested, ok
//    - org.openrewrite.java.cleanup.ForLoopControlVariablePostfixOperators                                                         // already tested, ko
//    - org.openrewrite.java.cleanup.FinalizePrivateFields                                                                          // already tested, ko
//    - org.openrewrite.java.cleanup.MethodParamPad                                                                                 // already tested, ok
//    - org.openrewrite.java.cleanup.NoWhitespaceAfter                                                                              // already tested, ok
//    - org.openrewrite.java.cleanup.NoWhitespaceBefore                                                                             // already tested, ok
//    - org.openrewrite.java.cleanup.PadEmptyForLoopComponents                                                                      // already tested, ok
//    - org.openrewrite.java.cleanup.TypecastParenPad                                                                               // already tested, ok
//    - org.openrewrite.java.cleanup.EqualsAvoidsNull                                                                               // already tested, ok
//    - org.openrewrite.java.cleanup.ExplicitInitialization                                                                         // already tested, ok
//    - org.openrewrite.java.cleanup.FallThrough                                                                                    // already tested, ok
//    - org.openrewrite.java.cleanup.HideUtilityClassConstructor                                                                    // already tested, ok
//    - org.openrewrite.java.cleanup.NeedBraces                                                                                     // already tested, ok
//    - org.openrewrite.java.cleanup.OperatorWrap                                                                                   // already tested, ok
//    - org.openrewrite.java.cleanup.UnnecessaryParentheses                                                                         // already tested, ok
//    - org.openrewrite.java.cleanup.ReplaceThreadRunWithThreadStart                                                                // already tested, ok
//    - org.openrewrite.java.cleanup.ChainStringBuilderAppendCalls                                                                  // already tested, ok
//    - org.openrewrite.java.cleanup.ReplaceStringBuilderWithString                                                                 // already tested, ok


// Global Java 17
////activeRecipe("org.openrewrite.java.migrate.UpgradeToJava17")                                                                    // ,cleanup, yes, 9, ?, ?,
////activeRecipe("org.openrewrite.java.migrate.JavaVersion17")
//activeRecipe("org.openrewrite.java.migrate.Java8toJava11")
//    - org.openrewrite.java.migrate.UseJavaUtilBase64                                                                              // ok, not anymore need
//    - org.openrewrite.java.migrate.javax.AddJaxbDependencies
//    - org.openrewrite.java.migrate.javax.AddJaxwsDependencies
//    - org.openrewrite.java.migrate.javax.AddInjectDependencies
//    - org.openrewrite.java.cleanup.BigDecimalRoundingConstantsToEnums                                                             // already tested, ok
//    - org.openrewrite.java.cleanup.PrimitiveWrapperClassConstructorToValueOf                                                      // already tested, ok
//    - org.openrewrite.java.migrate.concurrent.JavaConcurrentAPIs
    //    - org.openrewrite.java.migrate.concurrent.MigrateAtomicBooleanWeakCompareAndSetToWeakCompareAndSetPlain
    //    - org.openrewrite.java.migrate.concurrent.MigrateAtomicIntegerWeakCompareAndSetToWeakCompareAndSetPlain
    //    - org.openrewrite.java.migrate.concurrent.MigrateAtomicIntegerArrayWeakCompareAndSetToWeakCompareAndSetPlain
    //    - org.openrewrite.java.migrate.concurrent.MigrateAtomicLongWeakCompareAndSetToWeakCompareAndSetPlain
    //    - org.openrewrite.java.migrate.concurrent.MigrateAtomicLongArrayWeakCompareAndSetToWeakCompareAndSetPlain
    //    - org.openrewrite.java.migrate.concurrent.MigrateAtomicReferenceWeakCompareAndSetToWeakCompareAndSetPlain
    //    - org.openrewrite.java.migrate.concurrent.MigrateAtomicReferenceArrayWeakCompareAndSetToWeakCompareAndSetPlain
//    - org.openrewrite.java.migrate.lang.JavaLangAPIs
    //    - org.openrewrite.java.migrate.lang.MigrateCharacterIsJavaLetterToIsJavaIdentifierStart
    //    - org.openrewrite.java.migrate.lang.MigrateCharacterIsJavaLetterOrDigitToIsJavaIdentifierPart
    //    - org.openrewrite.java.migrate.lang.MigrateCharacterIsSpaceToIsWhitespace
    //    - org.openrewrite.java.migrate.lang.MigrateRuntimeVersionMajorToFeature
    //    - org.openrewrite.java.migrate.lang.MigrateRuntimeVersionMinorToInterim
    //    - org.openrewrite.java.migrate.lang.MigrateRuntimeVersionSecurityToUpdate
    //    - org.openrewrite.java.migrate.lang.MigrateSecurityManagerMulticast
    //    - org.openrewrite.java.migrate.lang.MigrateClassLoaderDefineClass
    //    - org.openrewrite.java.migrate.lang.MigrateClassNewInstanceToGetDeclaredConstructorNewInstance
//    - org.openrewrite.java.migrate.logging.JavaLoggingAPIs
    //    - org.openrewrite.java.migrate.logging.MigrateGetLoggingMXBeanToGetPlatformMXBean
    //    - org.openrewrite.java.migrate.logging.MigrateLoggerGlobalToGetGlobal
    //    - org.openrewrite.java.migrate.logging.MigrateLoggerLogrbToUseResourceBundle
    //    - org.openrewrite.java.migrate.logging.MigrateLogRecordSetMillisToSetInstant
    //    - org.openrewrite.java.migrate.logging.MigrateInterfaceLoggingMXBeanToPlatformLoggingMXBean
//    - org.openrewrite.java.migrate.net.JavaNetAPIs
    //    - org.openrewrite.java.migrate.net.MigrateMulticastSocketSetTTLToSetTimeToLive
    //    - org.openrewrite.java.migrate.net.MigrateMulticastSocketGetTTLToGetTimeToLive
    //    - org.openrewrite.java.migrate.net.MigrateHttpURLConnectionHttpServerErrorToHttpInternalError
    //    - org.openrewrite.java.migrate.net.MigrateURLDecoderDecode
    //    - org.openrewrite.java.migrate.net.MigrateURLEncoderEncode
//    - org.openrewrite.java.migrate.sql.JavaSqlAPIs
    //    - org.openrewrite.java.migrate.sql.MigrateDriverManagerSetLogStream
//    - org.openrewrite.java.migrate.javax.JavaxLangModelUtil
    //    - org.openrewrite.java.migrate.javax.MigrateAbstractAnnotationValueVisitor6To9
    //    - org.openrewrite.java.migrate.javax.MigrateAbstractElementVisitor6To9
    //    - org.openrewrite.java.migrate.javax.MigrateAbstractTypeVisitor6To9
    //    - org.openrewrite.java.migrate.javax.MigrateElementKindVisitor6To9
    //    - org.openrewrite.java.migrate.javax.MigrateElementScanner6To9
    //    - org.openrewrite.java.migrate.javax.MigrateSimpleAnnotationValueVisitor6To9
    //    - org.openrewrite.java.migrate.javax.MigrateSimpleElementVisitor6To9
    //    - org.openrewrite.java.migrate.javax.MigrateSimpleTypeVisitor6To9
    //    - org.openrewrite.java.migrate.javax.MigrateTypeKindVisitor6To9
//    - org.openrewrite.java.migrate.javax.JavaxManagementMonitorAPIs
//    - org.openrewrite.java.migrate.javax.JavaxXmlStreamAPIs
//    - org.openrewrite.java.migrate.cobertura.RemoveCoberturaMavenPlugin
//    - org.openrewrite.java.migrate.wro4j.UpgradeWro4jMavenPluginVersion
//    - org.openrewrite.java.migrate.jacoco.UpgradeJaCoCoMavenPluginVersion
//    - org.openrewrite.java.migrate.JavaVersion11
//    - org.openrewrite.java.migrate.util.JavaUtilAPIs
//    - org.openrewrite.java.migrate.util.OptionalNotPresentToIsEmpty // already done
//    - org.openrewrite.java.migrate.util.OptionalNotEmptyToIsPresent // already done
//activeRecipe("org.openrewrite.java.migrate.JavaVersion11")
//activeRecipe("org.openrewrite.java.migrate.JavaVersion17")
//    - org.openrewrite.java.migrate.Java8toJava11
//    - org.openrewrite.java.migrate.JavaVersion17
//    - org.openrewrite.java.migrate.lang.StringFormatted
//    - org.openrewrite.java.migrate.lombok.UpdateLombokToJava17
//    - org.openrewrite.github.SetupJavaUpgradeJavaVersion
//    - org.openrewrite.java.cleanup.InstanceOfPatternMatch
//    - org.openrewrite.java.migrate.lang.UseTextBlocks
//activeRecipe("org.openrewrite.java.migrate.util.JavaUtilAPIs")


// Guava
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuava")                                                                        // ,cleanup, yes, 9, ?, ?,

//    - org.openrewrite.java.migrate.guava.NoGuavaCreateTempDir
//    - org.openrewrite.java.migrate.guava.NoGuavaDirectExecutor
//    - org.openrewrite.java.migrate.guava.NoGuavaListsNewArrayList
//    - org.openrewrite.java.migrate.guava.NoGuavaListsNewCopyOnWriteArrayList
//    - org.openrewrite.java.migrate.guava.NoGuavaListsNewLinkedList
//    - org.openrewrite.java.migrate.guava.NoGuavaSetsNewHashSet
//    - org.openrewrite.java.migrate.guava.NoGuavaSetsNewConcurrentHashSet
//    - org.openrewrite.java.migrate.guava.NoGuavaSetsNewLinkedHashSet
//    - org.openrewrite.java.migrate.guava.PreferJavaUtilFunction
//    - org.openrewrite.java.migrate.guava.PreferJavaUtilPredicate
//    - org.openrewrite.java.migrate.guava.PreferJavaUtilSupplier
//    - org.openrewrite.java.migrate.guava.PreferJavaUtilObjectsEquals
//    - org.openrewrite.java.migrate.guava.PreferJavaUtilObjectsHashCode
//    - org.openrewrite.java.migrate.guava.PreferJavaUtilCollectionsUnmodifiableNavigableMap
//    - org.openrewrite.java.migrate.guava.PreferJavaUtilCollectionsSynchronizedNavigableMap
//    - org.openrewrite.java.migrate.guava.PreferCharCompare
//    - org.openrewrite.java.migrate.guava.PreferIntegerCompare
//    - org.openrewrite.java.migrate.guava.PreferLongCompare
//    - org.openrewrite.java.migrate.guava.PreferShortCompare
//    - org.openrewrite.java.migrate.guava.PreferIntegerCompareUnsigned
//    - org.openrewrite.java.migrate.guava.PreferIntegerDivideUnsigned
//    - org.openrewrite.java.migrate.guava.PreferIntegerParseUnsignedInt
//    - org.openrewrite.java.migrate.guava.PreferLongCompareUnsigned
//    - org.openrewrite.java.migrate.guava.PreferLongDivideUnsigned
//    - org.openrewrite.java.migrate.guava.PreferLongParseUnsignedLong
//    - org.openrewrite.java.migrate.guava.PreferLongRemainderUnsigned
//    - org.openrewrite.java.migrate.guava.PreferMathAddExact
//    - org.openrewrite.java.migrate.guava.PreferMathSubtractExact
//    - org.openrewrite.java.migrate.guava.PreferMathMultiplyExact
//    - org.openrewrite.java.migrate.guava.NoGuavaAtomicsNewReference
//    - org.openrewrite.java.migrate.guava.NoGuavaImmutableListOf
//    - org.openrewrite.java.migrate.guava.NoGuavaImmutableMapOf
//    - org.openrewrite.java.migrate.guava.NoGuavaImmutableSetOf
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
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaSetsNewConcurrentHashSet")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaSetsNewHashSet")
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuavaSetsNewLinkedHashSet")

//activeRecipe("org.openrewrite.java.migrate.guava.PreferCharCompare")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerCompare")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerCompareUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerDivideUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerParseUnsignedInt")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferIntegerRemainderUnsigned")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilCollectionsSynchronizedNavigableMap")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilCollectionsUnmodifiableNavigableMap")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilFunction")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilObjectsEquals")
//activeRecipe("org.openrewrite.java.migrate.guava.PreferJavaUtilObjectsHashCode")
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

//activeRecipe("org.openrewrite.java.migrate.apache.commons.codec.ApacheBase64ToJavaBase64")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.ApacheFileUtilsToJavaFiles")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.ApacheIOUtilsUseExplicitCharset")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.RelocateApacheCommonsIo")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.UseStandardCharsets")
//activeRecipe("org.openrewrite.java.migrate.apache.commons.io.UseSystemLineSeparator")


// Global Jakarta
//activeRecipe("org.openrewrite.java.migrate.jakarta.ChangeJavaxAnnotationToJakarta")                                               // ,?, not yet, 0, ?, ?, TODO to be tested on a big project

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
//activeRecipe("org.openrewrite.java.migrate.jakarta.RestAssuredJavaxToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.EhcacheJavaxToJakarta")
//activeRecipe("org.openrewrite.java.migrate.jakarta.JacksonJavaxToJakarta")


//activeRecipe("org.openrewrite.java.migrate.AddJDeprScanPlugin")
//activeRecipe("org.openrewrite.java.migrate.AddSuppressionForIllegalReflectionWarningsPlugin")
//activeRecipe("org.openrewrite.java.migrate.cobertura.RemoveCoberturaMavenPlugin")

//activeRecipe("org.openrewrite.java.migrate.concurrent.JavaConcurrentAPIs")
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicBooleanWeakCompareAndSetToWeakCompareAndSetPlain")
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicIntegerArrayWeakCompareAndSetToWeakCompareAndSetPlain")
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicIntegerWeakCompareAndSetToWeakCompareAndSetPlain")
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicLongArrayWeakCompareAndSetToWeakCompareAndSetPlain")
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicLongWeakCompareAndSetToWeakCompareAndSetPlain")
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicReferenceArrayWeakCompareAndSetToWeakCompareAndSetPlain")
//activeRecipe("org.openrewrite.java.migrate.concurrent.MigrateAtomicReferenceWeakCompareAndSetToWeakCompareAndSetPlain")

//activeRecipe("org.openrewrite.java.migrate.hibernate.MigrateToHibernate61")
//activeRecipe("org.openrewrite.java.migrate.hibernate.MigrateToHibernateDependencies61")
//activeRecipe("org.openrewrite.java.migrate.jacoco.UpgradeJaCoCoMavenPluginVersion")

//activeRecipe("org.openrewrite.java.migrate.javax.AddInjectDependencies")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxbDependencies")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxbRuntime")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxwsDependencies")
//activeRecipe("org.openrewrite.java.migrate.javax.AddJaxwsRuntime")
//activeRecipe("org.openrewrite.java.migrate.javax.JavaxLangModelUtil")
//activeRecipe("org.openrewrite.java.migrate.javax.JavaxManagementMonitorAPIs")
//activeRecipe("org.openrewrite.java.migrate.javax.JavaxXmlStreamAPIs")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateAbstractAnnotationValueVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateAbstractElementVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateAbstractTypeVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateCounterMonitorSetThreshholdToSetInitThreshold")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateElementKindVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateElementScanner6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateSimpleAnnotationValueVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateSimpleElementVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateSimpleTypeVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateTypeKindVisitor6To9")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateXMLEventFactoryNewInstanceToNewFactory")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateXMLInputFactoryNewInstanceToNewFactory")
//activeRecipe("org.openrewrite.java.migrate.javax.MigrateXMLOutputFactoryNewInstanceToNewFactory")
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
//activeRecipe("org.openrewrite.java.migrate.lang.StringFormatted")

//activeRecipe("org.openrewrite.java.migrate.logging.JavaLoggingAPIs")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateGetLoggingMXBeanToGetPlatformMXBean")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateInterfaceLoggingMXBeanToPlatformLoggingMXBean")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateLoggerGlobalToGetGlobal")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateLoggerLogrbToUseResourceBundle")
//activeRecipe("org.openrewrite.java.migrate.logging.MigrateLogRecordSetMillisToSetInstant")

//activeRecipe("org.openrewrite.java.migrate.lombok.LombokValToFinalVar")
//activeRecipe("org.openrewrite.java.migrate.lombok.UpdateLombokToJava17")
//activeRecipe("org.openrewrite.java.migrate.maven.UseMavenCompilerPluginReleaseConfiguration")
//activeRecipe("org.openrewrite.java.migrate.metrics.SimplifyMicrometerMeterTags")
//activeRecipe("org.openrewrite.java.migrate.net.JavaNetAPIs")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateHttpURLConnectionHttpServerErrorToHttpInternalError")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateMulticastSocketGetTTLToGetTimeToLive")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateMulticastSocketSetTTLToSetTimeToLive")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateURLDecoderDecode")
//activeRecipe("org.openrewrite.java.migrate.net.MigrateURLEncoderEncode")
//activeRecipe("org.openrewrite.java.migrate.search.AboutJavaVersion")
//activeRecipe("org.openrewrite.java.migrate.sql.JavaSqlAPIs")
//activeRecipe("org.openrewrite.java.migrate.sql.MigrateDriverManagerSetLogStream")
//activeRecipe("org.openrewrite.java.migrate.UpgradeJavaVersion")

//activeRecipe("org.openrewrite.java.migrate.UseJavaUtilBase64")

//activeRecipe("org.openrewrite.java.migrate.wro4j.UpgradeWro4jMavenPluginVersion")


// Global Logging
//activeRecipe("org.openrewrite.java.logging.slf4j.Log4jToSlf4j")                                                                   // TODO to be tested
//activeRecipe("org.openrewrite.java.logging.slf4j.Slf4jBestPractices")                                                             // TODO to be tested
//    - org.openrewrite.java.logging.slf4j.ConvertLogMessageMessageOnlyToLogMessageAndThrowable:
//    logMessage:
//    - org.openrewrite.java.logging.slf4j.LoggersNamedForEnclosingClass
//    - org.openrewrite.java.logging.slf4j.ParameterizedLogging
//    - org.openrewrite.java.logging.slf4j.Slf4jLogShouldBeConstant
//activeRecipe("org.openrewrite.java.logging.slf4j.LoggersNamedForEnclosingClass")
//activeRecipe("org.openrewrite.java.logging.slf4j.ParameterizedLogging")                                                           // TODO to be tested
//activeRecipe("org.openrewrite.java.logging.slf4j.Slf4jLogShouldBeConstant")
//activeRecipe("org.openrewrite.java.logging.PrintStackTraceToLogError")
//activeRecipe("org.openrewrite.java.logging.SystemErrToLogging")
//activeRecipe("org.openrewrite.java.logging.SystemOutToLogging")
//activeRecipe("org.openrewrite.java.logging.SystemPrintToLogging")
//activeRecipe("org.openrewrite.java.logging.slf4j.ConvertLogMessageMessageOnlyToLogMessageAndThrowable")

//activeRecipe("org.openrewrite.java.logging.slf4j.Log4j1ToSlf4j1")
//activeRecipe("org.openrewrite.java.logging.slf4j.Log4j2ToSlf4j1")
//activeRecipe("org.openrewrite.java.logging.slf4j.Log4jToSlf4j")

//activeRecipe("org.openrewrite.java.logging.log4j.Log4j1ToLog4j2")
//activeRecipe("org.openrewrite.java.logging.log4j.PrependRandomName")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jAppenderToLogback")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jLayoutToLogback")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jToLogback")


// Global Junit
//activeRecipe("org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration")                                                   //TODO to be tested
//activeRecipe("org.openrewrite.java.testing.cleanup.BestPractices")                                                                //TODO to be tested
//    - org.openrewrite.java.testing.junit5.StaticImports
//    - org.openrewrite.java.testing.junit5.JUnit4to5Migration
//    - org.openrewrite.java.testing.junit5.CleanupAssertions
//    - org.openrewrite.java.testing.cleanup.TestsShouldNotBePublic:
//activeRecipe("org.openrewrite.java.testing.junit5.JUnit4to5Migration")                                                            //TODO to be tested
//activeRecipe("org.openrewrite.java.testing.junit5.JUnit5BestPractices")                                                           //TODO to be tested
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldNotBePublic")
//activeRecipe("org.openrewrite.java.testing.junit5.CleanupAssertions")                                                             //TODO to be tested
//    - org.openrewrite.java.testing.cleanup.AssertTrueNegationToAssertFalse
//    - org.openrewrite.java.testing.cleanup.AssertFalseNegationToAssertTrue
//    - org.openrewrite.java.testing.cleanup.AssertTrueEqualsToAssertEquals
//    - org.openrewrite.java.testing.cleanup.AssertTrueComparisonToAssertEquals
//    - org.openrewrite.java.testing.cleanup.AssertFalseEqualsToAssertNotEquals
//    - org.openrewrite.java.testing.cleanup.AssertEqualsNullToAssertNull
//    - org.openrewrite.java.testing.cleanup.AssertFalseNullToAssertNotNull
//    - org.openrewrite.java.testing.cleanup.AssertionsArgumentOrder
//activeRecipe("org.openrewrite.java.testing.junit5.StaticImports")

//activeRecipe("org.openrewrite.java.testing.assertj.JUnitToAssertj")
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
//activeRecipe("org.openrewrite.java.testing.assertj.StaticImports")
//activeRecipe("org.openrewrite.java.testing.assertj.UseExplicitContains")
//activeRecipe("org.openrewrite.java.testing.assertj.UseExplicitSize")

//activeRecipe("org.openrewrite.java.testing.cleanup.AssertEqualsNullToAssertNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseEqualsToAssertNotEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseNegationToAssertTrue")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseNullToAssertNotNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertionsArgumentOrder")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueComparisonToAssertEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueEqualsToAssertEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueNegationToAssertFalse")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueNullToAssertNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.RemoveEmptyTests")
////activeRecipe("org.openrewrite.java.testing.cleanup.RemoveTestPrefix")
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldIncludeAssertions")

//activeRecipe("org.openrewrite.java.testing.cucumber.CucumberAnnotationToSuite")
//activeRecipe("org.openrewrite.java.testing.cucumber.CucumberJava8HookDefinitionToCucumberJava")
//activeRecipe("org.openrewrite.java.testing.cucumber.CucumberJava8StepDefinitionToCucumberJava")
//activeRecipe("org.openrewrite.java.testing.cucumber.CucumberJava8ToJava")
//activeRecipe("org.openrewrite.java.testing.cucumber.CucumberToJunitPlatformSuite")
//activeRecipe("org.openrewrite.java.testing.cucumber.DropSummaryPrinter")
//activeRecipe("org.openrewrite.java.testing.cucumber.RegexToCucumberExpression")
//activeRecipe("org.openrewrite.java.testing.cucumber.UpgradeCucumber2x")
//activeRecipe("org.openrewrite.java.testing.cucumber.UpgradeCucumber5x")
//activeRecipe("org.openrewrite.java.testing.cucumber.UpgradeCucumber7x")
//activeRecipe("org.openrewrite.java.testing.hamcrest.AddHamcrestIfUsed")
//activeRecipe("org.openrewrite.java.testing.junit5.AddMissingNested")
//activeRecipe("org.openrewrite.java.testing.junit5.AssertToAssertions")
//activeRecipe("org.openrewrite.java.testing.junit5.CategoryToTag")
//activeRecipe("org.openrewrite.java.testing.junit5.CleanupJUnitImports")
//activeRecipe("org.openrewrite.java.testing.junit5.EnclosedToNested")
//activeRecipe("org.openrewrite.java.testing.junit5.ExpectedExceptionToAssertThrows")
//activeRecipe("org.openrewrite.java.testing.junit5.IgnoreToDisabled")
//activeRecipe("org.openrewrite.java.testing.junit5.JUnitParamsRunnerToParameterized")
//activeRecipe("org.openrewrite.java.testing.junit5.LifecycleNonPrivate")
//activeRecipe("org.openrewrite.java.testing.junit5.MigrateJUnitTestCase")
//activeRecipe("org.openrewrite.java.testing.junit5.MockitoJUnitToMockitoExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.ParameterizedRunnerToParameterized")
//activeRecipe("org.openrewrite.java.testing.junit5.RemoveObsoleteRunners")
//activeRecipe("org.openrewrite.java.testing.junit5.RunnerToExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.TempDirNonFinal")
//activeRecipe("org.openrewrite.java.testing.junit5.TemporaryFolderToTempDir")
//activeRecipe("org.openrewrite.java.testing.junit5.TestRuleToTestInfo")
//activeRecipe("org.openrewrite.java.testing.junit5.UpdateBeforeAfterAnnotations")
//activeRecipe("org.openrewrite.java.testing.junit5.UpdateMockWebServer")
//activeRecipe("org.openrewrite.java.testing.junit5.UpdateTestAnnotation")
//activeRecipe("org.openrewrite.java.testing.junit5.UseHamcrestAssertThat")
//activeRecipe("org.openrewrite.java.testing.junit5.UseMockitoExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.UseTestMethodOrder")
//activeRecipe("org.openrewrite.java.testing.junit5.UseWiremockExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.VertxUnitToVertxJunit5")

//activeRecipe("org.openrewrite.java.testing.mockito.CleanupMockitoImports")
//activeRecipe("org.openrewrite.java.testing.mockito.Mockito1to3Migration")
//activeRecipe("org.openrewrite.java.testing.mockito.Mockito1to4Migration")
//activeRecipe("org.openrewrite.java.testing.mockito.MockitoJUnitRunnerSilentToExtension")
//activeRecipe("org.openrewrite.java.testing.mockito.MockUtilsToStatic")
//activeRecipe("org.openrewrite.java.testing.mockito.PowerMockitoMockStaticToMockito")
//activeRecipe("org.openrewrite.java.testing.mockito.ReplacePowerMockito")


// Spring

//activeRecipe("org.openrewrite.java.spring.AddSpringProperty")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementChunkListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementJobExecutionListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementRepeatListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementSkipListenerSupportDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.ImplementStepExecutionListenerDirectly")
//activeRecipe("org.openrewrite.java.spring.batch.MigrateItemWriterWrite")
//activeRecipe("org.openrewrite.java.spring.batch.MigrateJobBuilderFactory")
//activeRecipe("org.openrewrite.java.spring.batch.ReplaceSupportClassWithItsInterface")
//activeRecipe("org.openrewrite.java.spring.BeanMethodsNotPublic")
//activeRecipe("org.openrewrite.java.spring.boot2.AddConfigurationAnnotationIfBeansPresent")
//activeRecipe("org.openrewrite.java.spring.boot2.AuthorizeHttpRequests")
//activeRecipe("org.openrewrite.java.spring.boot2.ChangeEmbeddedServletContainerCustomizer")
//activeRecipe("org.openrewrite.java.spring.boot2.ConditionalOnBeanAnyNestedCondition")
//activeRecipe("org.openrewrite.java.spring.boot2.DatabaseComponentAndBeanInitializationOrdering")
//activeRecipe("org.openrewrite.java.spring.boot2.GetErrorAttributes")
//activeRecipe("org.openrewrite.java.spring.boot2.HttpSecurityLambdaDsl")
//activeRecipe("org.openrewrite.java.spring.boot2.MergeBootstrapYamlWithApplicationYaml")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateAbstractHealthIndicatorToPingHealthIndicator")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateActuatorMediaTypeToApiVersion")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateConfigurationPropertiesBindingPostProcessorValidatorBeanName")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateDatabaseCredentials")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateDiskSpaceHealthIndicatorConstructor")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateErrorControllerPackageName")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateErrorPropertiesIncludeStackTraceConstants")
//activeRecipe("org.openrewrite.java.spring.boot2.MigrateHibernateContraintsToJavax")
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
//activeRecipe("org.openrewrite.java.spring.boot2.WebSecurityConfigurerAdapter")
//activeRecipe("org.openrewrite.java.spring.boot3.ActuatorEndpointSanitization")
//activeRecipe("org.openrewrite.java.spring.boot3.ConfigurationOverEnableSecurity")
//activeRecipe("org.openrewrite.java.spring.boot3.DowngradeServletApiWhenUsingJetty")
//activeRecipe("org.openrewrite.java.spring.boot3.MavenPomUpgrade")
//activeRecipe("org.openrewrite.java.spring.boot3.MigrateMaxHttpHeaderSize")
//activeRecipe("org.openrewrite.java.spring.boot3.PreciseBeanType")
//activeRecipe("org.openrewrite.java.spring.boot3.RemoveConstructorBindingAnnotation")
//activeRecipe("org.openrewrite.java.spring.boot3.RemoveEnableBatchProcessing")
//activeRecipe("org.openrewrite.java.spring.boot3.SpringBatch4To5Migration")
//activeRecipe("org.openrewrite.java.spring.boot3.SpringBootProperties_3_0_0")
//activeRecipe("org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0")
//activeRecipe("org.openrewrite.java.spring.ChangeSpringPropertyKey")
//activeRecipe("org.openrewrite.java.spring.data.MigrateJpaSort")
//activeRecipe("org.openrewrite.java.spring.data.MigrateQuerydslJpaRepository")
//activeRecipe("org.openrewrite.java.spring.data.UpgradeSpringData_2_3")
//activeRecipe("org.openrewrite.java.spring.data.UpgradeSpringData_2_5")
//activeRecipe("org.openrewrite.java.spring.data.UseJpaRepositoryDeleteAllInBatch")
//activeRecipe("org.openrewrite.java.spring.data.UseJpaRepositoryGetById")
//activeRecipe("org.openrewrite.java.spring.data.UseTlsJdbcConnectionString")
//activeRecipe("org.openrewrite.java.spring.DeleteSpringProperty")
//activeRecipe("org.openrewrite.java.spring.ExpandProperties")
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
//activeRecipe("org.openrewrite.java.spring.ImplicitWebAnnotationNames")
//activeRecipe("org.openrewrite.java.spring.NoAutowiredOnConstructor")
//activeRecipe("org.openrewrite.java.spring.NoRepoAnnotationOnRepoInterface")
//activeRecipe("org.openrewrite.java.spring.NoRequestMappingAnnotation")
//activeRecipe("org.openrewrite.java.spring.PropertiesToKebabCase")
//activeRecipe("org.openrewrite.java.spring.search.FindApiCalls")
//activeRecipe("org.openrewrite.java.spring.search.FindApiEndpoints")
//activeRecipe("org.openrewrite.java.spring.search.FindSpringComponents")
//activeRecipe("org.openrewrite.java.spring.SeparateApplicationYamlByProfile")
//activeRecipe("org.openrewrite.java.spring.UpdateApiManifest")

//activeRecipe("org.openrewrite.java.security.FindTextDirectionChanges")
//activeRecipe("org.openrewrite.java.security.JavaSecurityBestPractices")
//activeRecipe("org.openrewrite.java.security.marshalling.SecureJacksonDefaultTyping")
//activeRecipe("org.openrewrite.java.security.marshalling.SecureSnakeYamlConstructor")
//activeRecipe("org.openrewrite.java.security.PartialPathTraversalVulnerability")
//activeRecipe("org.openrewrite.java.security.RegularExpressionDenialOfService")
//activeRecipe("org.openrewrite.java.security.search.FindJacksonDefaultTypeMapping")
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

//activeRecipe("org.openrewrite.java.search.FindAnnotations")
//activeRecipe("org.openrewrite.java.search.FindDeprecatedClasses")
//activeRecipe("org.openrewrite.java.search.FindDeprecatedFields")
//activeRecipe("org.openrewrite.java.search.FindDeprecatedMethods")
//activeRecipe("org.openrewrite.java.search.FindDeprecatedUses")
//activeRecipe("org.openrewrite.java.search.FindEmptyClasses")
//activeRecipe("org.openrewrite.java.search.FindEmptyMethods")
//activeRecipe("org.openrewrite.java.search.FindFields")
//activeRecipe("org.openrewrite.java.search.FindFieldsOfType")
//activeRecipe("org.openrewrite.java.search.FindFlowBetweenMethods")
//activeRecipe("org.openrewrite.java.search.FindImports")
//activeRecipe("org.openrewrite.java.search.FindLiterals")
//activeRecipe("org.openrewrite.java.search.FindMethods")
//activeRecipe("org.openrewrite.java.search.FindMissingTypes")
//activeRecipe("org.openrewrite.java.search.FindRepeatableAnnotations")
//activeRecipe("org.openrewrite.java.search.FindSecrets")
//activeRecipe("org.openrewrite.java.search.FindText")
//activeRecipe("org.openrewrite.java.search.FindTypes")
//activeRecipe("org.openrewrite.java.search.HasJavaVersion")
//activeRecipe("org.openrewrite.java.search.HasSourceSet")
//activeRecipe("org.openrewrite.java.search.IsLikelyNotTest")
//activeRecipe("org.openrewrite.java.search.IsLikelyTest")
//activeRecipe("org.openrewrite.java.search.PotentiallyDeadCode")
//activeRecipe("org.openrewrite.java.search.ResultOfMethodCallIgnored")
//activeRecipe("org.openrewrite.java.search.UriCreatedWithHttpScheme")

//activeRecipe("org.openrewrite.java.recipes.ExecutionContextParameterName")
//activeRecipe("org.openrewrite.java.recipes.FindRecipes")
//activeRecipe("org.openrewrite.java.recipes.PublicGetVisitor")
//activeRecipe("org.openrewrite.java.recipes.SetDefaultEstimatedEffortPerOccurrence")
//activeRecipe("org.openrewrite.java.recipes.SourceSpecTextBlockIndentation")

//activeRecipe("org.openrewrite.java.micronaut.BeanPropertyCapitalizationStrategy")
//activeRecipe("org.openrewrite.java.micronaut.CopyNonInheritedAnnotations")
//activeRecipe("org.openrewrite.java.micronaut.FixDeprecatedExceptionHandlerConstructors")
//activeRecipe("org.openrewrite.java.micronaut.Micronaut2to3Migration")
//activeRecipe("org.openrewrite.java.micronaut.OncePerRequestHttpServerFilterToHttpServerFilter")
//activeRecipe("org.openrewrite.java.micronaut.ProviderImplementationsToMicronautFactories")
//activeRecipe("org.openrewrite.java.micronaut.SubclassesReturnedFromFactoriesNotInjectable")
//activeRecipe("org.openrewrite.java.micronaut.TypeRequiresIntrospection")
//activeRecipe("org.openrewrite.java.micronaut.UpgradeMicronautGradlePropertiesVersion")
//activeRecipe("org.openrewrite.java.micronaut.UpgradeMicronautMavenPropertyVersion")

//activeRecipe("org.openrewrite.java.jhipster.FixCwe338")

}

checkstyle {
    isIgnoreFailures = true
}


tasks.withType<Test> {
    useJUnitPlatform()
}


