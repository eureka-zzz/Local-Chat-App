# Local-Chat-App

This project is an Android chat application supporting two modes:

1. **Local Mode**: Chat over a local WiFi network without internet. The server runs on an Android phone using Termux.
2. **Public Mode**: Chat using a public API server accessible from anywhere with internet.

Features:
- User login and signup with account management.
- Send and receive text messages (with "read more" for long texts), files, photos, videos, voice messages, and video messages.
- Interactive and lightweight UI inspired by Telegram.
- Supports Android 10 to 15 (API level 35).
- Local server setup instructions for Termux included.
- Source code hosted on GitHub with CI/CD for building and releasing APK.

## Setup

### Local Mode
- Run the local server on an Android device using Termux.
- Connect all users to the same WiFi network.
- Use the app in local mode to chat without internet.

### Public Mode
- Use the public API server with internet access.
- Login and chat globally.

## Repository Structure

- `android-app/` - Android application source code.
- `local-server/` - Local server code for Termux.
- `public-api/` - Public API server code.
- `docs/` - Documentation and setup guides.

## Build and Release

- CI/CD pipeline builds APK for Android 10-15.
- APKs are released on GitHub Releases.
