import React, { useEffect, useState } from 'react';
import axios from 'axios';

const SlaReports: React.FC = () => {
  const [uptime, setUptime] = useState<number>(0);

  useEffect(() => {
    const fetchUptime = async () => {
      const token = localStorage.getItem('token');
      const response = await axios.get('/api/sla/uptime/1', {
        headers: { Authorization: `Bearer ${token}` }
      });
      setUptime(response.data);
    };
    fetchUptime();
  }, []);

  return (
    <div>
      <h2>SLA Reports</h2>
      <p>Uptime: {uptime}%</p>
    </div>
  );
};

export default SlaReports;