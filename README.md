## 🌟 Project Overview

**EventMaster** is a feature-rich Android application designed to streamline event management processes through modern mobile development practices. Built using MVVM architecture, Room database, and Google Maps integration, this application demonstrates enterprise-level software design while maintaining intuitive user experience.

> **🎓 Academic Excellence**: This project showcases advanced Android development concepts including database management, real-time UI updates, geospatial integration, and material design implementation.

---

## 🎯 Key Features

### 🔐 **Secure Authentication System**
- **User Registration**: Create accounts with password validation
- **Login System**: Secure authentication with credential persistence
- **Session Management**: Remember login state using SharedPreferences
- **Input Validation**: Real-time form validation with user feedback

### 📅 **Advanced Event Management**
- **Event Creation**: Add events with category association and ticket tracking
- **Event Validation**: Smart input validation for names and numbers
- **Status Management**: Toggle active/inactive states for events
- **Google Search Integration**: Direct search functionality for events
- **Real-time Updates**: Automatic UI refresh when data changes

### 🏷️ **Category Management System**
- **Category Creation**: Organize events into meaningful categories
- **Location Integration**: Associate categories with geographic locations
- **Event Counting**: Automatic event count updates per category
- **Map Visualization**: View category locations on interactive maps
- **Status Control**: Manage active/inactive category states

### 🗄️ **Data Management & Persistence**
- **Room Database**: Modern SQLite abstraction with type-safe operations
- **MVVM Architecture**: Clean separation of UI, business logic, and data
- **LiveData Integration**: Reactive programming with automatic UI updates
- **Local Storage**: All data persisted locally with automatic backup
- **Transaction Safety**: ACID-compliant database operations

### 🗺️ **Google Maps Integration**
- **Interactive Maps**: Full Google Maps SDK implementation
- **Geocoding Services**: Convert addresses to coordinates
- **Custom Markers**: Category-specific map markers with information
- **Location Search**: Find and display locations with validation
- **Map Interactions**: Click-to-select functionality with country detection

### 📱 **Modern User Interface**
- **Material Design**: Contemporary UI following Google design principles
- **Navigation Drawer**: Intuitive side-panel navigation system
- **RecyclerView Implementation**: Efficient list rendering with view recycling
- **Fragment Architecture**: Modular UI components for better organization
- **Gesture Recognition**: Advanced touch interactions (long-press, double-tap)
- **Responsive Design**: Adaptive layouts for various screen configurations

---

## 🏗️ Technical Architecture

### 🔧 **Core Technology Stack**

| Component | Technology | Implementation |
|-----------|------------|----------------|
| **Architecture Pattern** | MVVM + Repository | Clean, testable, maintainable code structure |
| **Database** | Room + SQLite | Type-safe database operations with compile-time verification |
| **UI Framework** | Android Views + Material Design | Modern, accessible user interface components |
| **Reactive Programming** | LiveData + Observers | Real-time data binding and automatic UI updates |
| **Maps & Location** | Google Maps SDK + Geocoding | Professional geospatial functionality |
| **Web Integration** | WebView | Seamless in-app browsing experience |
| **Data Serialization** | Gson | Efficient JSON parsing and object mapping |
| **Navigation** | Fragment Transactions | Memory-efficient screen management |

---

## 🚀 Installation

### 📋 **Prerequisites**

- **Development Environment**: Android Studio Arctic Fox (2020.3.1) or later
- **Target SDK**: Android 14 (API level 34) with minimum support for API 33
- **Google Services**: Valid Google Maps API key with enabled services
- **Hardware Requirements**: Android device or emulator with Google Play Services

### ⚡ **Setup Instructions**

#### **Step 1: Download Source Code**
```bash
# Clone the repository
git clone https://github.com/nn-projects/android_project.git
cd android_project

# Alternative: Download ZIP from GitHub
# Visit: https://github.com/nn-projects/android_project
# Click "Code" → "Download ZIP"
```

#### **Step 2: Open in Android Studio**
1. Launch Android Studio
2. **File** → **Open** → Select project directory
3. Wait for Gradle sync to complete (may take several minutes)
4. Resolve any dependency issues if prompted

#### **Step 3: Configure Google Maps API**
1. **Obtain API Key**:
   - Visit [Google Cloud Console](https://console.cloud.google.com/)
   - Create new project or select existing
   - Enable "Maps SDK for Android" and "Geocoding API"
   - Generate API key with appropriate restrictions

2. **Add to Project**:
   - Create: `app/src/main/res/values/google_maps_api.xml`
   ```xml
   <resources>
       <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">YOUR_API_KEY_HERE</string>
   </resources>
   ```

#### **Step 4: Build and Run**
1. Connect Android device (USB debugging enabled) or start emulator
2. Click "Run" in Android Studio
3. Grant necessary permissions when prompted

---

## 📖 Usage Guide

### 🌟 **First-Time Setup**
1. **Registration**: Create account with secure password requirements
2. **Dashboard Exploration**: Familiarize with navigation drawer and main interface
3. **Category Creation**: Set up your first event category with location information
4. **Event Management**: Add events and associate with created categories

### 🎯 **Core Functionality**

#### **Event Operations**
- **Create Events**: Main dashboard form with validation
- **Event Lists**: Navigate to "View Events" for comprehensive overview
- **Google Integration**: Tap events for instant Google search
- **Status Management**: Toggle active/inactive states

#### **Category Management**
- **Add Categories**: Use navigation drawer → "Add Category"
- **Location Mapping**: Tap categories in "All Categories" for map view
- **Organization**: Group related events for efficient management

#### **Navigation Patterns**
- **Primary Navigation**: Slide-out drawer (☰ button)
- **Quick Actions**: Floating action button for save operations
- **Gesture Shortcuts**: Long-press (clear forms), Double-tap (save)
- **Contextual Navigation**: Back arrows for screen transitions

---

## 📊 Technical Specifications

### 🔧 **Project Configuration**

| Specification | Details |
|---------------|---------|
| **Target SDK** | Android 14 (API 34) |
| **Minimum SDK** | Android 13 (API 33) |
| **Programming Language** | Java 8 |
| **Build System** | Gradle 8.2.2 with Kotlin DSL |
| **Database** | Room 2.6.1 with SQLite backend |
| **Maps Integration** | Google Play Services Maps 18.2.0 |
| **UI Framework** | Android Views with Material Design 1.11.0 |
| **Architecture Components** | ViewModel, LiveData, Room |

### 📁 **Project Structure**
```
android_project/
├── app/
│   ├── src/main/java/com/example/assignment1/
│   │   ├── CategoryActivity.java           # Category management
│   │   ├── DashboardActivity.java          # Main interface
│   │   ├── EventGoogleSearchActivity.java  # Google search integration
│   │   ├── GoogleMapsActivity.java         # Maps functionality
│   │   ├── LoginActivity.java              # Authentication
│   │   ├── SignUpActivity.java             # User registration
│   │   ├── Fragment*.java                  # UI components
│   │   ├── List*Activity.java              # Data display
│   │   ├── *RecyclerAdapter.java           # List management
│   │   ├── RandomGenerator.java            # Utility functions
│   │   ├── KEYS.java                       # Constants
│   │   └── provider/                       # Database layer
│   │       ├── Category.java               # Category entity
│   │       ├── CategoryViewModel.java      # Category business logic
│   │       ├── Event.java                  # Event entity
│   │       └── EventViewModel.java         # Event business logic
│   └── src/main/res/                       # Resources
├── build.gradle.kts                        # Project configuration
├── settings.gradle.kts                     # Module settings
└── README.md                               # Documentation
```

---

## 🎓 Educational Outcomes

### **Technical Skills Demonstrated**
- **Android Architecture Components**: Comprehensive implementation of Room, ViewModel, LiveData
- **Design Patterns**: MVVM architecture, Repository pattern, Observer pattern
- **Database Design**: Normalized schema with proper relationships and constraints
- **API Integration**: Google Maps SDK, Geocoding services, WebView implementation
- **User Experience**: Material Design principles, responsive layouts, accessibility
- **Data Management**: Local persistence, real-time updates, transaction handling

### **Professional Development**
- **Clean Code**: SOLID principles, proper separation of concerns
- **Testing**: Comprehensive validation and error handling
- **Documentation**: Clear code comments and user documentation
- **Version Control**: Git workflow with structured commits
- **Problem Solving**: Real-world application development challenges

---

## 🔮 Future Enhancements

### **Planned Features**
- **Cloud Synchronization**: Firebase integration for multi-device support
- **Push Notifications**: Event reminders and category updates
- **Advanced Analytics**: Usage statistics and reporting dashboard
- **Social Integration**: Event sharing and collaborative planning
- **Offline Capabilities**: Enhanced functionality without internet connectivity
- **Accessibility**: Screen reader support and keyboard navigation

### **Technical Improvements**
- **Kotlin Migration**: Performance optimization through modern language features
- **Jetpack Compose**: Modern UI toolkit implementation
- **Dependency Injection**: Dagger/Hilt integration for improved testability
- **Automated Testing**: Comprehensive unit and integration test suites
- **CI/CD Pipeline**: Automated build and deployment workflows

---

## 📜 License & Usage

This project is developed for educational purposes as part of advanced mobile application development coursework. The codebase demonstrates industry-standard practices and serves as a comprehensive learning resource.

**Academic Use**: Available for educational and learning purposes  

