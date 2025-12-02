
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/Login';
import Dashboard from './components/Dashboard';
import ApiList from './components/ApiList';
import ApiDetail from './components/ApiDetail';
import Alerts from './components/Alerts';
import SlaReports from './components/SlaReports';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <h1>API Monitor Dashboard</h1>
        </header>
        <nav>
          <a href="/">Dashboard</a> | <a href="/apis">APIs</a> | <a href="/alerts">Alerts</a> | <a href="/sla">SLA</a>
        </nav>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/" element={<Dashboard />} />
          <Route path="/apis" element={<ApiList />} />
          <Route path="/apis/:id" element={<ApiDetail />} />
          <Route path="/alerts" element={<Alerts />} />
          <Route path="/sla" element={<SlaReports />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;