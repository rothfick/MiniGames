# MiniGamesRothFick

## Overview

MiniGamesRothFick is a Java application that allows users to play a simple Lotto game. It includes several components such as input handling, number generation, and result display using standard input/output.

## Features

- **LottoMiddleware**: Manages the core logic of the Lotto game, including user input, number generation, and result display.
- **LottoGenerator**: Generates random Lotto numbers.
- **LottoInputReader**: Handles user input for selecting Lotto numbers.
- **LottoMessageGenerator**: Generates messages based on the user's guessed numbers and the winning numbers.
- **LottoGame**: Implements the Game interface for executing the Lotto game flow.

## Prerequisites

- JDK 8 or higher
- Maven 3.x

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/MiniGamesRothFick.git
   ```
2.Navigate to the project directory:
```
cd MiniGamesRothFick
```
3. Build the project using Maven:

```
mvn clean install
```

## Usage
Run the MiniGamesApplication class to start the application:

```
java -cp target/classes rothfick.minigames.MiniGamesApplication
```
Follow the on-screen instructions to play the Lotto game:

- Enter six numbers when prompted.
- The application will generate Lotto numbers and display the results.
## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your improvements. Make sure to follow the existing code style and write tests for any new functionality.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
