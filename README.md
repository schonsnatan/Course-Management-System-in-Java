## 📌 About the Project
This project implements a simple system for managing courses and students, allowing the addition, removal, and listing of courses and students, as well as grade calculations and report generation. The system supports different types of courses (in-person and online) and includes file handling for data persistence.

## 🚀 Features
- Registration and management of in-person and online courses.
- Student enrollment and calculation of final grades based on provided scores.
- File handling to load courses and students.
- Generation of reports sorted by final course price and students' final grades.
- Custom exception handling for error management.

## 🛠️ Technologies Used
- **Language:** Java
- **IDE:** Intellij
- **File Handling:** BufferedReader and BufferedWriter

## 🏗️ Project Structure
- **`Curso.java`** → Abstract class for courses.
- **`CursoPresencial.java` & `CursoOnline.java`** → Derived classes implementing different pricing structures.
- **`Avaliavel.java`** → Interface for grade calculation.
- **`Aluno.java`** → Class for storing student information and grades.
- **`SistemaGestaoCursos.java`** → Main class for managing courses and students.
- **`Principal.java`** → Entry point for system execution.
- **Custom exceptions** → Handling specific system errors.
