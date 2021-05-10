<template>
  <p class="font-medium text-lg md:text-2xl lg:text-3xl pt-20">Trending CaseCoolors!</p>
  <p class="font-normal text-lg md:text-2xl lg:text-3xl text-md leading-3">Take these babies home with you</p>

  <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 ">
    <div class="pt-10 grid justify-items-center">
      <img src="@/images/DeepSpaceSparkleCase.png" class="w-5/12 md:w-8/12 lg:w-11/12" />
      <p class="font-semibold text-sm md:text-lg pb-2">Deep Space Sparkle Case</p>
      <p class="font-normal text-sm md:text-lg ">Iphone 12 Pro Max</p>
    </div>

    <div class="pt-10 grid justify-items-center ">
      <img src="@/images/MadderLakeCase.png" class="w-5/12 md:w-8/12 lg:w-11/12" />
      <p class="font-semibold text-sm md:text-lg pb-2">Madder Lake Case</p>
      <p class="font-normal text-sm md:text-lg">Iphone 12 Pro</p>
    </div>

    <div class="pt-10 grid justify-items-center ">
      <img src="@/images/EnglishVioletCase.png" class="w-5/12 md:w-8/12 lg:w-11/12" />
      <p class="font-semibold text-sm md:text-lg pb-2">English Violet Case</p>
      <p class="font-normal text-sm md:text-lg">Iphone 12</p>
    </div>

    <div class="pt-10 grid justify-items-center ">
      <img src="@/images/DeepSaffronCase.png" class=" w-5/12 md:w-8/12 lg:w-11/12" />
      <p class="font-semibold text-sm md:text-lg pb-2">Deep Saffron Case</p>
      <p class="font-normal text-sm md:text-lg">Iphone 12 mini</p>
    </div>

  </div>
    
</template>

<script>
export default {
  name: 'HomepageTrend',
  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;500;600;800&display=swap');

p{
  font-family: 'Poppins';
}
</style>
