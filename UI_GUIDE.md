# 🎨 UI/UX Design Guide

## Visual Overview

### Landing Page
```
╔════════════════════════════════════════════════════════════════╗
║                                                                ║
║                    🚀 Code Translator                          ║
║         Translate, Explain, Fix, and Optimize your code        ║
║                         with AI                                ║
║                                                                ║
╠════════════════════════════════════════════════════════════════╣
║                                                                ║
║  ┌──────────────────────────────────────────────────────────┐ ║
║  │  [🔄 Translate] [📖 Explain] [🔧 Fix] [⚡ Optimize]      │ ║
║  │                [🎯 Fix & Optimize]                        │ ║
║  ├──────────────────────────────────────────────────────────┤ ║
║  │                                                           │ ║
║  │  Source Language: [JavaScript ▼]  Target: [Python ▼]    │ ║
║  │                                                           │ ║
║  │  Your Code:                                               │ ║
║  │  ┌─────────────────────────────────────────────────────┐ │ ║
║  │  │ function add(a, b) {                                │ │ ║
║  │  │     return a + b;                                   │ │ ║
║  │  │ }                                                    │ │ ║
║  │  │                                                      │ │ ║
║  │  └─────────────────────────────────────────────────────┘ │ ║
║  │                                                           │ ║
║  │  [Translate Code]  [Clear]                               │ ║
║  │                                                           │ ║
║  │  ┌─────────────────────────────────────────────────────┐ │ ║
║  │  │ Translated Code (Python)          [📋 Copy Code]   │ │ ║
║  │  ├─────────────────────────────────────────────────────┤ │ ║
║  │  │ def add(a, b):                                      │ │ ║
║  │  │     return a + b                                    │ │ ║
║  │  │                                                      │ │ ║
║  │  └─────────────────────────────────────────────────────┘ │ ║
║  │  Model: llama-3.1-sonar-large-128k-online               │ ║
║  └──────────────────────────────────────────────────────────┘ ║
║                                                                ║
╚════════════════════════════════════════════════════════════════╝
```

---

## 🎨 Color Palette

### Primary Colors
```css
Background Gradient:  #667eea → #764ba2 (Purple gradient)
Card Background:      rgba(255, 255, 255, 0.95) (Frosted white)
Primary Button:       #667eea → #764ba2 (Gradient)
Secondary Button:     #6c757d (Gray)
```

### Text Colors
```css
Header Text:          #ffffff (White)
Body Text:            #333333 (Dark gray)
Code Output:          #abb2bf (Light gray on dark)
Code Background:      #282c34 (Dark)
```

### State Colors
```css
Success:              #28a745 (Green)
Error:                #dc3545 (Red)
Warning:              #ffc107 (Yellow)
Info:                 #17a2b8 (Cyan)
```

---

## 📐 Layout Specifications

### Desktop Layout (>768px)
```
┌─────────────────────────────────────────────────────────┐
│  Header (Full Width, Centered)                          │
│  Padding: 20px                                           │
├─────────────────────────────────────────────────────────┤
│  Main Card (Max-width: 1400px, Centered)                │
│  ├─ Tabs (Horizontal)                                   │
│  ├─ Form Section                                        │
│  │  ├─ Row (2 columns)                                  │
│  │  │  ├─ Source Language (50%)                         │
│  │  │  └─ Target Language (50%)                         │
│  │  ├─ Code Textarea (Full width)                       │
│  │  └─ Buttons (Horizontal)                             │
│  └─ Result Section (Full width)                         │
└─────────────────────────────────────────────────────────┘
```

### Mobile Layout (<768px)
```
┌──────────────────────┐
│  Header (Smaller)    │
├──────────────────────┤
│  Main Card           │
│  ├─ Tabs (Wrapped)   │
│  ├─ Form Section     │
│  │  ├─ Source Lang   │
│  │  │  (Full width)  │
│  │  ├─ Target Lang   │
│  │  │  (Full width)  │
│  │  ├─ Code Input    │
│  │  │  (Full width)  │
│  │  ├─ Button 1      │
│  │  │  (Full width)  │
│  │  └─ Button 2      │
│  │     (Full width)  │
│  └─ Result Section   │
│     (Full width)     │
└──────────────────────┘
```

---

## 🎬 Animation Specifications

### Page Load Animation
```javascript
Timeline:
0ms    → Header: opacity 0, scale 0.8
800ms  → Header: opacity 1, scale 1.0 (ease-out)
0ms    → Card: opacity 0, y: 50px
600ms  → Card: opacity 1, y: 0 (ease-out)
```

### Tab Switch Animation
```javascript
Duration: 500ms
Easing: ease-in-out
Effect: Fade (opacity 0 → 1)
```

### Button Hover
```javascript
Duration: 300ms
Easing: ease
Transform: translateY(-2px)
Shadow: Increase
```

### Result Display
```javascript
Duration: 500ms
Easing: ease-out
Effect: Fade + Slide (opacity 0 → 1, y: 20 → 0)
```

### Error Shake
```javascript
Duration: 500ms
Keyframes:
  0%, 100%  → translateX(0)
  10%, 50%  → translateX(-5px)
  20%, 60%  → translateX(5px)
```

---

## 📏 Spacing System

### Padding
```css
Small:    10px
Medium:   20px
Large:    30px
XLarge:   40px
```

### Margins
```css
Between sections:  25-30px
Between elements:  15px
Between buttons:   15px
```

### Border Radius
```css
Buttons:      10px
Cards:        20px
Inputs:       10px
Code output:  10px
```

---

## 🔤 Typography

### Font Families
```css
Body:    -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto'
Code:    'Courier New', monospace
```

### Font Sizes
```css
H1 (Desktop):  3rem (48px)
H1 (Mobile):   1.5rem (24px)
H4:            1.5rem (24px)
Body:          1rem (16px)
Small:         0.9rem (14.4px)
```

### Font Weights
```css
Headers:       700 (Bold)
Buttons:       600 (Semi-bold)
Body:          400 (Regular)
```

---

## 🎯 Interactive Elements

### Buttons

#### Primary Button
```css
Background:    Linear gradient (#667eea → #764ba2)
Color:         White
Padding:       12px 40px
Border-radius: 10px
Box-shadow:    0 4px 15px rgba(102, 126, 234, 0.4)

Hover:
  Transform:   translateY(-2px)
  Box-shadow:  0 6px 20px rgba(102, 126, 234, 0.6)

Disabled:
  Opacity:     0.6
  Cursor:      not-allowed
```

#### Secondary Button
```css
Background:    #6c757d
Color:         White
Padding:       12px 30px
Border-radius: 10px

Hover:
  Background:  #5a6268
  Transform:   translateY(-2px)
```

#### Copy Button
```css
Background:    Linear gradient (#667eea → #764ba2)
Color:         White
Padding:       8px 20px
Border-radius: 8px

Hover:
  Transform:   scale(1.05)
  Box-shadow:  0 4px 12px rgba(102, 126, 234, 0.4)

Active (Copied):
  Icon:        Check mark
  Text:        "Copied!"
```

### Form Inputs

#### Text Input / Textarea
```css
Border:        2px solid #e0e0e0
Border-radius: 10px
Padding:       12px
Background:    #f8f9fa (for code)

Focus:
  Border-color: #667eea
  Box-shadow:   0 0 0 0.2rem rgba(102, 126, 234, 0.25)
```

#### Select Dropdown
```css
Border:        2px solid #e0e0e0
Border-radius: 10px
Padding:       12px
Background:    White

Focus:
  Border-color: #667eea
  Box-shadow:   0 0 0 0.2rem rgba(102, 126, 234, 0.25)
```

---

## 📱 Responsive Breakpoints

### Breakpoint Values
```css
Mobile:    < 576px
Tablet:    576px - 768px
Desktop:   > 768px
Large:     > 992px
XLarge:    > 1200px
```

### Responsive Changes

#### < 576px (Mobile)
- Header font: 1.5rem
- Single column layout
- Full-width buttons
- Reduced padding: 15px
- Smaller code textarea: 200px min-height

#### 576px - 768px (Tablet)
- Header font: 2rem
- Optimized spacing
- Stacked forms
- Medium padding: 20px

#### > 768px (Desktop)
- Header font: 3rem
- Side-by-side layout
- Horizontal buttons
- Full padding: 30px
- Large code textarea: 300px min-height

---

## 🎨 Component Styles

### Header
```css
Text-align:    center
Color:         white
Margin-bottom: 30px
Padding:       20px

H1:
  Font-size:   3rem (desktop), 1.5rem (mobile)
  Font-weight: bold
  Text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3)

P:
  Font-size:   1.2rem (desktop), 1rem (mobile)
  Opacity:     0.9
```

### Main Card
```css
Background:    rgba(255, 255, 255, 0.95)
Border-radius: 20px
Box-shadow:    0 20px 60px rgba(0, 0, 0, 0.3)
Padding:       30px (desktop), 15px (mobile)
Max-width:     1400px
Margin:        0 auto
```

### Tabs
```css
Nav-link:
  Color:         #667eea
  Font-weight:   600
  Border:        none
  Padding:       12px 24px
  Margin-right:  10px
  Border-radius: 10px 10px 0 0

Nav-link:hover:
  Background:    #f0f0f0
  Transform:     translateY(-2px)

Nav-link.active:
  Background:    Linear gradient (#667eea → #764ba2)
  Color:         white
  Border:        none
```

### Code Output
```css
Background:    #282c34
Color:         #abb2bf
Padding:       20px
Border-radius: 10px
Font-family:   'Courier New', monospace
White-space:   pre-wrap
Word-wrap:     break-word
Max-height:    500px
Overflow-y:    auto
Line-height:   1.6
Font-size:     14px

Scrollbar:
  Width:       8px
  Track:       #1e2127
  Thumb:       #667eea
  Thumb:hover: #764ba2
```

### Result Section
```css
Margin-top:    30px
Padding:       25px
Background:    Linear gradient (#f8f9fa → #e9ecef)
Border-radius: 15px
Border:        2px solid #dee2e6
```

### Loading Spinner
```css
Width:         3rem
Height:        3rem
Border-width:  0.3rem
Color:         #667eea
```

### Error Alert
```css
Background:    #f8d7da
Color:         #721c24
Border:        1px solid #f5c6cb
Border-radius: 10px
Padding:       12px
Animation:     shake 0.5s
```

---

## 🎭 State Variations

### Loading State
- Button shows spinner
- Button text changes to "Translating..." / "Explaining..." etc.
- Button disabled
- Form inputs disabled

### Success State
- Result section fades in
- Code displays with formatting
- Copy button available
- Model info shown

### Error State
- Alert appears with shake animation
- Red background
- Error icon
- Clear error message

### Empty State
- Placeholder text in textarea
- Disabled submit button (optional)
- Helper text

---

## 🔍 Accessibility Features

### Keyboard Navigation
- Tab through all interactive elements
- Enter to submit forms
- Escape to close modals (if any)

### ARIA Labels
```html
<button aria-label="Copy code to clipboard">
<textarea aria-label="Enter your code here">
<select aria-label="Select source language">
```

### Focus Indicators
- Visible focus outline
- High contrast focus state
- Skip to content link (optional)

---

## 📊 Visual Hierarchy

### Priority Levels

**Level 1 (Highest):**
- Header title
- Primary action button
- Result code output

**Level 2:**
- Tab navigation
- Form labels
- Copy button

**Level 3:**
- Helper text
- Model info
- Secondary buttons

---

## 🎨 Dark Theme Ready (Future)

### Potential Dark Theme Colors
```css
Background:      #1a1a2e → #16213e
Card:            rgba(30, 30, 46, 0.95)
Text:            #e0e0e0
Primary:         #667eea → #764ba2 (same)
Code Output:     #282c34 (same)
```

---

## 📐 Grid System

### Bootstrap Grid Usage
```html
<div class="row">
  <div class="col-md-6">Source Language</div>
  <div class="col-md-6">Target Language</div>
</div>

<div class="row">
  <div class="col-12">Code Input</div>
</div>
```

### Responsive Grid
- Mobile: col-12 (full width)
- Tablet: col-md-6 (half width)
- Desktop: col-lg-4 (third width, if needed)

---

## 🎯 User Flow

### Typical User Journey
```
1. Land on page
   ↓ (Animation plays)
2. See header and tabs
   ↓
3. Select tab (e.g., Translate)
   ↓
4. Choose source language
   ↓
5. Choose target language
   ↓
6. Enter code
   ↓
7. Click "Translate Code"
   ↓ (Loading spinner)
8. View result
   ↓
9. Click "Copy Code"
   ↓
10. Success! (Copied feedback)
```

---

## 🎨 Visual Examples

### Button States
```
Normal:    [Translate Code]
Hover:     [Translate Code] ↑ (lifted)
Active:    [Translate Code] (pressed)
Disabled:  [Translate Code] (grayed)
Loading:   [⟳ Translating...]
```

### Copy Button States
```
Normal:    [📋 Copy Code]
Hover:     [📋 Copy Code] (scaled)
Copied:    [✓ Copied!]
```

### Tab States
```
Inactive:  [🔄 Translate] (purple text, white bg)
Hover:     [🔄 Translate] (gray bg, lifted)
Active:    [🔄 Translate] (gradient bg, white text)
```

---

## 📱 Mobile Optimizations

### Touch Targets
- Minimum size: 44x44px
- Spacing: 8px between
- Full-width buttons on mobile

### Font Scaling
- Respect user's font size preferences
- Use rem units for scalability

### Viewport
```html
<meta name="viewport" content="width=device-width, initial-scale=1">
```

---

## 🎉 Micro-interactions

### Copy Button
1. Click → Icon changes to checkmark
2. Text changes to "Copied!"
3. After 2 seconds → Reverts to original

### Form Submit
1. Click → Button shows spinner
2. Button text changes
3. Form disabled
4. On response → Result fades in

### Error Display
1. Error occurs → Alert slides in
2. Shake animation plays
3. User can dismiss
4. Auto-dismiss after 5s (optional)

---

**This UI design provides a modern, professional, and user-friendly experience!**

**Design System:** Bootstrap 5 + Custom CSS  
**Animation Library:** Framer Motion  
**Icons:** React Icons (Feather)  
