# Foodies - Social Meal Photo Sharing App (Prototype)

**Foodies** is a prototype social media application designed for users who want to share photos of their meals, track their nutrition, and connect with friends through their dietary habits. The app's core focus is on nutrition and tracking macronutrients.

## Key Features

*   **Onboarding:** A guided onboarding process to gather essential user data, including:
    *   Name, gender, age
    *   Height, weight
    *   Activity level
    *   Weight goals (lose, maintain, gain)
    *   Target macronutrient ratios (proteins, fats, carbs)
*   **Feed:** A personalized feed where users can view meal photos shared by the people they follow, encouraging social interaction and inspiration.
*   **Camera & Sharing:** A dedicated camera view that allows users to:
    *   Capture photos of their meals.
    *   Add comments to their meal posts.
    *   Share their meal photos with their followers.
*   **Journal (Tracker):** A detailed food journal where users can:
    *   Search for and track their food intake.
    *   Organize meals by day and meal type (breakfast, lunch, dinner, snacks).
    *   View nutritional summaries for each meal and day.
*   **Profile:** A personalized profile view that displays:
    *   User's personal data (name, gender, age, etc.).
    *   User's nutritional goals and preferences.
    *   Macro-nutrient ratios.

## Technology Stack

*   **Programming Language:**
    *   Kotlin
*   **UI Framework:**
    *   Jetpack Compose
*   **Architectural Pattern:**
    *   MVVM (Model-View-ViewModel)
*   **Libraries & Tools:**
    *   Retrofit - For making network requests (e.g., to a backend API).
    *   Coil - For loading and displaying images efficiently.
    *   Room - For local data storage using an SQLite database.
    * Jetpack Navigation - For managing the app's navigation flow.
    * CameraX - for the Camera implementation.
    * Permissions Accompanist - To manage the permissions.
    * Hilt - for the Dependency Injection.

## Future Improvements

This is a prototype, and there are many potential areas for future development, including:

*   **Backend Integration:** Connecting the app to a real backend to allow users to store and share their meal photos and data online.
*   **User Authentication:** Implementing user login and registration.
*   **Search:** Improving the search functionality.
*   **Notifications:** Adding notifications.
*   **Social features:** Add the likes and comments features.
*   **Add Unit Test:** Add tests to make sure of the quality of the code.
