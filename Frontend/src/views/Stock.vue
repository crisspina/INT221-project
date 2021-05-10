<template>
  <div class="flex justify-center">
    <button @click="buttonShow" class="focus:outline-none">
      <i class="fas fa-edit scale-95 md:scale-125 lg:scale-150 transform" />
    </button>
  </div>

  <!-- Add Edit Delete Buttons -->
  <div
    class="flex flex-col md:flex-row justify-center pt-5 md:pt-16 pb-10 items-center"
    id="button"
    v-show="isBtnShow"
  >
    <div>
      <BaseButton
        buttonLabel="Add New Case"
        buttonColor="bg-davysGrey"
        textColor="text-white"
        borderRounded="rounded-xl"
        class="w-36 lg:w-48 text-xs md:text-md lg:text-lg md:mr-5"
        @click="addBtn"
        id="Btn"
      />
    </div>

    <div class="mt-2 md:mt-0">
      <BaseButton
        buttonLabel="Edit"
        buttonColor="bg-davysGrey"
        textColor="text-white"
        borderRounded="rounded-xl"
        class="w-36 lg:w-48 text-xs md:text-md lg:text-lg md:mr-5"
        id="Btn"
        @click="editMode"
      />
    </div>

    <div class="mt-2 md:mt-0">
      <BaseButton
        buttonLabel="Delete"
        buttonColor="bg-davysGrey"
        textColor="text-white"
        borderRounded="rounded-xl"
        class="w-36 lg:w-48 text-xs md:text-md lg:text-lg"
        id="Btn"
        @click="deleteMode"
      />
    </div>
  </div>

  <div class="flex justify-end mr-96 pb-5" v-if="isCloseForm">
    <button
      @click="formShow"
      class="focus:outline-none text-2xl"
      id="cancelBtn"
    >
      X
    </button>
  </div>

  <div id="form" v-if="isFormShow">
    <form @submit.prevent="submitForm">
      <div class="grid justify-center justify-items-center">
        <!-- Upload Image -->
        <img
          :src="image"
          class="object-cover border w-28 h-40 md:w-48 md:h-60"
        />
        <br />

        <div class="relative overflow-hidden inline-block">
          <BaseButton
            buttonLabel="Upload Image"
            buttonColor="bg-davysGrey"
            textColor="text-white"
            borderRounded="rounded-xl"
            class="text-xs md:text-base"
            id="BtnUpload"
          />
          <input
            type="file"
            multiple
            accept=".jpg, .png, .svg"
            name="imgSrc"
            @change="uploadPhoto"
            class="absolute top-0 left-0 h-10 opacity-0"
          />
          <!-- <i class="text-sm text-red-500" v-if="errors">{{ errors.src }}</i> -->
        </div>
        <p
          class="text-xs text-red-500 font-normal pb-1 md:text-sm"
          v-if="isImageInvalid"
        >
          ["Please Upload images"]
        </p>
      </div>

      <!-- Casename -->
      <div class="flex justify-center pt-4">
        <label
          for="name"
          class="text-xs md:text-base pr-2 md:pr-5 grid place-items-center"
          >Casename:</label
        ><br />
        <input
          type="text"
          class="formName w-40 md:w-56 pl-2"
          name="name"
          v-model.trim="casename"
        />
      </div>
      <p class="text-xs md:text-sm text-red-500 font-normal pb-1" v-if="errors">
        {{ errors.name }}
      </p>

      <!-- Model & Date -->
      <div class="grid grid-cols-1 md:grid-cols-2">
        <div>
          <div class="flex justify-center md:justify-end md:pr-12 mt-3">
            <label
              for="model"
              class="grid place-items-center pr-2 md:pr-5 text-xs md:text-base"
              >Model:</label
            >
            <select
              class="formModel w-40"
              name="model"
              v-model.trim="modelname"
            >
              <option value="iPhone12 Pro max" class="text-xs md:text-base">
                iPhone12 Pro max
              </option>
              <option value="iPhone12 Pro" class="text-xs md:text-base">
                iPhone12 Pro
              </option>
              <option value="iPhone12" class="text-xs md:text-base">
                iPhone12
              </option>
              <option value="iPhone12 mini" class="text-xs md:text-base">
                iPhone12 mini
              </option>
            </select>
          </div>
          <div class="flex justify-center md:justify-end md:pr-14">
            <p
              class="text-xs text-red-500 font-normal pb-1 md:text-sm"
              v-if="errors"
            >
              {{ errors.model }}
            </p>
          </div>
        </div>

        <!-- Date -->
        <div>
          <div class="flex pr-2 justify-center md:justify-start mt-3">
            <label
              for="manufactureDate"
              class="text-xs md:text-base grid place-items-center pr-2 md:pr-5 mt"
              >Release Date:</label
            >
            <input
              type="date"
              class="formDate"
              name="manufactureDate"
              v-model="manufactureDate"
              min="2020-09-23"
              max="2027-01-30"
            />
          </div>
          <div class="flex justify-center md:justify-start md:pl-14 lg:pl-16">
            <p
              class="text-xs text-red-500 font-normal pb-1 md:text-sm"
              v-if="errors"
            >
              {{ errors.date }}
            </p>
          </div>
        </div>
      </div>

      <!-- color -->
      <div class="grid justify-center pl-3 mt-3">
        <div class="flex flex-col">
          <div>
            <p class="font-normal pb-1 text-xs md:text-base">color:</p>
            <div v-for="color in colors" :key="color.colorId">
              <input type="checkbox" v-model="addColor" :value="color" class="mt-1 mr-2 ml-3 "/>
              <label class="text-xs md:text-base">{{ color.colorName }}</label>
            </div>
          </div> 
          <div>
            <p class="text-xs md:text-sm text-red-500 font-normal  pb-5" v-show="isColorInvalid">
              ["Please select one or more color"]
            </p>
          </div> 
        </div>
      </div>   
      
      <!-- brand -->
      <div class="flex justify-center">
          <label for="brand" class="pr-2 md:pr-5 text-xs md:text-base grid place-items-center mt-3">Brand:</label>
          <select class="formModel" name="model" v-model="addBrand">
            <option v-for="brand in brands" :key="brand.brandid" :value="brand">
              {{ brand.brandName }}
            </option>
          </select>
      </div> 
      <p class="text-xs md:text-sm text-red-500 font-normal pb-5" v-show="isBrandInvalid">
        ["Please select Brand"]
      </p>

      <!-- Price & Amount -->
      <div class="grid md:grid-cols-2 grid-cols-1">
        <!-- 1 price-->
        <div class="flex flex-col justify-center md:justify-end">
          <div class="flex justify-center md:justify-end md:pr-4 mt-3">
            <label for="price" class="pr-2 md:pr-5 text-xs md:text-base grid place-items-center">Price:</label>
            <input type="text" class="formPrice" name="price" v-model.trim="price" />
          </div>
          <p class="text-xs md:text-sm text-red-500 font-normal flex justify-center md:justify-end md:pr-10 lg:pr-9 " v-if="errors">{{ errors.price }}</p>
        </div>
        <!-- 2 amount -->
        <div>
          <div class="flex justify-center md:justify-start  pl-3 pr-2 mt-3">
            <label for="amount" class="pr-2 md:pr-5 text-xs md:text-base grid place-items-center">Amount:</label>
            <input type="text" class="formAmount" name="amount" v-model.trim="amount"/>
          </div>
          <p class="text-xs md:text-sm text-red-500 font-normal flex justify-center md:justify-start md:pl-10 lg:pl-12 pb-1" v-if="errors">{{ errors.amount }}</p>
        </div>
      </div>

      <!-- Description -->
      <div class="flex justify-center pt-3">
        <label for="description" class="pr-5 text-xs md:text-base"
          >Description:</label
        ><br />
        <textarea
          name="description"
          class="formText w-44 md:w-96 h-20 md:h-32"
          maxlength="100"
          v-model.trim="description"
        ></textarea>
      </div>
      <p class="text-xs md:text-sm text-red-500 font-normal pb-1" v-if="errors">
        {{ errors.description }}
      </p>

      <!-- submit -->
      <div class="flex justify-center pt-12 pb-5" id="button">
        <div>
          <BaseButton
            buttonLabel="Submit"
            buttonColor="bg-davysGrey"
            textColor="text-white"
            borderRounded="rounded-xl"
            class="mr-5 px-1 py-1 text-xs md:px-10 md:py-3 md:text-md"
            id="Btn"
            type="submit"
          />
        </div>
      </div>
    </form>
  </div>
  <hr />

  <div class="grid grid-cols-2 md:grid-cols-3 lg:grid-cols-5 ">
    <div v-for="product in stock" :key="product.id">
      <div class="grid justify-center pt-5 " @click="showCaseData(product)">
        <p class="text-right text-xl" @click="deleteCase(product.productid); deleteimg(product.image);" v-show="isDeleteBtnShow">
          X
        </p>
<!-- w-36 md:w-40 lg:w-44 -->
<!-- h-20 md:h-36  w-auto -->
        <img :src="img + product.image" class="justify-self-center  h-20 md:h-36  w-auto"/>
        <p class="text-md pb-3 md:text-lg text-center font-medium">
          {{ product.casename }}
        </p>

        <div class="px-3 lg:pl-5 pb-5">
          <p id="info" class="text-xs lg:text-md font-semibold text-left pb-1">
            Model:
            <span class="font-normal" id="spanInfo">{{ product.modelname }}</span>
          </p>
          <p id="info" class="text-xs lg:text-md font-semibold text-left pb-1">
            Release Date:
            <span class="font-normal" id="spanInfo">{{ product.manufactureDate }}</span>
          </p>
          <p id="info" class="text-xs lg:text-md font-semibold text-left pb-1">
            Product:
            <span class="font-normal" id="spanInfo">{{ product.brands.brandName }}</span>
          </p>
          <p id="info" class="text-xs lg:text-md font-semibold text-left pb-1">
            Color:
            <span
              class="font-normal"
              id="spanInfo"
              v-for="c in product.colors"
              :key="c.id"
              >&nbsp;{{ c.colorName }}<br
            /></span>
          </p>

          <p id="info" class="text-xs lg:text-md font-semibold text-left pb-1">
            Price:
            <span class="font-normal" id="spanInfo">{{ product.price }}</span>
          </p>
          <p id="info" class="text-xs lg:text-md font-semibold text-left pb-1">
            Amount:
            <span class="font-normal" id="spanInfo">{{ product.amount }}</span>
          </p>
          <p id="info" class="text-xs lg:text-md font-semibold text-left pb-1">
            Description:
            <span class="font-normal" id="spanInfo">{{product.description}}</span>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import image from '@/images/placeholder.jpg'


const constraints = {
  src:{
    presence: true
  },
  name:{
    presence: true,
    length: {minimum: 1, message:"is empty, Please fill it."}
    // format:{pattern: "[a-zA-Z'.+/ ]+", 
    //         message:"input text only"}
  },
  model:{
    presence: {message:"please choose model"},
    inclusion: {
      within: ["iPhone12 Pro max","iPhone12 Pro","iPhone12","iPhone12 mini"],
      // The ^ prevents the field name from being prepended to the error
      message: "Please select Model"
    }
  },
  date:{
    presence:true,
  },
  price:{
    presence: true,
    numericality: {onlyInteger: true, message:"input number only"}
  },
  amount:{
    presence: true,
    numericality: {onlyInteger: true, message:"input number only"}
  },
  description:{
    presence: {message:"please fill description"},
    length: {minimum: 1, message:"is empty, Please fill it."}
  }
}

export default {
  name: 'Stock',
  components: {
    
  },
  data() {
    return {
      editId:'',
      image: '',
      imageName: '',
      casename: '',
      modelname: null,
      manufactureDate: null,
      price: '',
      amount: '',
      description: '',
      brands:[],
      addBrand:{},
      colors:[],
      addColor: [],
      stock: [],
      isBtnShow: false,
      isFormShow: false,
      isCloseForm: false,
      isAddMode:false,
      isDeleteMode: false,
      isDeleteBtnShow: false,
      isEditMode: false,
      isImageInvalid: false,
      isColorInvalid: false,
      isBrandInvalid: false,
      errors: null,
      url: 'http://52.148.70.112/casecoolors/stock',
      img: 'http://52.148.70.112/casecoolors/getImages/',
      urlColor: 'http://52.148.70.112/casecoolors/colors',
      urlBrand: 'http://52.148.70.112/casecoolors/brand',
      
    }
  },
  methods:{
    buttonShow(){
      this.isBtnShow = !this.isBtnShow
      if(this.isBtnShow == false){
        this.isFormShow = false;
        this.isCloseForm = false;
        this.isAddMode = false;
        this.isDeleteMode = false;
        this.isDeleteBtnShow = false;
        this.isEditMode = false;
      }
    },
    formShow(){
      this.isFormShow = false;
      this.isCloseForm = false;
      this.isAddMode = false;
      this.isEditMode = false;
      this.image = image
      this.imageName = ''
      this.casename = ''
      this.modelname = null
      this.manufactureDate = null
      this.price = ''
      this.amount = ''
      this.description = ''

      

    },
    addBtn(){
      this.isAddMode = !this.isAddMode
      this.isDeleteMode = false
      this.isDeleteBtnShow = false
      this.isEditMode = false
      this.isCloseForm = true
      if(this.isAddMode == true){
        this.isFormShow = true
        this.image = image
        this.imageName = ''
        this.casename = ''
        this.modelname = null
        this.manufactureDate = null
        this.price = ''
        this.amount = ''
        this.description = ''
        this.addBrand = {}
        this.addColor = []
        this.errors = null
        
        
      }else if(this.isAddMode == false){
        this.isFormShow = false;
        this.isCloseForm = false;
        this.image = image
        this.imageName = ''
        this.casename = ''
        this.modelname = null
        this.manufactureDate = null
        this.addColor = []
        this.addBrand = {}
        this.price = ''
        this.amount = ''
        this.description = ''
        this.errors = null
       
        
      }
    },
    deleteMode(){
      this.isDeleteMode = !this.isDeleteMode
      this.isFormShow = false;
      this.isCloseForm = false;
      this.isAddMode = false;
      this.isEditMode = false;

      
      if(this.isDeleteMode){
        this.isDeleteBtnShow = true
      }else{
        this.isDeleteBtnShow = false
      }
    },
    editMode(){
      this.isEditMode = !this.isEditMode
      this.isFormShow = true;
      this.isCloseForm = true;
      this.isAddMode = false;

      if(this.isEditMode == true){
        alert('Edit Mode is: ON')
        this.isDeleteMode = false;
        this.isDeleteBtnShow = false;
        this.isFormShow = false;
        this.isCloseForm = false;
        this.image = ''
        this.imageName = ''
        this.casename = ''
        this.modelname = null
        this.manufactureDate = null
        this.price = ''
        this.amount = ''
        this.description = ''
        this.errors = null
        this.isImageInvalid = false
        this.isColorInvalid = false
        this.isBrandInvalid = false
      }else if(this.isEditMode == false){
        this.isFormShow = false;
        this.isCloseForm = false;
        this.image = image
        this.imageName = ''
        this.casename = ''
        this.modelname = null
        this.manufactureDate = null
        this.price = ''
        this.amount = ''
        this.description = ''
        this.errors = null
        
      }
    
    },
    uploadPhoto(e) {
      const file = e.target.files[0] || e.dataTransfer.files[0];
      const reader = new FileReader();

      reader.onload = (e) => {
        this.image  = e.target.result;
        // this.imageName = file.name
      };
      
      reader.readAsDataURL(file);
      this.imageName = e.target.files[0];
      console.log(this.imageName);
    },
    checkForm(){
      var validate = require("validate.js");

      this.errors = validate({name: this.casename,
                              model: this.modelname,
                              date: this.manufactureDate,
                              price: this.price,
                              amount: this.amount,
                              description: this.description},
                            constraints)

      if(this.errors){
        console.log(this.errors)
      }else if(!this.errors){
        console.log("Registered successfully.");
      }
      this.imageName == '' ? this.isImageInvalid = true : this.isImageInvalid = false;
      this.addColor.length === 0 ? this.isColorInvalid = true : this.isColorInvalid = false;
      (Object.keys(this.addBrand).length === 0) ? this.isBrandInvalid = true : this.isBrandInvalid = false;
    },
    submitForm(){
      this.checkForm();
      if(this.casename !== '' && this.modelname !== '' &&  this.manufactureDate !== '' && this.addColor !== '' && this.price !== '' && this.amount !== '' && this.description !== '') {
        if(this.isEditMode){
          if(this.imageName == ''){
            this.isImageInvalid = true;
          }else if(this.addColor.length === 0){
            this.isColorInvalid = true;
          }else if((Object.keys(this.addBrand).length === 0)){
            this.isBrandInvalid = true;
          }else{
            this.editCase();
            this.isFormShow = false;
            this.isCloseForm = false;
            this.isImageInvalid = false;
            this.isColorInvalid = false;
            this.isBrandInvalid = false;
          }
        }
        else{
          if(this.imageName == ''){
            this.isImageInvalid = true;
          }else if(this.addColor.length === 0){
            this.isColorInvalid = true;
          }else if((Object.keys(this.addBrand).length === 0)){
            this.isBrandInvalid = true;
          }else{
            this.addNewCase();
            this.isImageInvalid = false;
            this.isColorInvalid = false;
            this.isBrandInvalid = false;
          }
            
        }
      }
    },
    async addNewCase(){
      try{
        console.log("image: " + this.imageName)
        console.log("casename: " + this.casename)
        console.log("modelname: " + this.modelname)
        console.log("manufactureDate: " + this.manufactureDate)
        console.log("colors: " + this.addColor)
        console.log("price: " + this.price)
        console.log("amount: " + this.amount)
        console.log("brand: " + this.addBrand)
        console.log("description: " + this.description)

        const newProduct = {
          modelname: this.modelname,
          casename: this.casename,
          description: this.description,
          price: this.price,
          amount: this.amount,
          manufactureDate: this.manufactureDate,
          brands: this.addBrand,
          colors: this.addColor
        }
        
        console.log(this.addColor)
        console.log(newProduct)
        
        const stingy = JSON.stringify(newProduct)
        const blob = new Blob([stingy], {
            type: "application/json",
          })

        console.log("This is blob: "+ blob)

        var formData = new FormData();
        formData.append("imageFile", this.imageName)
        formData.append("stock", blob)

        console.log(this.imageName)
        console.log(formData)

        const res = await fetch('http://52.148.70.112/casecoolors/stock/add',{
          method:'POST',
          body: formData
        })
        res.status === 404 ? alert(`Product name ${this.casename} is already exists`) : console.log(res);

        this.fetchStock();

        alert("submit button click")
      } catch(error){
        console.log(`POST error: ${error}`)
      }

      this.imageName = ''
      this.image = image
      this.casename = ''
      this.modelname = null
      this.manufactureDate = null
      this.addColor = []
      this.addBrand = {}
      this.price = ''
      this.amount = ''
      this.description = ''
    },
    async fetchStock() {
      try {
        const res = await fetch(this.url)
        const data = await res.json()
        this.stock = data;
        console.log(this.addBrand)
        console.log(this.addColor.length)
        return data
      } catch (error) {
        console.log(`GET error: ${error}`)
      }
    },
    async fetchColor() {
      try {
        const res = await fetch(this.urlColor)
        const data = await res.json()
        this.colors = data
        // console.log(this.colors)
        return data
      } catch (error) {
        console.log(`GET error: ${error}`)
      }
    },
    async fetchBrand() {
      try {
        const res = await fetch(this.urlBrand)
        const data = await res.json()
        this.brand = data
        // console.log(this.brand)
        return data
      } catch (error) {
        console.log(`GET error: ${error}`)
      }
    },
    async deleteimg(image){
      const resimg = await fetch(`http://52.148.70.112/casecoolors/delImages/${image}`,{
          method: 'DELETE'
      })

      if(this.isDeleteMode){
          resimg.status === 200 ? (this.stock = this.stock.filter((img) => img.image !== image)) : alert('Delete Pic failed')
        }
    },
    async deleteCase(id){
      try{
        const res = await fetch(`http://52.148.70.112/casecoolors/stock/${id}`,{
          method: 'DELETE'
        })
        
        if(this.isDeleteMode){
          res.status === 200 ? (this.stock = this.stock.filter((data) => data.productid !== id)) : alert('Delete failed')
        }
      }catch(error){
        console.log(`DELETE error: ${error}`)
      }
    },
    showCaseData(oldData){
      try{
        if(this.isEditMode){
          this.isFormShow = true;
          this.isCloseForm = true;
          this.editId = oldData.productid
          this.imageName = oldData.image
          this.image = this.img + oldData.image,
          this.casename = oldData.casename,
          this.modelname = oldData.modelname,
          this.manufactureDate = oldData.manufactureDate,
          this.addColor = oldData.colors,
          this.addBrand = oldData.brands,
          this.price = oldData.price,
          this.amount = oldData.amount,
          this.description = oldData.description
        }
        console.log(this.image)
        console.log(this.imageName)

      }catch(error){
        console.log(`Show data error: ${error}`)
      }
    },
    async editCase(){
      try{
        const editProduct = {
          modelname: this.modelname,
          casename: this.casename,
          description: this.description,
          price: this.price,
          amount: this.amount,
          manufactureDate: this.manufactureDate,
          brands: this.addBrand,
          colors: this.addColor
        }
        
        console.log(this.modelname);
        console.log(this.casename);
        console.log(this.description);
        console.log(this.price);
        console.log(this.amount);
        console.log(this.manufactureDate);
        console.log(this.addBrand);
        console.log(this.addColor);

        if(this.image.includes(this.imageName)){
          const editDataProduct = {
            productid: this.editId,
            modelname: this.modelname,
            casename: this.casename,
            description: this.description,
            price: this.price,
            amount: this.amount,
            manufactureDate: this.manufactureDate,
            image: this.imageName,
            brands: this.addBrand,
            colors: this.addColor
          }
          const stingy = JSON.stringify(editDataProduct)
          const blob = new Blob([stingy], {
            type: "application/json",
          })

          console.log("This is blob: "+ blob)

          let formDataEdit = new FormData();
          formDataEdit.append("stock", blob)

          console.log(this.imageName)
          console.log(formDataEdit)

          const res = await fetch(`http://52.148.70.112/casecoolors/stock/edit/${this.editId}`,{
            method:'PUT',
            body: formDataEdit
          })

          console.log(res);
        }else{
          const stingy = JSON.stringify(editProduct)
          const blob = new Blob([stingy], {
            type: "application/json",
          })

          console.log("This is blob: "+ blob)

          let formDataWithPic = new FormData();
          formDataWithPic.append("imageFile", this.imageName)
          formDataWithPic.append("stock", blob)

          console.log(this.imageName)
          console.log(formDataWithPic)

          const res = await fetch(`http://52.148.70.112/casecoolors/stock/add/${this.editId}`,{
            method:'PUT',
            body: formDataWithPic
          })

          console.log(res);
        }

        this.fetchStock();
        
        this.isEditMode = false;
        this.editId = '',
        this.image = image
        this.casename = ''
        this.modelname = null
        this.manufactureDate = null
        this.addColor = []
        this.addBrand = {}
        this.price = ''
        this.amount = ''
        this.description = ''
      }catch(error){
        console.log(`EDIT error: ${error}`)
      }
    }
    
  },
  async created(){
      this.stock = await this.fetchStock();
      this.colors = await this.fetchColor();
      this.brands = await this.fetchBrand();
      console.log(this.stock)
      console.log(this.colors)
      console.log(this.brands)
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500;600;800&display=swap');

p{
  font-family: 'Poppins';
}

span{
  font-family: 'Poppins';
}

#Btn{
  font-family: 'Poppins';
  font-weight: 400;
  border: 2px solid #46494C;
}

#BtnUpload{
  color: #1985A1;
  background-color: white;
  border: 2px solid #46494C;
  outline: none;
}

#Btn:hover{
  margin-top: -2px;
  border: 2px solid #46494C;
}

#Btn:focus{
  color: #1985A1;
  background-color: white;
  border: 2px solid #46494C;
  outline: none;
}

hr{
  width: 75%;
  margin:0 auto;
  border-top: 2px solid #8c8b8b;
  margin-top: 2.5rem;
  padding-bottom: 0.5rem;
}

#form{
  font-family: 'Poppins';
}

#cancelBtn{
  font-family: 'Poppins';
  font-weight: 800;
}

</style>