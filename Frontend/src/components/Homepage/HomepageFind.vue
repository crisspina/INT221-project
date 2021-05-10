<template>
    <div id="container" class="grid lg:grid-cols-2 auto-cols-max justify-center md:order-first">
        <div class="pt-5 lg:pt-24 ">
            <p class="md:text-3xl text-md font-semibold pb-3 md:pb-6">Our Best Cases Just</p>
            <p class="md:text-3xl text-md font-semibold leading-3">Got Even Better</p>
            <hr />
            <p class="pt-5 font-medium pb-5 text-xs md:text-xl">Protective. Sustainable. Antimicrobial.</p>
            <router-link to="/products">
            <BaseButton
            buttonLabel="Find out more"
            buttonColor="bg-button"
            textColor="text-white"
            borderRounded="rounded-xl"
            class="px-1 py-1 text-xs md:px-9 md:py-3 md:text-lg"
            id="Btn"
            />
            </router-link>
        </div>
        <div class="md:pt-16 pt-5 grid justify-items-center order-first lg:order-none">
            <img src="@/images/HomepageFind.png" class="md:w-9/12 w-6/12 " />
        </div>
    </div>
</template>

<script>
export default {
    name: 'HomepageFind'
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;500;600;800&display=swap');

#container{
    font-family: 'Poppins';
}

hr{
    width:50%;
    margin:0 auto;
    border-top: 2px solid #8c8b8b;
}

#Btn{
  font-weight: 400;
  border: solid #1985A1 ;
}

#Btn:hover{
  border: solid #1985A1 ;
}

@media only screen and (max-width: 640px){
    #container{
         margin:0 auto;
    }
}
</style>