# Event Management Android App

A comprehensive Android application for managing events and categories, built as part of a university assignment. This app demonstrates various Android development concepts, including database management, user authentication, maps integration, and modern UI components.

## 📱 Features

### 🔐 User Authentication
- **Sign Up**: Create new user accounts with password confirmation
- **Sign In**: Secure login with credential validation
- **Persistent Login**: Remember user credentials using SharedPreferences

### 🎯 Event Management
- **Create Events**: Add new events with validation
- **Event Details**: Track event name, category, ticket numbers, and active status
- **Event Listing**: View all events in an organized list
- **Event Validation**: Input validation for event names and ticket numbers
- **Google Search Integration**: Search for events directly on Google

### 📂 Category Management
- **Create Categories**: Add event categories with location information
- **Category Details**: Track category name, event count, location, and active status
- **Category Listing**: View all categories in a structured format
- **Auto Event Count**: Automatically increment event count when events are added
- **Location Mapping**: View category locations on Google Maps

### 🗄️ Data Management
- **Room Database**: Local database storage using Android Room
- **MVVM Architecture**: Clean architecture with ViewModels and LiveData
- **Real-time Updates**: Automatic UI updates when data changes
- **Data Persistence**: All data is stored locally on the device

### 🗺️ Maps Integration
- **Google Maps**: Interactive map display for category locations
- **Location Search**: Geocoding to find and display locations
- **Map Interactions**: Click to select countries and get location information
- **Custom Markers**: Category-specific markers with titles

### 📱 User Interface
- **Navigation Drawer**: Easy access to all app features
- **RecyclerView Lists**: Efficient display of events and categories
- **Fragments**: Modular UI components for better organization
- **Floating Action Button**: Quick access to save functionality
- **Toolbar Navigation**: Consistent navigation across screens

### 🎮 Interactive Features
- **Gesture Recognition**: Long press to clear forms, double tap to save
- **WebView Integration**: In-app Google search for events
- **Touch Interactions**: Interactive touchpad with gesture feedback
- **Form Validation**: Comprehensive input validation with user feedback

## 🏗️ Technical Architecture

### Components
- **Activities**: Main UI controllers for different screens
- **Fragments**: Reusable UI components for lists
- **ViewModels**: Business logic and data management
- **Room Database**: Local data persistence
- **RecyclerView Adapters**: Efficient list display
- **Shared Preferences**: User preference storage

### Key Technologies
- **Android SDK**: Native Android development
- **Room Database**: Local SQLite database with ORM
- **LiveData & ViewModel**: Reactive UI updates
- **Google Maps SDK**: Location and mapping features
- **WebView**: In-app web browsing
- **Gson**: JSON serialization/deserialization
- **Material Design**: Modern UI components

## 📁 Project Structure

```
src/main/java/com/example/assignment1/
├── CategoryActivity.java           # Add/Edit categories
├── DashboardActivity.java          # Main dashboard with navigation
├── EventGoogleSearchActivity.java  # Google search integration
├── FragmentListCategory.java       # Category list fragment
├── FragmentListEvent.java          # Event list fragment
├── GoogleMapsActivity.java         # Maps integration
├── ListCategoryActivity.java       # Category listing screen
├── ListEventActivity.java          # Event listing screen
├── LoginActivity.java              # User login
├── SignUpActivity.java             # User registration
├── RandomGenerator.java            # ID generation utilities
├── KEYS.java                       # Constants and keys
└── provider/                       # Database components
    ├── Category.java               # Category entity
    ├── CategoryViewModel.java      # Category business logic
    ├── Event.java                  # Event entity
    └── EventViewModel.java         # Event business logic
```

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK API level 21 or higher
- Google Maps API key (for maps functionality)
- Internet connection (for maps and search features)

### Installation

1. **Clone the repository**
   ```bash
   git clone https:
   cd 
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the project directory

3. **Configure Google Maps API**
   - Get a Google Maps API key from Google Cloud Console
   - Add the API key to your `strings.xml` or `local.properties`

4. **Build and Run**
   - Connect an Android device or start an emulator
   - Click "Run" in Android Studio

## 📖 Usage Guide

### First Time Setup
1. **Register**: Create a new account using the Sign Up screen
2. **Login**: Sign in with your credentials
3. **Create Categories**: Add event categories with locations
4. **Add Events**: Create events and assign them to categories

### Managing Events
- **Add Event**: Use the main dashboard form or double-tap gesture
- **View Events**: Navigate to "View Events" from the drawer menu
- **Search Events**: Click on any event to search it on Google

### Managing Categories
- **Add Category**: Use "Add Category" from the navigation drawer
- **View Categories**: Navigate to "All Categories" to see the list
- **View Location**: Click on any category to see its location on the map

### Navigation Tips
- Use the **hamburger menu** (☰) to access all features
- **Long press** on the touchpad to clear event forms
- **Double tap** on the touchpad to save events quickly
- Use the **back arrow** in toolbars to return to previous screens

## 🎯 Key Learning Outcomes

This project demonstrates proficiency in:
- **Android Architecture Components** (Room, ViewModel, LiveData)
- **User Interface Design** with Material Design principles
- **Database Management** with local SQLite storage
- **API Integration** (Google Maps, Geocoding)
- **Input Validation** and error handling
- **Fragment-based Navigation** and modular design
- **Gesture Recognition** and touch interactions
- **WebView Integration** for in-app browsing

## 📝 Features Demonstrated

### Database Operations
- CRUD operations for events and categories
- Real-time data updates with LiveData
- Relationship management between entities

### User Experience
- Intuitive navigation with drawer menu
- Form validation with user feedback
- Gesture-based interactions
- Responsive list displays with RecyclerView

### Integration Features
- Google Maps for location visualization
- Web search integration
- Geocoding for address resolution
- Camera positioning and markers

## 🎓 University Assignment Context

This project was developed as part of a mobile application development course, showcasing:
- **Technical Skills**: Android development, database design, API integration
- **Problem Solving**: Event management workflow design
- **User Experience**: Intuitive interface design and navigation
- **Code Quality**: Clean architecture and proper documentation

## 🔧 Technical Specifications

- **Target SDK**: Android API 21+
- **Programming Language**: Java
- **Architecture Pattern**: MVVM (Model-View-ViewModel)
- **Database**: Room (SQLite)
- **UI Framework**: Android Views with Material Design
- **Build System**: Gradle

## 📄 License

This project is created for educational purposes as part of university coursework.

---

**Note**: This application is designed for learning purposes and demonstrates various Android development concepts including database management, user authentication, maps integration, and modern UI design patterns.
