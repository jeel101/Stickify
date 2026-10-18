# 🛍️ Stickify — Full-Stack E-Commerce Platform

Stickify is a full-stack e-commerce web application built with a **React** frontend and a **Java / Spring Boot** backend. It supports secure authentication, role-based access control, product browsing with search and sorting, a persistent shopping cart, and Stripe-powered checkout — all containerized with Docker for easy deployment.

**🔗 Live Demo:**
https://stickify-lyart-alpha.vercel.app

<!-- Example once you have it:
**🔗 Live Demo:**
[https://stickify.yourdomain.com](https://stickify.yourdomain.com)
-->

---

## 📸 Screenshots

<!-- Add screenshots or a demo GIF here once available -->

HOME PAGE <img width="1895" height="871" alt="home" src="https://github.com/user-attachments/assets/f436bbcb-355c-4920-b793-dbfa8437c519" />

PRODUCT DETAIL <img width="1896" height="866" alt="product_detail" src="https://github.com/user-attachments/assets/505b25b4-e7c6-48a9-827a-cab02d563476" />

CART <img width="1897" height="862" alt="cart" src="https://github.com/user-attachments/assets/1ad85b3f-5ea6-4dca-8e53-92578cc39a65" />

ORDERS <img width="1900" height="862" alt="orders" src="https://github.com/user-attachments/assets/0ebd9349-0a5d-45cd-8451-7636dfed8e7e" />

---

## ✨ Features

- 🔐 **Authentication & Authorization** — JWT-based login/signup with Role-Based Access Control (RBAC) for customer and admin access levels
- 🛒 **Shopping Cart** — Add, update, and remove items with persistent state (Redux Toolkit) and quantity controls
- 🔍 **Product Search & Sorting** — Live search by name/description, and sorting by popularity or price (low↔high)
- 🖼️ **Product Detail View** — Zoom-on-hover product images and quantity selection before adding to cart
- 💳 **Checkout & Payments** — Stripe integration for secure payment processing
- 📦 **Order & Address Management** — Address validation required before checkout can proceed
- 🌗 **Dark Mode** — Full light/dark theme support across the UI
- 🐳 **Dockerized** — Backend, frontend, and database services containerized for consistent local and production environments

---

## 🧰 Tech Stack

**Frontend**

- React
- Redux Toolkit
- React Router
- Tailwind CSS
- Font Awesome

**Backend**

- Java, Spring Boot
- Spring Security
- MySQL

**Payments**

- Stripe API

**DevOps**

- Docker / Docker Compose

---

## 🚀 Getting Started

> Quick-start summary — see the setup notes below for backend and frontend.

```bash
# Clone the repository
git clone https://github.com/<your-username>/stickify.git
cd stickify

# Backend (Spring Boot)
cd backend
./mvnw spring-boot:run

# Frontend (React) — in a separate terminal
cd frontend
npm install
npm run dev
```

By default the frontend runs on `http://localhost:5173` (or your configured Vite/CRA port) and the backend API on `http://localhost:8080`. You'll need a running MySQL instance and a Stripe API key configured via environment variables before the app is fully functional.

Alternatively, if Docker Compose is set up for the project:

```bash
docker-compose up --build
```

---

## 🗂️ Project Structure

```
stickify/
├── backend/          # Spring Boot API (auth, products, cart, orders, payments)
├── frontend/         # React app (Redux Toolkit, Tailwind, React Router)
└── docker-compose.yml
```

---

## 👤 Author

**Jeel**

- GitHub: https://github.com/jeel101
- LinkedIn: www.linkedin.com/in/jeel-shah-07a6b9246
