# Makefile for java
# Author: Gabriel Bartholomaus
# Noting fancy, hard coded

# to run ConversionTest
# java -cp JUNIT/junit-4.13.jar:JUNIT/hamcrest-core-1.3.jar org.junit.runner.JUnitCore ConversionTest

all:
	javac Conversion.java
	javac -cp JUNIT/junit-4.13.jar ConversionTest.java

clean:
	$(RM) *.class
