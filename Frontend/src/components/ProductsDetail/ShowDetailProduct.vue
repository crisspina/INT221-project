<template>
  <div id="showProduct">
     <div class="grid grid-cols-1 md:grid-cols-2 place-items-center md:mt-5">


      <div class="w-6/12 md:w-8/12 lg:w-2/3 lg:ml-40">
        <!-- image slot -->
        <slot name="preview_img"> </slot>
      </div>


      <div class="lg:mr-72  ">
        <div class="text-lg md:text-2xl lg:text-3xl font-bold">
          <!-- slot-name -->
          <slot name="ProductName"></slot>
        </div>
        <div class="text-md md:text-xl lg:text-2xl font-semibold md:my-3">
          <!-- slot-price -->
          <slot name="Price"></slot>
        </div>
        <i class="fas fa-star text-yellow-400 transform scale-100 md:scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-100 md:scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-100 md:scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-100 md:scale-125 mr-1"></i>
        <i class="fas fa-star text-yellow-400 transform scale-100 md:scale-125"></i>
        <div class="text-md md:text-xl mt-4 ">choose color</div>
        <button id="btncolor">
          <i class="fas fa-circle text-green-900 transform scale-125 md:scale-150 m-1 md:m-3"></i>
        </button>
        <button id="btncolor">
          <i class="fas fa-circle text-red-900 transform scale-125 md:scale-150 m-1 md:m-3"></i>
        </button>
        <button id="btncolor">
          <i class="fas fa-circle text-red-400 transform scale-125 md:scale-150 m-1 md:m-3"></i>
        </button>
        <button id="btncolor">
          <i
            class="fas fa-circle text-gray-900 transform scale-125 md:scale-150 m-1 md:m-3"
          ></i></button
        ><br />
        <button ref="" id="btncolor">
          <i class="fas fa-circle text-gray-700 transform scale-125 md:scale-150 m-1 md:m-3"></i>
        </button>
        <button ref="" id="btncolor">
          <i class="fas fa-circle text-indigo-50 transform scale-125 md:scale-150 m-1 md:m-3"></i>
        </button>
        <button ref="" id="btncolor">
          <i
            class="fas fa-circle text-blue-300 transform scale-125 md:scale-150 m-1 md:m-3"
          ></i></button
        ><br />
        <div class="grid justify-center mt-10 ">
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
  </div>
</template>
<script>
export default {
  name: "ShowDetailProduct",
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
  outline: none;
}

#Btn:hover {
  border: solid #1985a1;
}

#image {
  width: 50%;
  margin-left: 50px;
  margin-top: -52px;
}
</style>