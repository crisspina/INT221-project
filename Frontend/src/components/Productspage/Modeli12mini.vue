<template>
    <div class="grid md:grid-cols-2 grid-cols-1 py-10   bg-background">
        <img
          src="@/images/iphone12minimodel.png"
          alt="12promax model"
          class="w-7/12 md:w-11/12 lg:w-10/12 place-self-center md:pl-10"
        />
        <div class="place-self-center md:pr-10 text-center">
          <p class="ModelName text-2xl md:text-4xl mt-4 md:mt-0">iphone 12 Mini</p>
          <router-link to="/ProductDetail/12mini">
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
<script>
export default  {
  name: 'ModelI12Mini'
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
