# Pulled from https://stackoverflow.com/questions/6623161/javac-option-to-compile-all-java-files-under-a-given-directory-recursively (although, I added the '.')
find . -name "*.java" > sources.txt
javac @sources.txt