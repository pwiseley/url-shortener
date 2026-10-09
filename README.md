# URL Shortener

[Lire en français](README.FR.md)

Full-stack URL shortening service with click analytics and redirect handling.

> [Live Demo](https://go.petiton.dev)

## Contents

- [Tech Stack](#tech-stack)
- [CI/CD Pipeline](#cicd-pipeline)
- [API](#api)
- [Deployment](#deployment)
- [Related](#related)

## Tech Stack

| Layer | Technology |
|---|---|
| **Backend** | Java 21, Spring Boot 3, Maven |
| **Frontend** | Angular, TypeScript |
| **Database** | PostgreSQL |
| **CI/CD** | Azure DevOps Pipelines |
| **Hosting** | Azure Container Apps, Azure Container Registry |
| **Architecture** | Controller / Service / Repository |

## CI/CD Pipeline

Every push to `main` runs a five-stage pipeline. Nothing reaches production without passing style, static analysis, dependency and image vulnerability checks.

| Stage | What it does |
|---|---|
| **Build** | Packages the backend with **Maven** |
| **Test** | Runs unit tests and publishes **JUnit** results |
| **Quality & Security** | Three parallel checks: code style with **Spotless**, quality and coverage with **SonarCloud**, dependency vulnerabilities with **OWASP Dependency-Check** |
| **Push** | Builds the image, pushes it to **Azure Container Registry**, and scans it with **Trivy** |
| **Deploy** | Deploys the new image to **Azure Container Apps** |

## API

> [API Docs (Swagger)](https://go.petiton.dev/swagger-ui/index.html)

| Method | Route | Purpose |
|---|---|---|
| `POST` | `/api/urls` | Create a short URL from a long one |
| `GET` | `/{shortCode}` | Resolve a short code and redirect (`302 Found`) |

Shortening a URL:

```jsonc
// POST /api/urls
{ "originalUrl": "https://www.example.com/some/very/long/path?ref=newsletter" }

// 201 Created
{
  "shortCode": "a1B2c3",
  "originalUrl": "https://www.example.com/some/very/long/path?ref=newsletter",
  "shortUrl": "https://go.petiton.dev/a1B2c3"
}
```

An invalid URL returns `400 Bad Request` with a field-level validation message.

## Deployment

Images are built by the **Azure DevOps** pipeline, stored in **Azure Container Registry**, and deployed to **Azure Container Apps**.

![Azure Container Apps deployments](assets/url-shortener-deployments-view.png)

![Azure DevOps pipeline run](assets/url-shortener-pipelines-view.png)

![Azure resource group overview](assets/url-shortener-rg-view.png)

## Related

- [insurance-quote](https://github.com/pwiseley/insurance-quote): Spring Boot + React, live at `primio.petiton.dev`
- [vehicle-maintenance-tracker](https://github.com/pwiseley/vehicle-maintenance-tracker): C# / ASP.NET Core + React, live at `vmt.petiton.dev`
- [Floppa Marketplace](https://github.com/pwiseley/Floppa-app): Java REST API, three-layer architecture, CI/CD
- [Portfolio](https://petiton.dev)
