# 🚀 GET STARTED - Quick Commands

## ⚡ Super Quick Start (3 Commands)

```bash
# 1. Install everything
npm run install-all

# 2. Start the app
npm start

# 3. Open browser → http://localhost:3000
```

**That's it! You're done!** 🎉

---

## 📋 What Just Happened?

### Command 1: `npm run install-all`
- Installed `concurrently` (runs both servers)
- Installed React and all frontend dependencies
- Installed Bootstrap, Framer Motion, Axios, etc.

### Command 2: `npm start`
- Started Spring Boot backend on port 8080
- Started React frontend on port 3000
- Opened browser automatically

### Command 3: Use the App!
- **Translate** code between languages
- **Explain** what code does
- **Fix** bugs in code
- **Optimize** code performance
- **Fix & Optimize** both at once

---

## 🎯 First Test

Try this simple translation:

1. Go to **🔄 Translate** tab
2. Select: **JavaScript** → **Python**
3. Paste this code:
   ```javascript
   function greet(name) {
       return "Hello, " + name + "!";
   }
   ```
4. Click **Translate Code**
5. See the Python version! ✨

---

## 📚 All Available Commands

### Installation
```bash
npm install              # Install root dependencies
npm run install-all      # Install root + frontend
cd frontend && npm install  # Install frontend only
```

### Running
```bash
npm start                # Run both (recommended)
./start.sh              # Run both (with checks)
./mvnw spring-boot:run  # Backend only
cd frontend && npm start # Frontend only
```

### Verification
```bash
./verify-setup.sh       # Check if everything is ready
```

### Building
```bash
npm run build-frontend  # Build React for production
./mvnw clean package    # Build Spring Boot JAR
```

---

## 🎨 What You'll See

### Beautiful UI Features
- ✨ **Purple gradient background**
- 🎬 **Smooth animations** on page load
- 📱 **Responsive design** (works on phone, tablet, desktop)
- 🎨 **5 colorful tabs** with emojis
- 💻 **Dark code output** theme
- 📋 **One-click copy** button
- ⚡ **Loading spinners** during processing
- 🔴 **Animated errors** if something goes wrong

---

## 🔧 Configuration

### API Keys (Required)
Edit: `src/main/resources/application.properties`

```properties
# Use Perplexity (default)
perplexity.api.key=YOUR_KEY_HERE

# Or use OpenAI
openai.api.api-key=YOUR_KEY_HERE
```

**Get API Keys:**
- Perplexity: https://www.perplexity.ai/settings/api
- OpenAI: https://platform.openai.com/api-keys

---

## 🌐 URLs

| Service | URL | Description |
|---------|-----|-------------|
| Frontend | http://localhost:3000 | React UI |
| Backend | http://localhost:8080 | Spring Boot API |
| API Docs | http://localhost:8080/api | REST endpoints |

---

## 🎯 5 Features Explained

### 1. 🔄 Translate
**What it does:** Converts code from one language to another

**Example:**
- Input: JavaScript function
- Output: Same function in Python/Java/C++/etc.

### 2. 📖 Explain
**What it does:** Explains what your code does in plain English

**Example:**
- Input: Complex algorithm
- Output: Step-by-step explanation

### 3. 🔧 Fix
**What it does:** Finds and fixes bugs in your code

**Example:**
- Input: Code with syntax/logic errors
- Output: Corrected code

### 4. ⚡ Optimize
**What it does:** Makes your code faster and more efficient

**Example:**
- Input: Slow, inefficient code
- Output: Optimized version

### 5. 🎯 Fix & Optimize
**What it does:** Fixes bugs AND optimizes in one go

**Example:**
- Input: Buggy, slow code
- Output: Fixed and optimized code

---

## 🎨 Supported Languages

✅ JavaScript  
✅ Python  
✅ Java  
✅ C++  
✅ C#  
✅ Ruby  
✅ Go  
✅ Rust  
✅ PHP  
✅ Swift  
✅ Kotlin  
✅ TypeScript  
✅ Scala  
✅ R  
✅ Perl  
✅ Dart  

---

## 🐛 Quick Troubleshooting

### Problem: Port already in use
```bash
# Kill processes
lsof -ti:8080 | xargs kill -9  # Backend
lsof -ti:3000 | xargs kill -9  # Frontend
```

### Problem: Dependencies not installing
```bash
# Clear cache
npm cache clean --force
rm -rf node_modules
npm install
```

### Problem: API not working
1. Check API keys in `application.properties`
2. Verify backend is running on port 8080
3. Check browser console for errors (F12)

### Problem: Frontend not connecting
1. Check CORS is configured
2. Restart both servers: `npm start`
3. Clear browser cache

---

## 📱 Mobile Usage

The app works great on mobile!

1. Start the app on your computer
2. Find your local IP: `ifconfig | grep inet`
3. On phone, visit: `http://YOUR_IP:3000`
4. Enjoy the responsive design!

---

## 🎓 Learning Resources

### Documentation Files
- **README.md** - Complete guide (250+ lines)
- **QUICKSTART.md** - Quick tips (150+ lines)
- **INSTALL.md** - Installation steps (400+ lines)
- **ARCHITECTURE.md** - System design (500+ lines)
- **UI_GUIDE.md** - Design system (600+ lines)
- **CHECKLIST.md** - Verification checklist (400+ lines)
- **FINAL_SUMMARY.md** - Project summary (300+ lines)

### Code Files
- **frontend/src/App.js** - Main React component
- **frontend/src/services/api.js** - API integration
- **frontend/src/components/** - All feature tabs
- **src/.../controller/TranslateController.java** - Backend API

---

## 🎉 Success Indicators

You'll know it's working when:

✅ Browser opens automatically  
✅ You see purple gradient background  
✅ Header says "🚀 Code Translator"  
✅ 5 tabs are visible  
✅ Forms accept input  
✅ Translate button works  
✅ Results display correctly  
✅ Copy button works  
✅ No errors in console  

---

## 🔥 Pro Tips

### Tip 1: Use Keyboard Shortcuts
- `Tab` - Navigate between fields
- `Enter` - Submit form (when focused on button)
- `Ctrl+C` - Copy (after clicking Copy button)

### Tip 2: Test with Simple Code First
Start with a simple function to verify everything works before trying complex code.

### Tip 3: Check the Model Info
The response shows which AI model was used. This helps with debugging.

### Tip 4: Use Clear Button
Click "Clear" to reset the form and start fresh.

### Tip 5: Mobile Testing
The app is fully responsive - try it on your phone!

---

## 📊 Performance Tips

### For Faster Results
1. Use shorter code snippets
2. Be specific with language selection
3. Check your internet connection
4. Ensure API has sufficient credits

### For Better Quality
1. Format your input code properly
2. Use correct language selection
3. Provide complete code (not fragments)
4. Include necessary context

---

## 🎯 Common Use Cases

### Use Case 1: Learning a New Language
- Write code in language you know
- Translate to language you're learning
- Compare the syntax and patterns

### Use Case 2: Code Review
- Paste code you don't understand
- Use Explain to get breakdown
- Learn from the explanation

### Use Case 3: Debugging
- Paste buggy code
- Use Fix to identify issues
- Learn from the corrections

### Use Case 4: Performance Tuning
- Paste slow code
- Use Optimize to improve
- Learn optimization techniques

### Use Case 5: Migration
- Translate entire codebase
- One function at a time
- Verify each translation

---

## 🚀 Next Steps

### After Getting Started
1. ✅ Test all 5 features
2. ✅ Try different languages
3. ✅ Test on mobile device
4. ✅ Read full documentation
5. ✅ Customize if needed

### Customization Ideas
- Change color scheme in CSS
- Add more languages
- Add syntax highlighting
- Add code history
- Add user accounts
- Add file upload

---

## 📞 Need Help?

### Check These First
1. Run `./verify-setup.sh`
2. Check browser console (F12)
3. Check backend terminal output
4. Read INSTALL.md troubleshooting section

### Documentation
- **Quick issues**: QUICKSTART.md
- **Installation issues**: INSTALL.md
- **Understanding code**: ARCHITECTURE.md
- **UI questions**: UI_GUIDE.md

---

## 🎊 You're All Set!

### What You Have Now
✅ Full-stack application running  
✅ Beautiful, responsive UI  
✅ 5 powerful AI features  
✅ Complete documentation  
✅ Production-ready code  

### Start Coding!
```bash
npm start
```

**Open http://localhost:3000 and enjoy!** 🚀

---

**Made with ❤️ using React, Spring Boot, and AI**

**Version:** 1.0.0  
**Status:** Production Ready  
**Last Updated:** 2025-10-05  
