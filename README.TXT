http://www.esiee.fr/~bureaud/
unites.htm

POUR CEUX QUI NE RENDENT PAS DE PAGE WEB

Install the required software

Install Visual Studio Code
Download and install VSCode:
https://code.visualstudio.com/

Install the Java JDK
Download the Java Development Kit (JDK) from Oracle:
https://www.oracle.com/java/technologies/downloads/#jdk25-windows
This project was tested with Java 25.
Example installation path:
C:\Program Files\Java\jdk-25
Note: The actual installation directory may have a different name.

Install VSCode extensions
Open VS Code and install:
	• Extension Pack for Java (Microsoft)
	• GitHub Pull Requests (GitHub, optional)

Verify the Java installation
Open a new terminal in VS Code and run:
java -version
javac -version

Both commands should display the installed Java version.
If either command is not recognized, check your JDK installation and the PATH environment variable.

Clone the repository
In VS Code, select Terminal → New Terminal.

Navigate to the directory where you want to store the project. For example : 
cd "$HOME\Documents"

Clone the repository:
git clone https://github.com/dandemb/PhotoWithIcon.git

Navigate to the project folder:
cd PhotoWithIcon

Compile the project
Make sure the terminal is in the directory containing Game.java and the other Java source files.

Compile the Java files:
javac *.java

If compilation succeeds, Java will generate the corresponding .class files.

Launch the game
java Game
The game's graphical interface should open if compilation succeeds and all required resources are available.

How to play

Objective:
Find the person you are looking for in 40 moves or fewer!

Commands
Enter commands in the game's command input field. For example:
go east
To see all available commands, enter:
help

Explore the different locations, discover useful items, and find your target before you run out of moves.

Good luck and enjoy the game!