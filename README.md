ToastCatalog
A simple Android app using MVVM, Jetpack Compose, Hilt for dependency injection, and unit testing.

Features

# MVVM architecture for clean code.

# Jetpack Compose UI.

# Hilt for DI.

# Unit testing for ViewModel and UseCase layers.

📦 Project Structure
├── data
│   ├── model         // Data models
│   ├── network       // API services
│   └── repository    // Data handling logic
│
├── domain
│   ├── usecase       // Business logic
│   └── model         // Domain models / sealed classes
│
├── di
│   └── hiltModule    // Hilt modules for DI
│
├── ui
│   ├── itemRow               // Reusable row UI
│   ├── itemScreen            // Compose screen
│   ├── itemComposeActivity   // Entry activity
│   └── ItemViewModel         // ViewModel with state
│
└── test
└── viewmodel 

Project Structure
✅ UI Layer (ui)
Built using Jetpack Compose.

Contains:

ItemScreen – the main screen that shows the list.

ItemRow – a reusable item row.

ItemComposeActivity – the launcher activity.

ItemViewModel – manages UI state and logic.

✅ ViewModel (ItemViewModel)
Acts as a bridge between UI and data.

Asks the Repository for data.

Stores and exposes state (like loading, success, or error) to the UI.

✅ Data Layer (data)
Handles actual data-related logic.

Contains:

Model – defines the data structure.

Network – makes API calls (or returns mock data).

Repository – fetches data from the network and provides it to the ViewModel.

✅ DI Layer (di)
Uses Hilt to automatically provide classes like the Repository and NetworkService where needed.

Keeps code clean and reduces boilerplate.

✅ Summary
MVVM keeps the app well-structured and testable.

Jetpack Compose builds the UI in a modern, clean way.

Hilt simplifies dependency management.

The app flows like:
UI → ViewModel → Repository → Data → ViewModel → UI