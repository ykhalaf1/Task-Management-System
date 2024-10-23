all: Main.java Menu.java PriorityLevel.java State.java Task.java TaskManager.java User.java Day.java FileManager.java
	javac Main.java Menu.java PriorityLevel.java State.java Task.java TaskManager.java User.java Day.java FileManager.java

run: all
	java Main

class:
	rm *.class

jar: all
	jar cfm tdl.jar manifest.txt *.class
	java -jar tdl.jar