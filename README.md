ToastCatalog
A simple Android app using MVVM, Jetpack Compose, Hilt for dependency injection, and unit testing.

Features

# MVVM architecture for clean code.

# Jetpack Compose UI.

# Hilt for DI.

# Unit testing for ViewModel and UseCase layers.

Project Structure
├── data
│ ├── model # Data models representing the structure of the fetched data
│ ├── network # API-related functionality (e.g., Retrofit interfaces)
│ └── repository # Repository classes to handle data fetching and processing
├── di
│ └── hiltModule # Hilt module for Dependency Injection setup
├── ui
│ ├── items # Folder containing UI components related to items
│ │ ├── state # Contains UI states represented as sealed classes
│ │ ├── ItemScreen # Main screen Composable that displays the list of items
│ │ ├── ItemViewModel # ViewModel to handle UI logic and state management
│ │ ├── ItemRow # Composable for displaying each item in the list
│ │ └── ItemComposeActivity # Activity that hosts the ItemScreen composable
├── utils
│ └── utility

Dependencies

# Hilt: Dependency Injection

# Jetpack Compose: UI

# JUnit & Mockito: Unit testing

Architecture
UI Layer: Displays data using ItemScreen and ItemRow.

ViewModel Layer: Fetches data via UseCases.

Domain Layer: Contains business logic and use cases.

Data Layer: Handles data sources (model, network, repository).

DI Layer: Hilt injects dependencies.

Unit Testing
Run tests via Android Studio's Run All Tests.