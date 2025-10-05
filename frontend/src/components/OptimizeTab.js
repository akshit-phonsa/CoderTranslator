import React, { useState } from 'react';
import { Form, Button, Alert, Spinner } from 'react-bootstrap';
import { motion, AnimatePresence } from 'framer-motion';
import { FiCopy, FiCheck } from 'react-icons/fi';
import apiService from '../services/api';

const LANGUAGES = [
  'JavaScript', 'Python', 'Java', 'C++', 'C#', 'Ruby', 'Go', 'Rust',
  'PHP', 'Swift', 'Kotlin', 'TypeScript', 'Scala', 'R', 'Perl', 'Dart'
];

function OptimizeTab() {
  const [sourceLang, setSourceLang] = useState('JavaScript');
  const [code, setCode] = useState('');
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [copied, setCopied] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!code.trim()) {
      setError('Please enter some code to optimize');
      return;
    }

    setLoading(true);
    setError('');
    setResult(null);

    try {
      const response = await apiService.optimizeCode(sourceLang, code);
      setResult(response);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  const handleCopy = () => {
    if (result?.translatedCode) {
      navigator.clipboard.writeText(result.translatedCode);
      setCopied(true);
      setTimeout(() => setCopied(false), 2000);
    }
  };

  const handleClear = () => {
    setCode('');
    setResult(null);
    setError('');
  };

  return (
    <motion.div
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      transition={{ duration: 0.5 }}
    >
      <Form onSubmit={handleSubmit}>
        <Form.Group className="form-section">
          <Form.Label>Source Language</Form.Label>
          <Form.Select
            value={sourceLang}
            onChange={(e) => setSourceLang(e.target.value)}
          >
            {LANGUAGES.map(lang => (
              <option key={lang} value={lang}>{lang}</option>
            ))}
          </Form.Select>
        </Form.Group>

        <Form.Group className="form-section">
          <Form.Label>Your Code</Form.Label>
          <Form.Control
            as="textarea"
            className="code-textarea"
            value={code}
            onChange={(e) => setCode(e.target.value)}
            placeholder={`Enter your ${sourceLang} code to optimize...`}
          />
        </Form.Group>

        <div className="button-group">
          <Button
            variant="primary"
            type="submit"
            disabled={loading}
          >
            {loading ? (
              <>
                <Spinner
                  as="span"
                  animation="border"
                  size="sm"
                  role="status"
                  aria-hidden="true"
                  className="me-2"
                />
                Optimizing...
              </>
            ) : (
              'Optimize Code'
            )}
          </Button>
          <Button
            variant="secondary"
            onClick={handleClear}
            disabled={loading}
          >
            Clear
          </Button>
        </div>
      </Form>

      <AnimatePresence>
        {error && (
          <motion.div
            initial={{ opacity: 0, y: -20 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: -20 }}
          >
            <Alert variant="danger" className="mt-3 error-alert">
              {error}
            </Alert>
          </motion.div>
        )}

        {result && (
          <motion.div
            className="result-section fade-in"
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ duration: 0.5 }}
          >
            <div className="result-header">
              <h4>Optimized Code</h4>
              <button className="copy-btn" onClick={handleCopy}>
                {copied ? (
                  <>
                    <FiCheck className="me-2" />
                    Copied!
                  </>
                ) : (
                  <>
                    <FiCopy className="me-2" />
                    Copy Code
                  </>
                )}
              </button>
            </div>
            <div className="code-output">
              {result.translatedCode}
            </div>
            {result.model && (
              <div className="model-info">
                <strong>Model:</strong> {result.model}
              </div>
            )}
          </motion.div>
        )}
      </AnimatePresence>
    </motion.div>
  );
}

export default OptimizeTab;
