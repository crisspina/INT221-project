<template>
    <div class="grid md:grid-cols-2  mt-12 py-5 justify-items-center">
        <div class="place-self-center text-center md:pl-10 order-last md:order-none">
          <p class="ModelName text-2xl md:text-4xl mt-4 md:mt-0">iphone 12 Pro Max</p>
          <router-link to="/productdetail/12promax">
          <BaseButton
            buttonLabel="+ View more"
            buttonColor="bg-button"
            textColor="text-white"
            borderRounded="rounded-3xl"
            class="px-1 py-1 text-xs  md:text-lg"
            id="Btn"
          />
          </router-link>
        </div>
        <img
          src="@/images/modeliphone12promax.svg"
          alt="12promax model"
          class="w-6/12 md:w-8/12 h-auto place-self-center lg:pr-10 order-first md:order-none"
        />
      </div>
</template>

<script>
export default  {
  name: 'ModelI12ProMax'
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;500;600;800&display=swap');

.ModelName {
  font-weight: bold;
  text-align: center;
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
