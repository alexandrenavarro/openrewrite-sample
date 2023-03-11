# openrewrite-sample
openrewrite-sample

Extract recipe and generate config for build.gradle.kts
    
    ./gradlew rewriteDiscover > recipes.txt

Clean begin and end files.
    
    cat recipes.txt|sort|awk '{print "//activeRecipe(\"" $0 "\")"} '

