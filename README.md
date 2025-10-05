# 🚀 Code Translator

A full-stack application that translates, explains, fixes, and optimizes code using AI. Built with React (frontend) and Spring Boot (backend).

## ✨ Features

- **🔄 Code Translation**: Translate code between different programming languages
- **📖 Code Explanation**: Get detailed explanations of your code
- **🔧 Code Fixing**: Automatically fix bugs in your code
- **⚡ Code Optimization**: Optimize your code for better performance
- **🎯 Fix & Optimize**: Fix bugs and optimize code in one go
- **🎨 Beautiful UI**: Responsive design with smooth animations
- **📱 Mobile Friendly**: Works seamlessly on all devices

## 🛠️ Tech Stack

### Frontend
- React 18
- Bootstrap 5 & React-Bootstrap
- Framer Motion (animations)
- Axios (HTTP client)
- React Icons

### Backend
- Spring Boot 3.2.0
- Spring WebFlux (Reactive)
- Java 21
- OpenAI/Perplexity API Integration

## 📋 Prerequisites

- **Node.js** (v16 or higher)
- **Java** (JDK 21)
- **Maven** (included via Maven Wrapper)
- **API Keys**: OpenAI or Perplexity API key

## 🚀 Quick Start

### 1. Clone the Repository
```bash
cd /Users/admin/Documents/SPRING\ BOOT/code-translator
```

### 2. Configure API Keys
Edit `src/main/resources/application.properties` and add your API keys:
```properties
openai.api.api-key=your-openai-api-key
perplexity.api.key=your-perplexity-api-key
```

### 3. Install Dependencies
```bash
# Install root dependencies (concurrently)
npm install

# Install frontend dependencies
cd frontend
npm install
cd ..
```

Or use the convenience script:
```bash
npm run install-all
```

### 4. Run the Application
Run both frontend and backend with a single command:
```bash
npm start
```

This will start:
- **Backend**: http://localhost:8080
- **Frontend**: http://localhost:3000

The frontend will automatically open in your browser.

## 🎯 Manual Start (Alternative)

If you prefer to run frontend and backend separately:

### Start Backend
```bash
./mvnw spring-boot:run
```

### Start Frontend (in a new terminal)
```bash
cd frontend
npm start
```

## 📁 Project Structure

```
code-translator/
├── src/                          # Backend source code
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/codeTranslator/
│   │   │       ├── config/       # Configuration classes
│   │   │       ├── controller/   # REST controllers
│   │   │       ├── dto/          # Data transfer objects
│   │   │       ├── service/      # Business logic
│   │   │       └── util/         # Utility classes
│   │   └── resources/
│   │       └── application.properties
│   └── test/                     # Backend tests
├── frontend/                     # React frontend
│   ├── public/
│   ├── src/
│   │   ├── components/           # React components
│   │   ├── services/             # API services
│   │   ├── App.js               # Main App component
│   │   ├── App.css              # Styles
│   │   └── index.js             # Entry point
│   └── package.json
├── pom.xml                       # Maven configuration
├── package.json                  # Root package.json (concurrently)
└── README.md
```

## 🎨 Features in Detail

### Code Translation
- Translate code between 16+ programming languages
- Preserves code logic and structure
- Handles complex code patterns

### Code Explanation
- Get detailed explanations in plain English
- Understand complex algorithms
- Learn from your code

### Code Fixing
- Automatically detect and fix bugs
- Syntax error correction
- Logic error detection

### Code Optimization
- Performance improvements
- Best practices implementation
- Code refactoring suggestions

## 🔧 API Endpoints

- `POST /api/translate` - Translate code
- `POST /api/explain` - Explain code
- `POST /api/fix` - Fix code bugs
- `POST /api/optimize` - Optimize code
- `POST /api/fix-optimize` - Fix and optimize code

## 🎨 Supported Languages

JavaScript, Python, Java, C++, C#, Ruby, Go, Rust, PHP, Swift, Kotlin, TypeScript, Scala, R, Perl, Dart

## 🔒 Environment Variables

Create a `.env` file in the root directory (optional):
```properties
OPENAI_API_KEY=your-key-here
PERPLEXITY_API_KEY=your-key-here
```

## 🐛 Troubleshooting

### Port Already in Use
If port 8080 or 3000 is already in use:
- Backend: Change `server.port` in `application.properties`
- Frontend: Set `PORT=3001` before running `npm start`

### CORS Issues
CORS is configured to allow requests from `http://localhost:3000`. If you change the frontend port, update `CorsConfig.java`.

### API Key Issues
Ensure your API keys are valid and have sufficient credits.

## 📦 Building for Production

### Build Frontend
```bash
npm run build-frontend
```

This creates an optimized production build in `frontend/build/`.

### Build Backend
```bash
./mvnw clean package
```

This creates a JAR file in `target/`.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## 📄 License

This project is licensed under the ISC License.

## 🙏 Acknowledgments

- OpenAI for GPT models
- Perplexity AI for Llama models
- React and Spring Boot communities

## 📞 Support

For issues and questions, please open an issue on GitHub.

---

Made with ❤️ using React and Spring Boot
