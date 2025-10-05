# ⚡ Quick Start Guide

## 🎯 Get Started in 3 Steps

### Step 1: Install Dependencies
```bash
npm run install-all
```

### Step 2: Configure API Keys
Edit `src/main/resources/application.properties` with your API keys.

### Step 3: Run the Application
```bash
npm start
```
or
```bash
./start.sh
```

That's it! 🎉

The application will open at:
- **Frontend**: http://localhost:3000
- **Backend**: http://localhost:8080

## 🎨 What You'll See

1. **Beautiful Landing Page** with gradient background
2. **5 Tabs** for different operations:
   - 🔄 Translate
   - 📖 Explain
   - 🔧 Fix
   - ⚡ Optimize
   - 🎯 Fix & Optimize

3. **Smooth Animations** powered by Framer Motion
4. **Responsive Design** that works on all devices
5. **Code Formatting** that handles `\n`, `\r`, `\t` automatically

## 🔥 Key Features

- **Copy to Clipboard**: One-click copy for all results
- **Real-time Validation**: Instant feedback on inputs
- **Loading States**: Beautiful spinners while processing
- **Error Handling**: Clear error messages with animations
- **Model Info**: See which AI model processed your request

## 📱 Responsive Breakpoints

- **Desktop**: Full layout with side-by-side forms
- **Tablet**: Stacked layout with optimized spacing
- **Mobile**: Single column with touch-friendly buttons

## 🎨 UI Highlights

- **Gradient Background**: Purple to blue gradient
- **Card Design**: Frosted glass effect
- **Animations**: Fade-in, slide-up, and shake effects
- **Custom Scrollbars**: Styled code output area
- **Bootstrap 5**: Modern, responsive components

## 🛠️ Troubleshooting

### Dependencies Not Installing?
```bash
# Clear npm cache
npm cache clean --force

# Try again
npm run install-all
```

### Port Already in Use?
```bash
# Kill process on port 8080
lsof -ti:8080 | xargs kill -9

# Kill process on port 3000
lsof -ti:3000 | xargs kill -9
```

### Backend Not Starting?
Make sure Java 21 is installed:
```bash
java -version
```

## 💡 Tips

1. **Test with Simple Code First**: Start with a simple function to test the setup
2. **Check API Credits**: Ensure your API keys have sufficient credits
3. **Use Chrome DevTools**: Check Network tab if API calls fail
4. **Clear Browser Cache**: If UI doesn't update, clear cache and reload

## 🎯 Next Steps

1. Try translating a simple function
2. Experiment with different languages
3. Test the explain feature to understand code
4. Use fix and optimize for production code

Enjoy coding! 🚀
