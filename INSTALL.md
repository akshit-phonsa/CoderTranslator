# 📦 Installation Guide

## Prerequisites Check

Before starting, ensure you have:

- ✅ **Node.js** v16 or higher
- ✅ **npm** v7 or higher
- ✅ **Java** JDK 21
- ✅ **Maven** (included via wrapper)
- ✅ **API Keys** (OpenAI or Perplexity)

Run verification:
```bash
./verify-setup.sh
```

## Step-by-Step Installation

### 1️⃣ Install Root Dependencies

Install `concurrently` to run both servers:

```bash
npm install
```

**Expected output:**
```
added 1 package
```

### 2️⃣ Install Frontend Dependencies

Navigate to frontend and install React dependencies:

```bash
cd frontend
npm install
cd ..
```

**Expected output:**
```
added 1500+ packages
```

**Packages installed:**
- react & react-dom
- bootstrap & react-bootstrap
- framer-motion (animations)
- axios (HTTP client)
- react-icons

### 3️⃣ Configure API Keys

Edit the application properties file:

```bash
# Open in your editor
nano src/main/resources/application.properties
# or
code src/main/resources/application.properties
```

Update these lines:
```properties
openai.api.api-key=YOUR_OPENAI_KEY_HERE
perplexity.api.key=YOUR_PERPLEXITY_KEY_HERE
```

**Where to get API keys:**
- OpenAI: https://platform.openai.com/api-keys
- Perplexity: https://www.perplexity.ai/settings/api

### 4️⃣ Verify Installation

Run the verification script:

```bash
./verify-setup.sh
```

You should see all green checkmarks ✓

## Running the Application

### Option A: Automated Start (Recommended)

```bash
./start.sh
```

This will:
1. Check dependencies
2. Install missing packages
3. Start both servers
4. Open browser automatically

### Option B: Using npm

```bash
npm start
```

This runs both frontend and backend concurrently.

### Option C: Manual Start

**Terminal 1 - Backend:**
```bash
./mvnw spring-boot:run
```

**Terminal 2 - Frontend:**
```bash
cd frontend
npm start
```

## Verification Steps

### 1. Check Backend is Running

Open: http://localhost:8080

You should see a Whitelabel Error Page (this is normal - no root endpoint).

### 2. Check Frontend is Running

Open: http://localhost:3000

You should see the Code Translator UI with:
- Purple gradient background
- "🚀 Code Translator" header
- 5 tabs (Translate, Explain, Fix, Optimize, Fix & Optimize)

### 3. Test API Connection

1. Go to the **Translate** tab
2. Enter simple code:
   ```javascript
   function add(a, b) {
     return a + b;
   }
   ```
3. Select: JavaScript → Python
4. Click **Translate Code**
5. You should see the translated Python code

## Troubleshooting

### Issue: Port 8080 Already in Use

**Solution 1:** Kill the process
```bash
lsof -ti:8080 | xargs kill -9
```

**Solution 2:** Change backend port
Edit `src/main/resources/application.properties`:
```properties
server.port=8081
```

### Issue: Port 3000 Already in Use

**Solution 1:** Kill the process
```bash
lsof -ti:3000 | xargs kill -9
```

**Solution 2:** Use different port
```bash
PORT=3001 npm start
```

### Issue: npm install fails

**Solution:** Clear cache and retry
```bash
npm cache clean --force
rm -rf node_modules package-lock.json
npm install
```

### Issue: Frontend can't connect to backend

**Check:**
1. Backend is running on port 8080
2. CORS is configured correctly
3. Check browser console for errors

**Fix:** Restart both servers
```bash
# Kill all
pkill -f "spring-boot:run"
pkill -f "react-scripts"

# Restart
npm start
```

### Issue: API returns 401 Unauthorized

**Cause:** Invalid API keys

**Fix:**
1. Verify API keys in `application.properties`
2. Check API key has credits
3. Test API key directly:
   ```bash
   curl https://api.perplexity.ai/chat/completions \
     -H "Authorization: Bearer YOUR_KEY"
   ```

### Issue: Animations not working

**Cause:** Framer Motion not installed

**Fix:**
```bash
cd frontend
npm install framer-motion
cd ..
npm start
```

### Issue: Bootstrap styles not applied

**Cause:** Bootstrap not imported

**Fix:** Check `frontend/src/index.js` has:
```javascript
import 'bootstrap/dist/css/bootstrap.min.css';
```

## Platform-Specific Instructions

### macOS

All commands work as-is. If you get permission errors:
```bash
chmod +x start.sh verify-setup.sh
```

### Linux

Same as macOS. Ensure Java 21 is installed:
```bash
sudo apt install openjdk-21-jdk  # Ubuntu/Debian
sudo dnf install java-21-openjdk # Fedora
```

### Windows

Use Git Bash or WSL for shell scripts.

**Alternative - PowerShell:**
```powershell
# Install dependencies
npm install
cd frontend
npm install
cd ..

# Start backend (Terminal 1)
.\mvnw.cmd spring-boot:run

# Start frontend (Terminal 2)
cd frontend
npm start
```

## IDE Setup

### VS Code

**Recommended Extensions:**
- ES7+ React/Redux/React-Native snippets
- Prettier - Code formatter
- ESLint
- Spring Boot Extension Pack

**Open workspace:**
```bash
code .
```

### IntelliJ IDEA

1. Open project root
2. Import as Maven project
3. Enable annotation processing (for Lombok)
4. Set JDK to 21

## Docker Setup (Optional)

### Backend Dockerfile
```dockerfile
FROM openjdk:21-jdk-slim
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

### Frontend Dockerfile
```dockerfile
FROM node:18-alpine
WORKDIR /app
COPY frontend/package*.json ./
RUN npm install
COPY frontend/ ./
RUN npm run build
```

### Docker Compose
```yaml
version: '3.8'
services:
  backend:
    build: .
    ports:
      - "8080:8080"
  frontend:
    build: ./frontend
    ports:
      - "3000:3000"
    depends_on:
      - backend
```

## Environment Variables (Optional)

Create `.env` file:
```bash
# Backend
OPENAI_API_KEY=your-key
PERPLEXITY_API_KEY=your-key
SERVER_PORT=8080

# Frontend
REACT_APP_API_URL=http://localhost:8080
```

## Build for Production

### Frontend Production Build
```bash
cd frontend
npm run build
```

Output: `frontend/build/` directory

### Backend Production Build
```bash
./mvnw clean package
```

Output: `target/code-translator-0.0.1-SNAPSHOT.jar`

### Run Production Build
```bash
# Backend
java -jar target/code-translator-0.0.1-SNAPSHOT.jar

# Frontend (serve static files)
npx serve -s frontend/build -p 3000
```

## Post-Installation

### Test All Features

1. **Translate**: JavaScript → Python
2. **Explain**: Explain a function
3. **Fix**: Fix buggy code
4. **Optimize**: Optimize slow code
5. **Fix & Optimize**: Both operations

### Check Logs

**Backend logs:**
```bash
tail -f logs/spring-boot-logger.log
```

**Frontend logs:**
Check browser console (F12)

## Next Steps

1. ✅ Read [README.md](README.md) for full documentation
2. ✅ Check [QUICKSTART.md](QUICKSTART.md) for quick tips
3. ✅ Review [ARCHITECTURE.md](ARCHITECTURE.md) for system design
4. ✅ Explore [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md) for overview

## Support

If you encounter issues:
1. Check this guide
2. Run `./verify-setup.sh`
3. Check browser console
4. Check backend logs
5. Review error messages

---

**Installation Complete!** 🎉

You're ready to translate, explain, fix, and optimize code!
