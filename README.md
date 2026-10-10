# **HackNC2026 Project!**
## Contributors: Micah Mckeller, Eli Kittinger, Aditya Meher, Matias Ripa

## Greenhouse:

Greenhouse is a board for community beautification.

### How it works:

- Log onto the website, create or suggest a community project.
- Each project board is either hosted by a government official or an individual
- A project board has a messenger, and an event system.
- Project Managers can host events, where the community can work together on a project.
- Every monday, get an sms notification outlining all events for the week

### Applies to:
- Community
- Frutiger Aero
- Photon AI
- possibly .tech domain?

## Backend development

The Spring Boot backend is in `BackEnd`. Run it from that directory with
`.\gradlew.bat bootRun`; it listens on port 8080. The API health check is
`GET http://localhost:8080/api/health`.

The backend allows browser requests from the default local React development
origins `http://localhost:5173` (Vite) and `http://localhost:3000`
(Create React App). Override these with the comma-separated
`app.cors.allowed-origins` property when using another origin.

The prototype uses an in-memory H2 database. Its data is temporary and is
cleared when the backend restarts. The H2 console is available at
`http://localhost:8080/h2-console`.
