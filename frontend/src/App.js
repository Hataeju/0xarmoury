import logo from './logo.svg';
import './App.css';
import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
  const [jsonData, setHello] = useState('')

  useEffect(() => {
      axios.get('/api/techniques')
      .then(response => setHello(response.data))
      .catch(error => console.log(error))
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <p>
          MITRE ATT&CK Json file
        </p>
        <div>
            {JSON.stringify(jsonData)}
        </div>
      </header>
    </div>
  );
}

export default App;
