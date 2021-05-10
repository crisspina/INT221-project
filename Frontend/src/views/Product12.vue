<template>
    <ShowDetailProduct>
        <template v-slot:preview_img >
            <img src="@/images/RifleGreenCase_12.jpg" 
            alt="iphone 12 case">
        </template>
        <template v-slot:ProductName>
        iPhone 12 
        </template>
        <template v-slot:Price>
        $ 50.00 USD
        </template>
    </ShowDetailProduct>
    <detailcase></detailcase>
    <Footer></Footer>
</template>

<script>
import ShowDetailProduct from "@/components/ProductsDetail/ShowDetailProduct.vue";
import Footer from "@/components/Footer.vue";
import detailcase from "@/components/ProductsDetail/DetailCase.vue";

export default {
  name: "Products",
  components: {
      ShowDetailProduct,Footer,detailcase
  },
};
</script>