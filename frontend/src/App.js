import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import VideoList from './component/VideoList';
import DetailedPage from './component/DetailedPage'
import { VideoProvider } from './context/Context';

function App() {
  return (
    <VideoProvider>
      <div className="App">
        <Router>
          <Route exact path="/videos" component={VideoList} />
          <Route exact path="/video/:id" component={DetailedPage} />
        </Router>
      </div>
    </VideoProvider>
  );
}

export default App;
