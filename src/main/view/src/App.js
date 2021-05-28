//import logo from './logo.svg';
//import './App.css';
import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import { Home, About ,Ex } from 'pages';

function App() {
  return (
     <div className="App">
          <h1>App</h1>
          <BrowserRouter>
            <ul>
              <li>
                <Link to="/">Home</Link>
              </li>
              <li>
                <Link to="/ex">Beauty</Link>
              </li>
              <li>
                <Link to="/about">Game</Link>
              </li>
            </ul>
            <Switch>
              <Route path="/" component={Home}></Route>
              <Route path="/ex" component={Ex}></Route>
              <Route path="/about" component={About}></Route>
            </Switch>
          </BrowserRouter>
        </div>
  );
}

export default App;
