# ✂️ URL Shortener

> Full-stack URL shortening service with custom alias support, click analytics, and redirect handling.

![Status](https://img.shields.io/badge/status-in%20development-yellow)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Angular](https://img.shields.io/badge/Angular-TypeScript-red)
![Azure](https://img.shields.io/badge/deployed-Azure-blue)

> **Note:** The primary repository is private. This is a public mirror for portfolio visibility. Full source will be available upon project completion.

---

## What it does

Shortit takes any long URL and generates a short, shareable link. Users can optionally define a custom alias. Every redirect is tracked, giving basic click analytics per link.

---

## Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 3, Maven |
| Frontend | Angular, TypeScript |
| Database | PostgreSQL |
| Infrastructure | Docker, Azure App Service, CI/CD |
| Architecture | Controller / Service / Repository |

---

## Key Features

- URL shortening with unique code generation and collision handling
- Custom alias support
- HTTP 301 redirect handling
- Click analytics per shortened link
- RESTful API with clean Controller/Service/Repository architecture
- Angular frontend — single page, minimal UX
- Dockerized and deployed on Azure App Service
- CI/CD pipeline via GitHub Actions

---

## Live Demo

🔗 Coming soon — `shortit.petiton.dev`

---

## Related

- [insurance-quote](https://github.com/pwiseley/insurance-quote) — Spring Boot + React, deployed on AWS
- [Floppa Marketplace](https://github.com/pwiseley/Floppa-app) — Java REST API, three-layer architecture, CI/CD
- [Portfolio](https://petiton.dev)