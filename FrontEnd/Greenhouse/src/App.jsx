import { useEffect, useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'

function App() {
  const [message, setMessage] = useState('')

  useEffect(() => {
    fetch('http://localhost:8080/api/test')
      .then((res) => res.text())
      .then((data) => setMessage(data))
  }, [])

  return (
    <div>{message}</div>
  )
}

export default App
