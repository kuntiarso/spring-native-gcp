#!/bin/bash

APP_DIR="/app"
APP_NAME="native-workshop"
PID_FILE="$APP_DIR/$APP_NAME.pid"

if [ -f "$PID_FILE" ]; then
    kill $(cat "$PID_FILE") 2>/dev/null
    sleep 2
    rm -f "$PID_FILE"
fi

nohup "$APP_DIR/$APP_NAME" > "$APP_DIR/$APP_NAME.log" 2>&1 &
echo $! > "$PID_FILE"
echo "Started $APP_NAME (PID: $!)"