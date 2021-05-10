<template>
  <div id="container">
    <navlanding-page></navlanding-page>
    
    <div id="nav" class="md:pt-6 pt-2  md:text-xl text-xs ">
      <router-link to="/">HOME</router-link>
      <router-link to="/products" class="lg:ml-24 md:ml-10 ml-4">PRODUCTS</router-link>
      <router-link to="/stock" class="lg:ml-24 md:ml-10 ml-4">STOCKS</router-link>
      <router-link to="/about" class="lg:ml-24 md:ml-10 ml-4">TEAM</router-link>
    </div>
  </div>

  <router-view/>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;500;600;800&display=swap');

p{
 text-align: center;
 font-weight: bold;
 padding-bottom: 30px;
}

#container {
  padding: 30px;
  text-align: center;
}

#container a {
  color: #2c3e50;
  text-decoration: none;
}

#container a.router-link-exact-active {
  color: #1985A1;
  border-bottom: 3px solid#2c3e50;
  padding-bottom: 6px;
}


#nav{
  font-family: 'Poppins';
  font-weight: 500;
  text-align: center;
}

</style>