plugins {
	java
	id("org.springframework.boot") version "3.0.3"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.openrewrite.rewrite") version "5.36.0"
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

rewrite {
	// Recipe, Note (10 formating; 9; 8; 7; tech migration;  0 note -1 do not use it, Check by checkstyle, Check by Sonar, Comment,

//activeRecipe("org.openrewrite.java.cleanup.EmptyBlock") 				// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.MethodParamPad") 			// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.ModifierOrder") 			// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.NeedBraces") 				// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceAfter")		// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceBefore") 		// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.OperatorWrap")				// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.TypecastParenPad") 		// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.cleanup.UnnecessaryParentheses") 	// ,10, yes, don't care
//
////activeRecipe("org.openrewrite.java.format.AutoFormat") 				// ,-1, yes, don't care, don't not format correct compared to intellij
//activeRecipe("org.openrewrite.java.format.BlankLines") 				// ,10, no, no, Add some blank like between method
//activeRecipe("org.openrewrite.java.format.EmptyNewlineAtEndOfFile") 	// ,10, yes, don't care
////activeRecipe("org.openrewrite.java.format.NormalizeFormat")			// ,-1, yes, don't care, break all the formating notably gradle.build, don't use it absolutely
////activeRecipe("org.openrewrite.java.format.NormalizeLineBreaks") 	// ,-1, no, no, Normalize LF / CRLF, weird behaviour to choose LF ou CRLF if different?
//activeRecipe("org.openrewrite.java.format.NormalizeTabsOrSpaces") 	// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.format.RemoveTrailingWhitespace") 	// ,10, yes, don't care
//activeRecipe("org.openrewrite.java.format.SingleLineComments") 		// ,10, yes?, don't care, just a space after a single line comment
//activeRecipe("org.openrewrite.java.format.Spaces") 					// ,10, yes, don't care
////activeRecipe("org.openrewrite.java.format.TabsAndIndents") 			// ,-1, yes, don't care, do not format like intellij (1 or 2 indent for continuation)
//
activeRecipe("org.openrewrite.java.RemoveUnusedImports")				// ,10, yes, don't care

//activeRecipe("org.openrewrite.java.cleanup.DefaultComesLast") // code cleanup 1/18 switch default end, impact code sematic yes, check by checkystle ?, check by sonar ?
//activeRecipe("org.openrewrite.java.cleanup.ForLoopControlVariablePostfixOperators") // code cleanup 4/18  --i -> i++ , pas util,  impact code sematic yes, check by checkystle no?, check by sonar no?
//activeRecipe("org.openrewrite.java.cleanup.FinalizePrivateFields") // code cleanup 4/18, ajout final, trop d’impact , impact code sematic yes, check check by checkystle no, check by sonar yes
//activeRecipe("org.openrewrite.java.cleanup.PadEmptyForLoopComponents") // code cleanup 9/18, impact code sematic no, check check by checkystle yes, check by sonar no?
//activeRecipe("org.openrewrite.java.cleanup.EqualsAvoidsNull") // code cleanup 11/18, impact code sematic little, check check by checkystle ?, check by sonar yes?
//activeRecipe("org.openrewrite.java.cleanup.ExplicitInitialization") // code cleanup 12/18, impact code sematic little, check check by checkystle no?, check by sonar no?
//activeRecipe("org.openrewrite.java.cleanup.FallThrough") // code cleanup 13/18, impact code sematic yes, check check by checkystle no?, check by sonar yes?
//activeRecipe("org.openrewrite.java.cleanup.HideUtilityClassConstructor") // code cleanup 14/18, impact code sematic little bit, check check by checkystle yes but not for lombok?, check by sonar yes?
//activeRecipe("org.openrewrite.java.cleanup.ReplaceThreadRunWithThreadStart")  // code cleanup 18/18, rare, impact code sematic yes, check check by checkystle no, check by sonar yes?


//activeRecipe("org.openrewrite.java.cleanup.MissingOverrideAnnotation")
//activeRecipe("org.openrewrite.java.cleanup.AddSerialVersionUidToSerializable")
//activeRecipe("org.openrewrite.java.cleanup.AtomicPrimitiveEqualsUsesGet")
//activeRecipe("org.openrewrite.java.cleanup.AvoidBoxedBooleanExpressions")
//activeRecipe("org.openrewrite.java.cleanup.BigDecimalRoundingConstantsToEnums")
//activeRecipe("org.openrewrite.java.cleanup.BooleanChecksNotInverted")
//activeRecipe("org.openrewrite.java.cleanup.CaseInsensitiveComparisonsDoNotChangeCase")
//activeRecipe("org.openrewrite.java.cleanup.CatchClauseOnlyRethrows")
//activeRecipe("org.openrewrite.java.cleanup.NewStringBuilderBufferWithCharArgument")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
