# Bike Racing Registration System

## Overview
This is a Java based console application designed to manage bike race registrations. It is developed by Team Manganese for Deliverable 4 for SER315.

## Architecture & Design Patterns
This system adheres to the **Model-View-Controller (MVC)** architectural pattern to separate business logic from the user interface. 

It integrates two core design patterns:
* **Strategy Pattern:** Implemented within `RegistrationController` (`controller` package) to dynamically switch between `OfficialRegistrationStrategy` and `UnofficialRegistrationStrategy` (`strategy` package) rulesets based on whether a selected race is official or unofficial.
* **Observer Pattern:** Implemented across the `observer` and `model` packages. The `RaceResult` class acts as the `Subject`, notifying attached `Racer` objects (`Observer`) when race placements are finalized and automatically upgrading a racer's category level upon a podium finish.

## How to Compile and Run (Windows PowerShell)
From the root project directory, run the following commands:

```powershell
mkdir bin -Force
javac -d bin (Get-ChildItem -Recurse -Filter *.java).FullName
java -cp bin view.Main
```

## How to Compile and Run (macOS / Linux Bash & Zsh)
From the root project directory, run the following commands:

```bash
mkdir -p bin
javac -d bin $(find . -name "*.java")
java -cp bin view.Main
```

## Error Flow Testing
The application includes test races in the menu to demonstrate registration error flows:
* **Past Deadline Race:** Uses a registration deadline that has already passed. Selecting this race displays a deadline error and prevents registration from continuing.
* **Full Race:** Uses 0 available spaces. Selecting this race displays a capacity error and prevents registration from continuing.
* **Input Validation:** For prototyping purposes, any invalid category input during the registration flow will default to Cat 3 automatically.