TARGETS=  Suitcase.pdf Suitcase.mk

all: ${TARGETS}

Suitcase.pdf:	Suitcase.tex
	pdflatex Suitcase.tex
	pdflatex Suitcase.tex

Suitcase.tex: Suitcase.nw
	noweave -latex Suitcase.nw > Suitcase.tex

Suitcase.mk: Suitcase.nw
	notangle -t2 -RSuitcase.mk $< | sed 's/^  /\t/' > $@

clean:
	rm ${TARGETS}

include Suitcase.mk
