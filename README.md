# Bike Racing Registration System

## Overview
This is a Java based console application designed to manage race registrations. It is developed for the Manganese team for Deliverable 3 for SER315.

## Architecture & Design Patterns
This system adheres to the **Model-View-Controller (MVC)** architectural pattern to separate business logic from the user interface. 

It integrates two core design patterns:
* **Strategy Pattern:** Implemented within the `RegistrationController` to dynamically switch between `OfficialRegistrationStrategy` and `UnofficialRegistrationStrategy` rulesets based on race type.
* **Observer Pattern:** Implemented in the Model layer. The `RaceResult` class acts as the Subject, notifying registered `Racer` objects (Observers) to trigger notifications when race placements are finalized.

## How to Run (Windows PowerShell)
1. Compile the source code:
   ```powershell
   javac -d bin (Get-ChildItem -Recurse -Filter *.java).FullName