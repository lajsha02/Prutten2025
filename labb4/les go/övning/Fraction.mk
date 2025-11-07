Fraction.class: Fraction.java
	javac Fraction.java
all: Fraction.class
Fraction.java: Fraction.nw
	notangle -RFraction.java Fraction.nw > Fraction.java

\section{Tester}

Vi vill kunna testa klassen [[Fraction]] med JUnit.
Vi skapar en fil som heter [[FractionTest.java]].
Denna fil kommer att innehålla tester för alla metoder i klassen [[Fraction]].
Vi lägger även till mål i byggfilen för att kompilera och köra testerna.


FractionTest.class: FractionTest.java Fraction.class
	javac -cp .:junit-4.12.jar FractionTest.java
test: FractionTest.class
	java -cp .:junit-4.12.jar org.junit.runner.JUnitCore FractionTest
