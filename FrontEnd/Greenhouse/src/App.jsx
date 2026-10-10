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
    <>
      <section id="section-header" className="header-section">
        <div className="clouds-wrapper">
          {/* merged image */}
          <div className="clouds-header">
            <img
              src={`${'./assets/header/clouds'}/7_107.svg`}
              alt="Cloud Header"
              className="header-img"
            />
          </div>
        </div>
        <div className="header-content">
          <h1>GreenHouse</h1>
        </div>
      </section>

      <section id="section-hero" className="hero-section">
        <div className="grey-box"></div>
      </section>

      <section id="section-footer" className="footer-section">
        <div className="footer">
          <img src={`${'./assets/Footer'}/4_4.svg`} alt="Footer" className="footer-img" />
        </div>
      </section>
    </>
  )
}

export default App
