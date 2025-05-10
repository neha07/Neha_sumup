ToastCatalog
A simple Android app using MVVM, Jetpack Compose, Hilt, and unit testing.

🔧 Tech Stack
MVVM Architecture

Jetpack Compose for UI

Hilt for Dependency Injection

JUnit for ViewModel testing

📁 Project Structure
- **data/**
    - **model/** – Kotlin data classes
    - **network/** – API services or mock data
    - **repository/** – Handles data fetching logic

- **di/**
    - **hiltModule/** – Hilt modules for dependency injection

- **ui/**
    - **itemRow/** – Reusable composable for a single item
    - **itemScreen/** – Main screen that displays the list
    - **itemComposeActivity/** – App's entry point
    - **ItemViewModel/** – ViewModel managing UI state and logic

- **test/**
    - **viewmodel/** – Unit tests for the Repository and ViewModel


🔄 App Flow
UI → ViewModel → Repository → Data → ViewModel → UI

✅ Highlights
MVVM architecture

Modern declarative UI

Testable and modular

Easy to maintain