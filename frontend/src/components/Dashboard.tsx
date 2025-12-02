import React, { useEffect, useState } from 'react';
import axios from 'axios';

interface Endpoint {
  id: number;
  name: string;
  url: string;
  status: string;
}

const Dashboard: React.FC = () => {
  const [endpoints, setEndpoints] = useState<Endpoint[]>([]);

  useEffect(() => {
    const fetchEndpoints = async () => {
      const token = localStorage.getItem('token');
      const response = await axios.get('/api/endpoints', {
        headers: { Authorization: `Bearer ${token}` }
      });
      setEndpoints(response.data);
    };
    fetchEndpoints();
  }, []);

  return (
    <div>
      <h1>API Monitor Dashboard</h1>
      <ul>
        {endpoints.map(endpoint => (
          <li key={endpoint.id}>{endpoint.name} - {endpoint.url}</li>
        ))}
      </ul>
    </div>
  );
};

export default Dashboard;