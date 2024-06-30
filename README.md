MiniGamesRothFick
Overview
MiniGamesRothFick is a Java console application that currently features a simple Lotto game. It serves as a foundational project with plans to expand to include additional mini games in the future. The application is designed to be interactive and provides a basic framework for implementing and playing various games.

Features
LottoMiddleware: Manages the core logic of the Lotto game, including user input, number generation, and result display.
LottoGenerator: Generates random Lotto numbers.
LottoInputReader: Handles user input for selecting Lotto numbers.
LottoMessageGenerator: Generates messages based on the user's guessed numbers and the winning numbers.
LottoGame: Implements the Game interface for executing the Lotto game flow.
Planned Enhancements
Expansion to Other Games: The architecture is designed to support multiple games. Future plans include adding games like Tic-Tac-Toe, Hangman, and more.
Improved User Interface: Enhance the console interface for better user interaction and experience.
Persistence and Statistics: Store game results and provide statistical insights over time.
Multiplayer Support: Implement multiplayer capabilities for selected games.
Prerequisites
JDK 8 or higher
Maven 3.x
Installation
Clone the repository:
bash
Skopiuj kod
git clone https://github.com/rothfick/MiniGamesRothFick.git
Navigate to the project directory:
bash
Skopiuj kod
cd MiniGamesRothFick
Build the project using Maven:
Skopiuj kod
mvn clean install
Usage
Run the MiniGamesApplication class to start the application:
bash
Skopiuj kod
java -cp target/classes rothfick.minigames.MiniGamesApplication
Follow the on-screen instructions to play the Lotto game:
Enter six numbers when prompted.
The application will generate Lotto numbers and display the results.
Contributing
Contributions are welcome! Please fork the repository and create a pull request with your improvements. Make sure to follow the existing code style and write tests for any new functionality.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
Thanks to OpenAI for providing the ChatGPT model used to generate this README template.
