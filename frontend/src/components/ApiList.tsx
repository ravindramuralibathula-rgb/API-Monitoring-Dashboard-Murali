import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

interface Api {
  id: number;
  name: string;
  url: string;
  enabled: boolean;
}

const ApiList: React.FC = () => {
  const [apis, setApis] = useState<Api[]>([]);

  useEffect(() => {
    const fetchApis = async () => {
      const token = localStorage.getItem('token');
      const response = await axios.get('/api/apis', {
        headers: { Authorization: `Bearer ${token}` }
      });
      setApis(response.data);
    };
    fetchApis();
  }, []);

  return (
    <div>
      <h2>Monitored APIs</h2>
      <ul>
        {apis.map(api => (
          <li key={api.id}>
            <Link to={`/apis/${api.id}`}>{api.name} - {api.url}</Link> ({api.enabled ? 'Enabled' : 'Disabled'})
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ApiList;