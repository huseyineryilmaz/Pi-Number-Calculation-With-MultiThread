
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	PiCalculation.java \
	MasterThread.java \
	SlaveThreads.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
run:
	$(run) java PiCalculation
