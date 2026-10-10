import { useEffect, useState } from 'react'
import './App.css'

function App() {
  const [message, setMessage] = useState('')

  useEffect(() => {
  fetch("http://localhost:8080/api/mix")
    .then(res => res.json())
    .then(data => {
      console.log(data);
      setProject(data);
    });
}, []);


  return (
    <div>{message}</div>
  )
}

export default App
