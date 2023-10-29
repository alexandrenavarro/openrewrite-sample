# openrewrite-sample
openrewrite-sample

Extract recipe and generate config for build.gradle.kts
    
    ./gradlew rewriteDiscover | sort | grep -e "^    .*" | cut -c5- > recipes-sortedtxt
    
    cat recipes.txt|awk '{print "////activeRecipe(\"" $0 "\")"} '

Only recipes with org.openrewrite.java.*

    cat recipes.txt|grep "org.openrewrite.java\.[^\.]*$"|awk '{print "////activeRecipe(\"" $0 "\")"} '

First activate the recipe in the build.gradle.kts and then run the rewrite

    ./gradlew rewriteRun
