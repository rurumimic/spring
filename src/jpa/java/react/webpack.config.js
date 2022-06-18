const path = require('path');

module.exports = {
    entry: './src/main/js/index.js',
    devtool: 'inline-source-map',
    cache: true,
    mode: 'development',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'src/main/resources/static/built'),
    },
    module: {
        rules: [{
            test: path.join(__dirname, '.'),
            exclude: /(node_modules)/,
            use: [{
                loader: 'babel-loader',
                options: {
                    presets: ['@babel/preset-env', '@babel/preset-react']
                }
            }]
        }]
    },
};
