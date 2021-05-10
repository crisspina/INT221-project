<template>
    <img src="@/images/landingPage.png" class="w-full pt-6 pb-10"/>
    <p class="md:text-3xl text-md font-semibold lg:pt-16 pb-5 ">Just In: Ultra Impact Brand-New Colors</p>
    <p>
      <router-link to="/products">
      <BaseButton
        buttonLabel="SHOP NOW"
        buttonColor="bg-button"
        textColor="text-white"
        borderRounded="rounded-xl"
        class="px-1 py-1 text-xs md:px-14 md:py-4 md:text-lg"
        id="Btn"
        />
      </router-link>
    </p>
</template>

<script>
export default {
    name:'HomepageShop'
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;500;600;800&display=swap');

p{
    font-family: 'Poppins';
}

#Btn{
  font-family: 'Poppins';
  font-weight: 400;
  border: solid #1985A1 ;
}

#Btn:hover{
  border: solid #1985A1 ;
}

</style>

