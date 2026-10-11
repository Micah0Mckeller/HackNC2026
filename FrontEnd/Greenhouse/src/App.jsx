import './App.css'
import perfectHue from './assets/perfect_hue_40.jpg'

function App() {
  return (
    <>
      <header className="topBar">
        <h1 className="topBar__brand">Greenhouse</h1>
      </header>

      <main
        style={{
          backgroundImage: `linear-gradient(rgba(0, 0, 0, 0.18), rgba(0, 0, 0, 0.18)), url(${perfectHue})`,
          backgroundSize: 'cover',
          backgroundPosition: 'center',
          backgroundRepeat: 'no-repeat',
          minHeight: '100vh',
          display: 'grid',
          placeItems: 'center',
        }}
      >
        <h1 style={{ color: '#fff', textShadow: '0 2px 8px #000' }}>Welcome</h1>
      </main>
    </>
  )
}

export default App
