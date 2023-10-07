# openrewrite-sample
openrewrite-sample

Extract recipe and generate config for build.gradle.kts
    
    ./gradlew rewriteDiscover > recipes.txt

Clean begin and end files.
    
    cat recipes.txt|sort|awk '{print "////activeRecipe(\"" $0 "\")"} '

Only recipes with org.openrewrite.java.*

    cat recipes.txt|sort|grep "org.openrewrite.java\.[^\.]*$"|awk '{print "////activeRecipe(\"" $0 "\")"} '

First activate the recipe in the build.gradle.kts and then run the rewrite

    ./gradlew rewriteRun
