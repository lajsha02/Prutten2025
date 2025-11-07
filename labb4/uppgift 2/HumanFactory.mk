TARGETS= HumanFactory.pdf HumanFactory.mk
all: classes-human HumanFactory.pdf

HumanFactory.pdf: HumanFactory.tex
	pdflatex -interaction=nonstopmode -halt-on-error HumanFactory.tex
	pdflatex -interaction=nonstopmode -halt-on-error HumanFactory.tex

HumanFactory.tex: HumanFactory.nw
	noweave -latex HumanFactory.nw > HumanFactory.tex
human/Human.java: HumanFactory.nw
	mkdir -p human
	notangle -L'//line %L "%F"%N' -Rhuman/Human.java HumanFactory.nw > human/Human.java

human/NonBinary.java: HumanFactory.nw
	mkdir -p human
	notangle -L'//line %L "%F"%N' -Rhuman/NonBinary.java HumanFactory.nw > human/NonBinary.java

human/Woman.java: HumanFactory.nw
	mkdir -p human
	notangle -L'//line %L "%F"%N' -Rhuman/Woman.java HumanFactory.nw > human/Woman.java

human/Man.java: HumanFactory.nw
	mkdir -p human
	notangle -L'//line %L "%F"%N' -Rhuman/Man.java HumanFactory.nw > human/Man.java

TestHuman.java: HumanFactory.nw
	notangle -L'//line %L "%F"%N' -RTestHuman.java HumanFactory.nw > TestHuman.java
.PHONY: classes-human run-human clean-HumanFactory
classes-human: human/Human.java human/NonBinary.java human/Woman.java human/Man.java TestHuman.java
	@if [ -x ./noerr.pl ]; then ./noerr.pl javac human/*.java TestHuman.java; else javac human/*.java TestHuman.java; fi

run-human: classes-human
	java TestHuman
clean: clean-HumanFactory
clean-HumanFactory:
	rm -f HumanFactory.tex HumanFactory.aux HumanFactory.log HumanFactory.toc
	rm -f HumanFactory.mk HumanFactory.pdf
	rm -f human/*.class *.class
	rm -f TestHuman.java human/*.java
	rmdir human 2>/dev/null || true
