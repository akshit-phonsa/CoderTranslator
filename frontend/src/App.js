import React, { useState } from 'react';
import { Container, Tab, Tabs } from 'react-bootstrap';
import { motion } from 'framer-motion';
import './App.css';
import TranslateTab from './components/TranslateTab';
import ExplainTab from './components/ExplainTab';
import FixTab from './components/FixTab';
import OptimizeTab from './components/OptimizeTab';
import FixOptimizeTab from './components/FixOptimizeTab';

function App() {
  const [activeTab, setActiveTab] = useState('translate');

  const containerVariants = {
    hidden: { opacity: 0, y: 50 },
    visible: {
      opacity: 1,
      y: 0,
      transition: {
        duration: 0.6,
        ease: 'easeOut'
      }
    }
  };

  const headerVariants = {
    hidden: { opacity: 0, scale: 0.8 },
    visible: {
      opacity: 1,
      scale: 1,
      transition: {
        duration: 0.8,
        ease: 'easeOut'
      }
    }
  };

  return (
    <div className="app-container">
      <Container>
        <motion.div
          className="header"
          variants={headerVariants}
          initial="hidden"
          animate="visible"
        >
          <h1>🚀 Code Translator</h1>
          <p>Translate, Explain, Fix, and Optimize your code with AI</p>
        </motion.div>

        <motion.div
          className="main-card"
          variants={containerVariants}
          initial="hidden"
          animate="visible"
        >
          <Tabs
            activeKey={activeTab}
            onSelect={(k) => setActiveTab(k)}
            className="mb-4 tabs-container"
          >
            <Tab eventKey="translate" title="🔄 Translate">
              <TranslateTab />
            </Tab>
            <Tab eventKey="explain" title="📖 Explain">
              <ExplainTab />
            </Tab>
            <Tab eventKey="fix" title="🔧 Fix">
              <FixTab />
            </Tab>
            <Tab eventKey="optimize" title="⚡ Optimize">
              <OptimizeTab />
            </Tab>
            <Tab eventKey="fix-optimize" title="🎯 Fix & Optimize">
              <FixOptimizeTab />
            </Tab>
          </Tabs>
        </motion.div>
      </Container>
    </div>
  );
}

export default App;
