A modern web application designed for the Vietnamese cuisine community. It serves as a central hub for discovering, sharing, and reviewing authentic Vietnamese recipes, alongside a searchable directory of local Vietnamese restaurants.

Core Features:
  User-Facing Site: Allows users to browse and search for recipes and restaurants, view detailed pages, and securely sign up to submit their own recipes and write reviews.
  Restaurant Directory: A filterable list of restaurants with dedicated detail pages, including address, hours, and specialty dishes.
  User Contributions: Authenticated users can submit recipes for approval and write reviews for both recipes and restaurants.
  Manager Panel: A protected dashboard for restaurant owners (ROLE_MANAGER) to manage their restaurant's profile, including details, photos, and linking specialty recipes.
  Admin Panel: A protected dashboard for administrators (ROLE_ADMIN) with full control over content (recipes, restaurants, reviews) and user roles, including approval/rejection of new content.
  Purpose: To create an engaging, community-driven platform with real-world complexity, featuring user-generated content, multi-role permissions, and content moderation, making it an excellent portfolio project.

Have done until now :
  REST Endpoints: Exposes endpoints for managing the application's main resources.
  Service Layer: Contains the business logic for the application.
  Data Persistence: Uses repositories for database interactions.
  Security: Implemented using Spring Security to protect endpoints. It requires authentication for all requests and supports form-based and HTTP Basic authentication. It also includes role-based access control and session management to maintain user state.
  Error Handling: A global exception handler is in place to manage application-wide errors consistently.
