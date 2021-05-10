<template>
    <div class="grid md:grid-cols-2 grid-cols-1 py-8 bg-background justify-items-center">
        <img
          src="@/images/iphone12promodel.png"
          alt="12promax model"
          class="w-6/12 md:w-7/12 lg:w-6/12 h-auto place-self-center "
        />
        <div class="place-self-center text-center md:pr-10 ">
          <p class="ModelName text-2xl md:text-4xl mt-4 md:mt-0">iphone 12 Pro</p>
          <router-link to="/ProductDetail/12pro">
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
      </div>

</template>
<script >
export default  {
  name: 'ModelI12Pro'
}
</script>

<style scoped>
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
