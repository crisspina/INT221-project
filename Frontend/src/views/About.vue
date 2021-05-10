<template>
  <div class="about">
    <div class="grid justify-items-center py-10 font-bold md:text-2xl text-lg">
      OUR MEMBER
      <div class="grid md:grid-cols-2 grid-cols-1 container p-10  rounded-xl w-2/3 my-10 bg-gray-100">
        <img src="@/images/phu.png" class="w-6/12 h-auto md:w-7/12 mx-auto place-self-center" />
        <div class="place-items-start ml-5 md:ml-0">
          <div class="font-semibold text-sm md:text-md lg:text-lg mt-4 md:mt-0">
            Student ID: 62130500076<br />
            Name : Pusit Assawateerakeat<br />
            <div class="lg:text-md text-xs font-medium mt-2">
              <p class="text-left pb-1"><i class="fa-x fas fa-tag text-blue-500 "></i>Devops</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-red-700"></i>Database</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-green-500"></i>Frontend</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-yellow-500"></i>Network</p>
              <p class="text-left"><i class=" fa-x fas fa-tag text-pink-500"></i>Backend</p>
            </div>
          </div>
        </div>
      </div>
      
         <div class="grid md:grid-cols-2 grid-cols-1 container p-10  rounded-xl w-2/3 my-10 bg-gray-100">
        <img src="@/images/silk.png" class="w-6/12 h-auto md:w-7/12 mx-auto place-self-center" />
        <div class="place-items-start my-auto ">
          <div class="font-semibold text-sm md:text-md lg:text-lg mt-4 md:mt-0">
         Student ID: 62130500123<br />
          Name : Nattakron Lestsakronparsert<br />
            <div class="lg:text-md text-xs font-medium mt-2">
              <p class="text-left pb-1"><i class="fa-x fas fa-tag text-blue-500 "></i>Devops</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-red-700"></i>Database</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-green-500"></i>Frontend</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-yellow-500"></i>Network</p>
              <p class="text-left"><i class=" fa-x fas fa-tag text-pink-500"></i>Backend</p>
            </div>
          </div>
        </div>
      </div>

         <div class="grid md:grid-cols-2 grid-cols-1 container p-10  rounded-xl w-2/3 my-10 bg-gray-100">
        <img src="@/images/nine.png" class="w-6/12 h-auto md:w-7/12 mx-auto place-self-center" />
        <div class="place-items-start my-auto ">
          <div class="font-semibold text-sm md:text-md lg:text-lg mt-4 md:mt-0">
            Student ID: 62130500124<br />
          Name : Natcha Phannoi<br />
             <div class="lg:text-md text-xs font-medium mt-2">
              <p class="text-left pb-1"><i class="fa-x fas fa-tag text-blue-500 "></i>Devops</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-red-700"></i>Database</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-green-500"></i>Frontend</p>
              <p class="text-left pb-1"><i class=" fa-x fas fa-tag text-yellow-500"></i>Network</p>
              <p class="text-left"><i class=" fa-x fas fa-tag text-pink-500"></i>Backend</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <Footer></Footer>
</template>

<script>
// @ is an alias to /src
import Footer from "@/components/Footer.vue";

export default {
  name: "About",
  components: {
    Footer,
  },
};
</script>

