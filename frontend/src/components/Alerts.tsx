import React, { useEffect, useState } from 'react';
import axios from 'axios';

interface Alert {
  id: number;
  message: string;
  status: string;
}

const Alerts: React.FC = () => {
  const [alerts, setAlerts] = useState<Alert[]>([]);

  useEffect(() => {
    const fetchAlerts = async () => {
      const token = localStorage.getItem('token');
      const response = await axios.get('/api/alerts/events', {
        headers: { Authorization: `Bearer ${token}` }
      });
      setAlerts(response.data);
    };
    fetchAlerts();
  }, []);

  return (
    <div>
      <h2>Alerts</h2>
      <ul>
        {alerts.map(alert => (
          <li key={alert.id}>{alert.message} - {alert.status}</li>
        ))}
      </ul>
    </div>
  );
};

export default Alerts;