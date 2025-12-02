#!/bin/bash
# Backup script for PostgreSQL database

DB_HOST=${DB_HOST:-localhost}
DB_PORT=${DB_PORT:-5432}
DB_NAME=${DB_NAME:-monitor}
DB_USER=${DB_USER:-monitor}
DB_PASSWORD=${DB_PASSWORD:-monitorpass}

BACKUP_DIR=./backups
mkdir -p $BACKUP_DIR

pg_dump -h $DB_HOST -p $DB_PORT -U $DB_USER -d $DB_NAME > $BACKUP_DIR/backup_$(date +%Y%m%d_%H%M%S).sql