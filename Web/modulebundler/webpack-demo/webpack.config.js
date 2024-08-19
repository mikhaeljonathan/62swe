const path = require('path');

module.exports = {
  // Entry point of the application
  entry: './src/index.js',

  // Output configuration
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js'
  },

  // Mode can be 'development' or 'production'
  mode: 'development',

  // Module rules (loaders)
  module: {
    rules: [
      {
        test: /\.css$/, // Regex to match .css files
        use: ['style-loader', 'css-loader'], // Loaders to handle CSS files
      },
      // {
      //   test: /\.m?js$/,
      //   exclude: /(node_modules|bower_components)/,
      //   use: [{
      //     loader: 'babel-loader',
      //     options: {
      //       presets: ['@babel/preset-env']
      //     }
      //   }]
      // },
      {
        test: /\.s[ac]ss$/,
        use: ['style-loader', 'css-loader', 'sass-loader']
      }
    ],
  },
};
