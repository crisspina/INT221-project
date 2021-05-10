import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import './assets/tailwind.css'
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'
import NavLandingPage from '@/components/Homepage/NavLandingPage.vue'
import HomepageShop from '@/components/Homepage/HomepageShop.vue'
import HomepageFind from '@/components/Homepage/HomepageFind.vue'
import HomepageFooter from '@/components/Homepage/HomepageFooter.vue'
import Footer from '@/components/Footer.vue'
import HomepageModel from '@/components/Productspage/HomepageModel'
import BaseButton from '@/components/BaseButton'

const app = createApp(App).use(router)
app.component('navlanding-page', NavLandingPage)
app.component('homepage-shop', HomepageShop)
app.component('homepage-find', HomepageFind)
app.component('homepage-footer', HomepageFooter)
app.component('Footer', Footer)
app.component('homepage-model', HomepageModel)
app.component('BaseButton', BaseButton)
app.mount('#app')
