import { useEffect, useState } from 'react'
import './App.css'

const API_URL = 'http://localhost:8080/api/project'

function App() {
  const [form, setForm] = useState({
    projectName: '',
    timeTillCompletion: '',
    description: ''
  })

  const [project, setProject] = useState(null)
  const [status, setStatus] = useState('')

  const loadProject = async () => {
    try {
      const response = await fetch(API_URL)
      if (!response.ok) {
        throw new Error(`Project request failed with status ${response.status}`)
      }

      const data = await response.json()
      setProject(data)
      setStatus('Project loaded from Java')
    } catch (error) {
      setStatus('Could not load project from Java')
      console.error(error)
    }
  }

  useEffect(() => {
    loadProject()
  }, [])

  const handleChange = (event) => {
    const { name, value } = event.target
    setForm((prev) => ({ ...prev, [name]: value }))
  }

  const handleSubmit = async (event) => {
    event.preventDefault()

    try {
      const response = await fetch(API_URL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          ...form,
          timeTillCompletion: Number(form.timeTillCompletion)
        })
      })

      if (!response.ok) {
        throw new Error(`Project submission failed with status ${response.status}`)
      }

      const data = await response.json()
      setProject(data)
      setStatus('Project sent to Java and stored as an object')
    } catch (error) {
      setStatus('Failed to send project to Java')
      console.error(error)
    }
  }

  return (
    <div className="app-shell">
      <form onSubmit={handleSubmit} className="project-form">
        <h2>Create Project</h2>

        <input
          name="projectName"
          value={form.projectName}
          onChange={handleChange}
          placeholder="Project name"
        />

        <input
          type="number"
          name="timeTillCompletion"
          value={form.timeTillCompletion}
          onChange={handleChange}
          placeholder="Time till completion"
          step="any"
          required
        />

        <textarea
          name="description"
          value={form.description}
          onChange={handleChange}
          placeholder="Description"
        />

        <button type="submit">Send to Java</button>
      </form>

      <div className="project-display">
        <h3>Java Project Data</h3>
        {status && <p>{status}</p>}
        {project ? (
          <ul>
            <li><strong>Project Name:</strong> {project.projectName}</li>
            <li><strong>Time till completion:</strong> {project.timeTillCompletion}</li>
            <li><strong>Description:</strong> {project.description}</li>
          </ul>
        ) : (
          <p>No project loaded yet.</p>
        )}
      </div>
    </div>
  )
}

export default App
