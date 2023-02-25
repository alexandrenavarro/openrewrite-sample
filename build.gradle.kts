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
	// Recipe, Comment, Note (10 formating; 9; 8; 7; tech migration;  0 note -1 do not use it, Check by checkstyle, Check by Sonar

	activeRecipe("org.openrewrite.java.cleanup.EmptyBlock") // Remove empty blocks that effectively do nothing code cleanup 2/18, 10, yes, don't care
//	activeRecipe("org.openrewrite.java.cleanup.MethodParamPad") // code cleanup 6/18, format method, impact code sematic yes, check check by checkystle yes, check by sonar no?
//	activeRecipe("org.openrewrite.java.cleanup.ModifierOrder")

//	activeRecipe("org.openrewrite.java.cleanup.NeedBraces") // code cleanup 15/18, impact code sematic yes, check check by checkystle yes, check by sonar yes?
//	activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceAfter")// code cleanup 7/18, add brack, impact code sematic no, check check by checkystle yes, check by sonar no?
//	activeRecipe("org.openrewrite.java.cleanup.NoWhitespaceBefore") // code cleanup 8/18, add brack, impact code sematic no, check check by checkystle yes, check by sonar no?
//	activeRecipe("org.openrewrite.java.cleanup.OperatorWrap") // code cleanup 16/18, operator wrap impact code sematic no, check check by checkystle yes, check by sonar ?
//	activeRecipe("org.openrewrite.java.cleanup.TypecastParenPad") // code cleanup 10/18, impact code sematic no, check check by checkystle yes, check by sonar no?
//	activeRecipe("org.openrewrite.java.cleanup.UnnecessaryParentheses") // code cleanup 17/18, operator wrap impact code sematic no, check check by checkystle yes, check by sonar ?
//
////activeRecipe("org.openrewrite.java.format.AutoFormat") // format 3/11 -1
//	activeRecipe("org.openrewrite.java.format.BlankLines") //format 1/11 add some line between method for instance, impact code sematic no, check by checkystle no, check by sonar no
//	activeRecipe("org.openrewrite.java.format.EmptyNewlineAtEndOfFile") //format 2/11 impact code sematic no, check by checkystle yes, check by sonar ?
////activeRecipe("org.openrewrite.java.format.NormalizeFormat") // format 4/11 -1
//	activeRecipe("org.openrewrite.java.format.NormalizeLineBreaks") // format 5/11 impact code sematic no,  check by checkystle no, check by sonar no
//	activeRecipe("org.openrewrite.java.format.NormalizeTabsOrSpaces") // format 6/11 impact code sematic no, check check by checkystle yes, check by sonar no?
//	activeRecipe("org.openrewrite.java.format.RemoveTrailingWhitespace") // format 7/11, impact code sematic no, check check by checkystle yes, check by sonar no?
//	activeRecipe("org.openrewrite.java.format.SingleLineComments") // format 8/11, add space after comment impact code sematic no, check check by checkystle ?, check by sonar no
//	activeRecipe("org.openrewrite.java.format.Spaces") // format 9/11, spaces, code semantic no, check by checkstyle yes, check by sonar no.
////activeRecipe("org.openrewrite.java.format.TabsAndIndents") // format 10/11, -1
//
//	activeRecipe("org.openrewrite.java.RemoveUnusedImports")

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
