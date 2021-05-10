<!--ไม่ใช้แล้ว-->
<template>
  <div id="showProduct">
    <div class="flex">
      <div class="w-2/3">
        <img
          id="image"
          src="@/images/RifleGreenCase.jpg"
          class="-mt-52 transform scale-50"
        /><br />
      </div>
      <div class="pt-28 w-1/3 -ml-48">
        <div class="text-3xl font-bold">iPhone 11 Pro Max</div>
        <div class="text-2xl font-semibold my-3">$ 50.00 USD</div>
        <i class="fas fa-star text-yellow-400 transform scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-125"></i>
        <div class="text-xl mt-4">choose color</div>
        <button id="btncolor" >
          <i class="fas fa-circle text-green-900 transform scale-150 m-3"></i>
        </button>
        <button id="btncolor" >
          <i class="fas fa-circle text-red-900 transform scale-150 m-3"></i>
        </button>
        <button id="btncolor" >
          <i class="fas fa-circle text-red-400 transform scale-150 m-3"></i>
        </button>
        <button id="btncolor" >
          <i
            class="fas fa-circle text-gray-900 transform scale-150 m-3"
          ></i></button
        ><br />
        <button id="btncolor">
          <i class="fas fa-circle text-gray-700 transform scale-150 m-3"></i>
        </button>
        <button id="btncolor" >
          <i class="fas fa-circle text-indigo-50 transform scale-150 m-3"></i>
        </button>
        <button id="btncolor" >
          <i
            class="fas fa-circle text-blue-300 transform scale-150 m-3"
          ></i></button
        ><br />

        <BaseButton
          buttonLabel="BUY NOW"
          buttonColor="bg-button"
          textColor="text-white"
          borderRounded="rounded-3xl"
          id="Btn"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ShowProduct",
};


</script>

<style scoped>
#btncolor {
  outline: none;
}

#Btn {
  font-family: "Poppins";
  font-weight: 400;
  border: solid #1985a1;
  margin-top: 40px;
  margin-left: 70px;
  outline: none;
}

#Btn:hover {
  border: solid #1985a1;
}
/*
#image{
  width:50%;
  margin-left: 50px;
  margin-top: -52px;
}*/

</style>