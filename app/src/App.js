import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    owners: []
  };

  async componentDidMount() {
    const response = await fetch('/api/owners');
    const body = await response.json();
    this.setState({ owners: body, isLoading: false });
  }

  render() {
    const {owners, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Owner list</h2>
            {owners.map(owner =>
                <div key={owner.id}>
                  {owner.firstName}
                </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}

export default App;
