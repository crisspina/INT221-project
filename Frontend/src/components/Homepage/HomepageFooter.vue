<template>
    <div id="container">
        <p class="text-2xl font-medium pt-6">#CaseCoolors</p>
        <p class="text-lg font-light">we stand up for what we believe in by supporting causes that matter to us and our global community.</p>
    
        <div class="grid grid-cols-1 gap-x-5 gap-y-5 pb-10 md:grid-cols-2 lg:grid-cols-2">
            <div id="about">
                <img src="@/images/About.png" class="w-8/12 mx-auto md:m-0 md:w-full" />
                <img src="@/images/About2.png" class="w-8/12 mx-auto md:m-0 md:w-full" id="imgtop" />
            </div>

            <div id="why">
                <img src="@/images/Why.png" class="w-8/12 mx-auto md:m-0 md:w-full" />
                <img src="@/images/Why2.png" class="w-8/12 mx-auto md:m-0 md:w-full" id="imgtop2" />
            </div>
        </div>
    </div> 
</template>

<script>
export default {
    name:'HomepageFooter'
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;500;600;800&display=swap');

#container{
    background-color: #DCDCDD;
    margin-top: 2.5rem;
    font-family: 'Poppins';
}


#about{
    position: relative;
    display: inline-block;

}

#about #imgtop{
    display: none;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    z-index: 99;
}

#about:hover #imgtop{
    display: inline;
}

#why{
    position: relative;
    display: inline-block;
}

#why #imgtop2{
    display: none;
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;
    z-index: 99;
}

#why:hover #imgtop2{
    display: inline;
}

</style>