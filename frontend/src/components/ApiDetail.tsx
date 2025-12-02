import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

interface Log {
  id: number;
  timestamp: string;
  responseTimeMs: number;
  statusCode: number;
  success: boolean;
}

const ApiDetail: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const [logs, setLogs] = useState<Log[]>([]);

  useEffect(() => {
    const fetchLogs = async () => {
      const token = localStorage.getItem('token');
      const response = await axios.get(`/api/logs/${id}`, {
        headers: { Authorization: `Bearer ${token}` }
      });
      setLogs(response.data);
    };
    fetchLogs();
  }, [id]);

  return (
    <div>
      <h2>API Details</h2>
      <h3>Recent Logs</h3>
      <ul>
        {logs.map(log => (
          <li key={log.id}>
            {log.timestamp} - {log.responseTimeMs}ms - {log.statusCode} - {log.success ? 'Success' : 'Fail'}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ApiDetail;