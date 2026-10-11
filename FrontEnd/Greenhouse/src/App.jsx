import { useEffect, useState } from 'react'
import './App.css'
import perfectHue from './assets/perfect_hue_40.jpg'
import footer from './assets/Footer/Footer.svg'

const PROJECTS_API_URL = 'http://localhost:8080/api/projects'

function App() {
  const [projects, setProjects] = useState([])
  const [selectedProject, setSelectedProject] = useState(null)
  const [isFormOpen, setIsFormOpen] = useState(false)
  const [rsvpedProjectIds, setRsvpedProjectIds] = useState(() => new Set())
  const [isRSVPing, setIsRSVPing] = useState(false)
  const [rsvpStatus, setRsvpStatus] = useState('')
  const [form, setForm] = useState({
    projectName: '',
    description: '',
    location: '',
    scheduledTime: '',
  })
  const [status, setStatus] = useState('')
  const [isSubmitting, setIsSubmitting] = useState(false)

  useEffect(() => {
    const loadProjects = async () => {
      try {
        const response = await fetch(PROJECTS_API_URL)
        if (!response.ok) {
          throw new Error(`Loading projects failed with status ${response.status}`)
        }

        setProjects(await response.json())
      } catch (error) {
        console.error(error)
        setStatus('Could not load projects. Make sure the Java backend is running.')
      }
    }

    loadProjects()
  }, [])

  const handleChange = (event) => {
    const { name, value } = event.target
    setForm((previous) => ({ ...previous, [name]: value }))
  }

  const handleRSVP = async () => {
    if (!selectedProject || rsvpedProjectIds.has(selectedProject.projectUUID)) {
      return
    }

    setIsRSVPing(true)
    setRsvpStatus('')

    try {
      const response = await fetch(
        `${PROJECTS_API_URL}/${selectedProject.projectUUID}/rsvp`,
        { method: 'POST' },
      )

      if (!response.ok) {
        throw new Error(`RSVP failed with status ${response.status}`)
      }

      const updatedProject = await response.json()
      setProjects((previous) =>
        previous.map((project) =>
          project.projectUUID === updatedProject.projectUUID ? updatedProject : project,
        ),
      )
      setSelectedProject(updatedProject)
      setRsvpedProjectIds((previous) => new Set(previous).add(updatedProject.projectUUID))
    } catch (error) {
      console.error(error)
      setRsvpStatus('Could not RSVP. Please try again.')
    } finally {
      setIsRSVPing(false)
    }
  }

  const handleSubmit = async (event) => {
    event.preventDefault()
    setIsSubmitting(true)
    setStatus('')

    try {
      const response = await fetch(PROJECTS_API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(form),
      })

      if (!response.ok) {
        throw new Error(`Creating project failed with status ${response.status}`)
      }

      const createdProject = await response.json()
      setProjects((previous) => [...previous, createdProject].slice(0, 10))
      setSelectedProject(createdProject)
      setIsFormOpen(false)
      setForm({
        projectName: '',
        description: '',
        location: '',
        scheduledTime: '',
      })
      setStatus('Project added.')
    } catch (error) {
      console.error(error)
      setStatus('Could not add project. Check that the Java backend is running.')
    } finally {
      setIsSubmitting(false)
    }
  }

  return (
    <>
      <header className="topBar">
        <h1 className="topBar__brand">Greenhouse</h1>
        <button
          className="topBar__add"
          type="button"
          onClick={() => setIsFormOpen((isOpen) => !isOpen)}
          aria-label={isFormOpen ? 'Close add project form' : 'Add a project'}
          aria-expanded={isFormOpen}
          aria-controls="project-form"
        >
          {isFormOpen ? '×' : '+'}
        </button>
      </header>

      <main
        className={`home${selectedProject ? ' home--project-selected' : ''}`}
        style={{
          backgroundImage: `linear-gradient(rgba(0, 0, 0, 0.18), rgba(0, 0, 0, 0.18)), url(${perfectHue})`,
          backgroundSize: 'cover',
          backgroundPosition: 'center',
          backgroundRepeat: 'no-repeat',
          minHeight: '100vh',
        }}
      >
        <section className="box" aria-labelledby="projects-title">
          <h1 className="box__title" id="projects-title">Greenhouse Projects</h1>

          <ul className="project-list">
            {projects.length > 0 ? (
              projects.map((project) => (
                <li className="project-card" key={project.projectUUID}>
                  <button
                    className="project-card__button"
                    type="button"
                    onClick={() => setSelectedProject(project)}
                    aria-pressed={selectedProject?.projectUUID === project.projectUUID}
                  >
                    <h2 className="project-card__name">{project.projectName}</h2>
                    <p className="project-card__id">ID: {project.projectUUID}</p>
                  </button>
                </li>
              ))
            ) : (
              <li className="project-list__empty">No projects yet. Add your first one below.</li>
            )}
          </ul>

          {status && <p className="project-form__status" role="status">{status}</p>}
        </section>

        {selectedProject && (
          <aside className="project-details" aria-live="polite">
            <h2 className="project-form__title">{selectedProject.projectName}</h2>
            <p>{selectedProject.description || 'No description provided.'}</p>
            <p><strong>Location:</strong> {selectedProject.location}</p>
            <p>
              <strong>Scheduled time:</strong>{' '}
              {selectedProject.scheduledTime
                ? new Date(selectedProject.scheduledTime).toLocaleString([], { hour: '2-digit', minute: '2-digit', hour12: false })
                : 'Not set'}
            </p>
            <p><strong>RSVPs:</strong> {selectedProject.RSVPs ?? 0}</p>
            <button
              className="project-details__rsvp"
              type="button"
              onClick={handleRSVP}
              disabled={isRSVPing || rsvpedProjectIds.has(selectedProject.projectUUID)}
            >
              {isRSVPing
                ? 'RSVPing…'
                : rsvpedProjectIds.has(selectedProject.projectUUID)
                  ? "You're RSVP'd"
                  : 'RSVP'}
            </button>
            {rsvpStatus && <p className="project-details__status" role="status">{rsvpStatus}</p>}
          </aside>
        )}
      </main>

      {isFormOpen && (
        <div className="project-drawer">
          <button
            className="project-drawer__backdrop"
            type="button"
            onClick={() => setIsFormOpen(false)}
            aria-label="Close add project panel"
          />
          <aside
            className="project-drawer__panel"
            aria-labelledby="project-form-title"
          >
            <button
              className="project-drawer__close"
              type="button"
              onClick={() => setIsFormOpen(false)}
              aria-label="Close add project form"
            >
              ×
            </button>
            <form
              className="project-form"
              id="project-form"
              onSubmit={handleSubmit}
            >
              <h2 className="project-form__title" id="project-form-title">Add a project</h2>
              <div className="project-form__fields">
                <label>
                  Project name
                  <input
                    name="projectName"
                    value={form.projectName}
                    onChange={handleChange}
                    required
                  />
                </label>
                <label className="project-form__description">
                  Description
                  <textarea
                    name="description"
                    value={form.description}
                    onChange={handleChange}
                    rows="4"
                    required
                  />
                </label>
                <label>
                  Location
                  <input
                    name="location"
                    value={form.location}
                    onChange={handleChange}
                    required
                  />
                </label>
                <label>
                  Scheduled date and time
                  <input
                    type="datetime-local"
                    name="scheduledTime"
                    value={form.scheduledTime}
                    onChange={handleChange}
                    required
                  />
                </label>
              </div>
              <button className="project-form__submit" type="submit" disabled={isSubmitting}>
                {isSubmitting ? 'Adding…' : 'Add project'}
              </button>
              {status && <p className="project-form__status" role="status">{status}</p>}
            </form>
          </aside>
        </div>
      )}
    </>
  )
}

export default App
