<template>
  <div class="products">
   <homepage-model></homepage-model>
    <div class="flex flex-col">
      <ModelI12ProMax></ModelI12ProMax> 
      <ModelI12Pro></ModelI12Pro>
      <ModelI12></ModelI12>
      <ModelI12Mini></ModelI12Mini>
    </div>
  </div>
  <Footer></Footer>
</template>

<script>
import ModelI12ProMax from '@/components/Productspage/Modeli12promax.vue'
import ModelI12Pro from '@/components/Productspage/Modeli12pro.vue'
import ModelI12 from '@/components/Productspage/Modeli12.vue'
import ModelI12Mini from '@/components/Productspage/Modeli12mini.vue'

export default {
  name: "Products",
  components: {
    ModelI12ProMax,ModelI12Pro,ModelI12,ModelI12Mini 
  
  },
};
</script>

  