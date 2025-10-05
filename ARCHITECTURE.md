# 🏗️ Architecture Overview

## System Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                         Browser                              │
│                    (http://localhost:3000)                   │
└────────────────────────┬────────────────────────────────────┘
                         │
                         │ HTTP Requests
                         │
┌────────────────────────▼────────────────────────────────────┐
│                    React Frontend                            │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  App.js (Main Component)                             │  │
│  │  ├── TranslateTab                                    │  │
│  │  ├── ExplainTab                                      │  │
│  │  ├── FixTab                                          │  │
│  │  ├── OptimizeTab                                     │  │
│  │  └── FixOptimizeTab                                  │  │
│  └──────────────────────────────────────────────────────┘  │
│                         │                                    │
│  ┌──────────────────────▼────────────────────────────────┐  │
│  │  API Service (api.js)                                │  │
│  │  ├── formatCodeForBackend()                          │  │
│  │  ├── formatCodeFromBackend()                         │  │
│  │  └── API Methods (translate, explain, fix, etc.)    │  │
│  └──────────────────────┬────────────────────────────────┘  │
└─────────────────────────┼───────────────────────────────────┘
                          │
                          │ Axios HTTP Calls
                          │ (Proxy: localhost:8080)
                          │
┌─────────────────────────▼───────────────────────────────────┐
│              Spring Boot Backend                             │
│                (http://localhost:8080)                       │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  CorsConfig (CORS Configuration)                     │  │
│  └──────────────────────┬────────────────────────────────┘  │
│                         │                                    │
│  ┌──────────────────────▼────────────────────────────────┐  │
│  │  TranslateController                                  │  │
│  │  ├── POST /api/translate                             │  │
│  │  ├── POST /api/explain                               │  │
│  │  ├── POST /api/fix                                   │  │
│  │  ├── POST /api/optimize                              │  │
│  │  └── POST /api/fix-optimize                          │  │
│  └──────────────────────┬────────────────────────────────┘  │
│                         │                                    │
│  ┌──────────────────────▼────────────────────────────────┐  │
│  │  TranslateServiceForPerplexity                        │  │
│  │  (Business Logic)                                     │  │
│  └──────────────────────┬────────────────────────────────┘  │
│                         │                                    │
│  ┌──────────────────────▼────────────────────────────────┐  │
│  │  WebClient (Spring WebFlux)                           │  │
│  └──────────────────────┬────────────────────────────────┘  │
└─────────────────────────┼───────────────────────────────────┘
                          │
                          │ HTTPS API Calls
                          │
┌─────────────────────────▼───────────────────────────────────┐
│              External AI Services                            │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Perplexity AI (llama-3.1-sonar-large-128k-online)  │  │
│  │  OpenAI (gpt-4o-mini-code)                           │  │
│  └──────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────┘
```

## Data Flow

### 1. Code Translation Flow
```
User Input (Frontend)
    │
    ├─ Source Language: "JavaScript"
    ├─ Target Language: "Python"
    └─ Code: "function hello() { ... }"
    │
    ▼
formatCodeForBackend()
    │ Escapes: \n, \r, \t, "
    ▼
Axios POST Request
    │ → /api/translate
    ▼
TranslateController
    │ Validates request
    ▼
TranslateServiceForPerplexity
    │ Builds prompt
    ▼
WebClient → Perplexity API
    │ AI Processing
    ▼
Response (JSON)
    │
    ├─ translatedCode: "def hello(): ..."
    ├─ model: "llama-3.1-sonar..."
    └─ rawModelOutput: "..."
    │
    ▼
formatCodeFromBackend()
    │ Unescapes: \\n → \n, \\t → \t
    ▼
Display in UI
    │ Syntax highlighted
    └─ Copy to clipboard option
```

## Component Hierarchy

```
App (Main Container)
│
├── Header (Animated)
│   ├── Title: "🚀 Code Translator"
│   └── Subtitle
│
└── Tabs Container
    │
    ├── TranslateTab
    │   ├── Source Language Selector
    │   ├── Target Language Selector
    │   ├── Code Input Textarea
    │   ├── Submit Button
    │   └── Result Display
    │
    ├── ExplainTab
    │   ├── Source Language Selector
    │   ├── Code Input Textarea
    │   ├── Submit Button
    │   └── Explanation Display
    │
    ├── FixTab
    │   ├── Source Language Selector
    │   ├── Code Input Textarea
    │   ├── Submit Button
    │   └── Fixed Code Display
    │
    ├── OptimizeTab
    │   ├── Source Language Selector
    │   ├── Code Input Textarea
    │   ├── Submit Button
    │   └── Optimized Code Display
    │
    └── FixOptimizeTab
        ├── Source Language Selector
        ├── Code Input Textarea
        ├── Submit Button
        └── Fixed & Optimized Code Display
```

## State Management

### Component State (useState)
```javascript
TranslateTab State:
├── sourceLang: string
├── targetLang: string
├── code: string
├── result: object | null
├── loading: boolean
├── error: string
└── copied: boolean
```

## API Request/Response Format

### Request Example
```json
POST /api/translate
{
  "sourceLang": "JavaScript",
  "targetLang": "Python",
  "code": "function add(a, b) {\n  return a + b;\n}"
}
```

### Response Example
```json
{
  "translatedCode": "def add(a, b):\n    return a + b",
  "model": "llama-3.1-sonar-large-128k-online",
  "rawModelOutput": "..."
}
```

## Code Formatting Pipeline

### Before Sending (Frontend → Backend)
```
Original Code:
function hello() {
    console.log("Hello");
}

↓ formatCodeForBackend()

Escaped Code:
function hello() {\n    console.log(\"Hello\");\n}
```

### After Receiving (Backend → Frontend)
```
Escaped Response:
def hello():\n    print(\"Hello\")

↓ formatCodeFromBackend()

Formatted Code:
def hello():
    print("Hello")
```

## Technology Stack Layers

```
┌─────────────────────────────────────────┐
│         Presentation Layer              │
│  React, Bootstrap, Framer Motion        │
│  HTML, CSS, JavaScript                  │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│         API Communication Layer         │
│  Axios, Proxy, CORS                     │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│         Backend Layer                   │
│  Spring Boot, WebFlux, Java 21          │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│         External Services               │
│  Perplexity AI, OpenAI                  │
└─────────────────────────────────────────┘
```

## Responsive Design Breakpoints

```
Desktop (> 768px)
┌─────────────────────────────────────────┐
│  Header (Full Width)                    │
├──────────────────┬──────────────────────┤
│  Source Lang     │  Target Lang         │
├──────────────────┴──────────────────────┤
│  Code Input (Full Width)                │
├─────────────────────────────────────────┤
│  [Translate] [Clear]                    │
├─────────────────────────────────────────┤
│  Result Display (Full Width)            │
└─────────────────────────────────────────┘

Mobile (< 768px)
┌─────────────────────────────────────────┐
│  Header (Smaller)                       │
├─────────────────────────────────────────┤
│  Source Lang (Full Width)               │
├─────────────────────────────────────────┤
│  Target Lang (Full Width)               │
├─────────────────────────────────────────┤
│  Code Input (Full Width)                │
├─────────────────────────────────────────┤
│  [Translate] (Full Width)               │
│  [Clear] (Full Width)                   │
├─────────────────────────────────────────┤
│  Result Display (Full Width)            │
└─────────────────────────────────────────┘
```

## Animation Timeline

```
Page Load:
  0ms   → Header fades in (scale 0.8 → 1.0)
  200ms → Card slides up (y: 50 → 0)
  400ms → Content fades in

User Action:
  Click → Button scales (1.0 → 1.05)
  Submit → Loading spinner appears
  Response → Result fades in (opacity 0 → 1)

Error:
  Error → Alert shakes (x: -5 → 5 → -5 → 5 → 0)
```

## Security Flow

```
Frontend
    │
    ├─ No API keys stored
    ├─ Input validation
    └─ HTTPS only
    │
    ▼
Backend
    │
    ├─ CORS validation (localhost:3000)
    ├─ Request validation (@Valid)
    ├─ API keys in application.properties
    └─ Error sanitization
    │
    ▼
External API
    │
    └─ Authenticated requests only
```

## Deployment Architecture

```
Development:
├── Frontend: localhost:3000 (React Dev Server)
└── Backend: localhost:8080 (Spring Boot)

Production:
├── Frontend: Static files (build/)
│   └── Served by: Nginx/Apache/CDN
└── Backend: JAR file
    └── Deployed on: Cloud (AWS/Azure/GCP)
```

## File Size Overview

```
Frontend:
├── Components: ~1.5 KB each (5 files)
├── API Service: ~3 KB
├── Styles: ~5 KB
└── Total (uncompressed): ~20 KB

Backend:
├── Controllers: ~2 KB
├── Services: ~5 KB
├── Config: ~1 KB
└── Total: ~8 KB
```

---

**Architecture Type**: Microservices (Frontend + Backend)
**Communication**: REST API (JSON)
**Deployment**: Containerizable (Docker ready)
