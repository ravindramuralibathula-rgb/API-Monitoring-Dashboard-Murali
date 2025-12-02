#!/bin/bash
# Log cleanup script

# Remove logs older than 30 days
find /app/logs -name "*.log" -type f -mtime +30 -delete