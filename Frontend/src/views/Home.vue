<template>
  <div class="home">
    <homepage-shop></homepage-shop>
    <homepage-find></homepage-find>
    <HomepageTrend></HomepageTrend>
    <homepage-footer></homepage-footer>
    <Footer></Footer>
  </div>
</template>

<script>
// @ is an alias to /src
import HomepageTrend from '@/components/Homepage/HomepageTrend.vue'

export default {
  name: 'Home',
  components: {
    HomepageTrend
  }
}
</script>
