# Games
Collection of games using java.
#  Gamers Project

This project is a **Java-based console game collection** that contains three mini-games:

1. **Rock Paper Scissors**
2. **Snake and Ladder**
3. **Quiz Game**

It also tracks scores for the quiz game using a file system.

---

##  Project Structure

Project/
│── Gamers.java # Main program file
│── questionAndAnswer.txt # Stores quiz questions and answers
│── score.txt # Stores the highest quiz score


---

##  Features

- **Main Menu**
  - Select between 3 games or exit.
  - Input validation to avoid crashes.

- **Rock Paper Scissors**
  - Play against the computer.
  - Random computer choice.
  - Detects win/loss/draw.

- **Snake and Ladder**
  - Dice roll simulation with ASCII dice face.
  - Starts only when you roll a 6.
  - Handles snakes 🐍 and ladders 🪜.
  - Board displayed after every move.
  - Ends when player reaches 100.

- **Quiz Game**
  - Reads questions from `questionAndAnswer.txt`.
  - Each question contains **4 options** and **1 correct answer**.
  - Asks 10 questions (or fewer if file has less).
  - Validates input (only `1–4` allowed).
  - Tracks and saves high score in `score.txt`.

---

##  Question File Format (`questionAndAnswer.txt`)

Each line should follow this format:

Question,Option1,Option2,Option3,Option4,CorrectOptionNumber
What is the capital of India?,New Delhi,Mumbai,Kolkata,Chennai,1
Which is the largest planet?,Earth,Mars,Jupiter,Saturn,3


 **Note:** First line is skipped (you can use it as a header).

---

##  Score File (`score.txt`)

- Contains a single number (the highest quiz score).
- Example:


---

## ▶️ How to Run

1. Compile the program:
   ```bash
   javac Project/Gamers.java

Run the program:
java Project.Gamers

Enter 1 for Rock Paper Scissors game.
Enter 2 for Snake and ladder.
Enter 3 for Quiz Game.
Enter 4 for Exit.

Requirements

Java 8 or higher

questionAndAnswer.txt with at least one question

score.txt (can be empty or contain 0 initially)

