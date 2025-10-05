#!/bin/bash

echo "🔍 Verifying Code Translator Setup..."
echo ""

# Color codes
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Check Node.js
echo -n "Checking Node.js... "
if command -v node &> /dev/null; then
    NODE_VERSION=$(node -v)
    echo -e "${GREEN}✓${NC} Found: $NODE_VERSION"
else
    echo -e "${RED}✗${NC} Node.js not found. Please install Node.js v16+"
    exit 1
fi

# Check npm
echo -n "Checking npm... "
if command -v npm &> /dev/null; then
    NPM_VERSION=$(npm -v)
    echo -e "${GREEN}✓${NC} Found: v$NPM_VERSION"
else
    echo -e "${RED}✗${NC} npm not found"
    exit 1
fi

# Check Java
echo -n "Checking Java... "
if command -v java &> /dev/null; then
    JAVA_VERSION=$(java -version 2>&1 | head -n 1)
    echo -e "${GREEN}✓${NC} Found: $JAVA_VERSION"
else
    echo -e "${RED}✗${NC} Java not found. Please install JDK 21"
    exit 1
fi

# Check Maven Wrapper
echo -n "Checking Maven Wrapper... "
if [ -f "./mvnw" ]; then
    echo -e "${GREEN}✓${NC} Found"
else
    echo -e "${RED}✗${NC} mvnw not found"
    exit 1
fi

echo ""
echo "📁 Checking Project Structure..."

# Check frontend directory
echo -n "Frontend directory... "
if [ -d "frontend" ]; then
    echo -e "${GREEN}✓${NC}"
else
    echo -e "${RED}✗${NC} frontend directory missing"
    exit 1
fi

# Check frontend package.json
echo -n "Frontend package.json... "
if [ -f "frontend/package.json" ]; then
    echo -e "${GREEN}✓${NC}"
else
    echo -e "${RED}✗${NC} frontend/package.json missing"
    exit 1
fi

# Check backend pom.xml
echo -n "Backend pom.xml... "
if [ -f "pom.xml" ]; then
    echo -e "${GREEN}✓${NC}"
else
    echo -e "${RED}✗${NC} pom.xml missing"
    exit 1
fi

# Check API configuration
echo -n "Application properties... "
if [ -f "src/main/resources/application.properties" ]; then
    echo -e "${GREEN}✓${NC}"
    
    # Check if API keys are configured
    echo -n "API Keys configured... "
    if grep -q "sk-proj-" src/main/resources/application.properties && grep -q "pplx-" src/main/resources/application.properties; then
        echo -e "${GREEN}✓${NC}"
    else
        echo -e "${YELLOW}⚠${NC} API keys may need configuration"
    fi
else
    echo -e "${RED}✗${NC} application.properties missing"
    exit 1
fi

# Check React components
echo -n "React components... "
COMPONENT_COUNT=$(find frontend/src/components -name "*.js" 2>/dev/null | wc -l)
if [ $COMPONENT_COUNT -ge 5 ]; then
    echo -e "${GREEN}✓${NC} Found $COMPONENT_COUNT components"
else
    echo -e "${RED}✗${NC} Missing components"
    exit 1
fi

# Check CORS configuration
echo -n "CORS configuration... "
if [ -f "src/main/java/com/example/codeTranslator/code_translator/config/CorsConfig.java" ]; then
    echo -e "${GREEN}✓${NC}"
else
    echo -e "${YELLOW}⚠${NC} CorsConfig.java not found"
fi

echo ""
echo "📦 Checking Dependencies..."

# Check root node_modules
echo -n "Root dependencies... "
if [ -d "node_modules" ]; then
    echo -e "${GREEN}✓${NC} Installed"
else
    echo -e "${YELLOW}⚠${NC} Not installed. Run: npm install"
fi

# Check frontend node_modules
echo -n "Frontend dependencies... "
if [ -d "frontend/node_modules" ]; then
    echo -e "${GREEN}✓${NC} Installed"
else
    echo -e "${YELLOW}⚠${NC} Not installed. Run: cd frontend && npm install"
fi

echo ""
echo "═══════════════════════════════════════════════════"
echo -e "${GREEN}✅ Setup Verification Complete!${NC}"
echo "═══════════════════════════════════════════════════"
echo ""
echo "🚀 Ready to start? Run one of these commands:"
echo "   npm start          (runs both frontend & backend)"
echo "   ./start.sh         (automated startup)"
echo ""
echo "📚 Documentation:"
echo "   README.md          (full documentation)"
echo "   QUICKSTART.md      (quick start guide)"
echo "   PROJECT_SUMMARY.md (project overview)"
echo ""
