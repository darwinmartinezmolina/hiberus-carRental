export const environment = {
  production: true,
  API_BASE_URL: {
    protocol: 'http://',
    uri: 'localhost',
    port: 9080,
    endpoint: 'api',
    api: {
      drivers: '/drivers/',
      vehicles: '/vehicles/',
      trips: '/trips/',
      utils: '/utils'
    }
  },
  LICENSES : ['A', 'B', 'C', 'D']
};
