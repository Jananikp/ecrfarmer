import eslintPluginReact from 'eslint-plugin-react';

export default [
  {
    ignores: ['dist/**'],
  },

  {
    files: ['src/**/*.{js,jsx,ts,tsx}'],

    languageOptions: {
      ecmaVersion: 2022,
      sourceType: 'module',
    },

    plugins: {
      react: eslintPluginReact,
    },

    rules: {
      
      quotes: ['error', 'single'],
      'react/jsx-uses-react': 'off',
      'react/react-in-jsx-scope': 'off',
    },
  },
];
