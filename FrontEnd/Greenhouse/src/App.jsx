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
          <div className="merged-clouds">
            <img
              src={`${ASSET_PATH}/7_107.svg`}
              alt="Cloud Background"
              className="cloud-img"
            />
            <img
              src={`${ASSET_PATH}/7_115.svg`}
              alt="Cloud Foreground"
              className="cloud-img"
            />
          </div>
        </div>
        <div className="header-content">
          <h1>Bloom Box</h1>
        </div>
      </section>

      <section id="section-hero" className="hero-section">
        <div className="grey-box"></div>
      </section>

      <section id="section-footer" className="footer-section">
        <div className="bubbles-right">
          {/* merged image */}
          <div className="merged-bubbles">
            <img src={`${ASSET_PATH}/6_15.svg`} alt="Bubble" className="bubble b-right-1" />
            <img src={`${ASSET_PATH}/6_21.svg`} alt="Bubble" className="bubble b-right-2" />
            <img src={`${ASSET_PATH}/6_27.svg`} alt="Bubble" className="bubble b-right-3" />
          </div>
        </div>
        
        <div className="bubbles-left">
          {/* merged image */}
          <div className="merged-bubbles">
            <img src={`${ASSET_PATH}/6_87.svg`} alt="Bubble" className="bubble b-left-1" />
            <img src={`${ASSET_PATH}/6_93.svg`} alt="Bubble" className="bubble b-left-2" />
            <img src={`${ASSET_PATH}/6_99.svg`} alt="Bubble" className="bubble b-left-3" />
          </div>
        </div>
        
        <div className="ice-container">
          <img src={`${ASSET_PATH}/4_4.svg`} alt="Ice Background" className="ice-img" />
        </div>
        
        <div className="grass-container">
          {/* merged image */}
          <div className="merged-grass">
            <img
              src={`${ASSET_PATH}/8_130.svg`}
              alt="Grass Foreground"
              className="grass-img"
            />
            <img
              src={`${ASSET_PATH}/8_136.svg`}
              alt="Grass Background"
              className="grass-img"
            />
          </div>
        </div>
      </section>
    </>
  )
}

export default App
