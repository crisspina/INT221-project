<template>
  <div class="ProductDetail">
    <showProduct></showProduct>
    <detailcase></detailcase>
    <Footer></Footer>
  </div>
</template>

<script>
import detailcase from "@/components/ProductsDetail/DetailCase.vue";
import ShowProduct from "@/components/ProductsDetail/ShowProduct.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "ProductDetail-page",
  components: {
    detailcase,
    ShowProduct,
    Footer
  },
};
</script>