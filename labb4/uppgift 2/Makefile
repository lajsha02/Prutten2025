TARGETS=  HumanFactory.pdf HumanFactory.mk

all: ${TARGETS}

HumanFactory.pdf:	HumanFactory.tex
	pdflatex HumanFactory.tex
	pdflatex HumanFactory.tex

HumanFactory.tex: HumanFactory.nw
	noweave -latex HumanFactory.nw > HumanFactory.tex

HumanFactory.mk: HumanFactory.nw
	notangle -t2 -RHumanFactory.mk $< | sed 's/^  /\t/' > $@

clean:
	rm ${TARGETS}
	-rmdir human 2>/dev/null || true

include HumanFactory.mk