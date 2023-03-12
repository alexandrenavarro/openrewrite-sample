plugins {
    java
    checkstyle
    id("org.springframework.boot") version "3.0.4"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.openrewrite.rewrite") version "5.37.1"
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
    implementation("org.springframework.boot:spring-boot-starter")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencies {
    rewrite(platform("org.openrewrite:rewrite-bom:7.37.3"))
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

    rewrite("org.openrewrite.recipe:rewrite-java-security:1.22.0")
    rewrite("org.openrewrite.recipe:rewrite-java-dependencies:0.1.0")
    rewrite("org.openrewrite.recipe:rewrite-migrate-java:1.17.2")
    rewrite("org.openrewrite.recipe:rewrite-testing-frameworks:1.34.0")
    rewrite("org.openrewrite.recipe:rewrite-logging-frameworks:1.18.0")
    rewrite("org.openrewrite.recipe:rewrite-spring:4.33.2")
    rewrite("org.openrewrite.recipe:rewrite-quarkus:1.17.0")
    rewrite("org.openrewrite.recipe:rewrite-micronaut:1.22.0")
    rewrite("org.openrewrite.recipe:rewrite-jhipster:1.18.0")
    rewrite("org.openrewrite.recipe:rewrite-kubernetes:1.28.0")
    rewrite("org.openrewrite.recipe:rewrite-github-actions:1.17.0")
    rewrite("org.openrewrite.recipe:rewrite-circleci:1.18.0")
    rewrite("org.openrewrite.recipe:rewrite-concourse:1.17.0")
}

rewrite {
// Note (10 formating; 9 change code but must not change behavior; 8 change code but may change behavior in some cases; 7 tech migration; 6 change code but rare case, 5 change code but can break, 1 , 0 note tested; note -1 do not use it,

// Recipe, Category, Note, Tested in the sample, Violation in checkstyle, Violation in Sonar, Comment,

//activeRecipe("org.openrewrite.java.cleanup.EmptyBlock") 								                                            // ,format, yes, 10, EmptyBlock, java:S108 (Nested blocks of code should not be left empty),
//activeRecipe("org.openrewrite.java.cleanup.MethodParamPad")                                                                       // ,format, yes, 10, MethodParamPad, no,
//activeRecipe("org.openrewrite.java.cleanup.ModifierOrder")                                                                        // ,format, yes, 10, ModifierOrder, java:S1124 (Reorder the modifiers to comply with the Java Language Specification),
//activeRecipe("org.openrewrite.java.cleanup.NeedBraces")                                                                           // ,format, yes, 10, NeedBraces, no,
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceAfter")                                                                    // ,format, yes, 10, NoWhitespaceAfter, no,
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceBefore")                                                                   // ,format, yes, 10, NoWhitespaceBefore, no,
//activeRecipe("org.openrewrite.java.cleanup.OperatorWrap")                                                                         // ,format, yes, 10, OperatorWrap, no,
//activeRecipe("org.openrewrite.java.cleanup.RemoveExtraSemicolons")                                                                // ,format, yes, 10, no, no,
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnneededBlock")                                                                  // ,format, yes, 10, AvoidNestedBlocks, java:S1199 (Extract this nested code block into a method.),
//activeRecipe("org.openrewrite.java.cleanup.TypecastParenPad")                                                                     // ,format, yes, 10, TypecastParenPad, java:S1905 (Remove this unnecessary cast to "String"),
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryParentheses")                                                               // ,format, yes, 10, no, no,
//activeRecipe("org.openrewrite.java.format.BlankLines")                                                                            // ,format, yes, 10, no, no, Add some blank like between method
//activeRecipe("org.openrewrite.java.format.EmptyNewlineAtEndOfFile")                                                               // ,format, yes, 10, NewlineAtEndOfFile, no,
//activeRecipe("org.openrewrite.java.format.NormalizeTabsOrSpaces")                                                                 // ,format, yes, 10, FileTabCharacter, no,
//activeRecipe("org.openrewrite.java.format.RemoveTrailingWhitespace")                                                              // ,format, yes, 10, RegexpSingleline, no,
//activeRecipe("org.openrewrite.java.format.SingleLineComments")                                                                    // ,format, yes, 10, no, no, just a space after a single line comment
//activeRecipe("org.openrewrite.java.RemoveUnusedImports")							                                           	    // ,format, yes, 10, yes, yes,
//activeRecipe("org.openrewrite.java.format.Spaces")                                                                                // ,format, yes, 10, WhitespaceAround ParenPad WhitespaceAfter GenericWhitespace, no, caution problem reformat with gradle, do exclusion of gradle file
//activeRecipe("org.openrewrite.java.cleanup.PadEmptyForLoopComponents")                                                            // ,format, yes, 10, EmptyForIteratorPad, ?,
////activeRecipe("org.openrewrite.java.format.AutoFormat")                                                                          // ,format, no, -1, no, no, don't not format correct compared to intellij
////activeRecipe("org.openrewrite.java.format.TabsAndIndents")                                                                      // ,format, no, -1, no, no, do not format like intellij (1 or 2 indent for continuation)
////activeRecipe("org.openrewrite.java.format.WrappingAndBraces")                                                                   // ,format, no, -1, no, no, break all the formatting notably gradle.build, don't use it absolutely
////activeRecipe("org.openrewrite.java.format.NormalizeFormat")                                                                     // ,format, no, -1, no, no, do nothing except some stuff in the gradle.build
////activeRecipe("org.openrewrite.java.format.NormalizeLineBreaks")                                                                 // ,format, no, -1, no, ?, Normalize LF / CRLF, weird behaviour to choose LF ou CRLF if different?

//activeRecipe("org.openrewrite.java.cleanup.RenameLocalVariablesToCamelCase")                                                      // ,cleanup, yes, ?, LocalFinalVariableName LocalVariableName, ?, to be retested on a big project generated not corrected not  can break if the project is a lib.
//activeRecipe("org.openrewrite.java.cleanup.RenamePrivateFieldsToCamelCase")                                                       // ,cleanup, yes, 1, MemberName, ?,  can break if the project is a lib.
//activeRecipe("org.openrewrite.java.cleanup.LowercasePackage")                                                                     // ,cleanup, yes, 1, PackageName, ?, can break if the project is a lib.
//activeRecipe("org.openrewrite.java.cleanup.MethodNameCasing")                                                                     // ,cleanup, yes, 1, MethodName, ?, can break if the project is a lib.
//activeRecipe("org.openrewrite.java.cleanup.HiddenField")                                                                          // ,cleanup, yes, ?, HiddenField, ?, ?, to be rested on a big project
//activeRecipe("org.openrewrite.java.cleanup.PrimitiveWrapperClassConstructorToValueOf")                                            // ,cleanup, yes, 9, IllegalInstantiation, ?,
//activeRecipe("org.openrewrite.java.cleanup.MinimumSwitchCases")                                                                   // ,cleanup, yes, 9, MissingSwitchDefault, ?, ok
//activeRecipe("org.openrewrite.java.cleanup.MultipleVariableDeclarations")                                                         // ,cleanup, yes, 9, MultipleVariableDeclarations, ?
//activeRecipe("org.openrewrite.java.cleanup.SimplifyBooleanExpression")                                                            // ,cleanup, yes, 9, SimplifyBooleanExpression, ?,
//activeRecipe("org.openrewrite.java.cleanup.SimplifyBooleanReturn")                                                                // ,cleanup, yes, 9, SimplifyBooleanReturn, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.UpperCaseLiteralSuffixes")                                                             // ,cleanup, yes, 9, UpperEll, ?, NotFound

//    <module name="DesignForExtension"/>
//    <module name="FinalClass"/>
//activeRecipe("org.openrewrite.java.cleanup.FinalClass")                                                                           // ,cleanup, not yet,?, ?, ?, set only on private class, seems ok?
//    <module name="HideUtilityClassConstructor"/>
//activeRecipe("org.openrewrite.java.cleanup.HideUtilityClassConstructor")                                                          // ,cleanup, not yet, 9, ?, ? vs @Utility
//    <module name="InterfaceIsType"/>
//    <module name="VisibilityModifier"/>
//    <module name="ArrayTypeStyle"/>
//    <module name="FinalParameters"/>
//    <module name="TodoComment"/>

//activeRecipe("org.openrewrite.java.cleanup.RemoveRedundantTypeCast")                                                              // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryThrows")                                                                    // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.UseDiamondOperator")                                                                   // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ExplicitInitialization")                                                               // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.StaticMethodNotFinal")                                                                 // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.MissingOverrideAnnotation")                                                            // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.NoDoubleBraceInitialization")                                                          // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.EqualsAvoidsNull")                                                                     // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.AddSerialVersionUidToSerializable")                                                    // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.UseLambdaForFunctionalInterface")                                                      // ,cleanup, not yet, 9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceLambdaWithMethodReference")                                                     // ,cleanup, not yet, -1, ?, problem if 2 classes with the same for the class
//activeRecipe("org.openrewrite.java.cleanup.CompareEnumsWithEqualityOperator")                                                     // ,cleanup, not yet, 9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NoRedundantJumpStatements")                                                            // ,cleanup, not yet, 9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NestedEnumsAreNotStatic")                                                              // ,cleanup, not yet, 9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseCollectionInterfaces")                                                              // ,cleanup, not yet, 9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.HideUtilityClassConstructor")                                                          // ,cleanup, not yet, 9, ?, ? vs @Utility
//activeRecipe("org.openrewrite.java.cleanup.CombineSemanticallyEqualCatchBlocks")                                                  // ,cleanup, not yet, -1, ?, ? error in comments in source code
//activeRecipe("org.openrewrite.java.cleanup.CommonStaticAnalysis")                                                                 // ,cleanup, not yet, -1, ?, ? group some others receipe, some are not ok
//activeRecipe("org.openrewrite.java.cleanup.ControlFlowIndentation")                                                               // ,cleanup, not yet, -1, ?, ? reformat code incorrectly
//activeRecipe("org.openrewrite.java.cleanup.CovariantEquals")                                                                      // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ExternalizableHasNoArgsConstructor")                                                   // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.FixStringFormatExpressions")                                                           // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.InlineVariable")                                                                       // ,cleanup, not yet, 9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseMapContainsKey")                                                                    // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.NoPrimitiveWrappersForToStringOrCompareTo")                                            // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.WhileInsteadOfFor")                                                                    // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.CommonDeclarationSiteTypeVariances")                                                   // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.RedundantFileCreation")                                                                // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.RemoveEmptyJavaDocParameters")                                                         // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryPrimitiveAnnotations")                                                      // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.RemoveCallsToObjectFinalize")                                                          // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.RemoveJavaDocAuthorTag")                                                               // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.NoFinalizer")                                                                          // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.RemoveCallsToSystemGc")                                                                // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.RenameExceptionInEmptyCatch")                                                          // ,cleanup, not yet, -1, ?, ? error in comments in source code
//activeRecipe("org.openrewrite.java.cleanup.ReplaceThreadRunWithThreadStart")                                                      // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.ReplaceDuplicateStringLiterals")                                                       // ,cleanup, not yet, 6, ?, ?, create String final and reference it on all,?
//activeRecipe("org.openrewrite.java.cleanup.UseListSort")                                                                          // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.UseForEachRemoveInsteadOfSetRemoveAll")                                                // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.ReplaceStackWithDeque")                                                                // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ReplaceApacheCommonsLang3ValidateNotNullWithObjectsRequireNonNull")                    // ,cleanup, not yet, 0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ReplaceRedundantFormatWithPrintf")                                                     // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.ReferentialEqualityToObjectEquals")                                                    // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UseObjectNotifyAll")                                                                   // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.ExplicitCharsetOnStringGetBytes")                                                      // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UnwrapRepeatableAnnotations")                                                          // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.IsEmptyCallOnCollections")                                                             // ,cleanup, not yet, 9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NoEmptyCollectionWithRawType")                                                         // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UseStandardCharset")                                                                   // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.UseStringReplace")                                                                     // ,cleanup, not yet, ?, ?, ?, replaceAll -> replace
//activeRecipe("org.openrewrite.java.cleanup.UseSystemLineSeparator")                                                               // ,cleanup, not yet, 0, ?, ?, not found
//activeRecipe("org.openrewrite.java.cleanup.NoEqualityInForCondition")                                                             // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.WriteOctalValuesAsDecimal")                                                            // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ObjectFinalizeCallsSuper")                                                             // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.ForLoopIncrementInUpdate")                                                             // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.IndexOfShouldNotCompareGreaterThanZero")                                               // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.IndexOfReplaceableByContains")                                                         // ,cleanup, not yet, 0, ?, ?


//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedLocalVariables")                                                           // ,cleanup, not yet,8, ?, ?, is it ok always?
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedPrivateFields")                                                            // ,cleanup, not yet,?, ?, ?,, NotFound, can break notably in unit or Autowired field
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedPrivateMethods")                                                           // ,cleanup, not yet,?, ?, ?, ? can break on private constructor on jackson ?
//activeRecipe("org.openrewrite.java.cleanup.FinalClass")                                                                           // ,cleanup, not yet,?, ?, ?, set only on private class, seems ok?
//activeRecipe("org.openrewrite.java.cleanup.FinalizeLocalVariables")                                                               // ,cleanup, not yet,?, ?, ?, contreversial, have some problem like finalvar on a big project
//activeRecipe("org.openrewrite.java.cleanup.FinalizePrivateFields")                                                                // ,cleanup, not yet,?, ?, ?, nonFound
//activeRecipe("org.openrewrite.java.cleanup.ExplicitLambdaArgumentTypes")                                                          // ,cleanup, not yet,?, ?, ?, do we want to do it (personally yes but controversial)
//activeRecipe("org.openrewrite.java.cleanup.ForLoopControlVariablePostfixOperators")                                               // ,cleanup, not yet,?, ?, ? --i -> i--

////activeRecipe("org.openrewrite.java.cleanup.SimplifyConsecutiveAssignments")                                                     // ,cleanup, not yet, -1, ?, ?, generate error in the code with comment
////activeRecipe("org.openrewrite.java.cleanup.LambdaBlockToExpression")                                                            // ,cleanup, not yet, -1, ?, ?, do not use, reformat gradle.build
////activeRecipe("org.openrewrite.java.cleanup.UnnecessaryCatch")                                                                   // ,cleanup, not yet, -1,?, ?, do not use, change the behaviour if NPE occurs for instance
////activeRecipe("org.openrewrite.java.cleanup.SimplifyDurationCreationUnits")                                                      // ,cleanup, not yet, 0, ?, ?, NotFound
////activeRecipe("org.openrewrite.java.cleanup.InstanceOfPatternMatch")                                                             // ,cleanup, not yet, 0, ?, ?, NotFound
////activeRecipe("org.openrewrite.java.cleanup.ReplaceTextBlockWithString")                                                         // ,cleanup, not yet, 0, ?, ?, NotFound


////activeRecipe("org.openrewrite.java.cleanup.SimplifyCompoundStatement")                                                          // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.SimplifyConstantIfBranchExecution")                                                  // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.BooleanChecksNotInverted")                                                           // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.NoToStringOnStringType")                                                             // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.NoValueOfOnStringType")                                                              // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.StringLiteralEquality")                                                              // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.RenameMethodsNamedHashcodeEqualOrTostring")                                          // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.RemoveUnneededAssertion")                                                            // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.UnnecessaryCloseInTryWithResources")                                                 // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.UnnecessaryExplicitTypeArguments")                                                   // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.UseJavaStyleArrayDeclarations")                                                      // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
//activeRecipe("org.openrewrite.java.cleanup.DefaultComesLast")                                                                     // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.FallThrough")                                                                        // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.IndexOfChecksShouldUseAStartPosition")                                               // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.AtomicPrimitiveEqualsUsesGet")                                                       // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.AvoidBoxedBooleanExpressions")                                                       // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.BigDecimalRoundingConstantsToEnums")                                                 // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.CaseInsensitiveComparisonsDoNotChangeCase")                                          // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.CatchClauseOnlyRethrows")                                                            // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.NewStringBuilderBufferWithCharArgument")                                             // ,cleanup, not yet, 0, ?, ?, no effect on a big project, to be tested

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
//activeRecipe("org.openrewrite.java.cleanup.ChainStringBuilderAppendCalls")                                                        // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.Cleanup")                                                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.DeclarationSiteTypeVariance")                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.FixSerializableFields")                                                                // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.JavaApiBestPractices")                                                                 // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.NoFinalizedLocalVariables")                                                            // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.RemoveInstanceOfPatternMatch")                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceDeprecatedRuntimeExecMethods")                                                  // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceStreamToListWithCollect")                                                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceStringBuilderWithString")                                                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceValidateNotNullHavingSingleArgWithObjectsRequireNonNull")                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceValidateNotNullHavingVarargsWithObjectsRequireNonNull")                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.UseAsBuilder")                                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.controlflow.ControlFlowVisualization")                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.DeleteMethodArgument")                                                                         // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.DependencyLicenseCheck")                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.dependencies.DependencyVulnerabilityCheck")                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.DoesNotUseRewriteSkip")                                                                        // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.UpdateSourcePositions")                                                                        // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.UseStaticImport")                                                                              // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.SimplifyMethodChain")                                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.NoStaticImport")                                                                               // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.OrderImports")                                                                                 // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RandomizeId")                                                                                  // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RecipeExceptionDemonstration")                                                                 // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RecipeMarkupDemonstration")                                                                    // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RemoveAnnotation")                                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RemoveImplements")                                                                             // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.RemoveObjectsIsNull")                                                                          // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReorderMethodArguments")                                                                       // ,?, not yet, 0, ?, ?,
//activeRecipe("org.openrewrite.java.ReplaceConstant")                                                                              // ,?, not yet, 0, ?, ?,


//activeRecipe("org.openrewrite.java.migrate.Java8toJava11")
//activeRecipe("org.openrewrite.java.migrate.JavaVersion11")
//activeRecipe("org.openrewrite.java.migrate.JavaVersion17")

//activeRecipe("org.openrewrite.java.migrate.util.JavaUtilAPIs")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonList")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonMap")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonSet")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableList")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableSet")
//activeRecipe("org.openrewrite.java.migrate.util.OptionalNotEmptyToIsPresent")
//activeRecipe("org.openrewrite.java.migrate.util.OptionalNotPresentToIsEmpty")
//activeRecipe("org.openrewrite.java.migrate.util.UseEnumSetOf")
//activeRecipe("org.openrewrite.java.migrate.util.UseMapOf")

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
//activeRecipe("org.openrewrite.java.migrate.jakarta.ChangeJavaxAnnotationToJakarta")
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
//activeRecipe("org.openrewrite.java.migrate.UpgradeToJava17")
//activeRecipe("org.openrewrite.java.migrate.UseJavaUtilBase64")
//activeRecipe("org.openrewrite.java.migrate.wro4j.UpgradeWro4jMavenPluginVersion")

//activeRecipe("org.openrewrite.java.logging.log4j.Log4j1ToLog4j2")
//activeRecipe("org.openrewrite.java.logging.log4j.ParameterizedLogging")
//activeRecipe("org.openrewrite.java.logging.log4j.PrependRandomName")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jAppenderToLogback")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jLayoutToLogback")
//activeRecipe("org.openrewrite.java.logging.logback.Log4jToLogback")
//activeRecipe("org.openrewrite.java.logging.ParameterizedLogging")
//activeRecipe("org.openrewrite.java.logging.PrintStackTraceToLogError")
//activeRecipe("org.openrewrite.java.logging.slf4j.ConvertLogMessageMessageOnlyToLogMessageAndThrowable")
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
//activeRecipe("org.openrewrite.java.testing.cleanup.BestPractices")
//activeRecipe("org.openrewrite.java.testing.cleanup.RemoveEmptyTests")
//activeRecipe("org.openrewrite.java.testing.cleanup.RemoveTestPrefix")
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldIncludeAssertions")
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldNotBePublic")
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
//activeRecipe("org.openrewrite.java.testing.junit5.CleanupAssertions")
//activeRecipe("org.openrewrite.java.testing.junit5.CleanupJUnitImports")
//activeRecipe("org.openrewrite.java.testing.junit5.EnclosedToNested")
//activeRecipe("org.openrewrite.java.testing.junit5.ExpectedExceptionToAssertThrows")
//activeRecipe("org.openrewrite.java.testing.junit5.IgnoreToDisabled")
//activeRecipe("org.openrewrite.java.testing.junit5.JUnit4to5Migration")
//activeRecipe("org.openrewrite.java.testing.junit5.JUnit5BestPractices")
//activeRecipe("org.openrewrite.java.testing.junit5.JUnitParamsRunnerToParameterized")
//activeRecipe("org.openrewrite.java.testing.junit5.LifecycleNonPrivate")
//activeRecipe("org.openrewrite.java.testing.junit5.MigrateJUnitTestCase")
//activeRecipe("org.openrewrite.java.testing.junit5.MockitoJUnitToMockitoExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.ParameterizedRunnerToParameterized")
//activeRecipe("org.openrewrite.java.testing.junit5.RemoveObsoleteRunners")
//activeRecipe("org.openrewrite.java.testing.junit5.RunnerToExtension")
//activeRecipe("org.openrewrite.java.testing.junit5.StaticImports")
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


