# Student Management System

A command-line Java application for managing student records — built by extending a
`Student` class (originally from a CS 206 assignment on constructors, encapsulation,
and object design) into a full multi-student system with search, sorting, and
persistent file storage.

## Features

- **Add / remove students** with input validation (grade must be 0–100)
- **View all students**, each showing name, numeric grade, letter grade, and
  graduate status
- **Search** students by full or partial name (case-insensitive)
- **Sort** by grade (highest first) or alphabetically by name
- **Class average** calculation across all students
- **Save / load** the student list to a text file (`students.txt`) so data
  persists between runs

## Concepts demonstrated

- Object-oriented design: encapsulation, constructors (default, 1-, 2-, and
  3-parameter overloads), accessors/mutators
- Collections: `ArrayList<Student>` for dynamic storage
- Comparators for custom sort order
- File I/O: reading/writing plain text files with `BufferedReader` /
  `PrintWriter`
- Input validation and basic error handling (`try/catch`, bounds checking)

## How to run

```bash
javac *.java
java Main
```

You'll see a menu-driven interface — enter a number to add, view, search,
sort, or save/load students.

## File structure

- `Student.java` — the core data class (name, grade, letter grade, graduate status)
- `StudentManager.java` — manages the collection of students (search, sort, save/load)
- `Main.java` — command-line menu that ties everything together

## Possible extensions

- Switch file storage to CSV with a header row, or to JSON
- Add GPA calculation across multiple courses per student
- Add a simple Swing or JavaFX GUI in place of the command-line menu
