plugins {
    java
    checkstyle
    id("org.springframework.boot") version "3.0.3"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.openrewrite.rewrite") version "5.36.0"
    id("org.sonarqube") version "3.5.0.2730"
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
    rewrite(platform("org.openrewrite.recipe:rewrite-recipe-bom:1.15.0"))
//    rewrite("org.openrewrite.recipe:rewrite-spring")
    rewrite("org.openrewrite.recipe:rewrite-testing-frameworks")

    // Other project dependencies
}

rewrite {
    // Recipe, Note (10 formating; 9 change code but must not change behavior; 8 change code but may change behavior in some cases; 7 tech migration; 6 change code but rare case, 5 change code but can break, 0 note tested; note -1 do not use it, Check by checkstyle, Check by Sonar, Comment,

    // Java Cleanup
//activeRecipe("org.openrewrite.java.cleanup.EmptyBlock") 								// ,10, yes, yes
//activeRecipe("org.openrewrite.java.cleanup.MethodParamPad") 							// ,10, yes, no
//activeRecipe("org.openrewrite.java.cleanup.ModifierOrder") 							// ,10, yes, yes
//activeRecipe("org.openrewrite.java.cleanup.NeedBraces") 								// ,10, yes, no
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceAfter")						// ,10, yes, no
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceBefore") 						// ,10, yes, no
//activeRecipe("org.openrewrite.java.cleanup.OperatorWrap")								// ,10, yes, no
//activeRecipe("org.openrewrite.java.cleanup.RemoveExtraSemicolons")			        // ,10, no, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnneededBlock")                      // ,10, yes, ?
//activeRecipe("org.openrewrite.java.cleanup.TypecastParenPad") 						// ,10, yes, no
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryParentheses") 					// ,10, no, ?

    // Java Format
//activeRecipe("org.openrewrite.java.format.BlankLines") 								// ,10, no, no, Add some blank like between method
//activeRecipe("org.openrewrite.java.format.EmptyNewlineAtEndOfFile") 					// ,10, yes, no
//activeRecipe("org.openrewrite.java.format.NormalizeTabsOrSpaces") 					// ,10, yes, no
//activeRecipe("org.openrewrite.java.format.RemoveTrailingWhitespace") 					// ,10, yes, no
//activeRecipe("org.openrewrite.java.format.SingleLineComments") 						// ,10, no, no, just a space after a single line comment
//activeRecipe("org.openrewrite.java.format.Spaces") 									// ,10, yes, no


    // Java
//activeRecipe("org.openrewrite.java.RemoveUnusedImports")								// ,10, yes, yes

    // Java Cleanup



//activeRecipe("org.openrewrite.java.cleanup.RemoveRedundantTypeCast")                  // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryThrows")                        // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseDiamondOperator")                       // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ExplicitInitialization") 					// ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.StaticMethodNotFinal")                     // ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.MissingOverrideAnnotation")				// ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.SimplifyBooleanExpression")                // ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.SimplifyBooleanReturn")                    // ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.NoDoubleBraceInitialization")              // ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.EqualsAvoidsNull") 						// ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.AddSerialVersionUidToSerializable")		// ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.UseLambdaForFunctionalInterface")          // ,9, ?, ?,
//activeRecipe("org.openrewrite.java.cleanup.ReplaceLambdaWithMethodReference")         // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.CompareEnumsWithEqualityOperator")         // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NoRedundantJumpStatements")                // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.MultipleVariableDeclarations")             // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NestedEnumsAreNotStatic")                  // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseCollectionInterfaces")                  // ,9, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.HideUtilityClassConstructor") 				// ,9, ?, ? vs @Utility

//activeRecipe("org.openrewrite.java.cleanup.CombineSemanticallyEqualCatchBlocks")      // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.CommonStaticAnalysis")                     // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ControlFlowIndentation")                   // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.CovariantEquals")                          // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ExternalizableHasNoArgsConstructor")       // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.FixStringFormatExpressions")               // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.InlineVariable")                           // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseMapContainsKey")                        // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NoPrimitiveWrappersForToStringOrCompareTo")// ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.WhileInsteadOfFor")                        // ,0, ?, ?
//activeRecipe("com.yourorg.DeclarationSiteTypeVarianceExample")                        // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.CommonDeclarationSiteTypeVariances")       // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RedundantFileCreation")                    // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveEmptyJavaDocParameters")             // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryPrimitiveAnnotations")          // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveCallsToObjectFinalize")              // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveJavaDocAuthorTag")                   // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NoFinalizer")                              // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveCallsToSystemGc")                    // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RenameExceptionInEmptyCatch")              // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ReplaceThreadRunWithThreadStart")          // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ReplaceDuplicateStringLiterals")           // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseListSort")                              // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseForEachRemoveInsteadOfSetRemoveAll")    // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ReplaceStackWithDeque")                    // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ReplaceApacheCommonsLang3ValidateNotNullWithObjectsRequireNonNull") // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ReplaceRedundantFormatWithPrintf")         // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ReferentialEqualityToObjectEquals")        // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseObjectNotifyAll")                       // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ExplicitCharsetOnStringGetBytes")          // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UnwrapRepeatableAnnotations")              // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.IsEmptyCallOnCollections")                 // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NoEmptyCollectionWithRawType")             // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseStandardCharset")                       // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseStringReplace")                         // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.UseSystemLineSeparator")                   // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.NoEqualityInForCondition")                 // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.PrimitiveWrapperClassConstructorToValueOf")// ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.WriteOctalValuesAsDecimal")                // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ObjectFinalizeCallsSuper")                 // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.ForLoopIncrementInUpdate")                 // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.IndexOfShouldNotCompareGreaterThanZero")   // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.IndexOfReplaceableByContains")             // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.MinimumSwitchCases")                       // ,0, ?, ?

//activeRecipe("org.openrewrite.java.cleanup.LowercasePackage")                         // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedLocalVariables")               // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedPrivateFields")                // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RemoveUnusedPrivateMethods")               // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.FinalClass")                               // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.FinalizeLocalVariables")                   // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.FinalizePrivateFields")                    // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RenameLocalVariablesToCamelCase")          // ,0, ?, ?
//activeRecipe("org.openrewrite.java.cleanup.RenamePrivateFieldsToCamelCase")           // ,0, ?, ?


//activeRecipe("org.openrewrite.java.cleanup.ExplicitLambdaArgumentTypes")              // ,?, ?, ?, do we want to do it (personally yes but controversial)
//activeRecipe("org.openrewrite.java.cleanup.ForLoopControlVariablePostfixOperators") 	// ,?, ?, ? --i -> i--


////activeRecipe("org.openrewrite.java.format.AutoFormat") 								// ,-1, yes, no, don't not format correct compared to intellij
////activeRecipe("org.openrewrite.java.format.TabsAndIndents") 							// ,-1, yes, no, do not format like intellij (1 or 2 indent for continuation)
////activeRecipe("org.openrewrite.java.format.WrappingAndBraces")						// ,-1, yes, no, break all the formatting notably gradle.build, don't use it absolutely
////activeRecipe("org.openrewrite.java.format.NormalizeFormat")							// ,-1, yes, no, do nothing except some stuff in the gradle.build
////activeRecipe("org.openrewrite.java.format.NormalizeLineBreaks") 					// ,-1, no, ?, Normalize LF / CRLF, weird behaviour to choose LF ou CRLF if different?
////activeRecipe("org.openrewrite.java.cleanup.SimplifyConsecutiveAssignments")         // ,-1, ?, ?, generate error in the code with comment
////activeRecipe("org.openrewrite.java.cleanup.LambdaBlockToExpression")                // ,-1, ?, ?, do not use, reformat gradle.build
////activeRecipe("org.openrewrite.java.cleanup.UnnecessaryCatch")                       // ,-1,?, ?, do not use, change the behaviour if NPE occurs for instance


////activeRecipe("org.openrewrite.java.cleanup.SimplifyDurationCreationUnits")            // ,0, ?, ?, NotFound
////activeRecipe("org.openrewrite.java.cleanup.InstanceOfPatternMatch")                   // ,0, ?, ?, NotFound
////activeRecipe("org.openrewrite.java.cleanup.ReplaceTextBlockWithString")               // ,0, ?, ?, NotFound
////activeRecipe("org.openrewrite.java.cleanup.UpperCaseLiteralSuffixes")                 // ,0, ?, ?, NotFound


////activeRecipe("org.openrewrite.java.cleanup.PadEmptyForLoopComponents") 				  // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.SimplifyCompoundStatement")                // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.SimplifyConstantIfBranchExecution")        // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.BooleanChecksNotInverted")			      // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.NoToStringOnStringType")                   // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.NoValueOfOnStringType")                    // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.StringLiteralEquality")                    // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.RenameMethodsNamedHashcodeEqualOrTostring")// ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.RemoveUnneededAssertion")                  // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.UnnecessaryCloseInTryWithResources")       // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.UnnecessaryExplicitTypeArguments")         // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.UseJavaStyleArrayDeclarations")            // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.DefaultComesLast")                         // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.FallThrough") 							  // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.IndexOfChecksShouldUseAStartPosition")     // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.AtomicPrimitiveEqualsUsesGet")			  // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.AvoidBoxedBooleanExpressions")			  // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.BigDecimalRoundingConstantsToEnums")		  // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.CaseInsensitiveComparisonsDoNotChangeCase")// ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.CatchClauseOnlyRethrows")				  // ,0, ?, ?, no effect on a big project, to be tested
////activeRecipe("org.openrewrite.java.cleanup.NewStringBuilderBufferWithCharArgument")	  // ,0, ?, ?, no effect on a big project, to be tested








    // Java Testing Assertj (ok globally)
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
//activeRecipe("org.openrewrite.java.testing.assertj.UseExplicitSize")

    // Java Testing cleanup  (ok globally)
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertionsArgumentOrder")
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldIncludeAssertions")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueComparisonToAssertEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.RemoveEmptyTests")
//activeRecipe("org.openrewrite.java.testing.cleanup.TestsShouldNotBePublic")
////activeRecipe("org.openrewrite.java.testing.cleanup.RemoveTestPrefix")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseNegationToAssertTrue")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseNullToAssertNotNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertFalseEqualsToAssertNotEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueNegationToAssertFalse")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueNullToAssertNull")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertTrueEqualsToAssertEquals")
//activeRecipe("org.openrewrite.java.testing.cleanup.AssertEqualsNullToAssertNull")

    // Java Testing Junit5  (ok globally)
//activeRecipe("org.openrewrite.java.testing.junit5.CleanupJUnitImports")
//activeRecipe("org.openrewrite.java.testing.junit5.AddMissingNested")


    // Java Spring (not tested)
//activeRecipe("org.openrewrite.java.spring.NoRequestMappingAnnotation")
//activeRecipe("org.openrewrite.java.spring.ImplicitWebAnnotationNames")
//activeRecipe("org.openrewrite.java.spring.BeanMethodsNotPublic")
//activeRecipe("org.openrewrite.java.spring.NoAutowiredOnConstructor")
//activeRecipe("org.openrewrite.java.spring.NoRepoAnnotationOnRepoInterface")

//activeRecipe("org.openrewrite.java.logging.slf4j.ParameterizedLogging")
//activeRecipe("org.openrewrite.java.logging.slf4j.ConvertLogMessageMessageOnlyToLogMessageAndThrowable")
//activeRecipe("org.openrewrite.java.logging.slf4j.Slf4jLogShouldBeConstant")
//activeRecipe("org.openrewrite.java.logging.SystemPrintToLogging")

    // Java Migrate Guava (ok)
//activeRecipe("org.openrewrite.java.migrate.guava.NoGuava")

    // Java Migrate Util  (not tested)
//activeRecipe("org.openrewrite.java.migrate.util.UseEnumSetOf")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonList")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableList")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonMap")
//activeRecipe("org.openrewrite.java.migrate.util.UseMapOf")
//activeRecipe("org.openrewrite.java.migrate.util.OptionalNotPresentToIsEmpty")
//activeRecipe("org.openrewrite.java.migrate.util.OptionalNotEmptyToIsPresent")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsSingletonSet")
//activeRecipe("org.openrewrite.java.migrate.util.MigrateCollectionsUnmodifiableSet")
//activeRecipe("org.openrewrite.java.migrate.lang.StringFormatted")

    // Java Migrate  (not tested)
//activeRecipe("org.openrewrite.java.migrate.UseJavaUtilBase64")

    // Java (to be inline)
//activeRecipe("org.openrewrite.java.OrderImports")

}

checkstyle {
    isIgnoreFailures = true
}


tasks.withType<Test> {
    useJUnitPlatform()
}


