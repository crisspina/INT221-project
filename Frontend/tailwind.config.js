const colors = require('tailwindcss/colors')

module.exports = {
    purge: {content: ['./public/**/*.html', './src/**/*.vue']},
    darkMode: false, // or 'media' or 'class'
    theme: {
        extend: {
            colors: {
                button: '#1985A1',
                silver: '#C5C3C6',
                davysGrey: '#46494C',
                silverChalice: '#AAAAAA',
                blueMunsell: '#1985A1',
                background: '#DCDCDD'

            }
        },
    },
    variants: {
        extend: {},
    },
    plugins: [],
}
