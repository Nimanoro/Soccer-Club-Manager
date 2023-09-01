# Soccer Club Manager (SCM)

![Logo]([Soccer-Club-Manager/data/Soccer.png])



## Overview

**The Soccer Club Manager is a Java-based game that simulates the management of a soccer team, games, and player customization. This README file provides an in-depth technical overview of the project, including its core classes, features, technical challenges faced during development, how to get started, and more.**

**What will the application do?:**
- Assign the user a starting team for competition.
- Simulate the match between user team and other teams in the league competition.
- Ability of user to strengthen their team by updating the players in their team.

**Who will use it?**

All soccer enthusiasts are welcomed to enjoy this game.

**Why is this project of interest to you?**

Based on my interest in soccer and game, I decided to develop this game in order to enable players to
enjoy a competition against pre-defined opponents in the league.

## Table of Contents
- [Technical Components](#technical-components)
  - [Core Classes](#core-classes)
  - [User Interface](#user-interface)
  - [Data Persistence](#data-persistence)
- [Technical Challenges](#technical-challenges)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [License](#license)
- [Acknowledgments](#acknowledgments)
- [Author](#author)

## Technical Components

### Core Classes

The project includes several core classes:

- **Player:** Represents a sports player with attributes such as name, star rating, and an associated manager.
- **Predefinedteams:** Represents predefined sports teams with attributes like overall rating and points.
- **Team:** Represents a user's soccer team, including player rosters and overall team ratings.
- **Manager:** Represents the user's in-game manager, responsible for managing coins and making decisions.
- **Game:** Simulates a soccer game between a user's team and a predefined team.
- **League:** Manages the standings of all predefined teams and user's team.
- **Fixture:** Generates the schedule of games for a user's team against predefined teams.

### User Interface

The project features a graphical user interface (GUI) built using Java Swing. The GUI includes menus for starting a game, managing the user's team, viewing league standings, and saving/loading game progress. It provides a visually appealing and user-friendly experience.

### Data Persistence

Data is persisted using JSON serialization. The project utilizes the JSON format to save and load game state, including player data, team information, league standings, and manager details.

## Technical Challenges

During the development of the Sports Management System, we encountered several technical challenges that required careful consideration and problem-solving:

1. **Data Serialization:** Implementing data serialization using JSON proved to be a complex task. Ensuring that all core classes could be properly serialized and deserialized while maintaining data integrity required meticulous design.

2. **Graphical User Interface (GUI):** Designing an intuitive and responsive GUI for the main menu and various game screens was challenging. Balancing aesthetics with functionality and providing a smooth user experience required several iterations.

3. **Game Logic:** Creating a realistic game simulation, including calculating game results based on team strengths and player attributes, was a technically demanding task. Ensuring that game outcomes were both fair and engaging for the player was a significant challenge.

4. **Managing Game State:** Implementing the saving and loading of the game state while handling potential errors, such as file not found exceptions or corrupted save files, was a complex aspect of the project.

5. **User Experience:** Striking the right balance between providing users with detailed game information and maintaining a user-friendly interface was an ongoing challenge. Deciding what data to display, where, and when was crucial to providing an enjoyable gaming experience.

## Getting Started
To run the Sports Management System on your local machine, follow these steps:

1. Clone the project repository from GitHub.
2. Ensure you have Java and Java Swing installed on your computer.
3. Compile the Java files using your preferred Java development environment.
4. Run the compiled application.

## Usage

Once the application is running, use the graphical user interface to navigate through the various screens and options. You can start a new game, manage your team, view league standings, save your progress, and load a saved game.

## Screenshots
![Main Menu](/images/main_menu.png)
*Main Menu of the Sports Management System*

![Team Panel](/images/team_panel.png)
*Team Panel for Player Customization*


## License

This project is licensed under the MIT License.

## Acknowledgments

We would like to acknowledge the following resources and libraries that contributed to the development of this project:

- Java Swing for the graphical user interface.
- JSON for data serialization and persistence.

## Author
This Soccer Club Manager(SMC) project was authored by Nima Norouzi.





