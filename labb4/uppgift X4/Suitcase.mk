TARGETS= Suitcase.pdf Suitcase.mk
all: classes Suitcase.pdf

Suitcase.pdf:  Suitcase.tex
	pdflatex -interaction=nonstopmode -halt-on-error Suitcase.tex
	pdflatex -interaction=nonstopmode -halt-on-error Suitcase.tex

Suitcase.tex: Suitcase.nw
	noweave -latex Suitcase.nw > Suitcase.tex
Component.java: Suitcase.nw
	notangle -L'//line %L "%F"%N' -RComponent.java Suitcase.nw > Component.java

Leaf.java: Suitcase.nw
	notangle -L'//line %L "%F"%N' -RLeaf.java Suitcase.nw > Leaf.java

Composite.java: Suitcase.nw
	notangle -L'//line %L "%F"%N' -RComposite.java Suitcase.nw > Composite.java

Client.java: Suitcase.nw
	notangle -L'//line %L "%F"%N' -RClient.java Suitcase.nw > Client.java

BreadthFirstIterator.java: Suitcase.nw
	notangle -L'//line %L "%F"%N' -RBreadthFirstIterator.java Suitcase.nw > BreadthFirstIterator.java

PreorderIterator.java: Suitcase.nw
	notangle -L'//line %L "%F"%N' -RPreorderIterator.java Suitcase.nw > PreorderIterator.java
.PHONY: classes run clean-Suitcase
classes: Component.java Leaf.java Composite.java Client.java BreadthFirstIterator.java PreorderIterator.java
	@if [ -x ./noerr.pl ]; then ./noerr.pl javac *.java; else javac *.java; fi

run: classes
	java Client
clean: clean-Suitcase
clean-Suitcase:
	rm -f Suitcase.tex Suitcase.aux Suitcase.log Suitcase.toc
	rm -f *.class *.java
