const PROXY_CONFIG = [
  {
    context: ['/api'],
    target: 'http://localhost:8080/',
    secure: false, // Não está usando SSL localmente (Https)
    logLevel: 'debug'
  }
];

module.exports = PROXY_CONFIG;
