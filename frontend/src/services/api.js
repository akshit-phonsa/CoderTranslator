import axios from 'axios';

const API_BASE_URL = '/api';

// Format code before sending to backend (convert to escaped string)
export const formatCodeForBackend = (code) => {
  if (!code) return '';
  // Escape special characters for JSON
  return code
    .replace(/\\/g, '\\\\')
    .replace(/\n/g, '\\n')
    .replace(/\r/g, '\\r')
    .replace(/\t/g, '\\t')
    .replace(/"/g, '\\"');
};

// Format code received from backend (unescape)
export const formatCodeFromBackend = (code) => {
  if (!code) return '';
  // Unescape special characters from JSON
  return code
    .replace(/\\n/g, '\n')
    .replace(/\\r/g, '\r')
    .replace(/\\t/g, '\t')
    .replace(/\\"/g, '"')
    .replace(/\\\\/g, '\\');
};

// API Service
const apiService = {
  // Translate code from one language to another
  translateCode: async (sourceLang, targetLang, code) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/translate`, {
        sourceLang,
        targetLang,
        code
      });
      return {
        ...response.data,
        translatedCode: formatCodeFromBackend(response.data.translatedCode)
      };
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Failed to translate code');
    }
  },

  // Explain code
  explainCode: async (sourceLang, code, targetLang = 'English') => {
    try {
      const response = await axios.post(`${API_BASE_URL}/explain`, {
        sourceLang,
        targetLang,
        code
      });
      return {
        ...response.data,
        translatedCode: formatCodeFromBackend(response.data.translatedCode)
      };
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Failed to explain code');
    }
  },

  // Fix code
  fixCode: async (sourceLang, code) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/fix`, {
        sourceLang,
        code
      });
      return {
        ...response.data,
        translatedCode: formatCodeFromBackend(response.data.translatedCode)
      };
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Failed to fix code');
    }
  },

  // Optimize code
  optimizeCode: async (sourceLang, code) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/optimize`, {
        sourceLang,
        code
      });
      return {
        ...response.data,
        translatedCode: formatCodeFromBackend(response.data.translatedCode)
      };
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Failed to optimize code');
    }
  },

  // Fix and Optimize code
  fixAndOptimizeCode: async (sourceLang, code) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/fix-optimize`, {
        sourceLang,
        code
      });
      return {
        ...response.data,
        translatedCode: formatCodeFromBackend(response.data.translatedCode)
      };
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Failed to fix and optimize code');
    }
  }
};

export default apiService;
