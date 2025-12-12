# 🍜 Vietnamese Cuisine Community Hub

> **Status:** In Development 🚧

## 📖 Overview
A modern web application designed for the Vietnamese cuisine community. It serves as a central hub for discovering, sharing, and reviewing authentic Vietnamese recipes, alongside a searchable directory of local restaurants.

**Purpose:** To create an engaging, community-driven platform with real-world complexity (User-generated content, RBAC, Content Moderation).

---

## 🚀 Core Features

### 🌐 User-Facing Site
* **Discovery:** Browse and search for recipes and restaurants, add comments and voting for them.
* **Detail Views:** Dedicated pages for specific dishes and restaurant profiles.
* **Secure Access:** Sign-up/login to submit recipes and write reviews.

### 📍 Restaurant Directory
* **Smart Filtering:** A searchable list of restaurants.
* **Profiles:** Address, operating hours, and specialty dishes.

### ✍️ User Contributions
* **Submissions:** Authenticated users can submit recipes for approval.
* **Engagement:** Review system for both recipes and restaurants.

### 🛡️ Role-Based Panels
* **Manager Panel (`ROLE_MANAGER`):** Dashboard for restaurant owners to manage profiles, photos, and menus.
* **Admin Panel (`ROLE_ADMIN`):** Full control over content, user roles, and approval/rejection workflows.

---

## ✅ Implementation Status

### Backend Architecture
- [x] **REST Endpoints, Basic CRUD operations:** Exposes endpoints for managing main resources.
- [x] **Service Layer:** Contains core business logic.
- [x] **Data Persistence:** Repositories implemented for database interactions.
- [x] **Error Handling:** Global exception handler implemented.

### Security Implementation (Spring Security) (On progress)
- [x] **Authentication:** Required for all protected requests ( On progress ).
- [ ] **Methods:** Supports Form-based and HTTP Basic auth.
- [ ] **RBAC:** Role-Based Access Control implemented.
- [ ] **Session Management:** Maintains user state securely.
